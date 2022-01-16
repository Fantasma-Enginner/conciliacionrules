do $$
declare 

v_count numeric;
	
begin

		select count(1) into v_count from detalletiquete where id_detalle_tiquete = 1;
	if v_count = 0 then
		insert into detalletiquete (id_detalle_tiquete,id_inve_tiqu,id_tran_dac,numero_tiquete,estado_tiquete,fecha_recaudo,id_conc,codigo_estacion,codigo_carril,codigo_turno,id_cate) 
		values (1,1,1001,8155478,1,'2021-09-08',680115773727815123,12, 6801, 2, 1);
		end if;
		
		select count(1) into v_count from detalletiquete where id_detalle_tiquete = 2;
	if v_count = 0 then
		insert into detalletiquete (id_detalle_tiquete,id_inve_tiqu,id_tran_dac,numero_tiquete,estado_tiquete,fecha_recaudo,id_conc,codigo_estacion,codigo_carril,codigo_turno,id_cate) 
		values (2,1,1002,8155478,1,'2021-09-08',680452773727815123,12, 6801, 3, 2);
		end if;
		
		select count(1) into v_count from detalletiquete where id_detalle_tiquete = 3;
	if v_count = 0 then
		insert into detalletiquete (id_detalle_tiquete,id_inve_tiqu,id_tran_dac,numero_tiquete,estado_tiquete,fecha_recaudo,id_conc,codigo_estacion,codigo_carril,codigo_turno,id_cate) 
		values (3,1,1003,8155478,1,'2021-09-08',456235424155542545,12, 6801, 2, 4);
		end if;
		
		select count(1) into v_count from detalletiquete where id_detalle_tiquete = 4;
	if v_count = 0 then
		insert into detalletiquete (id_detalle_tiquete,id_inve_tiqu,id_tran_dac,numero_tiquete,estado_tiquete,fecha_recaudo,id_conc,codigo_estacion,codigo_carril,codigo_turno,id_cate) 
		values (4,1,1004,8155478,1,'2021-09-08',474544772784578525,12, 6801, 4, 2);
		end if;
		
		select count(1) into v_count from detalletiquete where id_detalle_tiquete = 5;
	if v_count = 0 then
		insert into detalletiquete (id_detalle_tiquete,id_inve_tiqu,id_tran_dac,numero_tiquete,estado_tiquete,fecha_recaudo,id_conc,codigo_estacion,codigo_carril,codigo_turno,id_cate) 
		values (5,1,1005,8155478,1,'2021-09-08',235487852568545555,12, 6801, 2, 1);
		end if;
		
		select count(1) into v_count from detalletiquete where id_detalle_tiquete = 6;
	if v_count = 0 then
		insert into detalletiquete (id_detalle_tiquete,id_inve_tiqu,id_tran_dac,numero_tiquete,estado_tiquete,fecha_recaudo,id_conc,codigo_estacion,codigo_carril,codigo_turno,id_cate) 
		values (6,1,1006,8155478,1,'2021-09-08',125548565265662565,12, 6801, 1, 3);
		end if;
		
		
		
		
		select count(1) into v_count from authorizations where authorization_id = 65825;
	if v_count = 0 then
		insert into authorizations(
	authorization_id, resource_id, profile_id)
	values (65825, 1688862745165825, 1);
	end if;

		
		
		commit;

end 
$$;