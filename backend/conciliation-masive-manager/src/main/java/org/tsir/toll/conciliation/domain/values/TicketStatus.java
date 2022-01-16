package org.tsir.toll.conciliation.domain.values;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Enumeración de estados generales de estado de la conciliación masiva:  * `1` - Nuevo.  * `2` - Pendiente por asignar.  * `3` - Asignado. 
 */
public enum TicketStatus {
  NUMBER_1(1),
    NUMBER_2(2),
    NUMBER_3(3);

  private Integer value;

  TicketStatus(Integer value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static TicketStatus fromValue(String text) {
    for (TicketStatus b : TicketStatus.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
