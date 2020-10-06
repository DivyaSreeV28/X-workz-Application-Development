package com.xworkz.appmanagement.dto;

import org.apache.log4j.Logger;

public class AppInfoDto {

	private int id;
	private String projectName;
	private String teamManagerName;
	private String teamContactEmail;
	private Boolean deComissined;
	private String developedDate;
	private String version;
	private String lastRelease;
	private String nextRelease;
	private String environment;
	private String url;
	private String accessibility;
	
	private static final Logger logger=Logger.getLogger(AppInfoDto.class);
	
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
	
	public Boolean getDeComissined() {
		return deComissined;
	}
	public void setDeComissined(Boolean deComissined) {
		this.deComissined = deComissined;
	}
	public String getDevelopedDate() {
		return developedDate;
	}
	public void setDevelopedDate(String developedDate) {
		this.developedDate = developedDate;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getLastRelease() {
		return lastRelease;
	}
	public void setLastRelease(String lastRelease) {
		this.lastRelease = lastRelease;
	}
	public String getNextRelease() {
		return nextRelease;
	}
	public void setNextRelease(String nextRelease) {
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
	public String getAccessibility() {
		return accessibility;
	}
	public void setAccessibility(String accessibility) {
		this.accessibility = accessibility;
	}
	public AppInfoDto() {
		logger.info("Created AppInfoDto");
	}
	public AppInfoDto(String projectName, String teamManagerName, String teamContactEmail, Boolean deComissined,
			String developedDate, String version, String lastRelease, String nextRelease, String environment,
			String url, String accessibility) {
		super();
		this.projectName = projectName;
		this.teamManagerName = teamManagerName;
		this.teamContactEmail = teamContactEmail;
		this.deComissined = deComissined;
		this.developedDate = developedDate;
		this.version = version;
		this.lastRelease = lastRelease;
		this.nextRelease = nextRelease;
		this.environment = environment;
		this.url = url;
		this.accessibility = accessibility;
	}
	
	
}
