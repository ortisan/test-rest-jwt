-- Tables

CREATE TABLE "user"
(
    id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- SEQUENCES

CREATE SEQUENCE public.user_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 999999999
    CACHE 1;

ALTER SEQUENCE public.user_seq
    OWNER TO postgres;
