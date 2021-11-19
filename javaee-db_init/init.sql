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
    firstName  text    NOT NULL,
    lastName text not null,
    uuid uuid    NOT NULL DEFAULT uuid_generate_v4(),
    CONSTRAINT profile_id_pk PRIMARY KEY (id)
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
    uuid uuid    NOT NULL DEFAULT uuid_generate_v4(),
    paymentType text NOT NULL,
    activityDate date,
    CONSTRAINT profile_id_pk PRIMARY KEY (id)
);