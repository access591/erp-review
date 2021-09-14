package com.access.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.access.erp.model.master.Company;

@SpringBootApplication
public class ErpSolutionApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ErpSolutionApplication.class, args);
		
		System.out.println(" Running...");
		
		
		
		
	
		
		
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ErpSolutionApplication.class);
    }

}
