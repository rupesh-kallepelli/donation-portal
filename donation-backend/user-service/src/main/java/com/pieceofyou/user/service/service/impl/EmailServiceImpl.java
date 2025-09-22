package com.pieceofyou.user.service.service.impl;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pieceofyou.model.client.dto.email.EmailRequest;
import com.pieceofyou.model.client.dto.security.request.UserRegistrationRequest;
import com.pieceofyou.model.client.dto.user.User;
import com.pieceofyou.user.service.constants.Constants;
import com.pieceofyou.user.service.service.EmailService;
import com.pieceofyou.user.service.service.KafkaService;
import com.pieceofyou.user.service.util.EmailUtility;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    private KafkaService kafkaService;
    private ObjectMapper objectMapper;
    private EmailUtility emailUtility;

    public EmailServiceImpl(KafkaService kafkaService, EmailUtility emailUtility) {
        this.kafkaService = kafkaService;
        this.objectMapper = new ObjectMapper();
        this.emailUtility = emailUtility;
    }

    public void sendEmail(EmailRequest emailRequest) {
        try {
            log.info(objectMapper.writeValueAsString(emailRequest));
            kafkaService.produce(objectMapper.writeValueAsString(emailRequest));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    
  public void sendSignupVerificationEmailRequestForUser(UserRegistrationRequest user, String userEmail,
      String verificationKey) {
    String body = Constants.verificationEmailBody.formatted(user.getEmail(),
        user.getEmail(), verificationKey);
    sendEmail(emailUtility.generateEmailRequestFor(Constants.verificationSubject, userEmail, body));
  }


  public void sendVerificationCompletedEmailRequestForUser(User user, String userEmail) {
    String body = Constants.verificationSuccessfulEmailBody.formatted(user.getFirstName() + " " + user.getLastName());
    sendEmail(emailUtility.generateEmailRequestFor(Constants.verificationSuccessfulSubject, userEmail, body));
  }
}
