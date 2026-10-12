package com.au.campusconnect.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.au.campusconnect.model.Resource;
import com.au.campusconnect.repository.ResourceRepository;

@RestController
@RequestMapping("/api/resources")
@CrossOrigin(origins = {
    "http://localhost:5173",
    "https://au-campusconnect-frontend.onrender.com"
})
public class ResourceController {

    private final ResourceRepository repository;

    public ResourceController(ResourceRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Resource> getAllResources() {
        return repository.findAll();
    }

    @PostMapping
    public Resource addResource(@RequestBody Resource resource) {
        resource.setId(null);
        return repository.save(resource);
    }
}