package com.pieceofyou.model.client.dto.email;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Recipient implements Serializable {
    @NotNull
    @NotEmpty
    @NotBlank
    @Email
    private String email;
    @NotNull
    private RecipientType recipientType;
}
