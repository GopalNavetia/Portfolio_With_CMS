package com.portfolio.cms_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Health {
    @GetMapping("/api/health")
    public String health() {
        return "CMS backend is running";
    }
}
