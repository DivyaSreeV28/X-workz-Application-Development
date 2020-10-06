package com.xworkz.appmanagement.controller;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.appmanagement.dto.AppInfoDto;
import com.xworkz.appmanagement.entity.AppInfoEntity;
import com.xworkz.appmanagement.entity.EnvironmentInfoEntity;
import com.xworkz.appmanagement.service.AppInfoService;

@Controller
//@RequestMapping("/")
public class AppManagementController {
	
	@Autowired
	private AppInfoService appInfoService;
	
	private static final Logger logger = Logger.getLogger(AppManagementController.class);
	
	public AppManagementController() {
		logger.info("Created " + this.getClass().getSimpleName());
	}

	@RequestMapping("onclick")
	public String onClick() {
		logger.info("Invoked onClick");
		return "AddAppInfo";
	}

//	@RequestMapping(value="welcome",method = RequestMethod.POST)
//	public String welcome() {
//		logger.info("Invoked welcome page");
//		return "AddAppInfo";
//	}
	
	@RequestMapping(value="add",method = RequestMethod.POST)
	public String saveAppInfoDetails(AppInfoEntity appInfoEntity,EnvironmentInfoEntity envInfoEntity,Model model) {
		try {
			logger.info("Started: saveAppInfoDetails "+appInfoEntity+" and "+envInfoEntity);
			logger.info("Invoked welcome page ");

			if (Objects.nonNull(appInfoEntity) && Objects.nonNull(envInfoEntity)) {
				 
				AppInfoDto appInfoDto= appInfoService.saveAppInfo(appInfoEntity, envInfoEntity);
				logger.info("Saving application information into tables "+appInfoDto);
				
				model.addAttribute("projectName", appInfoDto.getProjectName());
				model.addAttribute("managerName", appInfoDto.getTeamManagerName());
				model.addAttribute("teamEmailId", appInfoDto.getTeamContactEmail());
				model.addAttribute("developedDate", appInfoDto.getDevelopedDate());
				model.addAttribute("version", appInfoDto.getVersion());
				model.addAttribute("lastRelease", appInfoDto.getLastRelease());
				model.addAttribute("nextRelease", appInfoDto.getNextRelease());
				model.addAttribute("deComissined", appInfoDto.getDeComissined());
				
				logger.info("Directing to success.jsp");
				return "Success";
				
			} else {
				logger.info("Field not valid");
				model.addAttribute("Error", "Please check which field and enter valid data");
				return "Welcome";
			}
		} catch (Exception e) {
			logger.error("Exception in saveAppInfoDetails controller " + e);
		}
		logger.info("Ended: saveAppInfoDetails "+appInfoEntity+" and "+envInfoEntity);
		return "Success";
	}
	
}