package com.au.campusconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.au.campusconnect.model.DiscussionReply;

public interface DiscussionReplyRepository extends JpaRepository<DiscussionReply, Long> {

    List<DiscussionReply> findByDiscussionId(Long discussionId);
}