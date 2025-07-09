UPDATE users SET name = 'Nome Padrão' WHERE name IS NULL;
ALTER TABLE users ALTER COLUMN name SET NOT NULL;