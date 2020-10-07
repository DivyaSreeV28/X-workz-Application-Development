package com.xworkz.springbootweb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="environment_info")
//@Data
//@AllArgsConstructor
public class EnvironmentInfoEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name="xworkz",strategy = "increment")
	@GeneratedValue(generator = "xworkz")
	@Column(name="ID")
	private int id;
	@Column(name="ENVIRONMENT")
	private String environment;
	@Column(name="URL")
	private String url;
	@Column(name="ACCESSIBILITY")
	private Boolean accessibility;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="APP_ID")
	private AppInfoEntity appInfoEntity;
	
	private static final Logger logger=Logger.getLogger(EnvironmentInfoEntity.class);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public AppInfoEntity getAppInfoEntity() {
		return appInfoEntity;
	}

	public void setAppInfoEntity(AppInfoEntity appInfoEntity) {
		this.appInfoEntity = appInfoEntity;
	}

	public EnvironmentInfoEntity() {
		logger.info("Created EnvironmentInfoEntity");
	}

	public EnvironmentInfoEntity(String environment, String url, Boolean accessibility, AppInfoEntity appInfoEntity) {
		super();
		this.environment = environment;
		this.url = url;
		this.accessibility = accessibility;
		this.appInfoEntity = appInfoEntity;
	}

}
