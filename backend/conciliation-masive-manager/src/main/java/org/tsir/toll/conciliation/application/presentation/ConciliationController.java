package org.tsir.toll.conciliation.application.presentation;
	
import org.springframework.web.bind.annotation.GetMapping;

public class ConciliationController {

	
	@GetMapping(value = "/test")
	public String test() {
		return "redirect:/swagger-ui/";
	}


}
