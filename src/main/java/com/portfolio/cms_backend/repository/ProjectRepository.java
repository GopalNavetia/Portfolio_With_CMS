package com.portfolio.cms_backend.repository;

import com.portfolio.cms_backend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p LEFT JOIN FETCH p.technologies")
    List<Project> findAllWithTechnologies();

    @Query("SELECT p FROM Project p LEFT JOIN FETCH p.technologies WHERE p.id = :id")
    Optional<Project> findByIdWithTechnologies(@Param("id") Long id);
}