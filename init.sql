CREATE DATABASE litres WITH TEMPLATE = template0;
ALTER DATABASE litres OWNER TO postgres;
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
    user_id bigint NOT NULL,
    title character varying(100)
);
ALTER TABLE public.user_role OWNER TO postgres;
create table public.user_data(
    id serial PRIMARY key,
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
    kind_of_literature character varying(255),
    name character varying(255) not null
);
ALTER TABLE public.book_genre OWNER TO postgres;
alter table public.user_role
add FOREIGN key (user_id) REFERENCES public.user_data(id_user);
alter table public.book_rating
add FOREIGN KEY (id_user) REFERENCES public.user_data(id_user);
alter table public.comment
add FOREIGN key (id_user) REFERENCES public.user_data(id_user);
alter table public.favorites
add FOREIGN key (id_user) REFERENCES public.user_data(id_user);
alter table public.book_rating
add FOREIGN key (id_book) REFERENCES public.book(id_book);
alter table public.comment
add FOREIGN key (id_book) REFERENCES public.book(id_book);
alter table public.favorites
add FOREIGN key (id_book) REFERENCES public.book(id_book);
alter table public.book
add FOREIGN key (id_author) REFERENCES public.book_author(id_author);
alter table public.book
add FOREIGN key (id_genre) REFERENCES public.book_genre(id_genre);
INSERT INTO public.user_data(
        id,
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
        1,
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
        2,
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
        3,
        true,
        '1234567890',
        'superman',
        'superman@mail.ru',
        'Чехов',
        'Антон',
        'Павлович',
        '1996-12-22'
    );
INSERT INTO public.user_role(user_id, role)
VALUES (1, 'ADMIN'),
    (2, 'USER'),
    (3, 'MODER');
INSERT INTO public.book_author(
        id,
        birth_date,
        middle_name,
        name,
        short_bio,
        surname
    )
values(
        1,
        '1876-01-12',
        'Лондон',
        'Джек',
        'Американский писатель и журналист, военный корреспондент, общественный деятель, социалист. Наиболее известен как автор приключенческих рассказов и романов.',
        ''
    ),
    (
        2,
        '1908-11-23',
        'Носов',
        'Николай',
        'Русский советский детский писатель-прозаик, драматург, киносценарист. Лауреат Сталинской премии III степени и Государственной премии РСФСР им. Н. К. Крупской.',
        'Николаевич'
    ),
    (
        3,
        '1828-09-09',
        'Толстой',
        'Лев',
        'Один из наиболее известных русских писателей и мыслителей, один из величайших в мире писателей-романистов. Участник обороны Севастополя.',
        'Николаевич'
    );
INSERT INTO book_genre(id, kind_of_literature, name)
VALUES (1, 'Роман', 'Роман'),
    (2, 'Детская литература', 'Рассказ'),
    (3, 'Драма', 'Повесть');
    
INSERT INTO public.book (
        id,
        description,
        download_link,
        image,
        title,
        total_rating,
        id_author,
        id_genre
    )
VALUES (
        1,
        'Завораживающая история любви покажет молодого юношу – моряка, который однажды волею случая спас жизнь богатому незнакомцу, а тот в свою очередь представил его высокому обществу. Познакомившись с семьей спасенного, Мартин влюбляется в его сестру Руфь и, чтобы завоевать ее сердце, собирается изменить всю свою никчемную жизнь.',
        'https://libreed.ru/martin-iden.html/2',
        'https://ndc.book24.ru/resize/674x1080/iblock/566/56643c5b588b26dc5ecc175bf9c6e29a/aaf97e606e377b8915d1f7a14c4a03b7.jpg',
        'Мартин Иден',
        5,
        1,
        1
    ),
    (
        2,
        'Незнайка находит на улице камень и считает, что этот камень упал с Луны. Он отдаёт его Знайке. На следующий день Знайка заметил, что при действии на камень магнитного поля камень создаёт невесомость. Знайка принял решение сделать ракету и полететь вместе с остальными коротышками на Луну',
        'http://www.planetaskazok.ru/nnosovskz/neznajkanalunenosov',
        'http://www.planetaskazok.ru/images/stories/nosov/neznaika_valk/neznaika_na_lune/img_02.jpg',
        'Незнайка на Луне',
        3,
        2,
        2
    ),
    (
        3,
        'Масштабная картина жизни России, взятая во всех ее социальных слоях (от крестьян до императора Александра I), и детальное описание хода военных действий, и осмысление поведения человека на войне, но главное - это глубокое философское осмысление и исследование жизни как таковой - в быту, в семье',
        'https://ilibrary.ru/text/11/index.html',
        'https://tolstoy.ru/upload/creativity/fiction/detail/upload/iblock/72e/w-p.jpg',
        'Война и Мир',
        4.6,
        3,
        1
    );