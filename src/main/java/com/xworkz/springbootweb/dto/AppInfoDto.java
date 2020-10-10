package com.xworkz.springbootweb.dto;

import java.time.LocalDate;
import java.util.Date;

import org.apache.log4j.Logger;

public class AppInfoDto {

	private int id;
	private String projectName;
	private String teamManagerName;
	private String teamContactEmail;
	private Boolean deCommissined;
	private Date developedDate;
	private String version;
	private Date lastRelease;
	private Date nextRelease;
	private LocalDate createdTime;
	private String createdBy;
	private LocalDate updatedTime;
	private String updatedBy;
	private String environment;
	private String url;
	private Boolean accessibility;
	
	private static final Logger logger=Logger.getLogger(AppInfoDto.class);
	
	public AppInfoDto() {
		logger.info("Created AppInfoDto");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTeamManagerName() {
		return teamManagerName;
	}

	public void setTeamManagerName(String teamManagerName) {
		this.teamManagerName = teamManagerName;
	}

	public String getTeamContactEmail() {
		return teamContactEmail;
	}

	public void setTeamContactEmail(String teamContactEmail) {
		this.teamContactEmail = teamContactEmail;
	}

	public Boolean getDeCommissined() {
		return deCommissined;
	}

	public void setDeCommissined(Boolean deCommissined) {
		this.deCommissined = deCommissined;
	}

	public Date getDevelopedDate() {
		return developedDate;
	}

	public void setDevelopedDate(Date developedDate) {
		this.developedDate = developedDate;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getLastRelease() {
		return lastRelease;
	}

	public void setLastRelease(Date lastRelease) {
		this.lastRelease = lastRelease;
	}

	public Date getNextRelease() {
		return nextRelease;
	}

	public void setNextRelease(Date nextRelease) {
		this.nextRelease = nextRelease;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public LocalDate getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDate createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(LocalDate updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getAccessibility() {
		return accessibility;
	}

	public void setAccessibility(Boolean accessibility) {
		this.accessibility = accessibility;
	}

	public AppInfoDto(String projectName, String teamManagerName, String teamContactEmail, Boolean deCommissined,
			Date developedDate, String version, Date lastRelease, Date nextRelease, LocalDate createdTime, String createdBy,
			LocalDate updatedTime, String updatedBy, String environment, String url, Boolean accessibility) {
		super();
		this.projectName = projectName;
		this.teamManagerName = teamManagerName;
		this.teamContactEmail = teamContactEmail;
		this.deCommissined = deCommissined;
		this.developedDate = developedDate;
		this.version = version;
		this.lastRelease = lastRelease;
		this.nextRelease = nextRelease;
		this.createdTime = createdTime;
		this.createdBy = createdBy;
		this.updatedTime = updatedTime;
		this.updatedBy = updatedBy;
		this.environment = environment;
		this.url = url;
		this.accessibility = accessibility;
	}

}
