ALTER TABLE tb_person
    ADD COLUMN enabled BOOLEAN NOT NULL DEFAULT TRUE;

UPDATE tb_person
SET enabled = TRUE;

