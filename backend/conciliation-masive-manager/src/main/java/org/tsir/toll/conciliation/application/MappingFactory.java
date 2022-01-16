package org.tsir.toll.conciliation.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsir.toll.conciliation.domain.dto.DacTicketDTO;
import org.tsir.toll.conciliation.domain.dto.DetailTicketConcDTO;
import org.tsir.toll.conciliation.domain.dto.InfoTablesDTO;
import org.tsir.toll.conciliation.domain.entities.DetalleTiquete;
import org.tsir.toll.conciliation.domain.entities.IConsolidateTickect;
import org.tsir.toll.conciliation.domain.values.TicketStatus;






@Service
public class MappingFactory {

	@Autowired
	private ModelMapper modelMapper;
	
	public void loadReconcileMapping() {
		
		modelMapper.addConverter(this::getTicketStatusEnum, Integer.class, TicketStatus.class);
		modelMapper.addConverter(this::getTicketStatusCode, TicketStatus.class, Integer.class);
		
		modelMapper.addConverter(this::getLocalDate, String.class, LocalDate.class);
		modelMapper.addConverter(this::getLocalDateString, LocalDate.class, String.class);
		
		


		setMappingReconcile();
	}

	private void setMappingReconcile() {
		modelMapper.typeMap(InfoTablesDTO.class, DetalleTiquete.class).addMappings(mapper -> {
			mapper.map(InfoTablesDTO::getFECHA_RECAUDO, DetalleTiquete::setFecharecaudo);
			mapper.map(InfoTablesDTO::getID_CONC, DetalleTiquete::setIdconc);
			mapper.map(InfoTablesDTO::getCODIGO_CARRIL, DetalleTiquete::setIdcarril);			
			mapper.map(InfoTablesDTO::getCODIGO_TURNO, DetalleTiquete::setCodigoturno);
			
		});

		modelMapper.typeMap(DetalleTiquete.class, InfoTablesDTO.class).addMappings(mapper -> {
			mapper.map(DetalleTiquete::getFecharecaudo, InfoTablesDTO::setFECHA_RECAUDO);
			mapper.map(DetalleTiquete::getIdconc, InfoTablesDTO::setID_CONC);
			mapper.map(DetalleTiquete::getIdcarril, InfoTablesDTO::setCODIGO_CARRIL);
			mapper.map(DetalleTiquete::getCodigoturno, InfoTablesDTO::setCODIGO_TURNO);
		});
		
		
		modelMapper.typeMap(DetailTicketConcDTO.class, DetalleTiquete.class).addMappings(mapper -> {
			mapper.map(DetailTicketConcDTO::getDetailTicketId, DetalleTiquete::setIddetalletiquete);
			mapper.map(DetailTicketConcDTO::getInveTicketId, DetalleTiquete::setIdinvetiqu);
			mapper.map(DetailTicketConcDTO::getTranDacId, DetalleTiquete::setIdtrandac);
			mapper.map(DetailTicketConcDTO::getTicketNumber, DetalleTiquete::setNumerotiquete);
			mapper.map(DetailTicketConcDTO::getTicketStatus, DetalleTiquete::setEstadotiquete);
			mapper.map(DetailTicketConcDTO::getDateCollection, DetalleTiquete::setFecharecaudo);
			mapper.map(DetailTicketConcDTO::getConcId, DetalleTiquete::setIdconc);
			mapper.map(DetailTicketConcDTO::getTollCode, DetalleTiquete::setCodigoestacion);
			mapper.map(DetailTicketConcDTO::getLaneCode, DetalleTiquete::setIdcarril);
			mapper.map(DetailTicketConcDTO::getTurnCode, DetalleTiquete::setCodigoturno);
			mapper.map(DetailTicketConcDTO::getCateId, DetalleTiquete::setIdcate);
		});
		
		modelMapper.typeMap(DetalleTiquete.class, DetailTicketConcDTO.class).addMappings(mapper -> {
			mapper.map(DetalleTiquete::getIddetalletiquete, DetailTicketConcDTO::setDetailTicketId);
			mapper.map(DetalleTiquete::getIdinvetiqu, DetailTicketConcDTO::setInveTicketId);
			mapper.map(DetalleTiquete::getIdtrandac, DetailTicketConcDTO::setTranDacId);
			mapper.map(DetalleTiquete::getNumerotiquete, DetailTicketConcDTO::setTicketNumber);
			mapper.map(DetalleTiquete::getEstadotiquete, DetailTicketConcDTO::setTicketStatus);
			mapper.map(DetalleTiquete::getFecharecaudo, DetailTicketConcDTO::setDateCollection);
			mapper.map(DetalleTiquete::getIdconc, DetailTicketConcDTO::setConcId);
			mapper.map(DetalleTiquete::getCodigoestacion, DetailTicketConcDTO::setTollCode);
			mapper.map(DetalleTiquete::getIdcarril, DetailTicketConcDTO::setLaneCode);
			mapper.map(DetalleTiquete::getCodigoturno, DetailTicketConcDTO::setTurnCode);
			mapper.map(DetalleTiquete::getIdcate, DetailTicketConcDTO::setCateId);
		});
		
	}
	
	
	public TicketStatus getTicketStatusEnum(MappingContext<Integer, TicketStatus> ctx) {
		return TicketStatus.fromValue(ctx.getSource().toString());
	}
	public Integer getTicketStatusCode(MappingContext<TicketStatus, Integer> ctx) {
		return Integer.valueOf(ctx.getSource().toString());	
	}
	
	public LocalDate getLocalDate(MappingContext<String, LocalDate> ctx) {
		return LocalDate.parse(ctx.getSource(),DateTimeFormatter.ofPattern("yyyy/MM/dd")) ;
	}
	public String getLocalDateString(MappingContext<LocalDate, String> ctx) {
		return String.valueOf(ctx.getSource().toString());
	}
	
	
	
	public InfoTablesDTO mapInfoTablesDTO(IConsolidateTickect consolidateTiquete) {
		return modelMapper.map(consolidateTiquete, InfoTablesDTO.class);
	}
	
	public DacTicketDTO mapDacTicketDTO(IConsolidateTickect consolidateTiquete) {
		return modelMapper.map(consolidateTiquete, DacTicketDTO.class);
	}
	
	public DetailTicketConcDTO mapToDetailTicketDTO(DetalleTiquete tiquete) {
		return modelMapper.map(tiquete, DetailTicketConcDTO.class);
	}
	
	public DetalleTiquete mapToDetailTicket(DetailTicketConcDTO tiquete) {
		return modelMapper.map(tiquete, DetalleTiquete.class);
	}
	
	
	
	
}
