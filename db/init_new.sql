CREATE DATABASE litres WITH TEMPLATE = template0;
ALTER DATABASE litres OWNER TO postgres;
\ connect litres
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
SET default_tablespace = '';
SET default_table_access_method = heap;
CREATE TABLE public.user_role (
    id_role serial PRIMARY KEY,
    id_user bigint NOT NULL,
    title character varying(100)
);
ALTER TABLE public.user_role OWNER TO postgres;
create table public.user_data(
    id_user serial PRIMARY key,
    account_activity boolean,
    password character varying(255),
    username character varying(255),
    email character varying(255),
    surname character varying(255),
    name character varying(255),
    middle_name character varying(255),
    birth_date date
);
ALTER TABLE public.user_data OWNER TO postgres;
create table public.comment(
    id_comment serial PRIMARY key,
    id_book bigint not null,
    date date not null,
    text character varying(2000) not null,
    id_user bigint not null
);
ALTER TABLE public.comment OWNER TO postgres;
create table public.book_rating(
    id_rating serial PRIMARY KEY,
    rating real not null,
    id_user bigint not null,
    id_book bigint not null
);
ALTER TABLE public.book_rating OWNER TO postgres;
CREATE TABLE public.book (
    id_book serial PRIMARY KEY,
    download_link character varying(1000),
    image character varying(1000),
    description character varying(1000),
    title character varying(255) not null,
    id_author bigint not null,
    id_genre bigint,
    total_rating real
);
ALTER TABLE public.book OWNER TO postgres;
create table public.book_author(
    id_author serial PRIMARY KEY,
    surname character varying(255),
    name character varying(255),
    middle_name character varying(255),
    birth_date date,
    short_bio character varying(2000)
);
ALTER TABLE public.book_author OWNER TO postgres;
create table public.favorites(
    id_favorite bigint PRIMARY KEY,
    id_book bigint not null,
    id_user bigint not null
);
ALTER TABLE public.favorites OWNER TO postgres;
create table public.book_genre(
    id_genre serial PRIMARY key,
    literature_kind character varying(255),
    title character varying(255) not null
);
ALTER TABLE public.book_genre OWNER TO postgres;
alter table user_role
add FOREIGN key (id_user) REFERENCES user_data(id_user);
alter table book_rating
add FOREIGN KEY (id_user) REFERENCES user_data(id_user);
alter table comment
add FOREIGN key (id_user) REFERENCES user_data(id_user);
alter table favorites
add FOREIGN key (id_user) REFERENCES user_data(id_user);
alter table book_rating
add FOREIGN key (id_book) REFERENCES book(id_book);
alter table comment
add FOREIGN key (id_book) REFERENCES book(id_book);
alter table favorites
add FOREIGN key (id_book) REFERENCES book(id_book);
alter table book
add FOREIGN key (id_author) REFERENCES book_author(id_author);
alter table book
add FOREIGN key (id_genre) REFERENCES book_genre(id_genre);
INSERT INTO public.user_data(
        account_activity,
        password,
        username,
        email,
        surname,
        name,
        middle_name,
        birth_date
    )
VALUES (
        true,
        '1234567890',
        'mahinka007',
        'mahinka@mail.ru',
        'Иванов',
        'Иван',
        'Иванович',
        '2000-01-13'
    ),
    (
        true,
        '1234567890',
        'coolguy',
        'coolguy@mail.ru',
        'Козлов',
        'Дмитрий',
        'Степанович',
        '2002-03-14'
    ),
    (
        true,
        '1234567890',
        'superman',
        'superman@mail.ru',
        'Чехов',
        'Антон',
        'Павлович',
        '1996-12-22'
    );

INSERT INTO public.user_role(id_user, title)
VALUES (1, 'ADMIN'),(2, 'USER'), (3, 'MODER');

-- НЕ ПРОТЕСТИРОВАНО! --
INSERT INTO public.book
VALUES (
        3,
        'download_link',
        'image',
        'description',
        'Мартин Иден',
        'Джек Лондон',
        'Роман',
        5
    );
INSERT INTO public.book
VALUES (
        9,
        'download_link',
        'image',
        'description',
        'Title1',
        'Author1',
        'Genre1',
        4
    );
INSERT INTO public.book
VALUES (
        5,
        'download_link',
        'image',
        'description',
        'Title2',
        'Author2',
        'Genre2',
        3
    );