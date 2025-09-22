package com.pieceofyou.model.client.dto.email;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserEmailRequest implements Serializable {
    private String recipient;
    private String subject;
    private String body;
}
