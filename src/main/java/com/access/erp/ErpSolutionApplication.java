package com.access.erp;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.access.erp.model.master.Company;
import com.access.erp.service.FilesStorageService;

@SpringBootApplication
public class ErpSolutionApplication implements CommandLineRunner{

	@Resource
	FilesStorageService storageService;
	
	public static void main(String[] args) {
		SpringApplication.run(ErpSolutionApplication.class, args);
		
		System.out.println(" Running...");
	
		
	}

	@Override
	public void run(String... args) throws Exception {
		//storageService.init();	
	}
	


}
