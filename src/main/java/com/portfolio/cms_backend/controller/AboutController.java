package com.portfolio.cms_backend.controller;

import com.portfolio.cms_backend.dto.AboutRequest;
import com.portfolio.cms_backend.dto.AboutResponse;
import com.portfolio.cms_backend.service.AboutService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AboutController {

    private final AboutService aboutService;

    @GetMapping("/about")
    public ResponseEntity<AboutResponse> getAbout() {
        return ResponseEntity.ok(aboutService.getAbout());
    }

    @PutMapping("/admin/about/update")
    public ResponseEntity<AboutResponse> updateAbout(@Valid @RequestBody AboutRequest request) {
        return ResponseEntity.ok(aboutService.updateAbout(request));
    }
}