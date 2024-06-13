CREATE TABLE tb_person (
    id SERIAL PRIMARY KEY NOT NULL,
    name varchar(80) NOT NULL,
    gender varchar(6) NOT NULL,
    address varchar(80) NOT NULL
);