-- Database: tp2

-- drop database tp2;

CREATE DATABASE tp2
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'French_France.1252'
    LC_CTYPE = 'French_France.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE tp2
    IS 'exercice pour la construction d''une script SQL';

create sequence event_sequence;
comment on sequence event_sequence is 'generateur d entiers pour l id';
create table event (id integer primary key not null default nextval('event_sequence'),
					title varchar(25),
					description varchar(100),
					beginDate date,
					allDays boolean);
alter sequence event_sequence owned by event.id;

create sequence address_sequence;
create table address (id integer primary key not null default nextval('address_sequence'),
					  name varchar(25),
					  street varchar(100),
					  comments varchar(255),
					  zipCode varchar(10),
					  city varchar(25),
					  fk_address_event integer,
					  foreign key (fk_address_event) references event(id));
alter sequence address_sequence owned by address.id;

create sequence item_sequence;
create table item (id integer primary key not null default nextval('item_sequence'),
				  name varchar(25),
				  neededQuantity integer,
				  currentQuantity integer,
				  fk_item_event integer,
				  foreign key (fk_item_event) references event(id));
alter sequence item_sequence owned by item.id;

create sequence creator_sequence;
create table creator (id integer primary key not null default nextval('creator_sequence'),
					 login varchar(25),
					 password varchar(25),
					 email varchar(50));
alter sequence creator_sequence owned by creator.id;				   

create sequence guest_sequence;
create table guest (id integer primary key not null default nextval('guest_sequence'),
			 name varchar(25),
			 email varchar(50));
alter sequence guest_sequence owned by guest.id;
														  
create table guest_event (fk_event integer,
						  fk_guest integer,
						  primary key (fk_event, fk_guest),
						  foreign key (fk_event) references event(id),
						  foreign key (fk_guest) references guest(id));

alter table item
add constraint neededQuantity_check check (neededQuantity > 0),
add constraint currentQuantity_check check (currentQuantity > 0);

alter table event
add column fk_creator integer,
add constraint event_creator foreign key(fk_creator) references creator(id);

alter table event 
add constraint beginDate_check check (beginDate > '2010-01-01');
																  
alter table event
drop constraint event_creator,
add constraint event_creator foreign key(fk_creator) references creator(id) on delete cascade;
																  
-- insertion des données
truncate creator cascade;
truncate event ;
insert into creator (login, password, email) values ('barre', 'lenny', 'lenny.barre@dawan.fr');																  
insert into event (title, description, beginDate, allDays, fk_creator) 
	   values ('Noël', 'fête des enfants', '2018-12-25', false, 
              (select id from creator where login = 'barre' and email = 'lenny.barre@dawan.fr'));																  
insert into address (name, street, comments, zipCode, city, fk_address_event)
	   values ('Esipe', '71 rue Saint Simon', 'etablssement scolaire', '94010', 'Créteil', 
			  (select id from event where title = 'Noël' and beginDate = '2018-12-25'));
insert into item (name, neededQuantity, currentQuantity, fk_item_event)
	   values ('sapin de Noël', 1, 1, (select id from event where title = 'Noël' and beginDate='2018-12-25')),
			  ('boule de Noël', 20, 1, (select id from event where title = 'Noël' and beginDate='2018-12-25'));
insert into guest (name, email) values ('Terrieur', 'alain.terrieur@dawan.fr'),
									   ('Touille', 'sacha.touille@dawan.fr');
insert into guest_event (fk_event, fk_guest) values 
			((select id from event where title = 'Noël' and beginDate = '2018-12-25'), (select id from guest where name = 'Terrieur')),
            ((select id from event where title = 'Noël' and beginDate = '2018-12-25'), (select id from guest where name = 'Touille'));
			   