package com.valhallacore.service.payment;

import com.valhallacore.config.PayPalConfig;
import com.valhallacore.dto.Constant;
import com.valhallacore.dto.bo.Category;
import com.valhallacore.dto.bo.ClientOrder;
import com.valhallacore.dto.bo.Product;
import com.valhallacore.dto.paypal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class PayPalService {
    public static final String CURRENCY_CODE = Constant.USD;
    @Autowired
    private PayPalConfig payPalConfig;
    public PayPalCreateOrderResponse createOrder(ClientOrder clientOrder) {
        String url = payPalConfig.getUrls().getCreateOrder();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(payPalConfig.getClient().getId(), payPalConfig.getClient().getSecret());
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> payPalRequireHeader = new HashMap<>();
        payPalRequireHeader.put("Prefer", "return=representation");

        payPalRequireHeader.put("PayPal-Request-Id", UUID.randomUUID().toString());
        headers.setAll(payPalRequireHeader);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // Create an HTTP entity containing the request body and headers

        PayPalCreateOrderRequest createOrderRequest = buildRequestBody(clientOrder);
        HttpEntity<PayPalCreateOrderRequest> requestEntity = new HttpEntity<>(createOrderRequest, headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(url, requestEntity, PayPalCreateOrderResponse.class).getBody();
    }
    private PayPalCreateOrderRequest buildRequestBody(ClientOrder clientOrder) {
        PayPalCreateOrderRequest request = new PayPalCreateOrderRequest();
        List<com.valhallacore.dto.paypal.PurchaseUnit> purchaseUnits = new ArrayList<>();
        PurchaseUnit purchaseUnit = new PurchaseUnit();
        AmountWithBreakDown amountWithBreakdown = new AmountWithBreakDown();
        AmountBreakDown amountBreakdown = new AmountBreakDown();
        Money discount = new Money();
        Money itemTotal = new Money();

        request.setIntent(Intent.CAPTURE);

        //Items
        purchaseUnit.setItems(new ArrayList<>());
        double itemTotalPrice = 0;
        for(Product product: clientOrder.getProducts()){
            Money money = new Money();
            money.setCurrencyCode(CURRENCY_CODE);
            money.setValue(String.valueOf(product.getSalePrice()));
            itemTotalPrice += product.getSubTotal();
            Item item = new Item();
            item.setCategory(Category.DIGITAL_GOODS);
            item.setDescription(product.getDescription());
            item.setName(product.getName());
            item.setUnitAmount(money);
            item.setQuantity(String.valueOf(product.getQuantity()));
            purchaseUnit.getItems().add(item);
        }

        //total discount
        double discountValue = calculationDiscount(clientOrder.getProducts(), clientOrder.getDiscountCode().getAmount());
        discount.setValue(String.valueOf(discountValue));
        discount.setCurrencyCode(CURRENCY_CODE);
        amountBreakdown.setDiscount(discount);

        itemTotal.setValue(String.valueOf(itemTotalPrice));
        itemTotal.setCurrencyCode(CURRENCY_CODE);
        amountBreakdown.setItemTotal(itemTotal);
        // amount (total price)
        amountWithBreakdown.setValue(String.valueOf(clientOrder.getTotalPrice()));
        amountWithBreakdown.setCurrencyCode(CURRENCY_CODE);
        amountWithBreakdown.setBreakdown(amountBreakdown);
        purchaseUnit.setAmount(amountWithBreakdown);


        purchaseUnits.add(purchaseUnit);
        request.setPurchaseUnits(purchaseUnits);
        request.setApplicationContext(new ApplicationContext());
        request.getApplicationContext().setCancelUrl(payPalConfig.getUrls().getCancel());
        request.getApplicationContext().setReturnUrl(payPalConfig.getUrls().getSuccess());

        return request;
    }

    public PayPalCreateOrderResponse checkout(ClientOrder clientOrder) throws IOException {
        return this.createOrder(clientOrder);
    }

    public double calculationDiscount(final List<Product> products, double discount) {
        AtomicReference<Double> totalPrice = new AtomicReference<>((double) 0);
        products.forEach(product -> totalPrice.updateAndGet(v -> v + product.getSalePrice() * product.getQuantity()));
        return  totalPrice.get() *  discount / 100;
    }

}

