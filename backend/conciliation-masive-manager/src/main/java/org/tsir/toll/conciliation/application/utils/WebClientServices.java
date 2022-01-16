package org.tsir.toll.conciliation.application.utils;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.tsir.toll.conciliation.domain.dto.ReconcileDTO;

@Service
public class WebClientServices {
	
	private Logger log = LoggerFactory.getLogger(WebClientServices.class);
	
	static final String ERROR_FILTERS = "no fue posible convertir a json la lista con los filtros de consulta";
	static final String AUTHORIZATION = "Authorization";
	static final String FILTER = "filter";
	
	public List<ReconcileDTO> getReconcileDTO(Map<String,String > filterReconcile, String token) {
		log.info("http://localhost:8760/conciliation-manager/api/v1/reconcile");
		return WebClient.create("http://localhost:8760/conciliation-manager/api/v1/reconcile").get().headers(httpHeaders -> httpHeaders.add(AUTHORIZATION, token))
//				.uri(uriBuilder -> uriBuilder.path("/ParametersManager/api/v1/parameter/"))
//						.queryParam("stationId", idEsta).build()
				.accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(new ParameterizedTypeReference<List<ReconcileDTO>>() {
				}).block(); 
	}
}
