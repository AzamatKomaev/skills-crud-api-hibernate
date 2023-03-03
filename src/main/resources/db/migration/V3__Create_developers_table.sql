create table developers (
    id serial primary key not null,
    firstname varchar(255) not null,
    lastname varchar(255) not null,
    status smallint not null,
    specialty_id integer not null,

    foreign key (specialty_id) references specialties(id) on delete cascade
)