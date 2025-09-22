package com.pieceofyou.user.service.util;

import java.util.Base64;

import org.springframework.stereotype.Component;

import com.pieceofyou.model.client.dto.security.request.UserRegistrationRequest;
import com.pieceofyou.user.service.constants.Constants;

@Component
public class VerificationTokenUtility {
    public String getVerificationToken(UserRegistrationRequest userRegistrationRequest, String username) {
        return userRegistrationRequest.getEmail().concat(Constants.verificationSeparator + username)
                .concat(Constants.verificationSeparator + userRegistrationRequest.getCreatedAt());
    }

    public String convertVerificationKey(String key, boolean encode) {
        if (encode)
            return Base64.getEncoder().encodeToString(key.getBytes());
        else
            return new String(Base64.getDecoder().decode(key));
    }
}
