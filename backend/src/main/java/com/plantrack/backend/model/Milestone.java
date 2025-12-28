package com.plantrack.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "milestones")
public class Milestone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long milestoneId;

    @Column(nullable = false)
    private String title;

    private LocalDateTime dueDate;

    private Integer completionPercent; // e.g., 0 to 100

    @Enumerated(EnumType.STRING)
    private MilestoneStatus status;

    // --- RELATIONSHIP: Many Milestones belong to One Plan (Goal) ---
    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private Plan plan;

    // --- CONSTRUCTOR ---
    public Milestone() {}

    // --- GETTERS AND SETTERS ---
    public Long getMilestoneId() { return milestoneId; }
    public void setMilestoneId(Long milestoneId) { this.milestoneId = milestoneId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public LocalDateTime getDueDate() { return dueDate; }
    public void setDueDate(LocalDateTime dueDate) { this.dueDate = dueDate; }

    public Integer getCompletionPercent() { return completionPercent; }
    public void setCompletionPercent(Integer completionPercent) { this.completionPercent = completionPercent; }

    public MilestoneStatus getStatus() { return status; }
    public void setStatus(MilestoneStatus status) { this.status = status; }

    public Plan getPlan() { return plan; }
    public void setPlan(Plan plan) { this.plan = plan; }
}