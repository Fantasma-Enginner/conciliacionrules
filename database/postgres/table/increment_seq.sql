do $$
declare
	
begin
	
	if not exists (select 0 from pg_class where relname = 'ticket_detail_seq')
	then
		execute ('
		create sequence ticket_detail_seq
    		increment 1
  		start 1200000000000000 
 		minvalue 1200000000000000 
 		maxvalue 1299999999999999
 		cache 1');
		raise notice 'secuencia creada satisfactoriamente: ticket_detail_seq';
	else 
		raise notice'secuencia validada: ticket_detail_seq';
	end if;

	
end $$;


