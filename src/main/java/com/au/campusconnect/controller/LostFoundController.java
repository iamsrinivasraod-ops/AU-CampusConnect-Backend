package com.au.campusconnect.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.au.campusconnect.model.LostFound;
import com.au.campusconnect.repository.LostFoundRepository;

@RestController
@RequestMapping("/api/lostfound")
@CrossOrigin(origins = "http://localhost:5173")
public class LostFoundController {

    private final LostFoundRepository repository;

    public LostFoundController(LostFoundRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<LostFound> getAllItems() {
        return repository.findAll();
    }

    @PostMapping
    public LostFound addItem(@RequestBody LostFound item) {
        item.setId(null);
        return repository.save(item);
    }
}