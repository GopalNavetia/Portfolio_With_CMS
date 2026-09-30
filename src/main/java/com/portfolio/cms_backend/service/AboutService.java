package com.portfolio.cms_backend.service;

import com.portfolio.cms_backend.dto.AboutRequest;
import com.portfolio.cms_backend.dto.AboutResponse;
import com.portfolio.cms_backend.model.About;
import com.portfolio.cms_backend.repository.AboutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AboutService {

    private static final Long ABOUT_ID = 1L;

    private final AboutRepository aboutRepository;

    public AboutResponse getAbout() {
        About about = aboutRepository.findById(ABOUT_ID)
                .orElseThrow(() -> new NoSuchElementException("About content has not been set up yet"));
        return toResponse(about);
    }

    public AboutResponse updateAbout(AboutRequest request) {
        About about = aboutRepository.findById(ABOUT_ID).orElse(new About());
        about.setId(ABOUT_ID);
        about.setName(request.getName());
        about.setTitle(request.getTitle());
        about.setSummary(request.getSummary());
        about.setEmail(request.getEmail());
        about.setPhone(request.getPhone());
        about.setLocation(request.getLocation());
        about.setProfileImage(request.getProfileImage());
        about.setResumeUrl(request.getResumeUrl());
        about.setGithubUrl(request.getGithubUrl());
        about.setLinkedinUrl(request.getLinkedinUrl());

        return toResponse(aboutRepository.save(about));
    }

    private AboutResponse toResponse(About about) {
        return AboutResponse.builder()
                .name(about.getName())
                .title(about.getTitle())
                .summary(about.getSummary())
                .email(about.getEmail())
                .phone(about.getPhone())
                .location(about.getLocation())
                .profileImage(about.getProfileImage())
                .resumeUrl(about.getResumeUrl())
                .githubUrl(about.getGithubUrl())
                .linkedinUrl(about.getLinkedinUrl())
                .updatedAt(about.getUpdatedAt())
                .build();
    }
}