package com.xworkz.appmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xworkz.appmanagement.dto.AppInfoDto;

@Repository
public interface AppInfoRepository extends JpaRepository<AppInfoDto, Long>{

}
