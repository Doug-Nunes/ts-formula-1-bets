create table bets.user(
	id int8 GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	name varchar(60)
);

create table bets.user_balance(
	id int8 GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	user_id int8 not null,
	currency_type varchar(60),
	amount numeric(19,2)
);

alter table bets.user_balance add constraint fk_balance_user_id foreign key (user_id) references bets.user(id);

create table bets.event_session(
    id int8 GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    country varchar(255),
    year varchar(4),
    session_type varchar(30),
    session_key int not null
);

create table bets.driver (
    id int8 GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	full_name varchar(60) not null,
	id_number int not null,
	event_session_id int8,
	odds int
);

alter table bets.driver add constraint fk_event_session_id foreign key (event_session_id)
    references bets.event_session(id);

create table bets.bet(
    id int8 GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id int8 not null,
	driver_id int8 not null,
	event_session_id int8 not null,
	amount numeric(19,2) not null,
	bet_date timestamp not null,
	status varchar(30) not null
);


alter table bets.bet add constraint fk_user foreign key (user_id) references bets.user(id);
alter table bets.bet add constraint fk_driver foreign key (driver_id) references bets.driver(id);
alter table bets.bet add constraint fk_event_session_id foreign key (event_session_id) references bets.event_session(id);

create table bets.event_outcome (
    id int8 GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	driver_id int not null,
	session_key int not null
);