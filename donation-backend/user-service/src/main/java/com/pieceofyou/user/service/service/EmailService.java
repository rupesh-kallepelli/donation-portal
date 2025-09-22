package com.pieceofyou.user.service.service;

import com.pieceofyou.model.client.dto.email.EmailRequest;
import com.pieceofyou.model.client.dto.security.request.UserRegistrationRequest;
import com.pieceofyou.model.client.dto.user.User;

public interface EmailService {
    void sendEmail(EmailRequest emailRequest);
    void sendSignupVerificationEmailRequestForUser(UserRegistrationRequest user, String userEmail,
        String verificationKey);
    void sendVerificationCompletedEmailRequestForUser(User user, String userEmail);
}
