package com.plantrack.backend.service;

import com.plantrack.backend.model.Comment;
import com.plantrack.backend.model.Plan;
import com.plantrack.backend.model.User;
import com.plantrack.backend.repository.CommentRepository;
import com.plantrack.backend.repository.PlanRepository;
import com.plantrack.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private UserRepository userRepository;

    public Comment addComment(Long planId, Long userId, Comment comment) {
        Plan plan = planRepository.findById(planId)
                .orElseThrow(() -> new RuntimeException("Plan not found"));
        
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        comment.setPlan(plan);
        comment.setUser(user);
        
        // DELETED LINE: comment.setCreatedDate(...) 
        // Reason: JPA Auditing now handles this automatically.

        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByPlan(Long planId) {
        return commentRepository.findByPlanPlanId(planId);
    }
}