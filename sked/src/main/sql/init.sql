drop table USERS_AUTHORITY;
drop table AUTHORITY;
drop table USERS;

CREATE TABLE IF NOT EXISTS AUTHORITY (
  id int(10) NOT NULL AUTO_INCREMENT,
  role varchar(255) NOT NULL,
  PRIMARY KEY (id)
);
INSERT INTO AUTHORITY (role) VALUES
('ROLE_USER'),
('ROLE_ADMIN');

CREATE TABLE IF NOT EXISTS USERS (
  id int(10) NOT NULL AUTO_INCREMENT,
  username varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  enabled tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
);
 
INSERT INTO USERS (username, password, enabled) VALUES
('user', '12345', 1),
('admin', '12345', 1);

CREATE TABLE IF NOT EXISTS USERS_AUTHORITY (
  id int(10) NOT NULL AUTO_INCREMENT,
  user_id int(10) NOT NULL,
  authority_id int(10) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES USERS(id),
  FOREIGN KEY (authority_id) REFERENCES AUTHORITY(id)
);

INSERT INTO USERS_AUTHORITY (user_id, authority_id) VALUES
((select id from users where username='user'), (select id from authority where role='ROLE_USER')),
((select id from users where username='admin'), (select id from authority where role='ROLE_USER')),
((select id from users where username='admin'), (select id from authority where role='ROLE_ADMIN'))
;

CREATE TABLE IF NOT EXISTS kunden (
  id int(11) NOT NULL AUTO_INCREMENT,
  vorname varchar(255) DEFAULT NULL,
  nachname varchar(255) DEFAULT NULL,
  strasse varchar(255) DEFAULT NULL,
  plz varchar(8) DEFAULT NULL,
  stadt varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

INSERT INTO kunden (id, vorname, nachname, strasse, plz, stadt) VALUES
(1, 'Max', 'Mustermann', 'Musterstraﬂe 13', '80939', 'Musterstadt'),
(2, 'Alexandra', 'Mustermann', 'Musterstraﬂe 11', '80993', 'Musterstadt');
