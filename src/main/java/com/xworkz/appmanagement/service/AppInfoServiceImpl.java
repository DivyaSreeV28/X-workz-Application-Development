package com.xworkz.appmanagement.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.appmanagement.dto.AppInfoDto;
import com.xworkz.appmanagement.entity.AppInfoEntity;
import com.xworkz.appmanagement.entity.EnvironmentInfoEntity;
import com.xworkz.appmanagement.exceptions.FieldNotFoundException;
import com.xworkz.appmanagement.repository.AppInfoRepository;

@Service
public class AppInfoServiceImpl implements AppInfoService {
	
	@Autowired
	private AppInfoRepository appInfoRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private static final Logger logger = Logger.getLogger(AppInfoServiceImpl.class);

	@Override
	public AppInfoDto saveAppInfo(AppInfoEntity appInfoEntity, EnvironmentInfoEntity envInfoEntity) {
		AppInfoDto appInfoDto= null;
		try {
			logger.info("Started: saveMessage from MessageServiceImpl ");
			if (Objects.nonNull(appInfoEntity)) {
				
				logger.info("-------------------Copying both entities fields with dto "+appInfoEntity+" and "+envInfoEntity);
				appInfoDto=modelMapper.map(appInfoEntity, AppInfoDto.class);
				appInfoDto=modelMapper.map(envInfoEntity, AppInfoDto.class);
				
				logger.info("-------------------Saving entity into message_table "+appInfoDto);
				appInfoRepo.save(appInfoDto);

			}else {
				throw new FieldNotFoundException("Field not found exception");
			}
			return appInfoDto;
		} catch (Exception e) {
			logger.error("Exception in saveMessage ", e);
			System.out.println(e);
		}
		logger.info("Ended: saveMessage from MessageServiceImpl");
		return appInfoDto;
	}

}
