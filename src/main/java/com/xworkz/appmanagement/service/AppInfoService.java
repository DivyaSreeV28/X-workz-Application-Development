package com.xworkz.appmanagement.service;

import com.xworkz.appmanagement.dto.AppInfoDto;
import com.xworkz.appmanagement.entity.AppInfoEntity;
import com.xworkz.appmanagement.entity.EnvironmentInfoEntity;

public interface AppInfoService {
	
	public AppInfoDto saveAppInfo(AppInfoEntity appInfoEntity, EnvironmentInfoEntity envInfoEntity);

}
