package com.xworkz.springbootweb.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.xworkz.springbootweb.dto.AppInfoDto;

public interface AppInfoService {
	
	public AppInfoDto saveAppInfo(AppInfoDto appInfoDto,List<AppInfoDto> list);
	
	public List<AppInfoDto> readAppInfoFromExcel(MultipartFile excelfile);
	
	public String saveBulkData(MultipartFile excelfile);
	
	
//	public void saveBulkData(MultipartFile excelfile);

}
