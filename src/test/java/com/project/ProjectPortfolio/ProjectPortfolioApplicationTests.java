package com.project.ProjectPortfolio;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.ProjectPortfolio.controller.ProjectController;
import com.project.ProjectPortfolio.exception.ResourceNotFoundException;
import com.project.ProjectPortfolio.model.Project;
import com.project.ProjectPortfolio.model.ProjectDetails;
import com.project.ProjectPortfolio.model.ProjectKeyContacts;
import com.project.ProjectPortfolio.repository.ProjectPortfolioRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectPortfolioApplicationTests {

	@InjectMocks
	ProjectController controller;

	@Mock
	Project project;

	@Mock
	ProjectPortfolioRepository repository;

	private static Validator validator;

	private static long GET_ID = 1;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@BeforeClass
	public static void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
    
	//Test valid estimate and projectType
	@Test
	public void testValidors() throws ParseException {
		Project project = new Project();
		project.setEstimates(5);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date parsed = format.parse("20110210");
		java.sql.Date sql = new java.sql.Date(parsed.getTime());
		project.setdRequested(sql);
		project.setdRequired(sql);
		project.setCritical(true);
		project.setType("DOCSMANAGE");
		ProjectKeyContacts contacts = new ProjectKeyContacts();
		contacts.setEmail("assdasd.gmail.com");
		contacts.setFname("sdsd");
		contacts.setLname("asdasd");
		contacts.setPhone("asd");
		contacts.setRole("asda");
		contacts.setTeam("saad");
		project.setContacts(contacts);
		ProjectDetails det = new ProjectDetails();
		det.setDescription("asdsd");
		det.setName("asd");
		det.setName("asdad");
		det.setSummary("asdd");
		project.setProjectDetails(det);
		project.setType("DOCSMANAGE");
		Set<ConstraintViolation<Project>> constraintViolations = validator.validate(project);
		assertEquals(constraintViolations.size(), 0);
	}

	//Test Invalid estimate and ProjectType
	@Test
	public void testInvalidValidators() {
		Project project = new Project();
		project.setEstimates(76);
		project.setType("DOCSMANAGEYY");
		Set<ConstraintViolation<Project>> constraintViolations = validator.validate(project);
		assertEquals(constraintViolations.size(), 2);
	}

	//Test invalid project Type and valid Estimate
	@Test
	public void testValidInvalid() {
		Project project = new Project();
		project.setEstimates(5);
		project.setType("DOCSMANAGEYY");
		Set<ConstraintViolation<Project>> constraintViolations = validator.validate(project);
		assertEquals(constraintViolations.size(), 1);
	}

	//Test invalid Estimate and valid projectType
	@Test
	public void testValidInvalidEstimtes() {
		Project project = new Project();
		project.setEstimates(-1);
		project.setType("DOCSMANAGE");
		Set<ConstraintViolation<Project>> constraintViolations = validator.validate(project);
		assertEquals(constraintViolations.size(), 1);
	}

	//test estimate not in fibonacci series
	@Test
	public void testValidInvalidEstimtesFib() {
		Project project = new Project();
		project.setEstimates(10);
		project.setType("DOCSMANAGE");
		Set<ConstraintViolation<Project>> constraintViolations = validator.validate(project);
		assertEquals(constraintViolations.size(), 1);
	}

	//Test fetch all project portfolio details
	@Test
	public void getProjects() {
		List<Project> projects = new ArrayList<Project>();
		projects.add(project);
		when(repository.findAll()).thenReturn(projects);
		assertEquals(controller.getAllProjects(), projects);
	}

	//test Save project Portfolio
	@Test
	public void saveProjects() throws ParseException {
		project.setEstimates(5);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date parsed = format.parse("20110210");
		java.sql.Date sql = new java.sql.Date(parsed.getTime());
		project.setdRequested(sql);
		project.setdRequired(sql);
		project.setCritical(true);
		project.setType("DOCSMANAGE");
		ProjectKeyContacts contacts = new ProjectKeyContacts();
		contacts.setEmail("assdasd.gmail.com");
		contacts.setFname("sdsd");
		contacts.setLname("asdasd");
		contacts.setPhone("asd");
		contacts.setRole("asda");
		contacts.setTeam("saad");
		project.setContacts(contacts);
		ProjectDetails det = new ProjectDetails();
		det.setDescription("asdsd");
		det.setName("asd");
		det.setName("asdad");
		det.setSummary("asdd");
		project.setProjectDetails(det);
		project.setType("DOCSMANAGE");
		assertEquals(controller.saveProject(project).getStatusCode(), HttpStatus.CREATED);
	}

	//test getProjectById
	@Test
	public void getProjectById() {
		when(repository.findById(1L)).thenReturn(Optional.of(project));
		assertEquals(controller.getProjectById(GET_ID), project);
	}

	//get project By InvalidId
	@Test
	public void getProjectByIdInvalid() {
		thrown.expect(ResourceNotFoundException.class);
		thrown.expectMessage("Project Id not Found");
		controller.getProjectById(7L);
	}

	//Update Project by Invalid Id
	@Test
	public void updateProjectsInvalidId() {
		thrown.expect(ResourceNotFoundException.class);
		thrown.expectMessage("Project Id not Found");
		controller.updateProject(7L, project);
	}

	//Update Project
	@Test
	public void updateProjectsValid() throws ParseException {
		project.setEstimates(5);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date parsed = format.parse("20110210");
		java.sql.Date sql = new java.sql.Date(parsed.getTime());
		project.setdRequested(sql);
		project.setdRequired(sql);
		project.setCritical(true);
		project.setType("DOCSMANAGE");
		project.setId(1L);
		ProjectKeyContacts contacts = new ProjectKeyContacts();
		contacts.setEmail("assdasd.gmail.com");
		contacts.setFname("sdsd");
		contacts.setLname("asdasd");
		contacts.setPhone("asd");
		contacts.setRole("asda");
		contacts.setTeam("saad");
		project.setContacts(contacts);
		ProjectDetails det = new ProjectDetails();
		det.setDescription("asdsd");
		det.setName("asd");
		det.setName("asdad");
		det.setSummary("asdd");
		project.setProjectDetails(det);
		project.setType("DOCSMANAGE");
		when(repository.findById(1L)).thenReturn(Optional.of(project));
		assertEquals(controller.updateProject(1L, project).getStatusCode(), HttpStatus.OK);
	}

	//delete Project
	@Test
	public void deleteProjects() {
		when(repository.findById(2L)).thenReturn(Optional.of(project));
		assertEquals(controller.deleteProject(2L).getStatusCode(), HttpStatus.OK);
	}

	//Delete Project with invalidId
	@Test
	public void deleteProjectsInvalidID() {
		thrown.expect(ResourceNotFoundException.class);
		thrown.expectMessage("Project Id not Found");
		controller.deleteProject(7L);
	}
}
