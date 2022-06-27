create table if not exists public.products
(
    id         bigserial
    constraint orders_pk
    primary key,
    title varchar(255) not null
    );

create unique index if not exists products_id_uindex
    on public.products (id);

INSERT INTO public.products (title) VALUES ('PC');
INSERT INTO public.products (title) VALUES ('Laptop');
INSERT INTO public.products (title) VALUES ('Phone');
