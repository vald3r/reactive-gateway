create table if not exists public.orders
(
    id         bigserial
    constraint orders_pk
    primary key,
    productid  bigint not null,
    customerid bigint not null
);

alter table public.orders
    owner to postgres;

create unique index if not exists orders_id_uindex
    on public.orders (id);

INSERT INTO public.orders (productid, customerid) VALUES (1, 1);
INSERT INTO public.orders (productid, customerid) VALUES (2, 2);
INSERT INTO public.orders (productid, customerid) VALUES (1, 1);
INSERT INTO public.orders (productid, customerid) VALUES (2, 1);
