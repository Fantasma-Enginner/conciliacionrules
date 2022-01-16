package org.tsir.toll.conciliation.application.presentation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.hibernate.TypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.tsir.common.api.RequestHandler;
import org.tsir.common.utils.ObjectUtilsVP;
import org.tsir.toll.conciliation.application.MappingFactory;
import org.tsir.toll.conciliation.application.register.ConciliationModule;
import org.tsir.toll.conciliation.domain.services.ResourcesServices;
import org.tsir.toll.conciliation.infraestructure.api.ConciliationmassiveApi;
import org.tsir.toll.conciliation.domain.dto.EntryFilter;
import org.tsir.toll.conciliation.domain.dto.DacTicketDTO;
import org.tsir.toll.conciliation.domain.dto.DetailTicketConcDTO;
import org.tsir.toll.conciliation.domain.dto.DetailTicketDTO;
import org.tsir.toll.conciliation.domain.dto.InfoTablesDTO;
import org.tsir.toll.conciliation.domain.entities.IConsolidateTickect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;





@RestController
@RequestMapping({ "/api/v1" })
public class ResourceApiController extends RequestHandler implements ConciliationmassiveApi {


	
	@Autowired
	private MappingFactory mapper;

	@Autowired
	private ResourcesServices infoTablesService;

	@Autowired
	private static final Logger log = LoggerFactory.getLogger(ResourceApiController.class);

	
	@Override
	public ResponseEntity<Void> postReconcileMassive(@Valid Map<String, String> filter) {
	    
		return null;
	}

	@Override
	@PreAuthorize("hasAuthority('" + ConciliationModule.GET_CONCILIATION_AUTHORITY + "')")
	public ResponseEntity<List<DacTicketDTO>> getDACTicket(@Valid Map<String, String> mapFilter) {
			
		String token = null;
		if(getRequest().isPresent()) {
			token= getRequest().get().getHeader("Authorization");
		}
		
	//	Map<String, String> mapFilter = ObjectUtilsVP.getMapFilter(getObjectMapper(), filter);
		List<IConsolidateTickect> lsMod = infoTablesService.getInfoTables(mapFilter,token);
		List<DacTicketDTO> body = lsMod.stream().map(mapper::mapDacTicketDTO).collect(Collectors.toList());
		return ResponseEntity.ok(body);
	}

	@Override
	public ResponseEntity<List<InfoTablesDTO>> getInfoTables(@Valid String filter) {
		
		String token = null;
		if(getRequest().isPresent()) {
			token= getRequest().get().getHeader("Authorization");
		}
		
		List<InfoTablesDTO> miLista = new ArrayList<InfoTablesDTO>();

		Map<String, String> mapFilter = mapFilters(filter);
		List<InfoTablesDTO> body = miLista;
		List<IConsolidateTickect> lsMod = infoTablesService.getInfoTables(mapFilter,token);

		body = lsMod.stream().map(mapper::mapInfoTablesDTO).collect(Collectors.toList());
		return ResponseEntity.ok(body);

	}

	@PostConstruct
	private void loadMapping() {
		mapper.loadReconcileMapping();
	}

	private Map<String, String> mapFilters(String stringFilter) {
		List<EntryFilter> filter = null;
		try {
			Optional<ObjectMapper> objectMapper = getObjectMapper();
			if (objectMapper.isPresent() && !ObjectUtils.isEmpty(stringFilter)) {
				filter = objectMapper.get().readerForListOf(EntryFilter.class).readValue(stringFilter);
			}
		} catch (JsonProcessingException e) {
			throw new TypeMismatchException("No es posible obtener criterios de búsqueda para nodos");
		}
		return filter != null ? filter.stream().collect(Collectors.toMap(EntryFilter::getKey, EntryFilter::getValue))
				: new HashMap<>();
	}
	
	
	
	
	
	
	
	
	
	@Override
	@PreAuthorize("hasAuthority('" + ConciliationModule.PUT_CONCILIATE_MASSIVELY_AUTHORITY + "')")
	public ResponseEntity<Void> putReconcileMassive(@Valid DetailTicketConcDTO body) {
		infoTablesService.updateTicket(mapper.mapToDetailTicket(body));
		//return RESPONSE_VOID_OK;
		return ResponseEntity.created(null).build();
	}


	
	

	
	
	


}
