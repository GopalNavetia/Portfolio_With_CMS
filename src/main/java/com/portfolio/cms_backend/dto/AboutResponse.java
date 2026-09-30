package com.portfolio.cms_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class AboutResponse {
    private String name;
    private String title;
    private String summary;
    private String email;
    private String phone;
    private String location;
    private String profileImage;
    private String resumeUrl;
    private String githubUrl;
    private String linkedinUrl;
    private LocalDateTime updatedAt;
}