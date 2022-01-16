package org.tsir.toll.conciliation.domain.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import io.swagger.annotations.ApiModelProperty;


import org.springframework.validation.annotation.Validated;


/**
 * DetailTicketDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-08T13:27:57.939Z[GMT]")


public class DetailTicketDTO   {
  @JsonProperty("detailTicketId")
  @JacksonXmlProperty(localName = "detailTicketId")
  private Long detailTicketId = null;

  @JsonProperty("ticketNumber")
  @JacksonXmlProperty(localName = "ticketNumber")
  private String ticketNumber = null;

  @JsonProperty("dacId")
  @JacksonXmlProperty(localName = "dacId")
  private String dacId = null;

  @JsonProperty("ticketStatus")
  @JacksonXmlProperty(localName = "ticketStatus")
  private String ticketStatus = null;

  @JsonProperty("detatilTicketDatetime")
  @JacksonXmlProperty(localName = "detatilTicketDatetime")
  private String detatilTicketDatetime = null;

  public DetailTicketDTO detailTicketId(Long detailTicketId) {
    this.detailTicketId = detailTicketId;
    return this;
  }

  /**
   * Id del detalle del tiquete
   * @return detailTicketId
   **/
  @ApiModelProperty(value = "Id del detalle del tiquete")
  
    public Long getDetailTicketId() {
    return detailTicketId;
  }

  public void setDetailTicketId(Long detailTicketId) {
    this.detailTicketId = detailTicketId;
  }

  public DetailTicketDTO ticketNumber(String ticketNumber) {
    this.ticketNumber = ticketNumber;
    return this;
  }

  /**
   * Id del Tiquete
   * @return ticketNumber
   **/
  @ApiModelProperty(value = "Id del Tiquete")
  
    public String getTicketNumber() {
    return ticketNumber;
  }

  public void setTicketNumber(String ticketNumber) {
    this.ticketNumber = ticketNumber;
  }

  public DetailTicketDTO dacId(String dacId) {
    this.dacId = dacId;
    return this;
  }

  /**
   * Id del DAC
   * @return dacId
   **/
  @ApiModelProperty(value = "Id del DAC")
  
    public String getDacId() {
    return dacId;
  }

  public void setDacId(String dacId) {
    this.dacId = dacId;
  }

  public DetailTicketDTO ticketStatus(String ticketStatus) {
    this.ticketStatus = ticketStatus;
    return this;
  }

  /**
   * Estado del tiquete
   * @return ticketStatus
   **/
  @ApiModelProperty(value = "Estado del tiquete")
  
    public String getTicketStatus() {
    return ticketStatus;
  }

  public void setTicketStatus(String ticketStatus) {
    this.ticketStatus = ticketStatus;
  }

  public DetailTicketDTO detatilTicketDatetime(String detatilTicketDatetime) {
    this.detatilTicketDatetime = detatilTicketDatetime;
    return this;
  }

  /**
   * Fecha y hora de
   * @return detatilTicketDatetime
   **/
  @ApiModelProperty(value = "Fecha y hora de")
  
    public String getDetatilTicketDatetime() {
    return detatilTicketDatetime;
  }

  public void setDetatilTicketDatetime(String detatilTicketDatetime) {
    this.detatilTicketDatetime = detatilTicketDatetime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DetailTicketDTO detailTicketDTO = (DetailTicketDTO) o;
    return Objects.equals(this.detailTicketId, detailTicketDTO.detailTicketId) &&
        Objects.equals(this.ticketNumber, detailTicketDTO.ticketNumber) &&
        Objects.equals(this.dacId, detailTicketDTO.dacId) &&
        Objects.equals(this.ticketStatus, detailTicketDTO.ticketStatus) &&
        Objects.equals(this.detatilTicketDatetime, detailTicketDTO.detatilTicketDatetime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(detailTicketId, ticketNumber, dacId, ticketStatus, detatilTicketDatetime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DetailTicketDTO {\n");
    
    sb.append("    detailTicketId: ").append(toIndentedString(detailTicketId)).append("\n");
    sb.append("    ticketNumber: ").append(toIndentedString(ticketNumber)).append("\n");
    sb.append("    dacId: ").append(toIndentedString(dacId)).append("\n");
    sb.append("    ticketStatus: ").append(toIndentedString(ticketStatus)).append("\n");
    sb.append("    detatilTicketDatetime: ").append(toIndentedString(detatilTicketDatetime)).append("\n");
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
