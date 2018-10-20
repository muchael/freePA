SET search_path TO public;

TRUNCATE "function_referenced_tables" CASCADE;

INSERT INTO function_referenced_tables(function_id, referenced_tables_id) 
	VALUES(1001, 1000);