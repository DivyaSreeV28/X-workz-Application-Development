package com.xworkz.springbootweb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="app_info")
//@Data
//@AllArgsConstructor
public class AppInfoEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name="xworkz",strategy = "increment")
	@GeneratedValue(generator = "xworkz")
	@Column(name="APP_ID")
	private int id;
	@Column(name="PROJECT_NAME")
	private String projectName;
	@Column(name="TEAM_MANAGER_NAME")
	private String teamManagerName;
	@Column(name="TEAM_CONTACT_EMAIL")
	private String teamContactEmail;
	@Column(name="DE_COMMISSINED")
	private Boolean deCommissined;
	@Column(name="DEVELOPED_DATE")
	private Date developedDate;
	@Column(name="VERSION")
	private String version;
	@Column(name="LAST_RELEASE")
	private Date lastRelease;
	@Column(name="NEXT_RELEASE")
	private Date nextRelease;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,targetEntity=EnvironmentInfoEntity.class,mappedBy ="appInfoEntity")
	private List<EnvironmentInfoEntity> environmentInfoEntity;
	
	private static final Logger logger=Logger.getLogger(AppInfoEntity.class);
	
	public AppInfoEntity() {
		logger.info("Created AppInfoEntity");
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

	public List<EnvironmentInfoEntity> getEnvironmentInfoEntity() {
		return environmentInfoEntity;
	}

	public void setEnvironmentInfoEntity(List<EnvironmentInfoEntity> environmentInfoEntity) {
		this.environmentInfoEntity = environmentInfoEntity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public AppInfoEntity(int id, String projectName, String teamManagerName, String teamContactEmail,
			Boolean deCommissined, Date developedDate, String version, Date lastRelease, Date nextRelease,
			List<EnvironmentInfoEntity> environmentInfoEntity) {
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
		this.environmentInfoEntity = environmentInfoEntity;
	}
	
}
