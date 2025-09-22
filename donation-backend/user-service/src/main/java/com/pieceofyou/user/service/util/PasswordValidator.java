package com.pieceofyou.user.service.util;


import com.pieceofyou.model.client.exceptions.user.InvalidPasswordException;
import com.pieceofyou.user.service.constants.Constants;

import lombok.extern.slf4j.Slf4j;



@Slf4j
public class PasswordValidator {

    public static void validatePassword(String password) throws InvalidPasswordException {
        if (!password.matches(Constants.passwordRegex)) {
            throw new InvalidPasswordException(validatePasswordString(password));
        }
    }

    private static String validatePasswordString(String password) {
        StringBuilder errorMessage = new StringBuilder();

        // Check minimum length
        if (password.length() < 8) {
            errorMessage.append("Password must be at least 8 characters long. <br>");
        }

        // Check for at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            errorMessage.append("Password must contain at least one uppercase letter. <br>");
        }

        // Check for at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            errorMessage.append("Password must contain at least one lowercase letter. <br>");
        }

        // Check for at least one digit
        if (!password.matches(".*\\d.*")) {
            errorMessage.append("Password must contain at least one digit. <br>");
        }

        // Check for at least one special character
        if (!password.matches(".*[@$!%*?&].*")) {
            errorMessage.append("Password must contain at least one special character (e.g., @$!%*?&). <br>");
        }

        // Check if the password matches the pattern
        if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
            errorMessage.append("Password does not meet the required criteria. <br>");
        }
        log.error(errorMessage.toString());
        return errorMessage.toString();
    }
}
