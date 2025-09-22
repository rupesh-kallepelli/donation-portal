package com.pieceofyou.user.service.util;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.pieceofyou.model.client.dto.email.EmailRequest;
import com.pieceofyou.model.client.dto.email.Recipient;
import com.pieceofyou.model.client.dto.email.RecipientType;
import com.pieceofyou.user.service.constants.Constants;


@Component
public class EmailUtility {
    @Value("{from.address}")
    private String from;

    public EmailRequest generateEmailRequestFor(String verificationSuccessfulSubject, String userEmail, String body) {
        return EmailRequest.builder()
                .subject(verificationSuccessfulSubject)
                .from(from)
                .recipients(List.of(new Recipient(userEmail, RecipientType.TO)))
                .body(body)
                .bodyType(Constants.htmlContentType)
                .build();
    }
}
