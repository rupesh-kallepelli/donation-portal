package com.pieceofyou.model.client.dto.email;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmailRequest implements Serializable {

    @NotNull
    @NotEmpty
    @NotBlank
    private String from;
    @NotEmpty
    @Valid
    private List<Recipient> recipients;
    @NotNull
    @NotEmpty
    @NotBlank
    private String subject;
    private String bodyType;
    private String body;
    private String mimeType;
    private List<EmailAttachment> emailAttachments;

}
