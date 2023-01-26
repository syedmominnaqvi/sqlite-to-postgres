CREATE TABLE TableA(
    uuid UUID not null primary key,
    request_uuid UUID NOT NULL ,
    title VARCHAR,
    number BIGINT
);

CREATE TABLE public.tableb (
	uuid UUID not null primary key,
	request_uuid uuid NOT NULL,
	id int8,
	subject varchar
);