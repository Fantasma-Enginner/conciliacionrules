package org.tsir.toll.conciliation.domain.services;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tsir.toll.conciliation.domain.entities.IConsolidateTickect;
import org.tsir.toll.conciliation.domain.entities.DetalleTiquete;


public interface ResourcesServices {
	
	Logger log = LoggerFactory.getLogger(ResourcesServices.class);
	
	List<DetalleTiquete> conciliationmassive(Map<String, String> mapFilter);
	List<IConsolidateTickect> getInfoTables(Map<String, String> mapFilter, String token);
	public void updateTicket(DetalleTiquete data);
}
