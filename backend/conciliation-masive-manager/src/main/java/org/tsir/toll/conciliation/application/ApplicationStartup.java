package org.tsir.toll.conciliation.application;

import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.tsir.common.modules.TaskRegistrable;
import org.tsir.toll.conciliation.application.presentation.ResourceApiController;
@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent>{

	@Autowired
	private TaskRegistrable task;


	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		Timer timer = new Timer("RegistrationModule");
		timer.schedule(new RegisterTask(), 30000);
		
	}

	private class RegisterTask extends TimerTask {

		@Override
		public void run() {
			task.register();
		}

	}
}
