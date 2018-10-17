SET search_path TO public;

TRUNCATE "project" CASCADE;

INSERT INTO project (id, created, name, start_date) VALUES (1000, NOW(), 'Test Project', NOW());