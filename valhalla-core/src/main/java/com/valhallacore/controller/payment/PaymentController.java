package com.valhallacore.controller.payment;


import com.valhallacore.dto.bo.ClientOrder;
import com.valhallacore.dto.paypal.PayPalCreateOrderResponse;
import com.valhallacore.dto.paypal.PayPalOrder;
import com.valhallacore.service.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @PostMapping("create-order")
    public ResponseEntity<PayPalCreateOrderResponse> createOrder(@RequestBody ClientOrder clientOrder) throws IOException {
        PayPalCreateOrderResponse payPalCreateOrderResponse = this.paymentService.calculationCost(clientOrder);
        return new ResponseEntity<>(payPalCreateOrderResponse, HttpStatus.OK);
    }

    @PostMapping("calculation-cost")
    public void calculationCost(){

    }
    @GetMapping("cancel")
    public String payCancel(){
        return  "cancel";
    }
    @GetMapping("success")
    public String paySuccess(){
        return "success";
    }
}
