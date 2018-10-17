SET search_path TO public;

TRUNCATE "document" CASCADE;

INSERT INTO document (id, created, counting_type, document_status, document_type, number, project_id) 
	VALUES (1000, NOW(), 0, 0, 0, 1, 1000);