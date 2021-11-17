CREATE
EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE SEQUENCE public.user_seq
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 2147483647
    START WITH 1000 CACHE 1
    NO CYCLE
    OWNED BY NONE;
ALTER SEQUENCE public.user_seq OWNER TO stackleader;

CREATE TABLE public.user
(
    id   integer NOT NULL DEFAULT nextval('public.user_seq'::regclass),
    first_name  text    NOT NULL,
    last_name text not null,
    uuid uuid    NOT NULL DEFAULT uuid_generate_v4(),
    CONSTRAINT user_id_pk PRIMARY KEY (id)
);

CREATE SEQUENCE public.payment_seq
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 2147483647
    START WITH 1000 CACHE 1
    NO CYCLE
    OWNED BY NONE;
ALTER SEQUENCE public.payment_seq OWNER TO stackleader;


CREATE TABLE public.payment
(
    id   integer NOT NULL DEFAULT nextval('public.payment_seq'::regclass),
    amount numeric not null,
    user_id integer not null,
    uuid uuid    NOT NULL DEFAULT uuid_generate_v4(),
    payment_type text NOT NULL,
    activity_date date,
    CONSTRAINT payment_id_pk PRIMARY KEY (id)
);

ALTER TABLE public.payment
    ADD CONSTRAINT user_fk FOREIGN KEY (user_id)
        REFERENCES public.user (id) MATCH FULL
        ON DELETE CASCADE ON UPDATE CASCADE;


INSERT INTO "user" (first_name, last_name, uuid) 
    VALUES ('David', 'Norris', 'e5885598-8e94-49b3-a642-af4d8e5d8033');
INSERT INTO payment (amount, user_id, uuid, payment_type, activity_date) 
    VALUES (1000, 1000, '2469fb5f-6b77-44b2-a3b8-602cdab8c4b4', 'ACH', '2021-11-01');
