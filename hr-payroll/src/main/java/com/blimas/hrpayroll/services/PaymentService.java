package com.blimas.hrpayroll.services;

import com.blimas.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    public Payment getPayment(UUID workerId, int days){
        return new Payment("Bob", 200.0, days);
    }
}
