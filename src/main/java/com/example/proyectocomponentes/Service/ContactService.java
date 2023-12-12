package com.example.proyectocomponentes.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;

@Service
public class ContactService {

    @Value("${brevo.api.url}")
    private String apiUrl;

    @Value("${brevo.api.key}")
    private String apiKey;

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String fromPhoneNumber;
    private final RestTemplate restTemplate = new RestTemplate();

    public void sendEmail(String to, String subject, String content) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("api-key", apiKey);

        String body = String.format("{ \"sender\": { \"name\": \"gymx\", \"email\":\"josi.hi.um@gmail.com\" }, " +
                "\"to\": [{ \"email\": \"%s\", \"name\": \"Recipient Name\" }], " +
                "\"subject\": \"%s\", " +
                "\"htmlContent\": \"%s\" }", to, subject, content);

        HttpEntity<String> request = new HttpEntity<>(body, headers);

        restTemplate.postForObject(apiUrl, request, String.class);
    }
    public void sendSMS(Long to, String message) {
        Twilio.init(accountSid, authToken);

        Message.creator(
                new PhoneNumber("+"+to.toString()),  // To number
                new PhoneNumber(fromPhoneNumber),  // From number
                message
        ).create();
    }
}

