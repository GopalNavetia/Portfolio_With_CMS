package com.portfolio.cms_backend.dto;

import com.portfolio.cms_backend.model.SkillCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SkillRequest {

    @NotBlank(message = "Name is required")
    @Size(max = 50, message = "Name must be under 50 characters")
    private String name;

    @NotNull(message = "Category is required")
    private SkillCategory category;

    @Size(max = 30, message = "Proficiency level must be under 30 characters")
    private String proficiencyLevel;
}