package com.xworkz.springbootweb.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
	private LocalDate createdDate;
	private String createdBy;
	private LocalDate updatedDate;
	private String updatedBy;
	private List<String> environment;
	private List<String> url;
	private List<Boolean> accessibility;
	
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

	

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public List<String> getEnvironment() {
		return environment;
	}

	public void setEnvironment(List<String> environment) {
		this.environment = environment;
	}

	public List<String> getUrl() {
		return url;
	}

	public void setUrl(List<String> url) {
		this.url = url;
	}

	public List<Boolean> getAccessibility() {
		return accessibility;
	}

	public void setAccessibility(List<Boolean> accessibility) {
		this.accessibility = accessibility;
	}

	public AppInfoDto(String projectName, String teamManagerName, String teamContactEmail, Boolean deCommissined,
			Date developedDate, String version, Date lastRelease, Date nextRelease, LocalDate createdTime,
			String createdBy, LocalDate updatedTime, String updatedBy, List<String> environment, List<String> url,
			List<Boolean> accessibility) {
		super();
		this.projectName = projectName;
		this.teamManagerName = teamManagerName;
		this.teamContactEmail = teamContactEmail;
		this.deCommissined = deCommissined;
		this.developedDate = developedDate;
		this.version = version;
		this.lastRelease = lastRelease;
		this.nextRelease = nextRelease;
		this.createdDate = createdTime;
		this.createdBy = createdBy;
		this.updatedDate = updatedTime;
		this.updatedBy = updatedBy;
		this.environment = environment;
		this.url = url;
		this.accessibility = accessibility;
	}

}
