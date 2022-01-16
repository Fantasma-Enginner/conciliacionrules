package org.tsir.toll.conciliation.infraestructure.config;

import java.time.LocalDate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;
import org.tsir.common.services.AbstractService;
import org.tsir.toll.conciliation.application.utils.WebClientServices;
import org.tsir.toll.conciliation.domain.dto.ReconcileDTO;

public class ConciliationService extends AbstractService {

	
	private Logger log = LoggerFactory.getLogger(ConciliationService.class);
	
	static final String ERROR_FILTERS = "no fue posible convertir a json la lista con los filtros de consulta";
	static final String AUTHORIZATION = "Authorization";
	static final String FILTER = "filter";
	
	public ConciliationService() {
		setHost("localhost");
		setPort(8760);
		setSecure(false);
		setContextPath("conciliation-manager/");
		setApiPath("api/v1/");
	}

	private String location;

	public String getLocation() {
		return location;
	}

	public List<ReconcileDTO> findConciliations(Map<String, String> mapFilter, String token) {
		try {
			log.info(mapFilter.toString());
			log.info("map "+ mapFilter);
			
			String uri = getUriComponents("reconcile").queryParam("filter", mapFilter.toString()).toUriString();
			log.info("map "+ mapFilter);
			List<ReconcileDTO> objects = WebClient.create("http://localhost:8760").get()
					.uri(uriBuilder -> uriBuilder.path("/conciliation-manager/api/v1/reconcile").queryParam("filter", mapFilter.toString()).build())
					.headers(httpHeaders -> httpHeaders.add(AUTHORIZATION, token)).retrieve()
					.bodyToMono(new ParameterizedTypeReference<List<ReconcileDTO>>() {
					}).block();
//			log.info(uriBuilder.path("/conciliation-manager/api/v1/reconcile").queryParam("filter", mapFilter.toString()).toUriString());
			return objects;
		} catch (Exception e) {
			logger.warn("Creation resource warning {}", e.getMessage());
			return Collections.emptyList();
		}
	}

}
