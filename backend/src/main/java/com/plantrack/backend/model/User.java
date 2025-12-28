package com.plantrack.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data // Lombok generates Getters, Setters, and toString automatically
@Table(name = "users") // 'user' is a reserved keyword in SQL, so we use 'users'
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId; //

    private String name; //

    private String email; //

    private String department; //

    @Enumerated(EnumType.STRING)
    private Role role; // - Employee, Manager, Admin

    @Enumerated(EnumType.STRING)
    private UserStatus status; // - Active, Inactive
}