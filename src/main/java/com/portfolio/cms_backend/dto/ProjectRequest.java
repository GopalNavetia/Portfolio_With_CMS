package com.portfolio.cms_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.util.List;

@Data
public class ProjectRequest {

    @NotBlank(message = "Title is required")
    @Size(max = 150, message = "Title must be under 150 characters")
    private String title;

    @NotBlank(message = "Description is required")
    @Size(max = 3000, message = "Description must be under 3000 characters")
    private String description;

    @URL(message = "Must be a valid image URL")
    private String image;

    @URL(message = "Must be a valid GitHub URL")
    private String githubUrlBackend;

    @URL(message = "Must be a valid GitHub URL")
    private String githubUrlFrontend;

    @URL(message = "Must be a valid live URL")
    private String liveUrl;

    private List<String> technologies;
}