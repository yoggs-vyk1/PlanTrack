package com.plantrack.backend.repository;

import com.plantrack.backend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Find all comments for a specific Plan
    List<Comment> findByPlanPlanId(Long planId);
}