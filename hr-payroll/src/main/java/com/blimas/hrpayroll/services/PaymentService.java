package com.blimas.hrpayroll.services;

import com.blimas.hrpayroll.entities.Payment;
import com.blimas.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    private final RestTemplate restTemplate;

    public PaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment getPayment(UUID workerId, int days) {

        Map<String, String> uriVariables = new HashMap<>();

        uriVariables.put("id", workerId.toString());

        String url = workerHost + "/workers/{id}";

        Worker worker = restTemplate.getForObject(url, Worker.class, uriVariables);

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
