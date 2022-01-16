do $$
declare
	v_count integer;
begin

	
--------------- create table detalletiquete -----------------
	
	select count(1) into v_count from information_schema.tables where table_name = 'detalletiquete';
	if v_count = 0 then
		execute ('
	create table detalletiquete (
	id_detalle_tiquete numeric(19,0) not null,
	id_inve_tiqu numeric(19,0) not null,
	id_tran_dac numeric(19,0),
	numero_tiquete numeric(19,0) not null,
    estado_tiquete numeric(2,0) not null, 
	fecha_recaudo date not null,
	id_conc numeric(19,0),
	codigo_estacion numeric (19,0) not null,
	codigo_carril numeric (19,0) not null,
	codigo_turno numeric (19,0) not null,
	id_cate numeric (19,0) not null,
	constraint resources_pk primary key (id_detalle_tiquete))');

execute ('comment on column detalletiquete.id_detalle_tiquete is ''id del detalle del tiquete.''');
execute ('comment on column detalletiquete.id_inve_tiqu is ''id del inventario del tiquete.''');
execute ('comment on column detalletiquete.id_tran_dac is ''Id de la transacción del DAC..''');
execute ('comment on column detalletiquete.numero_tiquete is ''número del tiquete.''');
execute ('comment on column detalletiquete.estado_tiquete is ''estado del tiquete.''');
execute ('comment on column detalletiquete.fecha_recaudo is ''fecha del recaudo del tiquete.''');
execute ('comment on column detalletiquete.id_conc is ''id de la conciliación.''');
execute ('comment on column detalletiquete.codigo_estacion is ''código de estación.''');
execute ('comment on column detalletiquete.codigo_carril is ''código del carril que pertenece la estación.''');
execute ('comment on column detalletiquete.codigo_turno is ''código del turno que pertenece a la estación.''');
execute ('comment on column detalletiquete.id_cate is ''corresponde a la categoría del vehículo.''');
execute ('comment on table detalletiquete  is ''tabla que almacena el detalle de tiquete para conciliacion masiva de tiquetes y dacs.''');


raise notice 'tabla creada satisfactoriamente: detalletiquete';
	else 
		raise notice 'tabla validada: detalletiquete';
	end if;	
	
end $$;