SET search_path TO public;

TRUNCATE "data_type" CASCADE;

INSERT INTO data_type(id, created, name, function_id) 
	VALUES	(1000, NOW(), 'Name', 1000),
			(1001, NOW(), 'Number', 1000),
			(1002, NOW(), 'Name', 1001),
			(1003, NOW(), 'Number', 1001);