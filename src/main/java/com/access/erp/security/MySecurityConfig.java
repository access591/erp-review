package com.access.erp.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/static/**").permitAll()
		.antMatchers("/login*").permitAll()
		.anyRequest().authenticated().and()
		.formLogin().loginPage("/login").loginProcessingUrl("/doLogin")	
		.defaultSuccessUrl("/verify",true).and().logout().logoutSuccessUrl("/login?logout")
		;
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		 auth.inMemoryAuthentication()
         .withUser("admin")
         .password("{noop}admin")
         .roles("USER");
		 
		 
	}

	

	
	
}
