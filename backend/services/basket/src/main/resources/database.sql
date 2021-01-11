CREATE DATABASE postgres
    WITH
    OWNER = postgres
    ENCODING ='UTF8'
    TABLESPACE =pg_default
    CONNECTION LIMIT =-1;

CREATE TABLE public.product
(
    id character varying COLLATE pg_catalog."default" NOT NULL,
)

CREATE TABLE public.category
(
    id character varying COLLATE pg_catalog."default" NOT NULL,
)