package com.portfolio.cms_backend.service;

import com.portfolio.cms_backend.dto.ProjectRequest;
import com.portfolio.cms_backend.dto.ProjectResponse;
import com.portfolio.cms_backend.model.Project;
import com.portfolio.cms_backend.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<ProjectResponse> getAll() {
        return projectRepository.findAllWithTechnologies()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public ProjectResponse getById(Long id) {
        Project project = projectRepository.findByIdWithTechnologies(id)
                .orElseThrow(() -> new NoSuchElementException("Project not found with id: " + id));
        return toResponse(project);
    }

    public ProjectResponse create(ProjectRequest request) {
        Project project = Project.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .image(request.getImage())
                .githubUrlBackend(request.getGithubUrlBackend())
                .githubUrlFrontend(request.getGithubUrlFrontend())
                .liveUrl(request.getLiveUrl())
                .technologies(request.getTechnologies())
                .build();

        return toResponse(projectRepository.save(project));
    }

    public ProjectResponse update(Long id, ProjectRequest request) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Project not found with id: " + id));

        project.setTitle(request.getTitle());
        project.setDescription(request.getDescription());
        project.setImage(request.getImage());
        project.setGithubUrlBackend(request.getGithubUrlBackend());
        project.setGithubUrlFrontend(request.getGithubUrlFrontend());
        project.setLiveUrl(request.getLiveUrl());
        project.setTechnologies(request.getTechnologies());

        return toResponse(projectRepository.save(project));
    }

    public void delete(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new NoSuchElementException("Project not found with id: " + id);
        }
        projectRepository.deleteById(id);
    }

    private ProjectResponse toResponse(Project project) {
        return ProjectResponse.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .image(project.getImage())
                .githubUrlBackend(project.getGithubUrlBackend())
                .githubUrlFrontend(project.getGithubUrlFrontend())
                .liveUrl(project.getLiveUrl())
                .technologies(project.getTechnologies())
                .updatedAt(project.getUpdatedAt())
                .build();
    }
}