drop database IF EXISTS eventnext;

CREATE DATABASE IF NOT EXISTS eventnext;

ALTER DATABASE eventnext
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;


USE eventnext;

CREATE TABLE IF NOT EXISTS organizer (
oid INTEGER(11)  PRIMARY KEY,
org_name varchar(50),
org_contact varchar(50), 
org_altcontact varchar(50),
org_mail_address varchar(50),
org_address varchar(50),
org_City varchar(50),
org_password varchar(50)	
);

CREATE TABLE IF NOT EXISTS event (
  id INTEGER(11)  PRIMARY KEY,
  happening_city VARCHAR(50),
  alt_contact_no VARCHAR(50),
  contact_no VARCHAR(50),
  event_date date,
  event_name VARCHAR(50),
  event_location VARCHAR(50),
  mail_address VARCHAR(50),
  ticket_price decimal(10,2),
  oid INTEGER(11),
  FOREIGN KEY (oid) REFERENCES organizer(oid)
);

