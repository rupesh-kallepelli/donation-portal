package com.pieceofyou.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "users_table")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 32)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 15)
    private String mobileExt;

    @Column(nullable = false, length = 10)
    private String mobile;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 3)
    private String bloodType;

    @Column(nullable = false)
    private Boolean organDonor = false;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
