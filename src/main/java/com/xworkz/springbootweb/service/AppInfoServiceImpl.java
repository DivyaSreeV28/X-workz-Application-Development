package com.xworkz.springbootweb.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.springbootweb.dto.AppInfoDto;
import com.xworkz.springbootweb.entity.AppInfoEntity;
import com.xworkz.springbootweb.entity.EnvironmentInfoEntity;
import com.xworkz.springbootweb.repository.AppInfoRepository;

@Service
public class AppInfoServiceImpl implements AppInfoService {
	
	@Autowired
	private AppInfoRepository appInfoRepo;

	static final Logger logger = Logger.getLogger(AppInfoServiceImpl.class);
	
	@Override
	public AppInfoDto saveAppInfo(AppInfoDto appInfoDto,List<AppInfoDto> list) {
		try {
			if (Objects.nonNull(appInfoDto) && Objects.nonNull(list)) {
				logger.debug("AppInfoDto not null can save..");

				AppInfoEntity appInfoEntity = new AppInfoEntity();
				List<EnvironmentInfoEntity> envEntityList = new ArrayList<>();
				
				appInfoDto.setCreatedDate(LocalDate.now());
				appInfoDto.setCreatedBy("User");

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
	
	@Override
	public List<AppInfoDto> readAppInfoFromExcel(MultipartFile excelfile) {
		logger.debug("invoked readAppInfoFromExcel method in ExcelServiceImpl class");
		List<AppInfoDto> listAppInfo = new ArrayList<>();
		try {
			int i = 1;                      // fetching excel data for AppInfo..
			// Creates a workbook object from the uploaded excel file
			XSSFWorkbook workbook = new XSSFWorkbook(excelfile.getInputStream());
			// Creates a worksheet object representing the first sheet for AppInfo
			XSSFSheet worksheetForAppInfo = workbook.getSheetAt(0);
			// Creates a worksheet object representing the first sheet for EnvInfo
			XSSFSheet worksheetForEnvInfo = workbook.getSheetAt(1);
			// Reads the data in excel file until last row is encountered
			while (i < worksheetForAppInfo.getLastRowNum()) {
				 AppInfoDto appInfo = new AppInfoDto();
				// Creates an object representing a single row in excel for AppInfo
				XSSFRow row = worksheetForAppInfo.getRow(i);
				// Sets the Read data to the model class for AppInfo
				appInfo.setProjectName(row.getCell(0).getStringCellValue());
				appInfo.setTeamManagerName(row.getCell(1).getStringCellValue());
				appInfo.setTeamContactEmail(row.getCell(2).getStringCellValue());
				appInfo.setDeCommissined(row.getCell(3).getBooleanCellValue());
				appInfo.setDevelopedDate(row.getCell(4).getDateCellValue());
				appInfo.setVersion(row.getCell(5).toString());
				//Convert string to date type
				appInfo.setLastRelease(new SimpleDateFormat("dd/MM/yyyy").parse(row.getCell(6).toString()));
				appInfo.setNextRelease(new SimpleDateFormat("dd/MM/yyyy").parse(row.getCell(7).toString()));
				//convert String to localdate
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
				String createdDate=row.getCell(8).toString();
				appInfo.setCreatedDate(LocalDate.parse(createdDate, formatter));
				appInfo.setCreatedBy(row.getCell(9).getStringCellValue());
				String UpdatedTime=row.getCell(10).toString();
				appInfo.setUpdatedDate(LocalDate.parse(UpdatedTime, formatter));
				appInfo.setUpdatedBy(row.getCell(11).getStringCellValue());

				double idForApp = row.getCell(12).getNumericCellValue();
				System.out.println("idForApp :" + idForApp);

				int j = 1;
				double idForEnv = 0.0;
				List<String> urlList = new ArrayList<>();
				List<String> environmentList = new ArrayList<>();
				List<Boolean> accessibilityList = new ArrayList<>();
				//setting data for EnvInfo
				while (j < worksheetForEnvInfo.getLastRowNum()+1) {
					// Creates an object representing a single row in excel for EnvInfo
					XSSFRow rowForEnv = worksheetForEnvInfo.getRow(j);
					// Sets the Read data to the model class for EnvInfo
					idForEnv = rowForEnv.getCell(0).getNumericCellValue();
					System.out.println("idForEnv :" + idForEnv);
					if (idForApp == idForEnv) {
						accessibilityList.add(rowForEnv.getCell(3).getBooleanCellValue());
						urlList.add(rowForEnv.getCell(2).getStringCellValue());
						environmentList.add(rowForEnv.getCell(1).getStringCellValue());
					}
					j++;
				}
				appInfo.setAccessibility(accessibilityList);
				appInfo.setUrl(urlList);
				appInfo.setEnvironment(environmentList);

				System.out.println(accessibilityList);
				System.out.println(urlList);
				System.out.println(environmentList);

				listAppInfo.add(appInfo);               // persist data into database in here
				System.out.println(listAppInfo);
				i++;
			}
			workbook.close();
			return listAppInfo;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return listAppInfo;
	}

	@Override
	public String saveBulkData(MultipartFile excelfile) {
		logger.debug("invoked saveExcel method in SaveExcelImpl class..");
		try {
			List<AppInfoDto> appInfoDTO = readAppInfoFromExcel(excelfile);
			System.out.println(appInfoDTO);
			
			Iterator<AppInfoDto> iter = appInfoDTO.iterator();

			if (Objects.nonNull(appInfoDTO)) {
				logger.debug("appInfoDTO is not null can save it..");

				while (iter.hasNext()) {

					AppInfoDto dto = iter.next();
					AppInfoEntity entity = new AppInfoEntity();
					BeanUtils.copyProperties(dto, entity);
					List<String> environmentList = dto.getEnvironment();
					List<String> urlList = dto.getUrl();
					List<Boolean> accessibilityList = dto.getAccessibility();
					Iterator<String> itr1=environmentList.iterator();
					Iterator<String> itr2=urlList.iterator();
					Iterator<Boolean> itr3=accessibilityList.iterator();
				
					List<EnvironmentInfoEntity> envEntities = new ArrayList<EnvironmentInfoEntity>();
					EnvironmentInfoEntity appInfoEnvEntity = null;
					while (itr1.hasNext() && itr2.hasNext()) {
						appInfoEnvEntity = new EnvironmentInfoEntity();
						String env=itr1.next();
						String url=itr2.next();
						Boolean accessibility=itr3.next();
						appInfoEnvEntity.setEnvironment(env);
						appInfoEnvEntity.setUrl(url);
						appInfoEnvEntity.setAccessibility(accessibility);
						envEntities.add(appInfoEnvEntity);
					}
					entity.setEnvironmentInfoEntity(envEntities);
					appInfoEnvEntity.setAppInfoEntity(entity);
					appInfoRepo.save(entity);				}
				return "File Uploaded Successfully and Save it..";
			} else {
				logger.debug("appInfoDTO is null can't save it..");
				return "File Uploaded Successfully but not Save it..";
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

}
