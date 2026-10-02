package com.portfolio.cms_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ProjectResponse {
    private Long id;
    private String title;
    private String description;
    private String image;
    private String githubUrlBackend;
    private String githubUrlFrontend;
    private String liveUrl;
    private List<String> technologies;
    private LocalDateTime updatedAt;
}