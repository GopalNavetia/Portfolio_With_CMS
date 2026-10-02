package com.portfolio.cms_backend.service;

import com.portfolio.cms_backend.dto.SkillRequest;
import com.portfolio.cms_backend.dto.SkillResponse;
import com.portfolio.cms_backend.model.Skill;
import com.portfolio.cms_backend.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillRepository skillRepository;

    public List<SkillResponse> getAll() {
        return skillRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public SkillResponse getById(Long id) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Skill not found with id: " + id));
        return toResponse(skill);
    }

    public SkillResponse create(SkillRequest request) {
        Skill skill = Skill.builder()
                .name(request.getName())
                .category(request.getCategory())
                .proficiencyLevel(request.getProficiencyLevel())
                .build();

        return toResponse(skillRepository.save(skill));
    }

    public SkillResponse update(Long id, SkillRequest request) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Skill not found with id: " + id));

        skill.setName(request.getName());
        skill.setCategory(request.getCategory());
        skill.setProficiencyLevel(request.getProficiencyLevel());

        return toResponse(skillRepository.save(skill));
    }

    public void delete(Long id) {
        if (!skillRepository.existsById(id)) {
            throw new NoSuchElementException("Skill not found with id: " + id);
        }
        skillRepository.deleteById(id);
    }

    private SkillResponse toResponse(Skill skill) {
        return SkillResponse.builder()
                .id(skill.getId())
                .name(skill.getName())
                .category(skill.getCategory())
                .proficiencyLevel(skill.getProficiencyLevel())
                .build();
    }
}