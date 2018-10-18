SET search_path TO public;

TRUNCATE "data_type" CASCADE;

INSERT INTO data_type(id, created, name, function_id) 
	VALUES(1000, NOW(), 'Name', 1000),
	(1001, NOW(), 'Number', 1000);