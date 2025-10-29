
create sequence if not exists my_playground_schema.users_seq start with 1 increment by 1;


create table if not exists my_playground_schema.users (
                       id bigint auto_increment not null,
                       first_name varchar(255),
                       last_name varchar(255),
                       local_date_time timestamp(6),
                       offset_date_time timestamp(6) with time zone,
                       role enum ('ADMIN','DEVELOPER','EMPLOYEE','MANAGER','USER'),
                       time_zone_offset varchar(255),
                       primary key (id)
);
