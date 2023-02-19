package com.valhallacore.service.payment;

import com.valhallacore.dto.bo.ClientOrder;
import com.valhallacore.dto.bo.Product;
import com.valhallacore.dto.paypal.PayPalCreateOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.List;

@Service
public class PaymentService {
    @Autowired
    PayPalService payPalService;
    public PayPalCreateOrderResponse calculationCost(final ClientOrder clientOrder) throws IOException {
        List<Product> products = clientOrder.getProducts();
        if(CollectionUtils.isEmpty(products)){
            return null;
        }
          return this.payPalService.checkout(clientOrder);

    }
}
