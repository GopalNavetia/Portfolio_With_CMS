package com.portfolio.cms_backend.dto;

import com.portfolio.cms_backend.model.SkillCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SkillResponse {
    private Long id;
    private String name;
    private SkillCategory category;
    private String proficiencyLevel;
}