create database if not exists birds;
use birds;
drop table if exists birdtype;
drop table if exists birdname;
create table birdtype(
	id int(10) not null auto_increment,
	type varchar(25) not null,
	primary key(id)
);
create table birdname(
	id int(10) not null auto_increment,
	name varchar(25) not null,
	typeid int(10) not null,
	primary key(id),
	foreign key(typeid) references birdtype(id)
);