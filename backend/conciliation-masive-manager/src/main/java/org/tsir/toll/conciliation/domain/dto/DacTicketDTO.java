package org.tsir.toll.conciliation.domain.dto;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModelProperty;

import org.springframework.validation.annotation.Validated;

/**
 * DacTicketDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-08T13:27:57.939Z[GMT]")
@JacksonXmlRootElement(localName = "DacTicketDTO")
@XmlRootElement(name = "DacTicketDTO")
@XmlAccessorType(XmlAccessType.FIELD)

public class DacTicketDTO {

	@JsonProperty("category")
	@JacksonXmlProperty(localName = "category")
	private Integer category = null;

	@JsonProperty("ticketG")
	@JacksonXmlProperty(localName = "ticketG")
	private Integer ticketG = null;

	@JsonProperty("ticketD")
	@JacksonXmlProperty(localName = "ticketD")
	private Integer ticketD = null;

	@JsonProperty("ticketC")
	@JacksonXmlProperty(localName = "ticketC")
	private Integer ticketC = null;

	@JsonProperty("dacG")
	@JacksonXmlProperty(localName = "dacG")
	private Integer dacG = null;

	@JsonProperty("dacD")
	@JacksonXmlProperty(localName = "dacD")
	private Integer dacD = null;

	@JsonProperty("dacC")
	@JacksonXmlProperty(localName = "dacD")
	private Integer dacC = null;

	public DacTicketDTO category(Integer category) {
		this.category = category;
		return this;
	}

	/**
	 * Categoria del vehículo
	 * 
	 * @return category
	 **/
	@ApiModelProperty(value = "Categoria del vehículo")

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public DacTicketDTO ticketG(Integer ticketG) {
		this.ticketG = ticketG;
		return this;
	}

	/**
	 * Tiquetes Generados
	 * 
	 * @return ticketG
	 **/
	@ApiModelProperty(value = "Tiquetes Generados")

	public Integer getTicketG() {
		return ticketG;
	}

	public void setTicketG(Integer ticketG) {
		this.ticketG = ticketG;
	}

	public DacTicketDTO ticketD(Integer ticketD) {
		this.ticketD = ticketD;
		return this;
	}

	/**
	 * Tiquetes Disponibles
	 * 
	 * @return ticketD
	 **/
	@ApiModelProperty(value = "Tiquetes Disponibles")

	public Integer getTicketD() {
		return ticketD;
	}

	public void setTicketD(Integer ticketD) {
		this.ticketD = ticketD;
	}

	public DacTicketDTO ticketC(Integer ticketC) {
		this.ticketC = ticketC;
		return this;
	}

	/**
	 * Tiquetes Conciliados
	 * 
	 * @return ticketC
	 **/
	@ApiModelProperty(value = "Tiquetes Conciliados")

	public Integer getTicketC() {
		return ticketC;
	}

	public void setTicketC(Integer ticketC) {
		this.ticketC = ticketC;
	}

	public DacTicketDTO dacG(Integer dacG) {
		this.dacG = dacG;
		return this;
	}

	/**
	 * DAC Generados
	 * 
	 * @return dacG
	 **/
	@ApiModelProperty(value = "DAC Generados")

	public Integer getDacG() {
		return dacG;
	}

	public void setDacG(Integer dacG) {
		this.dacG = dacG;
	}

	public DacTicketDTO dacD(Integer dacD) {
		this.dacD = dacD;
		return this;
	}

	/**
	 * DAC Disponibles
	 * 
	 * @return dacD
	 **/
	@ApiModelProperty(value = "DAC Disponibles")

	public Integer getDacD() {
		return dacD;
	}

	public void setDacD(Integer dacD) {
		this.dacD = dacD;
	}

	public DacTicketDTO dacC(Integer dacC) {
		this.dacC = dacC;
		return this;
	}

	/**
	 * DAC Conciliados
	 * 
	 * @return dacC
	 **/
	@ApiModelProperty(value = "DAC Conciliados")

	public Integer getDacC() {
		return dacC;
	}

	public void setDacC(Integer dacC) {
		this.dacC = dacC;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DacTicketDTO dacTicketDTO = (DacTicketDTO) o;
		return Objects.equals(this.category, dacTicketDTO.category)
				&& Objects.equals(this.ticketG, dacTicketDTO.ticketG)
				&& Objects.equals(this.ticketD, dacTicketDTO.ticketD)
				&& Objects.equals(this.ticketC, dacTicketDTO.ticketC) && Objects.equals(this.dacG, dacTicketDTO.dacG)
				&& Objects.equals(this.dacD, dacTicketDTO.dacD) && Objects.equals(this.dacC, dacTicketDTO.dacC);
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, ticketG, ticketD, ticketC, dacG, dacD, dacC);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class DacTicketDTO {\n");

		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    ticketG: ").append(toIndentedString(ticketG)).append("\n");
		sb.append("    ticketD: ").append(toIndentedString(ticketD)).append("\n");
		sb.append("    ticketC: ").append(toIndentedString(ticketC)).append("\n");
		sb.append("    dacG: ").append(toIndentedString(dacG)).append("\n");
		sb.append("    dacD: ").append(toIndentedString(dacD)).append("\n");
		sb.append("    dacC: ").append(toIndentedString(dacC)).append("\n");
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
