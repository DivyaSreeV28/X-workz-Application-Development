package com.xworkz.springbootweb.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.springbootweb.dto.AppInfoDto;
import com.xworkz.springbootweb.service.AppInfoService;
import com.xworkz.springbootweb.service.MessageService;

@Controller
public class AppInfoController {
	
	private static final Logger logger = Logger.getLogger(AppInfoController.class);
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	private AppInfoService appInfoService;
	
	private List<AppInfoDto> list;

	public AppInfoController() {
		logger.info("Created " + this.getClass().getSimpleName());
	}

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), true));
	}

	@PostConstruct
	public void init() {
		list = new ArrayList<AppInfoDto>();
	}
	
	@RequestMapping("onadd")
	public String onClick() {
		logger.info("Invoked onClick");
		return "AddAppInfo";
	}
	
	@RequestMapping(value = "sendModal", method = RequestMethod.POST)
	public String getModalData(AppInfoDto appInfoDto, Model model) {

		list.add(appInfoDto);
		logger.info(list);
		model.addAttribute("modalList", list);

		return "AddAppInfo";

	}
	
	@RequestMapping(value="sendAppInfo",method = RequestMethod.POST)
	public String saveAppInfoDetails(AppInfoDto appInfoDto,Model model) {
		try {
			logger.info("Started: saveAppInfoDetails "+appInfoDto);
			logger.info("Invoked welcome page ");

			if (Objects.nonNull(appInfoDto)) {
				logger.debug("invoked addAppInfoDetails method");
				appInfoService.saveAppInfo(appInfoDto, list);
				logger.info("Saving application information into tables "+appInfoDto);
				
				model.addAttribute("projectName", appInfoDto.getProjectName());
				model.addAttribute("managerName", appInfoDto.getTeamManagerName());
				model.addAttribute("teamEmailId", appInfoDto.getTeamContactEmail());
				model.addAttribute("developedDate", appInfoDto.getDevelopedDate());
				model.addAttribute("deCommissined", appInfoDto.getDeCommissined());
				model.addAttribute("version", appInfoDto.getVersion());
				model.addAttribute("lastRelease", appInfoDto.getLastRelease());
				model.addAttribute("nextRelease", appInfoDto.getNextRelease());
				
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
		logger.info("Ended: saveAppInfoDetails "+appInfoDto);
		return "AddAppInfo";
	}
}