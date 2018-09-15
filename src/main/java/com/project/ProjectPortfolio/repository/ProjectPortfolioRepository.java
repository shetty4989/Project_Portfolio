package com.project.ProjectPortfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.ProjectPortfolio.model.Project;

@Repository
public interface ProjectPortfolioRepository extends JpaRepository<Project, Long> {

}
