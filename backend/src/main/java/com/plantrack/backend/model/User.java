package com.plantrack.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*; 

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    @NotBlank(message = "Name is required") 
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email is required") 
    @Email(message = "Email should be valid") 
    private String email;

    private String department;

    // FIX: Removed @Enumerated because this is a String
    private String role; 

    // FIX: Removed @Enumerated because this is a String
    private String status; 

    public User() {}

    // --- Getters and Setters ---
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}