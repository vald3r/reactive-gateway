create table if not exists customers
(
    id         bigserial
    constraint orders_pk
    primary key,
    name varchar(255) not null
    );

INSERT INTO customers (name) VALUES ('Igor');
INSERT INTO customers (name) VALUES ('Vasya');
INSERT INTO customers (name) VALUES ('Ignat');
