package org.tsir.toll.conciliation.infraestructure.api;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.annotation.Validated;
import org.tsir.common.api.ApiMessage;
import org.tsir.toll.conciliation.domain.dto.DacTicketDTO;
import org.tsir.toll.conciliation.domain.dto.InfoTablesDTO;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-08T13:27:57.939Z[GMT]")
@Validated
public interface ResourceApi {

	Logger log = LoggerFactory.getLogger(ResourceApi.class);

	@Operation(summary = "Consultar DAc´s y tiquetes disponibles", description = "Realiza la busqueda DAC´s y tiquetes disponibles", tags = {
			"conciliationmassive" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DacTicketDTO.class)))),

			@ApiResponse(responseCode = "200", description = "Contenido con el codigo y mensaje del error. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiMessage.class))) })
	@RequestMapping(value = "/conciliationmassive", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<DacTicketDTO>> getDACTicket(
			@Parameter(in = ParameterIn.QUERY, description = "Llaves y valores de los criterios de búsqueda.  Enumeración de las posibles llaves:  * `DATECOLLECTION` - Fecha de recaudo.  * `STATIONAME` - Nombre de la estación.  * `LANECODE` - Número de carril.  * `TURNCODE` - Número de turno. ", schema = @Schema()) @Valid @RequestParam(value = "filter", required = false) Map<String, String> filter);

	@Operation(summary = "Consultar Campos de tablas", description = "Consulta las conciliaciones por fecha de recaudo, estación, carril, turno, fecha de recaudo y id conciliación", security = {
			@SecurityRequirement(name = "bearerAuth") }, tags = { "conciliación" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = InfoTablesDTO.class)))),

			@ApiResponse(responseCode = "200", description = "Contenido con el codigo y mensaje del error. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiMessage.class))) })
	@RequestMapping(value = "/reconcile", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<InfoTablesDTO>> getInfoTables(
			@Parameter(in = ParameterIn.QUERY, description = "Llaves y valores de los criterios de búsqueda.  Enumeración de las posibles llaves:  * `FECHA_RECAUDO` - Fecha de recaudo.  * `STATIONAME` - Nombre de la estación.  * `CODIGO_CARRIL` - Número de carril.  * `CODIGO_TURNO` - Número de turno.  * `PAYMENTNAME` - Nombre de la forma de pago. ", schema = @Schema()) @Valid @RequestParam(value = "filter", required = false) String filter);
}
