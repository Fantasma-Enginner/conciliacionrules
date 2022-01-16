package org.tsir.toll.conciliation.application.register;

import static org.tsir.common.modules.ResourceConstants.CONCILIATION_DOMAIN;
import static org.tsir.common.modules.ResourceConstants.CONCILIACION_MASIVE_MODULE;
import static org.tsir.common.modules.ResourceConstants.SEPARATOR;

import org.tsir.common.modules.Operation;
import org.tsir.common.modules.Registrable;


public class ConciliationModule implements Registrable{

	public static final ConciliationModule INSTANCE = new ConciliationModule();

	private ConciliationModule() {
	}

	private static final String GET_CONCILIATION_CODE = "1";
	public static final String GET_CONCILIATION_AUTHORITY = CONCILIATION_DOMAIN + SEPARATOR + CONCILIACION_MASIVE_MODULE + SEPARATOR
			+ GET_CONCILIATION_CODE;
	public static final Operation GET_CONCILIATION_RESOURCE = Operation.getFromAuthority("Obtener", GET_CONCILIATION_AUTHORITY);

	
	
	private static final String PUT_CONCILIATE_MASSIVELY_CODE = "2";
	public static final String PUT_CONCILIATE_MASSIVELY_AUTHORITY = CONCILIATION_DOMAIN + SEPARATOR + CONCILIACION_MASIVE_MODULE + SEPARATOR
			+ PUT_CONCILIATE_MASSIVELY_CODE;
	public static final Operation PUT_CONCILIATE_MASSIVELY_RESOURCE = Operation.getFromAuthority("Conciliar masivamente", PUT_CONCILIATE_MASSIVELY_AUTHORITY);

}
