package com.au.campusconnect.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.au.campusconnect.model.Discussion;
import com.au.campusconnect.model.DiscussionReply;
import com.au.campusconnect.repository.DiscussionReplyRepository;
import com.au.campusconnect.repository.DiscussionRepository;

@RestController
@RequestMapping("/api/discussions")
@CrossOrigin(origins = "http://localhost:5173")
public class DiscussionController {

    private final DiscussionRepository discussionRepository;
    private final DiscussionReplyRepository replyRepository;

    public DiscussionController(
            DiscussionRepository discussionRepository,
            DiscussionReplyRepository replyRepository) {

        this.discussionRepository = discussionRepository;
        this.replyRepository = replyRepository;
    }

    @GetMapping
    public List<Discussion> getAllDiscussions() {
        return discussionRepository.findAll();
    }

    @PostMapping
    public Discussion addDiscussion(@RequestBody Discussion discussion) {
        discussion.setId(null);
        discussion.setCreatedAt(java.time.LocalDateTime.now());
        return discussionRepository.save(discussion);
    }

    @GetMapping("/{id}/replies")
    public ResponseEntity<List<DiscussionReply>> getReplies(@PathVariable Long id) {
        if (!discussionRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(replyRepository.findByDiscussionId(id));
    }

    @PostMapping("/{id}/replies")
    public ResponseEntity<DiscussionReply> addReply(
            @PathVariable Long id,
            @RequestBody DiscussionReply reply) {

        if (!discussionRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        reply.setId(null);
        reply.setDiscussionId(id);
        reply.setCreatedAt(java.time.LocalDateTime.now());

        return ResponseEntity.ok(replyRepository.save(reply));
    }
}