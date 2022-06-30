create table if not exists public.customers
(
    id         bigserial
    constraint orders_pk
    primary key,
    name varchar(255) not null
);

create unique index if not exists customers_id_uindex
    on public.customers (id);

INSERT INTO public.customers (name) VALUES ('Igor');
INSERT INTO public.customers (name) VALUES ('Vasya');
INSERT INTO public.customers (name) VALUES ('Ignat');
