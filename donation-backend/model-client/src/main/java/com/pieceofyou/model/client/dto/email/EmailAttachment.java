package com.pieceofyou.model.client.dto.email;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class EmailAttachment implements Serializable {
    private String attachmentName;
    private String attachmentExtension;
    private byte[] data;
}
