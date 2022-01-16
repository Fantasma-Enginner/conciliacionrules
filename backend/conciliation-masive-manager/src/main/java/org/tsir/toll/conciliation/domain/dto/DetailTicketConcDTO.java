package org.tsir.toll.conciliation.domain.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.tsir.toll.conciliation.domain.values.TicketStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;


/**
 * DetailTicketDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-12-06T17:36:10.124Z[GMT]")


public class DetailTicketConcDTO   {
  @JsonProperty("detailTicketId")
  private Long detailTicketId = null;

  @JsonProperty("inveTicketId")
  private String inveTicketId = null;

  @JsonProperty("tranDacId")
  private String tranDacId = null;

  @JsonProperty("ticketNumber")
  private Long ticketNumber = null;

  @JsonProperty("ticketStatus")
  private TicketStatus ticketStatus = null;

  @JsonProperty("dateCollection")
  private String dateCollection = null;

  @JsonProperty("concId")
  private Long concId = null;

  @JsonProperty("tollCode")
  private Long tollCode = null;

  @JsonProperty("laneCode")
  private Long laneCode = null;

  @JsonProperty("turnCode")
  private Long turnCode = null;

  @JsonProperty("cateId")
  private Long cateId = null;

  public DetailTicketConcDTO detailTicketId(Long detailTicketId) {
    this.detailTicketId = detailTicketId;
    return this;
  }

  /**
   * Id del detalle del tiquete
   * @return detailTicketId
   **/
  @Schema(example = "1200000000133781", description = "Id del detalle del tiquete")
  
    public Long getDetailTicketId() {
    return detailTicketId;
  }

  public void setDetailTicketId(Long detailTicketId) {
    this.detailTicketId = detailTicketId;
  }

  public DetailTicketConcDTO inveTicketId(String inveTicketId) {
    this.inveTicketId = inveTicketId;
    return this;
  }

  /**
   * Id del Inventario de tiquetes
   * @return inveTicketId
   **/
  @Schema(example = "2800000000133781", description = "Id del Inventario de tiquetes")
  
    public String getInveTicketId() {
    return inveTicketId;
  }

  public void setInveTicketId(String inveTicketId) {
    this.inveTicketId = inveTicketId;
  }

  public DetailTicketConcDTO tranDacId(String tranDacId) {
    this.tranDacId = tranDacId;
    return this;
  }

  /**
   * Id del Tran Dac
   * @return tranDacId
   **/
  @Schema(example = "2800000000133781", description = "Id del Tran Dac")
  
    public String getTranDacId() {
    return tranDacId;
  }

  public void setTranDacId(String tranDacId) {
    this.tranDacId = tranDacId;
  }

  public DetailTicketConcDTO ticketNumber(Long ticketNumber) {
    this.ticketNumber = ticketNumber;
    return this;
  }

  /**
   * Número del tiquete
   * @return ticketNumber
   **/
  @Schema(example = "2800000000004195", description = "Número del tiquete")
  
    public Long getTicketNumber() {
    return ticketNumber;
  }

  public void setTicketNumber(Long ticketNumber) {
    this.ticketNumber = ticketNumber;
  }

  public DetailTicketConcDTO ticketStatus(TicketStatus ticketStatus) {
    this.ticketStatus = ticketStatus;
    return this;
  }

  /**
   * Get ticketStatus
   * @return ticketStatus
   **/
  @Schema(description = "")
  
    @Valid
    public TicketStatus getTicketStatus() {
    return ticketStatus;
  }

  public void setTicketStatus(TicketStatus ticketStatus) {
    this.ticketStatus = ticketStatus;
  }

  public DetailTicketConcDTO dateCollection(String dateCollection) {
    this.dateCollection = dateCollection;
    return this;
  }

  /**
   * Fecha del recaudo
   * @return dateCollection
   **/
  @Schema(example = "30/11/2021", description = "Fecha del recaudo")
  
    public String getDateCollection() {
    return dateCollection;
  }

  public void setDateCollection(String dateCollection) {
    this.dateCollection = dateCollection;
  }

  public DetailTicketConcDTO concId(Long concId) {
    this.concId = concId;
    return this;
  }

  /**
   * Id de la conciliación
   * @return concId
   **/
  @Schema(example = "2800000004686950", description = "Id de la conciliación")
  
    public Long getConcId() {
    return concId;
  }

  public void setConcId(Long concId) {
    this.concId = concId;
  }

  public DetailTicketConcDTO tollCode(Long tollCode) {
    this.tollCode = tollCode;
    return this;
  }

  /**
   * Código de la estación
   * @return tollCode
   **/
  @Schema(example = "28", description = "Código de la estación")
  
    public Long getTollCode() {
    return tollCode;
  }

  public void setTollCode(Long tollCode) {
    this.tollCode = tollCode;
  }

  public DetailTicketConcDTO laneCode(Long laneCode) {
    this.laneCode = laneCode;
    return this;
  }

  /**
   * Código del carril
   * @return laneCode
   **/
  @Schema(example = "2", description = "Código del carril")
  
    public Long getLaneCode() {
    return laneCode;
  }

  public void setLaneCode(Long laneCode) {
    this.laneCode = laneCode;
  }

  public DetailTicketConcDTO turnCode(Long turnCode) {
    this.turnCode = turnCode;
    return this;
  }

  /**
   * Código del turno
   * @return turnCode
   **/
  @Schema(example = "1", description = "Código del turno")
  
    public Long getTurnCode() {
    return turnCode;
  }

  public void setTurnCode(Long turnCode) {
    this.turnCode = turnCode;
  }

  public DetailTicketConcDTO cateId(Long cateId) {
    this.cateId = cateId;
    return this;
  }

  /**
   * Id de la categoría
   * @return cateId
   **/
  @Schema(example = "1", description = "Id de la categoría")
  
    public Long getCateId() {
    return cateId;
  }

  public void setCateId(Long cateId) {
    this.cateId = cateId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DetailTicketConcDTO detailTicketDTO = (DetailTicketConcDTO) o;
    return Objects.equals(this.detailTicketId, detailTicketDTO.detailTicketId) &&
        Objects.equals(this.inveTicketId, detailTicketDTO.inveTicketId) &&
        Objects.equals(this.tranDacId, detailTicketDTO.tranDacId) &&
        Objects.equals(this.ticketNumber, detailTicketDTO.ticketNumber) &&
        Objects.equals(this.ticketStatus, detailTicketDTO.ticketStatus) &&
        Objects.equals(this.dateCollection, detailTicketDTO.dateCollection) &&
        Objects.equals(this.concId, detailTicketDTO.concId) &&
        Objects.equals(this.tollCode, detailTicketDTO.tollCode) &&
        Objects.equals(this.laneCode, detailTicketDTO.laneCode) &&
        Objects.equals(this.turnCode, detailTicketDTO.turnCode) &&
        Objects.equals(this.cateId, detailTicketDTO.cateId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(detailTicketId, inveTicketId, tranDacId, ticketNumber, ticketStatus, dateCollection, concId, tollCode, laneCode, turnCode, cateId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DetailTicketDTO {\n");
    
    sb.append("    detailTicketId: ").append(toIndentedString(detailTicketId)).append("\n");
    sb.append("    inveTicketId: ").append(toIndentedString(inveTicketId)).append("\n");
    sb.append("    tranDacId: ").append(toIndentedString(tranDacId)).append("\n");
    sb.append("    ticketNumber: ").append(toIndentedString(ticketNumber)).append("\n");
    sb.append("    ticketStatus: ").append(toIndentedString(ticketStatus)).append("\n");
    sb.append("    dateCollection: ").append(toIndentedString(dateCollection)).append("\n");
    sb.append("    concId: ").append(toIndentedString(concId)).append("\n");
    sb.append("    tollCode: ").append(toIndentedString(tollCode)).append("\n");
    sb.append("    laneCode: ").append(toIndentedString(laneCode)).append("\n");
    sb.append("    turnCode: ").append(toIndentedString(turnCode)).append("\n");
    sb.append("    cateId: ").append(toIndentedString(cateId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
