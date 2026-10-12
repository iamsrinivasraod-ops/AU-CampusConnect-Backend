package com.au.campusconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.au.campusconnect.model.LostFound;

public interface LostFoundRepository extends JpaRepository<LostFound, Long> {
}