CREATE DATABASE postgres
    WITH
    OWNER = postgres
    ENCODING ='UTF8'
    TABLESPACE =pg_default
    CONNECTION LIMIT =-1;

CREATE TABLE public.user_account
(
    id character varying COLLATE pg_catalog."default" NOT NULL,
    username character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    surname character varying COLLATE pg_catalog."default" NOT NULL,
    lastname character varying COLLATE pg_catalog."default" NOT NULL,
    email character varying COLLATE pg_catalog."default" NOT NULL,
)