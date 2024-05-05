CREATE TABLE plant (
    id serial PRIMARY KEY,
    name varchar(128) not null,
    type varchar(128) not null
);
CREATE TABLE track_time_method (
    id serial PRIMARY KEY,
    class_name varchar(128) not null,
    method_name varchar(128) not null,
    execution_time bigint not null,
    call_time timestamp not null
);