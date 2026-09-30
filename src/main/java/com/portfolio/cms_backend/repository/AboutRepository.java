package com.portfolio.cms_backend.repository;

import com.portfolio.cms_backend.model.About;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AboutRepository extends JpaRepository<About, Long> {
}