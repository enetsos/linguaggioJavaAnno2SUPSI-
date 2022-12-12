-- Tested on H2 version 1.4.200 & 2.0.202
create table author (
    first_name varchar2(20) not null,
    last_name varchar2(20) not null,
    birth_year integer,
    primary key (first_name, last_name)
);

create table book (
    title varchar2(50),
    pub_year integer,
    publisher varchar2(20),
    author_first_name varchar2(20),
    author_last_name varchar2(20),
    primary key (title),
    foreign key(author_first_name, author_last_name) references author(first_name, last_name)
);
