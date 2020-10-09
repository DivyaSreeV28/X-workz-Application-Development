package com.xworkz.springbootweb.dto;

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

	public AppInfoDto(int id, String projectName, String teamManagerName, String teamContactEmail,
			Boolean deCommissined, Date developedDate, String version, Date lastRelease, Date nextRelease,
			String environment, String url, Boolean accessibility) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.teamManagerName = teamManagerName;
		this.teamContactEmail = teamContactEmail;
		this.deCommissined = deCommissined;
		this.developedDate = developedDate;
		this.version = version;
		this.lastRelease = lastRelease;
		this.nextRelease = nextRelease;
		this.environment = environment;
		this.url = url;
		this.accessibility = accessibility;
	}

}
