package org.tsir.toll.conciliation.application.register;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.tsir.common.modules.TaskRegistrable;
import org.tsir.common.services.RegisterService;

public class RegisterProductionTask implements TaskRegistrable {

	
	  private Logger logger =
	  LoggerFactory.getLogger(RegisterProductionTask.class);
	  
	  @Autowired 
	  private RegisterService service;
	  
	  
	  @Override
	  public void register() {
		  List<String> results = new ArrayList<>();
		  results.addAll(service.registerModule(ConciliationModule.INSTANCE, "/conciliationmasive-app/main.js"));
		  logger.info("Registration Module Conciliation Masive: \n{}", results);
	  }
	 
}
