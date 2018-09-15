package com.project.ProjectPortfolio.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.ProjectPortfolio.exception.ResourceNotFoundException;
import com.project.ProjectPortfolio.model.Project;
import com.project.ProjectPortfolio.repository.ProjectPortfolioRepository;

@RestController
public class ProjectController {

	@Autowired
	private ProjectPortfolioRepository projectRepository;

	@PostMapping("/project/save")
	public ResponseEntity<String> saveProject(@Valid @RequestBody Project project) {
		projectRepository.save(project);
		return new ResponseEntity<String>(CREATED, HttpStatus.CREATED);
	}

	@GetMapping("/projects")
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@GetMapping("/projects/{id}")
	public Project getProjectById(@PathVariable(value = "id") Long id) {
		Optional<Project> project = projectRepository.findById(id);
		if (project != null && !project.isPresent())
			throw new ResourceNotFoundException(NOT_FOUND);
		return project.get();
	}

	@DeleteMapping("/projects/{id}")
	public ResponseEntity<?> deleteProject(@PathVariable(value = "id") long id) {
		Optional<Project> projectResp = projectRepository.findById(id);
		if (projectResp != null && !projectResp.isPresent())
			throw new ResourceNotFoundException(NOT_FOUND);
		projectRepository.delete(projectResp.get());
		return new ResponseEntity<String>(DELETED, HttpStatus.OK);

	}

	@PutMapping("/projects/{id}")
	public ResponseEntity<?> updateProject(@PathVariable Long id, @Valid @RequestBody Project project) {
		Optional<Project> projectResp = projectRepository.findById(id);
		if (projectResp != null && !projectResp.isPresent())
			throw new ResourceNotFoundException(NOT_FOUND);
		project.setId(id);
		projectRepository.save(project);
		return new ResponseEntity<String>(UPDATED, HttpStatus.OK);
	}

	private static final String UPDATED = "Project Details successfully updated";
	private static final String DELETED = "Project Details successfully deleted";
	private static final String CREATED = "Project Details successfully created";
	private static final String NOT_FOUND = "Project Id not Found";
}