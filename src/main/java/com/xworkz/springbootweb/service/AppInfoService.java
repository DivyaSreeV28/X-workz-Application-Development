package com.xworkz.springbootweb.service;

import java.util.List;

import com.xworkz.springbootweb.dto.AppInfoDto;

public interface AppInfoService {
	
	public AppInfoDto saveAppInfo(AppInfoDto appInfoDto,List<AppInfoDto> list);

}
