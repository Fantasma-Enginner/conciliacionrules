package org.tsir.toll.conciliation.domain.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;
import org.tsir.toll.conciliation.domain.dto.EntryFilter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "Objeto que contiene una entrada de lave valor para un filtro de búsqueda. ")
@Validated
public class EntryFilter {

	  @JsonProperty("key")
	  @JacksonXmlProperty(localName = "key")
	  private String key = null;

	  @JsonProperty("value")
	  @JacksonXmlProperty(localName = "value")
	  private String value = null;

	  public EntryFilter key(String key) {
	    this.key = key;
	    return this;
	  }

	  /**
	   * Llave o nombre del criterio de búsqueda. 
	   * @return key
	   **/
	  @Schema(description = "Llave o nombre del criterio de búsqueda. ")
	  
	    public String getKey() {
	    return key;
	  }

	  public void setKey(String key) {
	    this.key = key;
	  }

	  public EntryFilter value(String value) {
	    this.value = value;
	    return this;
	  }

	  /**
	   * Valor del criterio de criterio de búsqueda. 
	   * @return value
	   **/
	  @Schema(description = "Valor del criterio de criterio de búsqueda. ")
	  
	    public String getValue() {
	    return value;
	  }

	  public void setValue(String value) {
	    this.value = value;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    EntryFilter entryFilter = (EntryFilter) o;
	    return Objects.equals(this.key, entryFilter.key) &&
	        Objects.equals(this.value, entryFilter.value);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(key, value);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class EntryFilter {\n");
	    
	    sb.append("    key: ").append(toIndentedString(key)).append("\n");
	    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
