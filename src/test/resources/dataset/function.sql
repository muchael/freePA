SET search_path TO public;

TRUNCATE "function" CASCADE;

INSERT INTO function(id, created, function_category_type, function_type, name, document_id, tr_quantity, td_quantity ) 
	VALUES(1000, NOW(), 0, 0, 'Function', 1000, 5, 1),
	(1001, NOW(), 2, 0, 'Insert function', 1000, 3, 1);