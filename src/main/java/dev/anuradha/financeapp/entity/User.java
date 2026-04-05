package dev.anuradha.financeapp.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Boolean active;

    private LocalDateTime createdAt;
}
