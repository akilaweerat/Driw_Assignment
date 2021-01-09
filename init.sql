--
-- PostgreSQL database dump
--

-- Dumped from database version 10.15 (Ubuntu 10.15-0ubuntu0.18.04.1)
-- Dumped by pg_dump version 10.15 (Ubuntu 10.15-0ubuntu0.18.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: carton; Type: TABLE; Schema: public; Owner: product_user
--

CREATE TABLE public.carton (
    id bigint NOT NULL,
    price bigint NOT NULL,
    units integer NOT NULL,
    product_id bigint
);


ALTER TABLE public.carton OWNER TO product_user;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: product_user
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO product_user;

--
-- Name: product; Type: TABLE; Schema: public; Owner: product_user
--

CREATE TABLE public.product (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.product OWNER TO product_user;

--
-- Data for Name: carton; Type: TABLE DATA; Schema: public; Owner: product_user
--

COPY public.carton (id, price, units, product_id) FROM stdin;
1	175	20	1
2	825	5	2
\.


--
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: product_user
--

COPY public.product (id, name) FROM stdin;
1	Penguin-ears
2	Horseshoe
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: product_user
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- Name: carton container_pkey; Type: CONSTRAINT; Schema: public; Owner: product_user
--

ALTER TABLE ONLY public.carton
    ADD CONSTRAINT container_pkey PRIMARY KEY (id);


--
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: product_user
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- Name: carton fkprpgxed7wyc2fo69nve2s6v5a; Type: FK CONSTRAINT; Schema: public; Owner: product_user
--

ALTER TABLE ONLY public.carton
    ADD CONSTRAINT fkprpgxed7wyc2fo69nve2s6v5a FOREIGN KEY (product_id) REFERENCES public.product(id);


--
-- PostgreSQL database dump complete
--

