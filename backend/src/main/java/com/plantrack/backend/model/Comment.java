package com.plantrack.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false, length = 1000) // Allow longer text
    private String text;

    private LocalDateTime createdDate;

    // --- RELATIONSHIP: Linked to User (Author) ---
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // --- RELATIONSHIP: Linked to Plan (Goal) ---
    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private Plan plan;

    public Comment() {
        this.createdDate = LocalDateTime.now(); // Auto-set date
    }

    // --- GETTERS AND SETTERS ---
    public Long getCommentId() { return commentId; }
    public void setCommentId(Long commentId) { this.commentId = commentId; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Plan getPlan() { return plan; }
    public void setPlan(Plan plan) { this.plan = plan; }
}