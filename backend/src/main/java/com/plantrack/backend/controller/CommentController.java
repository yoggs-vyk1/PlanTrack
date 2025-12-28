package com.plantrack.backend.controller;

import com.plantrack.backend.model.Comment;
import com.plantrack.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // Add a comment to a plan
    // URL Example: POST /api/plans/1/comments?userId=1
    @PostMapping("/plans/{planId}/comments")
    public Comment addComment(@PathVariable Long planId, 
                              @RequestParam Long userId, 
                              @RequestBody Comment comment) {
        return commentService.addComment(planId, userId, comment);
    }

    // Get all comments for a plan
    @GetMapping("/plans/{planId}/comments")
    public List<Comment> getCommentsByPlan(@PathVariable Long planId) {
        return commentService.getCommentsByPlan(planId);
    }
}