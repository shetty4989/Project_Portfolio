package com.project.ProjectPortfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "ProjectDetails")
public class ProjectDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proj_det_id")
	@NotNull
	private long id;

	@Column(name = "proj_name")
	private String name;

	@Column(name = "proj_desc")
	private String description;

	@Column(name = "proj_summ")
	private String summary;

	public ProjectDetails() {
	}

	public ProjectDetails(long id, String name, String description, String summary) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.summary = summary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}
