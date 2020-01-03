--
-- PostgreSQL database dump
--

-- Dumped from database version 11.1
-- Dumped by pg_dump version 11.1

-- Started on 2019-07-05 14:39:39

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 41378)
-- Name: categories; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categories (
    "nameCategory" character(1) NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.categories OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 41383)
-- Name: categories_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categories_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categories_id_seq OWNER TO postgres;

--
-- TOC entry 2845 (class 0 OID 0)
-- Dependencies: 197
-- Name: categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categories_id_seq OWNED BY public.categories.id;


--
-- TOC entry 199 (class 1259 OID 41430)
-- Name: event; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.event (
    name character varying NOT NULL,
    id integer NOT NULL,
    description character varying NOT NULL,
    tag character varying NOT NULL,
    location character varying NOT NULL,
    time_of_start date NOT NULL,
    tags_id integer[]
);


ALTER TABLE public.event OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 41428)
-- Name: event_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.event_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.event_id_seq OWNER TO postgres;

--
-- TOC entry 2846 (class 0 OID 0)
-- Dependencies: 198
-- Name: event_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.event_id_seq OWNED BY public.event.id;


--
-- TOC entry 202 (class 1259 OID 49636)
-- Name: event_tag; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.event_tag (
    event_id integer,
    tag_id integer
);


ALTER TABLE public.event_tag OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 49563)
-- Name: tags; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tags (
    tag_id integer NOT NULL,
    name character varying NOT NULL
);


ALTER TABLE public.tags OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 49571)
-- Name: tags_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tags_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tags_id_seq OWNER TO postgres;

--
-- TOC entry 2847 (class 0 OID 0)
-- Dependencies: 201
-- Name: tags_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tags_id_seq OWNED BY public.tags.tag_id;


--
-- TOC entry 2703 (class 2604 OID 41385)
-- Name: categories id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories ALTER COLUMN id SET DEFAULT nextval('public.categories_id_seq'::regclass);


--
-- TOC entry 2704 (class 2604 OID 41433)
-- Name: event id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event ALTER COLUMN id SET DEFAULT nextval('public.event_id_seq'::regclass);


--
-- TOC entry 2705 (class 2604 OID 49573)
-- Name: tags tag_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tags ALTER COLUMN tag_id SET DEFAULT nextval('public.tags_id_seq'::regclass);


--
-- TOC entry 2833 (class 0 OID 41378)
-- Dependencies: 196
-- Data for Name: categories; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2836 (class 0 OID 41430)
-- Dependencies: 199
-- Data for Name: event; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.event (name, id, description, tag, location, time_of_start, tags_id) VALUES ('Event', 2, 'Description', 'tag', 'location', '1212-12-12', NULL);
INSERT INTO public.event (name, id, description, tag, location, time_of_start, tags_id) VALUES ('Event1', 3, 'Description1', 'tag1', 'location1', '1212-12-12', NULL);
INSERT INTO public.event (name, id, description, tag, location, time_of_start, tags_id) VALUES ('Duolingo Ukunda Spanish at Ukunda-beach', 6, 'Â¡Hola estudiantes de espaÃ±ol! Join us for a casual social gathering or adventure at Ukunda-beach to practice your spanish conversation skills, meet your local community, and put your skills from all those Duolingo sessions to the test! Reserve your spot and weâll see you there at 10 AM.

I will need every student to come with 100$ so that i can arrange there meals, transport and venue entry

Additional information

You can find the date, time, and address of the event below this description.
We aim to meet monthly, and our events are targeted for intermediate.
This event is free to attend. Please consider supporting the hosting business by purchasing a drink or snack.
This group is open to all ages, but under 18s must be accompanied by an adult.', 'duolingo', 'Ukunda', '2019-07-21', NULL);
INSERT INTO public.event (name, id, description, tag, location, time_of_start, tags_id) VALUES ('Memffffory Dishes', 8, 'Memoryf Dishes highlights the cooking practices of six Rhode Island families: Alcantara, Aubourg, Malabre, da GraÃÂ§a, Jones, and Powell. They follow a long tradition of women of African descent who reimagined culinary practices in the New World, blending traditional West and Central African recipes with indigenous and European staples.Today mothers, grandmothers, and aunts continue this tradition, passing recipes mixed with family histories to daughters, granddaughters and nieces in kitchens throughout the Americas. The smells of the cachupa simmering on the stove, the sound of the concÃÂ³n scraped from the bottom of the pot, the rhythm of the pilon, and the heat of the scotch bonnet pepper, are central to African diasporic life. Everyday food and cooking become complex forms of culinary art and rituals of remembrance and independence. This exhibition pays homage to female cooks, both seen and unseen, and the ways their labor connects a vast and diverse diasporic peoples across generations.', 'Arts, Performance, History, Cultural Studies, Languages, Humanities, Identity, Culture, Inclusion', 'Center for the Study of Slavery & Justice (CSSJ)', '2019-10-31', NULL);
INSERT INTO public.event (name, id, description, tag, location, time_of_start, tags_id) VALUES ('Tea and Biscuits', 9, 'CBI Presents: Tea & Biscuits

BCBI is hosting Tea & Biscuits, a summer social event to bring together BCBI Faculty, Students and Staff to celebrate summer. Please join us Tuesday, July 2, 2019 at 3:30pm for refreshments (hot/iced tea and coffee) and conversation at the BCBI office.
If you have any questions, or if you plan to attend, please email us at bcbi@brown.edu We hope to see you there!', 'BCDI', 'BCDI', '2019-07-02', NULL);
INSERT INTO public.event (name, id, description, tag, location, time_of_start, tags_id) VALUES ('The International 2019 (TI9)', 10, 'The International 2019 (TI9) is the upcoming ninth iteration of The International, an annual Dota 2 world championship esports tournament. Hosted by Valve Corporation, the game''s developer, TI9 will follow a year-long series of tournaments awarding qualifying points, known as the Dota Pro Circuit (DPC), with the top 12 ranking teams being directly invited to the tournament. In addition, six more teams will earn invites through regional qualifiers, with the group stage and main event of the tournament to be played at the Mercedes-Benz Arena in Shanghai in August 2019. As with every International from 2013 onwards, the prize pool is being crowdfunded by the Dota 2 community via its battle pass feature, with the total currently at over US$24 million, making it one of the largest for any esports tournament in history.', 'international, 2019, ', 'Mercedes-Benz Arena in Shanghai', '2019-08-20', NULL);
INSERT INTO public.event (name, id, description, tag, location, time_of_start, tags_id) VALUES ('Event', 19, 'Ekjhadfevliiwuerhnlwr3ev24f34f34gt', 'jdsalgf', 'location', '0121-02-12', NULL);
INSERT INTO public.event (name, id, description, tag, location, time_of_start, tags_id) VALUES ('StarLadder Events', 11, 'Format
Single elimination
All matches are played in a Bo3
Prize Distribution
Total prize pool for the tournament is $2,000 USD.

Place	$ USD	Qualified	Team
 1st	$1,200	-	 TBD
 2nd	$500	-	 TBD
 3rd	$300	-	 TBD
place 4 to 8 
 4th	-	-	 TBD
5th-8th	-	-	 TBD
 TBD
 TBD
 TBD
League Information
Series:StarLadder ProSeries StarLadder ProSeries
Organizer:StarLadder
Type:Online
Location:Europe Europe
Dates:Jul 4 - 6, 2019
Teams:8
Format:Single Elimination
Prize Pool:$2,000 USD
Liquipedia Tier:Minor
', 'starladder', 'Europe', '2019-07-04', NULL);
INSERT INTO public.event (name, id, description, tag, location, time_of_start, tags_id) VALUES ('Memory Dishes', 7, 'Memory Dishes1 highlights the cooking practices of six Rhode Island families: Alcantara, Aubourg, Malabre, da GraÃÂÃÂ§a, Jones, and Powell. They follow a long tradition of women of African descent who reimagined culinary practices in the New World, blending traditional West and Central African recipes with indigenous and European staples.Today mothers, grandmothers, and aunts continue this tradition, passing recipes mixed with family histories to daughters, granddaughters and nieces in kitchens throughout the Americas. The smells of the cachupa simmering on the stove, the sound of the concÃÂÃÂ³n scraped from the bottom of the pot, the rhythm of the pilon, and the heat of the scotch bonnet pepper, are central to African diasporic life. Everyday food and cooking become complex forms of culinary art and rituals of remembrance and independence. This exhibition pays homage to female cooks, both seen and unseen, and the ways their labor connects a vast and diverse diasporic peoples across generations.', 'Arts, Performance1, History, Cultural Studies, Languages, Humanities, Identity, Culture, Inclusion', 'Center for th1e Study of Slavery & Justice (CSSJ)', '2020-10-31', NULL);
INSERT INTO public.event (name, id, description, tag, location, time_of_start, tags_id) VALUES ('eqaweqwecqf', 20, 'rvqfqwtvogei4jyhnymju56byhn,uo56nj ', 'tag', 'location', '1222-02-12', NULL);
INSERT INTO public.event (name, id, description, tag, location, time_of_start, tags_id) VALUES ('23f4523f5g34t', 21, 'g3t4g-6g9k3-09p4g8kihuioyhi4uohiyj4uh4p9yhui', 'iy34itgyh3itgyhnu', 'otjygnho', '1222-02-12', NULL);
INSERT INTO public.event (name, id, description, tag, location, time_of_start, tags_id) VALUES ('v45ty54byju4mhpo694yhju', 23, 'outvgnj34up90g5tup34uo3utgo3p4tjugo34ginu', 'ugn34po5g34ugpo59`', 'pouig5n2po45gnup', '0122-12-12', NULL);


--
-- TOC entry 2839 (class 0 OID 49636)
-- Dependencies: 202
-- Data for Name: event_tag; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2837 (class 0 OID 49563)
-- Dependencies: 200
-- Data for Name: tags; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tags (tag_id, name) VALUES (1, 'Entertainment');
INSERT INTO public.tags (tag_id, name) VALUES (2, 'game');
INSERT INTO public.tags (tag_id, name) VALUES (3, 'Trip');
INSERT INTO public.tags (tag_id, name) VALUES (4, 'Science');
INSERT INTO public.tags (tag_id, name) VALUES (5, 'Cars');
INSERT INTO public.tags (tag_id, name) VALUES (6, 'Relax');
INSERT INTO public.tags (tag_id, name) VALUES (7, 'Tech');
INSERT INTO public.tags (tag_id, name) VALUES (8, 'Technology');
INSERT INTO public.tags (tag_id, name) VALUES (9, 'Extreme');
INSERT INTO public.tags (tag_id, name) VALUES (10, 'Skydiving');


--
-- TOC entry 2848 (class 0 OID 0)
-- Dependencies: 197
-- Name: categories_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categories_id_seq', 1, false);


--
-- TOC entry 2849 (class 0 OID 0)
-- Dependencies: 198
-- Name: event_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.event_id_seq', 23, true);


--
-- TOC entry 2850 (class 0 OID 0)
-- Dependencies: 201
-- Name: tags_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tags_id_seq', 10, true);


--
-- TOC entry 2707 (class 2606 OID 41438)
-- Name: event event_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event
    ADD CONSTRAINT event_pkey PRIMARY KEY (id);


--
-- TOC entry 2709 (class 2606 OID 49655)
-- Name: tags tag_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tags
    ADD CONSTRAINT tag_id PRIMARY KEY (tag_id);


--
-- TOC entry 2710 (class 2606 OID 49649)
-- Name: event_tag event_tag_event_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event_tag
    ADD CONSTRAINT event_tag_event_id_fkey FOREIGN KEY (event_id) REFERENCES public.event(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2711 (class 2606 OID 49656)
-- Name: event_tag event_tag_tag_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event_tag
    ADD CONSTRAINT event_tag_tag_id_fkey FOREIGN KEY (tag_id) REFERENCES public.tags(tag_id) ON UPDATE CASCADE ON DELETE CASCADE;


-- Completed on 2019-07-05 14:39:40

--
-- PostgreSQL database dump complete
--

