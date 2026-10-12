package com.au.campusconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.au.campusconnect.model.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}