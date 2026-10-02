package com.portfolio.cms_backend.controller;

import com.portfolio.cms_backend.dto.SkillRequest;
import com.portfolio.cms_backend.dto.SkillResponse;
import com.portfolio.cms_backend.service.SkillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @GetMapping("/skills/get")
    public ResponseEntity<List<SkillResponse>> getAll() {
        return ResponseEntity.ok(skillService.getAll());
    }

    @GetMapping("/skills/get/{id}")
    public ResponseEntity<SkillResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(skillService.getById(id));
    }

    @PostMapping("/admin/skills/create")
    public ResponseEntity<SkillResponse> create(@Valid @RequestBody SkillRequest request) {
        return ResponseEntity.status(201).body(skillService.create(request));
    }

    @PutMapping("/admin/skills/update/{id}")
    public ResponseEntity<SkillResponse> update(@PathVariable Long id, @Valid @RequestBody SkillRequest request) {
        return ResponseEntity.ok(skillService.update(id, request));
    }

    @DeleteMapping("/admin/skills/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        skillService.delete(id);
        return ResponseEntity.noContent().build();
    }
}