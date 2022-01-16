package org.tsir.toll.conciliation.domain.services.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QSort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.tsir.common.api.exceptions.NotFoundException;
import org.tsir.common.api.exceptions.NotSupportCriteriaException;
import org.tsir.toll.conciliation.application.MappingFactory;
import org.tsir.toll.conciliation.application.utils.WebClientServices;
import org.tsir.toll.conciliation.domain.dto.ReconcileDTO;
import org.tsir.toll.conciliation.domain.entities.DetalleTiquete;
import org.tsir.toll.conciliation.domain.entities.IConsolidateTickect;
import org.tsir.toll.conciliation.domain.entities.QDetalleTiquete;
import org.tsir.toll.conciliation.domain.services.ResourcesServices;
import org.tsir.toll.conciliation.domain.values.TicketStatus;
import org.tsir.toll.conciliation.infraestructure.config.ConciliationService;
import org.tsir.toll.conciliation.infraestructure.persistence.ResourceRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

@Service
public class ResourceServiceImpl implements ResourcesServices {

	@Autowired
	private ResourceRepository reconciliateDAO;

	@Autowired
	private ConciliationService conciliationService;

	@Autowired
	private ConciliationService webClient;

	private String filterReconcile;
	
	private MappingFactory mapping;

	@Override
	public List<DetalleTiquete> conciliationmassive(Map<String, String> mapFilter) {
		return null;
	}

	
	@Override
	public List<IConsolidateTickect> getInfoTables(Map<String, String> filter, String token) {
		
		BooleanBuilder builder = new BooleanBuilder();
		// log.info(filter.toString());
		QDetalleTiquete qdetalleTiquete = QDetalleTiquete.detalleTiquete;
		// log.info(qdetalleTiquete.iddetalletiquete.asc().toString());
		Sort sort = new QSort(qdetalleTiquete.iddetalletiquete.asc());
		List<DetalleTiquete> results;
		if (filter != null && !filter.isEmpty()) {
			filter.forEach((k, v) -> builder.and(getPredicate(qdetalleTiquete, k, v)));
			results = IterableUtils.toList(reconciliateDAO.findAll(builder, sort));
		} else {
			log.info(reconciliateDAO.findAll(sort).toString());

			results = reconciliateDAO.findAll(sort);
		}

		// Get result grouped by category and null reconciliation
		Map<Long, Map<Boolean, Long>> group = results.stream().collect(Collectors.groupingBy(
				DetalleTiquete::getIdcate, Collectors.groupingBy(d -> d.getIdconc() != null, Collectors.counting())));
		log.info("Agreegate ->" + group);

		List<IConsolidateTickect> collect = new ArrayList<>();

		List<ReconcileDTO> list = new ArrayList<>();

		// Get amount of DAC'S (G,D,C)

		webClient = new ConciliationService();
		list = webClient.findConciliations(filter, token);

		list.containsAll(list);
		log.info("lista contains" + list);

		List<Integer> lst = new ArrayList<>();

		Map<Integer, IConsolidateTickect> mapCollect = new HashMap<>();
		// Results are traversed by category
		group.forEach((c, v) -> {

			// Get amount of Tickets (G,D,C)
			IConsolidateTickect t = new IConsolidateTickect();
			ReconcileDTO j = new ReconcileDTO();
			t.setCategory(Integer.parseInt(c.toString()));

			// Results are traversed by not reconcile
			v.forEach((b, qty) -> {
				if (b) {
					t.setTicketC(qty.intValue());
				} else {
					t.setTicketD(qty.intValue());
				}
			});
			if (t.getTicketC() == null) {
				t.setTicketC(0);
			}
			if (t.getTicketD() == null) {
				t.setTicketD(0);
			}
			t.setTicketG(t.getTicketC() + t.getTicketD());
			t.setDacC(0);
			t.setDacD(0);
			t.setDacG(0);
			collect.add(t);
			mapCollect.put(t.getCategory(), t);

			lst.add(Integer.valueOf(c.toString()));
			log.info("lista " + lst);
		});

		// Get amount of DAC'S (G,D,C)
		List<ReconcileDTO> list1 = new ArrayList<>();
		webClient = new ConciliationService();
		list1 = webClient.findConciliations(filter, token);

		list1.containsAll(list1);
//		log.info("lista contains" + list1);

		Map<Integer, Map<Boolean, Long>> groupDacs = list1.stream()
				.collect(Collectors.groupingBy(ReconcileDTO::getDacCategory,
						Collectors.groupingBy(d -> d.getConciliationRuleName() != null, Collectors.counting())));

		log.info("lista de agrupada filtrada por  categoria =  c" + groupDacs);

		// Results are traversed by not reconcile
		groupDacs.forEach((d, f) -> {
			IConsolidateTickect t;
			if (mapCollect.containsKey(d)) {
				t = mapCollect.get(d);
			} else {
				t = new IConsolidateTickect();
				collect.add(t);
				t.setTicketC(0);
				t.setTicketD(0);
				t.setTicketG(0);
				t.setCategory(d);
			}
			
			// Results are traversed by not reconcile
			f.forEach((b, qty) -> {
				if (b) {
					t.setDacC(qty.intValue());
				} else {
					t.setDacD(qty.intValue());
				}
			});

			if (t.getDacC() == null) {
				t.setDacC(0);
			}
			if (t.getDacD() == null) {
				t.setDacD(0);
			}
			log.info(t.getDacC() + "  " + t.getDacD());
			t.setDacG(t.getDacC() + t.getDacD());
		});
		return collect;
		
	
	}

	public boolean validateCat(List<Integer> lst, Integer cat) {
		for (Integer i : lst) {
			if (i == cat) {
				return true;
			}
		}
		return false;

	}

	private Predicate getPredicate(QDetalleTiquete q, String criteria, String value) {
		switch (criteria) {
		case "DATECOLLECTION":
			LocalDate date = LocalDate.parse(value);
			return q.fecharecaudo.eq(date);
		case "LANEID":
			return q.idcarril.stringValue().equalsIgnoreCase(value);
		case "TURNCODE":
			return q.codigoturno.stringValue().contains(value);
		default:
			throw new NotSupportCriteriaException("Conciliacion masiva", criteria);
		}
	}

	@Override
	public void updateTicket(DetalleTiquete data) {
		log.info(data.getIddetalletiquete().toString());
		DetalleTiquete ticket = findTicket(data.getIddetalletiquete());
		ticket.setIdinvetiqu(data.getIdinvetiqu());
		ticket.setIdtrandac(data.getIdtrandac());
		ticket.setNumerotiquete(data.getNumerotiquete());
		ticket.setEstadotiquete(data.getEstadotiquete());
		ticket.setFecharecaudo(data.getFecharecaudo());
		ticket.setIdconc(data.getIdconc());
		ticket.setCodigoestacion(data.getCodigoestacion());
		ticket.setIdcarril(data.getIdcarril());
		ticket.setCodigoturno(data.getCodigoturno());
		ticket.setIdcate(data.getIdcate());
		reconciliateDAO.save(ticket);
	}
	
	private DetalleTiquete findTicket(long id) {
		return reconciliateDAO.findById(id)
				.orElseThrow(() -> new NotFoundException("Tiquete", "identificador", String.valueOf(id)));
	}

}