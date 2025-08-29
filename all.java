import java.util.*;
import java.lang.*;
import java.io.*;
package com.example.webhooksql;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class WebhookApp implements CommandLineRunner {

    private final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        SpringApplication.run(WebhookApp.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            String url = "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA";

            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("name", "John Doe");
            requestBody.put("regNo", "REG12347"); 
            requestBody.put("email", "john@example.com");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

            Map<String, Object> response = restTemplate.postForObject(url, request, Map.class);

            String webhookUrl = (String) response.get("webhook");
            String accessToken = (String) response.get("accessToken");

            System.out.println("Webhook: " + webhookUrl);
            System.out.println("AccessToken: " + accessToken);

           
            String regNo = (String) requestBody.get("regNo");
            String lastTwo = regNo.substring(regNo.length() - 2);
            int lastDigits = Integer.parseInt(lastTwo);


 