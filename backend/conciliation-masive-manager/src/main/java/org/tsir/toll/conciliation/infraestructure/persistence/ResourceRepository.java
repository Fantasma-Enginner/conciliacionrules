package org.tsir.toll.conciliation.infraestructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.tsir.toll.conciliation.domain.entities.DetalleTiquete;
import org.tsir.toll.conciliation.domain.entities.IConsolidateTickect;

public interface ResourceRepository extends JpaRepository<DetalleTiquete, Long>, QuerydslPredicateExecutor<DetalleTiquete> {
	
	
	@Query("SELECT d.fecharecaudo AS fechaRecaudo, d.idcate AS idCategoria, d.idcarril AS idCarril, d.codigoturno AS codigoTurno, count(d) AS count "
			+ "FROM DetalleTiquete AS d "
			+ "WHERE d.idcarril = ?1 and d.codigoturno = ?2 "
			+ "GROUP BY d.fecharecaudo, d.idcate, d.idcarril, d.codigoturno")
	List<IConsolidateTickect> countBycate(String idcarr, String codigoturno);
	
}
