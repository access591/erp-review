package com.access.erp.singleton;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonDummy {
	
	
	private String userName;

	   public String getUserName() {
	      return userName;
	   }

	   public void setUserName(String userName) {
	      this.userName = userName;
	   }

	
}
