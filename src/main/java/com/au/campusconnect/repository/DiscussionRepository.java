package com.au.campusconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.au.campusconnect.model.Discussion;

public interface DiscussionRepository extends JpaRepository<Discussion, Long> {
}