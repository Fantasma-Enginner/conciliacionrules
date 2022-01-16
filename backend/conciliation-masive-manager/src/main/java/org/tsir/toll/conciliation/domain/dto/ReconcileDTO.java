package org.tsir.toll.conciliation.domain.dto;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.v3.oas.annotations.media.Schema;


@Validated
@JacksonXmlRootElement(localName = "ReconcileDTO")
@XmlRootElement(name = "ReconcileDTO")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReconcileDTO {
	
	  @JsonProperty("dateCollection")
	  private String dateCollection = null;

	  @JsonProperty("laneCode")
	  private Integer laneCode = null;

	  @JsonProperty("turnCode")
	  private Integer turnCode = null;

	  @JsonProperty("consoleCategory")
	  private Integer consoleCategory = null;

	  @JsonProperty("dacCategory")
	  private Integer dacCategory = null;

	  @JsonProperty("conciliationRuleName")
	  private Integer conciliationRuleName = null;

	  @JsonProperty("reconcileValue")
	  private Integer reconcileValue = null;

	  public ReconcileDTO dateCollection(String dateCollection) {
	    this.dateCollection = dateCollection;
	    return this;
	  }

	  /**
	   * Fecha del recaudo
	   * @return dateCollection
	   **/
	  @Schema(description = "Fecha del recaudo")
	  
	    public String getDateCollection() {
	    return dateCollection;
	  }

	  public void setDateCollection(String dateCollection) {
	    this.dateCollection = dateCollection;
	  }

	  public ReconcileDTO laneCode(Integer laneCode) {
	    this.laneCode = laneCode;
	    return this;
	  }

	  /**
	   * Número de carril
	   * @return laneCode
	   **/
	  @Schema(description = "Número de carril")
	  
	    public Integer getLaneCode() {
	    return laneCode;
	  }

	  public void setLaneCode(Integer laneCode) {
	    this.laneCode = laneCode;
	  }

	  public ReconcileDTO turnCode(Integer turnCode) {
	    this.turnCode = turnCode;
	    return this;
	  }

	  /**
	   * Número de turno
	   * @return turnCode
	   **/
	  @Schema(description = "Número de turno")
	  
	    public Integer getTurnCode() {
	    return turnCode;
	  }

	  public void setTurnCode(Integer turnCode) {
	    this.turnCode = turnCode;
	  }

	  public ReconcileDTO consoleCategory(Integer consoleCategory) {
	    this.consoleCategory = consoleCategory;
	    return this;
	  }

	  /**
	   * Categoría de Consola
	   * @return consoleCategory
	   **/
	  @Schema(description = "Categoría de Consola")
	  
	    public Integer getConsoleCategory() {
	    return consoleCategory;
	  }

	  public void setConsoleCategory(Integer consoleCategory) {
	    this.consoleCategory = consoleCategory;
	  }

	  public ReconcileDTO dacCategory(Integer dacCategory) {
	    this.dacCategory = dacCategory;
	    return this;
	  }

	  /**
	   * Categoría de DAC
	   * @return dacCategory
	   **/
	  @Schema(description = "Categoría de DAC")
	  
	    public Integer getDacCategory() {
	    return dacCategory;
	  }

	  public void setDacCategory(Integer dacCategory) {
	    this.dacCategory = dacCategory;
	  }

	  public ReconcileDTO conciliationRuleName(Integer conciliationRuleName) {
	    this.conciliationRuleName = conciliationRuleName;
	    return this;
	  }

	  /**
	   * Nombre de la regla de conciliación
	   * @return conciliationRuleName
	   **/
	  @Schema(description = "Nombre de la regla de conciliación")
	  
	    public Integer getConciliationRuleName() {
	    return conciliationRuleName;
	  }

	  public void setConciliationRuleName(Integer conciliationRuleName) {
	    this.conciliationRuleName = conciliationRuleName;
	  }

	  public ReconcileDTO reconcileValue(Integer reconcileValue) {
	    this.reconcileValue = reconcileValue;
	    return this;
	  }

	  /**
	   * Valor real conciliado
	   * @return reconcileValue
	   **/
	  @Schema(description = "Valor real conciliado")
	  
	    public Integer getReconcileValue() {
	    return reconcileValue;
	  }

	  public void setReconcileValue(Integer reconcileValue) {
	    this.reconcileValue = reconcileValue;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    ReconcileDTO reconcileDTO = (ReconcileDTO) o;
	    return Objects.equals(this.dateCollection, reconcileDTO.dateCollection) &&
	        Objects.equals(this.laneCode, reconcileDTO.laneCode) &&
	        Objects.equals(this.turnCode, reconcileDTO.turnCode) &&
	        Objects.equals(this.consoleCategory, reconcileDTO.consoleCategory) &&
	        Objects.equals(this.dacCategory, reconcileDTO.dacCategory) &&
	        Objects.equals(this.conciliationRuleName, reconcileDTO.conciliationRuleName) &&
	        Objects.equals(this.reconcileValue, reconcileDTO.reconcileValue);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(dateCollection, laneCode, turnCode, consoleCategory, dacCategory, conciliationRuleName, reconcileValue);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class ReconcileDTO {\n");
	    
	    sb.append("    dateCollection: ").append(toIndentedString(dateCollection)).append("\n");
	    sb.append("    laneCode: ").append(toIndentedString(laneCode)).append("\n");
	    sb.append("    turnCode: ").append(toIndentedString(turnCode)).append("\n");
	    sb.append("    consoleCategory: ").append(toIndentedString(consoleCategory)).append("\n");
	    sb.append("    dacCategory: ").append(toIndentedString(dacCategory)).append("\n");
	    sb.append("    conciliationRuleName: ").append(toIndentedString(conciliationRuleName)).append("\n");
	    sb.append("    reconcileValue: ").append(toIndentedString(reconcileValue)).append("\n");
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
