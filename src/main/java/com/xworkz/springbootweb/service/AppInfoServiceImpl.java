package com.xworkz.springbootweb.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.springbootweb.dto.AppInfoDto;
import com.xworkz.springbootweb.entity.AppInfoEntity;
import com.xworkz.springbootweb.entity.EnvironmentInfoEntity;
import com.xworkz.springbootweb.repository.AppInfoRepository;

@Service
public class AppInfoServiceImpl implements AppInfoService {
	
	@Autowired
	private AppInfoRepository appInfoRepo;
	
//	@Autowired
//	private ModelMapper modelMapper;
	
	private static final Logger logger = Logger.getLogger(AppInfoServiceImpl.class);

	@Override
	public AppInfoDto saveAppInfo(AppInfoDto appInfoDto,List<AppInfoDto> list) {
		try {
			if (Objects.nonNull(appInfoDto) && Objects.nonNull(list)) {
				logger.debug("AppInfoDto not null can save..");

				AppInfoEntity appInfoEntity = new AppInfoEntity();
				List<EnvironmentInfoEntity> envEntityList = new ArrayList<>();
				
				appInfoDto.setCreatedTime(LocalDate.now());
				appInfoDto.setCreatedBy("Dell User");

				//modelMapper.map(appInfoDto, AppInfoEntity.class);
				BeanUtils.copyProperties(appInfoDto, appInfoEntity);

				for (AppInfoDto envList : list) {

					EnvironmentInfoEntity envEntity = new EnvironmentInfoEntity();
					//modelMapper.map(envList, EnvironmentInfoEntity.class);
					BeanUtils.copyProperties(envList, envEntity);
					envEntity.setAppInfoEntity(appInfoEntity);

					envEntityList.add(envEntity);
				}
				appInfoEntity.setEnvironmentInfoEntity(envEntityList);

				appInfoRepo.save(appInfoEntity);
			} else {
				logger.debug("AppInfoDTO is null can't save..");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

}
