--liquibase formatted sql
--changeset matheus:202502211122
--comment: boards table create

CREATE TABLE BOARDS (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

--rollback DROP TABLE BOARDS