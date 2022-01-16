package org.tsir.toll.conciliation.domain.dto;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.v3.oas.annotations.media.Schema;

@Validated
@JacksonXmlRootElement(localName = "InfoTablesDTO")
@XmlRootElement(name = "InfoTablesDTO")
@XmlAccessorType(XmlAccessType.FIELD)
public class InfoTablesDTO {


	 @JsonProperty("FECHA_RECAUDO")
	 @JacksonXmlProperty(localName = "FECHA_RECAUDO")
	  private String FECHA_RECAUDO = null;

	  @JsonProperty("ID_CONC")
	  @JacksonXmlProperty(localName = "ID_CONC")
	  private Long ID_CONC = null;

	  @JsonProperty("CODIGO_ESTACION")
	  @JacksonXmlProperty(localName = "CODIGO_ESTACION")
	  private Integer CODIGO_ESTACION = null;

	  @JsonProperty("CODIGO_CARRIL")
	  @JacksonXmlProperty(localName = "CODIGO_CARRIL")
	  private Integer CODIGO_CARRIL = null;

	  @JsonProperty("CODIGO_TURNO")
	  @JacksonXmlProperty(localName = "CODIGO_TURNO")
	  private Integer CODIGO_TURNO = null;
	  
	  

	  
	  /**
	   * Fecha del recaudo
	   * @return dateCollection
	   **/
	 
	  @Schema(description = "Fecha del recaudo")
	
	  public String getFECHA_RECAUDO() {
		return FECHA_RECAUDO;
	}

	public void setFECHA_RECAUDO(String fECHA_RECAUDO) {
		FECHA_RECAUDO = fECHA_RECAUDO;
	}
	  
	public InfoTablesDTO ID_CONC(Long iD_CONC) {
		    this.ID_CONC = iD_CONC;
		    return this;
		  }	
	  /**
	   * Id de la conciliación
	   * @return laneCode
	   **/

	public Long getID_CONC() {
		return ID_CONC;
	}

	public void setID_CONC(Long iD_CONC) {
		ID_CONC = iD_CONC;
	}

	public InfoTablesDTO CODIGO_ESTACION(Integer cODIGO_ESTACION) {
	    this.CODIGO_ESTACION = cODIGO_ESTACION;
	    return this;
	  }
	 
	/**
	   * Código de la estación
	   * @return laneCode
	   **/
	

	public Integer getCODIGO_ESTACION() {
		return CODIGO_ESTACION;
	}

	public void setCODIGO_ESTACION(Integer cODIGO_ESTACION) {
		CODIGO_ESTACION = cODIGO_ESTACION;
	}	
	
	public InfoTablesDTO CODIGO_CARRIL(Integer cODIGO_CARRIL) {
	    this.CODIGO_CARRIL = cODIGO_CARRIL;
	    return this;
	  }
	
	/**
	   * Código del carril
	   * @return laneCode
	   **/

	public Integer getCODIGO_CARRIL() {
		return CODIGO_CARRIL;
	}

	public void setCODIGO_CARRIL(Integer cODIGO_CARRIL) {
		CODIGO_CARRIL = cODIGO_CARRIL;
	}
	
	public InfoTablesDTO CODIGO_TURNO(Integer cODIGO_TURNO) {
	    this.CODIGO_TURNO = cODIGO_TURNO;
	    return this;
	  }
	
	/**
	   * Código dl turno
	   * @return laneCode
	   **/

	public Integer getCODIGO_TURNO() {
		return CODIGO_TURNO;
	}

	public void setCODIGO_TURNO(Integer cODIGO_TURNO) {
		CODIGO_TURNO = cODIGO_TURNO;
	}
	
	 @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    InfoTablesDTO InfoTablesDTO = (InfoTablesDTO) o;
	    return 
	    	Objects.equals(this.FECHA_RECAUDO, InfoTablesDTO.FECHA_RECAUDO) &&
	        Objects.equals(this.ID_CONC, InfoTablesDTO.ID_CONC) &&
	        Objects.equals(this.CODIGO_ESTACION, InfoTablesDTO.CODIGO_ESTACION) &&
	        Objects.equals(this.CODIGO_CARRIL, InfoTablesDTO.CODIGO_CARRIL) &&
	        Objects.equals(this.CODIGO_TURNO, InfoTablesDTO.CODIGO_TURNO);
	  }
	 
	  @Override
	  public int hashCode() {
	    return Objects.hash(FECHA_RECAUDO, ID_CONC, CODIGO_ESTACION, CODIGO_CARRIL, CODIGO_TURNO);
	  }
	  
	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class InfoTablesDTO {\n");
	    
	    sb.append("    FECHA_RECAUDO: ").append(toIndentedString(FECHA_RECAUDO)).append("\n");
	    sb.append("    ID_CONC: ").append(toIndentedString(ID_CONC)).append("\n");
	    sb.append("    CODIGO_ESTACION: ").append(toIndentedString(CODIGO_ESTACION)).append("\n");
	    sb.append("    CODIGO_CARRIL: ").append(toIndentedString(CODIGO_CARRIL)).append("\n");
	    sb.append("    CODIGO_TURNO: ").append(toIndentedString(CODIGO_TURNO)).append("\n");
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
