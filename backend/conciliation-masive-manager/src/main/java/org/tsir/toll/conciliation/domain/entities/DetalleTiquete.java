package org.tsir.toll.conciliation.domain.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DETALLETIQUETE")
public class DetalleTiquete implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 627144056046863292L;

	@Id
	@GeneratedValue(generator="TICKET_DETAIL_SEQ") 
	@SequenceGenerator(name="TICKET_DETAIL_SEQ",sequenceName="TICKET_DETAIL_SEQ", allocationSize=1)
	@Column(name = "ID_DETALLE_TIQUETE")
	private Long iddetalletiquete = null;

	@Column(name = "ID_INVE_TIQU")
	private Long idinvetiqu = null;
	
	@Column(name = "ID_TRAN_DAC")
	private Long idtrandac = null;

	@Column(name = "NUMERO_TIQUETE")
	private Long numerotiquete = null;

	@Column(name = "ESTADO_TIQUETE")
	private Integer estadotiquete = null;

	@Column(name = "FECHA_RECAUDO")
	private LocalDate fecharecaudo = null;

	@Column(name = "ID_CONC")
	private Long idconc = null;
	
	@Column(name = "CODIGO_ESTACION")
	private Long codigoestacion = null;

	@Column(name = "CODIGO_CARRIL")
	private Long idcarril = null;

	@Column(name = "CODIGO_TURNO")
	private Long codigoturno = null;

	@Column(name = "ID_CATE")
	private Long idcate = null;

	public Long getIddetalletiquete() {
		return iddetalletiquete;
	}

	public void setIddetalletiquete(Long iddetalletiquete) {
		this.iddetalletiquete = iddetalletiquete;
	}

	public Long getIdinvetiqu() {
		return idinvetiqu;
	}

	public void setIdinvetiqu(Long idinvetiqu) {
		this.idinvetiqu = idinvetiqu;
	}

	public Long getNumerotiquete() {
		return numerotiquete;
	}

	public void setNumerotiquete(Long numerotiquete) {
		this.numerotiquete = numerotiquete;
	}

	public Integer getEstadotiquete() {
		return estadotiquete;
	}

	public void setEstadotiquete(Integer estadotiquete) {
		this.estadotiquete = estadotiquete;
	}

	public LocalDate getFecharecaudo() {
		return fecharecaudo;
	}

	public void setFecharecaudo(LocalDate fecharecaudo) {
		this.fecharecaudo = fecharecaudo;
	}

	public Long getIdconc() {
		return idconc;
	}

	public void setIdconc(Long idconc) {
		this.idconc = idconc;
	}

	public Long getCodigoturno() {
		return codigoturno;
	}

	public void setCodigoturno(Long codigoturno) {
		this.codigoturno = codigoturno;
	}

	public Long getIdcate() {
		return idcate;
	}

	public void setIdcate(Long idcate) {
		this.idcate = idcate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public Long getIdtrandac() {
		return idtrandac;
	}

	public void setIdtrandac(Long idtrandac) {
		this.idtrandac = idtrandac;
	}

	public Long getCodigoestacion() {
		return codigoestacion;
	}

	public void setCodigoestacion(Long codigoestacion) {
		this.codigoestacion = codigoestacion;
	}

	public Long getIdcarril() {
		return idcarril;
	}

	public void setIdcarril(Long idcarril) {
		this.idcarril = idcarril;
	}

	@Override
	public String toString() {
		return "DetalleTiquete [iddetalletiquete=" + iddetalletiquete + ", idinvetiqu=" + idinvetiqu
				+ ", numerotiquete=" + numerotiquete + ", estadotiquete=" + estadotiquete + ", fecharecaudo="
				+ fecharecaudo + ", idconc=" + idconc + ", codigocarril=" + idcarril + ", codigoturno=" + codigoturno
				+ ", idcate=" + idcate + "]";
	}

}
