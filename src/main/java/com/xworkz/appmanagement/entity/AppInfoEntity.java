package com.xworkz.appmanagement.entity;

import java.io.Serializable;
import java.util.Set;

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

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="app_info")
@Data
@AllArgsConstructor
public class AppInfoEntity  implements Serializable{
	
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
	private String developedDate;
	@Column(name="VERSION")
	private String version;
	@Column(name="LAST_RELEASE")
	private String lastRelease;
	@Column(name="NEXT_RELEASE")
	private String nextRelease;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy ="environment_info")
	private Set<EnvironmentInfoEntity> environmentInfoEntity;
	
	private static final Logger logger=Logger.getLogger(AppInfoEntity.class);
	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getProjectName() {
//		return projectName;
//	}
//	public void setProjectName(String projectName) {
//		this.projectName = projectName;
//	}
//	public String getTeamManagerName() {
//		return teamManagerName;
//	}
//	public void setTeamManagerName(String teamManagerName) {
//		this.teamManagerName = teamManagerName;
//	}
//	public String getTeamContactEmail() {
//		return teamContactEmail;
//	}
//	public void setTeamContactEmail(String teamContactEmail) {
//		this.teamContactEmail = teamContactEmail;
//	}
//	
//	public Boolean getDeComissined() {
//		return deComissined;
//	}
//	public void setDeComissined(Boolean deComissined) {
//		this.deComissined = deComissined;
//	}
//	public String getDevelopedDate() {
//		return developedDate;
//	}
//	public void setDevelopedDate(String developedDate) {
//		this.developedDate = developedDate;
//	}
//	public String getVersion() {
//		return version;
//	}
//	public void setVersion(String version) {
//		this.version = version;
//	}
//	public String getLastRelease() {
//		return lastRelease;
//	}
//	public void setLastRelease(String lastRelease) {
//		this.lastRelease = lastRelease;
//	}
//	public String getNextRelease() {
//		return nextRelease;
//	}
//	public void setNextRelease(String nextRelease) {
//		this.nextRelease = nextRelease;
//	}
//	public Set<EnvironmentInfoEntity> getEnvironmentInfoEntity() {
//		return environmentInfoEntity;
//	}
//	public void setEnvironmentInfoEntity(Set<EnvironmentInfoEntity> environmentInfoEntity) {
//		this.environmentInfoEntity = environmentInfoEntity;
//	}
	public AppInfoEntity() {
		logger.info("Created AppInfoEntity");
	}
//	public AppInfoEntity(String projectName, String teamManagerName, String teamContactEmail, Boolean deComissined,
//			String developedDate, String version, String lastRelease, String nextRelease,
//			Set<EnvironmentInfoEntity> environmentInfoEntity) {
//		super();
//		this.projectName = projectName;
//		this.teamManagerName = teamManagerName;
//		this.teamContactEmail = teamContactEmail;
//		this.deCommissined = deComissined;
//		this.developedDate = developedDate;
//		this.version = version;
//		this.lastRelease = lastRelease;
//		this.nextRelease = nextRelease;
//		this.environmentInfoEntity = environmentInfoEntity;
//	}

}
