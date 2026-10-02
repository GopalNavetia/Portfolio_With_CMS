package com.portfolio.cms_backend.repository;

import com.portfolio.cms_backend.model.Skill;
import com.portfolio.cms_backend.model.SkillCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findByCategory(SkillCategory category);
}