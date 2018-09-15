package com.project.ProjectPortfolio.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.project.ProjectPortfolio.EnumValidate;
import com.project.ProjectPortfolio.ProjectValidate;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private long id;

	@Column(name = "requested_date")
	private Date dRequested;

	@Column(name = "required_date")
	private Date dRequired;

	@ProjectValidate
	@Column(name = "estimates")
	private int estimates;

	@Column(name = "isCritical", columnDefinition = "tinyint default false")
	private boolean isCritical;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "proj_det_id")
	private ProjectDetails projectDetails;

	@EnumValidate(enumClass = ProjectType.class)
	@Column(name = "type")
	private String type;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "key_cont_id")
	private ProjectKeyContacts contacts;

	public Project() {
	}

	public Project(long id, Date dRequested, Date dRequired, int estimates, boolean isCritical,
			ProjectKeyContacts contacts, ProjectDetails projectDetails, String type) {
		super();
		this.id = id;
		this.dRequested = dRequested;
		this.dRequired = dRequired;
		this.estimates = estimates;
		this.isCritical = isCritical;
		this.contacts = contacts;
		this.projectDetails = projectDetails;
		this.type = type;
	}

	public Date getdRequested() {
		return dRequested;
	}

	public void setdRequested(Date dRequested) {
		this.dRequested = dRequested;
	}

	public Date getdRequired() {
		return dRequired;
	}

	public void setdRequired(Date dRequired) {
		this.dRequired = dRequired;
	}

	public int getEstimates() {
		return estimates;
	}

	public void setEstimates(int estimates) {
		this.estimates = estimates;
	}

	public boolean isCritical() {
		return isCritical;
	}

	public void setCritical(boolean isCritical) {
		this.isCritical = isCritical;
	}

	public ProjectDetails getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(ProjectDetails projectDetails) {
		this.projectDetails = projectDetails;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ProjectKeyContacts getContacts() {
		return contacts;
	}

	public void setContacts(ProjectKeyContacts contacts) {
		this.contacts = contacts;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
