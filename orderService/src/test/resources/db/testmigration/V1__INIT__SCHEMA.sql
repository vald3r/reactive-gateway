create table if not exists orders
(
    id         bigserial
    constraint orders_pk
    primary key,
    productId  bigint not null,
    customerId bigint not null
);

create unique index if not exists orders_id_uindex
    on orders (id);

INSERT INTO orders (productid, customerid) VALUES (1, 1);
INSERT INTO orders (productid, customerid) VALUES (2, 2);
INSERT INTO orders (productid, customerid) VALUES (1, 1);
INSERT INTO orders (productid, customerid) VALUES (2, 1);
