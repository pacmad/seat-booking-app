CREATE DATABASE seat_booking_app;

CREATE TABLE employee (
id BIGSERIAL PRIMARY KEY,
first_name VARCHAR(65) NOT NULL,
last_name VARCHAR(65) NOT NULL,
email_address VARCHAR(65) NOT NULL
);

CREATE TABLE booking (
id BIGSERIAL PRIMARY KEY,
creation_date_time TIMESTAMP DEFAULT NULL,
booking_code UUID DEFAULT NULL,
employee_id BIGINT REFERENCES employee (id)
);

CREATE TABLE building (
id BIGSERIAL PRIMARY KEY,
name VARCHAR(65) NOT NULL
);

CREATE TABLE floor (
id BIGSERIAL PRIMARY KEY,
number INTEGER NOT NULL,
name VARCHAR(65) NOT NULL,
building_id BIGINT REFERENCES building (id)
);

CREATE TABLE room (
id BIGSERIAL PRIMARY KEY,
project_date_time TIMESTAMP NOT NULL,
room_title VARCHAR(65) NOT NULL,
duration_time_in_minutes INTEGER NOT NULL,
floor_id BIGINT REFERENCES floor (id)
);

CREATE TABLE row (
id BIGSERIAL PRIMARY KEY,
row_index INTEGER NOT NULL,
number_of_seats INTEGER NOT NULL,
room_id BIGINT REFERENCES room (id)
);

CREATE TABLE seat (
id BIGSERIAL PRIMARY KEY,
number INTEGER NOT NULL,
is_reserved BOOLEAN DEFAULT FALSE,
row_id BIGINT REFERENCES row (id),
booking_id BIGINT REFERENCES booking (id)
);

INSERT INTO building (name) VALUES ('JKT F2');
INSERT INTO building (name) VALUES ('JKT F3');

INSERT INTO floor (number, name, building_id) VALUES (1, 'F2FFL', 1);
INSERT INTO floor (number, name, building_id) VALUES (2, 'F3FFL', 2);
INSERT INTO floor (number, name, building_id) VALUES (3, 'F2GFL', 1);
INSERT INTO floor (number, name, building_id) VALUES (4, 'F3GFL', 2);

INSERT INTO room (project_date_time, room_title, duration_time_in_minutes, floor_id) VALUES ('2020-08-29 09:00:00', 'Project 1', 510, 1);
INSERT INTO room (project_date_time, room_title, duration_time_in_minutes, floor_id) VALUES ('2020-08-29 09:00:00', 'Project 2', 510, 1);
INSERT INTO room (project_date_time, room_title, duration_time_in_minutes, floor_id) VALUES ('2020-08-29 11:30:00', 'Project 3', 510, 2);
INSERT INTO room (project_date_time, room_title, duration_time_in_minutes, floor_id) VALUES ('2020-08-30 14:00:00', 'Project 4', 510, 3);
INSERT INTO room (project_date_time, room_title, duration_time_in_minutes, floor_id) VALUES ('2020-08-30 09:30:00', 'Project 5', 510, 3);
INSERT INTO room (project_date_time, room_title, duration_time_in_minutes, floor_id) VALUES ('2020-08-30 10:30:00', 'Project 6', 510, 4);

INSERT INTO row (row_index, number_of_seats, room_id) VALUES (1, 10, 1);
INSERT INTO row (row_index, number_of_seats, room_id) VALUES (2, 10, 1);
INSERT INTO row (row_index, number_of_seats, room_id) VALUES (3, 10, 1);

INSERT INTO row (row_index, number_of_seats, room_id) VALUES (1, 10, 2);
INSERT INTO row (row_index, number_of_seats, room_id) VALUES (2, 10, 2);
INSERT INTO row (row_index, number_of_seats, room_id) VALUES (3, 10, 2);

INSERT INTO row (row_index, number_of_seats, room_id) VALUES (1, 10, 3);
INSERT INTO row (row_index, number_of_seats, room_id) VALUES (2, 10, 3);
INSERT INTO row (row_index, number_of_seats, room_id) VALUES (3, 10, 3);

INSERT INTO row (row_index, number_of_seats, room_id) VALUES (1, 10, 4);
INSERT INTO row (row_index, number_of_seats, room_id) VALUES (2, 10, 4);
INSERT INTO row (row_index, number_of_seats, room_id) VALUES (3, 10, 4);

INSERT INTO row (row_index, number_of_seats, room_id) VALUES (1, 10, 5);
INSERT INTO row (row_index, number_of_seats, room_id) VALUES (2, 10, 5);
INSERT INTO row (row_index, number_of_seats, room_id) VALUES (3, 10, 5);

INSERT INTO row (row_index, number_of_seats, room_id) VALUES (1, 10, 6);
INSERT INTO row (row_index, number_of_seats, room_id) VALUES (2, 10, 6);
INSERT INTO row (row_index, number_of_seats, room_id) VALUES (3, 10, 6);

INSERT INTO seat (number, row_id) VALUES (1, 1);
INSERT INTO seat (number, row_id) VALUES (2, 1);
INSERT INTO seat (number, row_id) VALUES (3, 1);
INSERT INTO seat (number, row_id) VALUES (4, 1);
INSERT INTO seat (number, row_id) VALUES (5, 1);
INSERT INTO seat (number, row_id) VALUES (6, 1);
INSERT INTO seat (number, row_id) VALUES (7, 1);
INSERT INTO seat (number, row_id) VALUES (8, 1);
INSERT INTO seat (number, row_id) VALUES (9, 1);
INSERT INTO seat (number, row_id) VALUES (10, 1);

INSERT INTO seat (number, row_id) VALUES (1, 2);
INSERT INTO seat (number, row_id) VALUES (2, 2);
INSERT INTO seat (number, row_id) VALUES (3, 2);
INSERT INTO seat (number, row_id) VALUES (4, 2);
INSERT INTO seat (number, row_id) VALUES (5, 2);
INSERT INTO seat (number, row_id) VALUES (6, 2);
INSERT INTO seat (number, row_id) VALUES (7, 2);
INSERT INTO seat (number, row_id) VALUES (8, 2);
INSERT INTO seat (number, row_id) VALUES (9, 2);
INSERT INTO seat (number, row_id) VALUES (10, 2);

INSERT INTO seat (number, row_id) VALUES (1, 3);
INSERT INTO seat (number, row_id) VALUES (2, 3);
INSERT INTO seat (number, row_id) VALUES (3, 3);
INSERT INTO seat (number, row_id) VALUES (4, 3);
INSERT INTO seat (number, row_id) VALUES (5, 3);
INSERT INTO seat (number, row_id) VALUES (6, 3);
INSERT INTO seat (number, row_id) VALUES (7, 3);
INSERT INTO seat (number, row_id) VALUES (8, 3);
INSERT INTO seat (number, row_id) VALUES (9, 3);
INSERT INTO seat (number, row_id) VALUES (10, 3);

INSERT INTO seat (number, row_id) VALUES (1, 4);
INSERT INTO seat (number, row_id) VALUES (2, 4);
INSERT INTO seat (number, row_id) VALUES (3, 4);
INSERT INTO seat (number, row_id) VALUES (4, 4);
INSERT INTO seat (number, row_id) VALUES (5, 4);
INSERT INTO seat (number, row_id) VALUES (6, 4);
INSERT INTO seat (number, row_id) VALUES (7, 4);
INSERT INTO seat (number, row_id) VALUES (8, 4);
INSERT INTO seat (number, row_id) VALUES (9, 4);
INSERT INTO seat (number, row_id) VALUES (10, 4);

INSERT INTO seat (number, row_id) VALUES (1, 5);
INSERT INTO seat (number, row_id) VALUES (2, 5);
INSERT INTO seat (number, row_id) VALUES (3, 5);
INSERT INTO seat (number, row_id) VALUES (4, 5);
INSERT INTO seat (number, row_id) VALUES (5, 5);
INSERT INTO seat (number, row_id) VALUES (6, 5);
INSERT INTO seat (number, row_id) VALUES (7, 5);
INSERT INTO seat (number, row_id) VALUES (8, 5);
INSERT INTO seat (number, row_id) VALUES (9, 5);
INSERT INTO seat (number, row_id) VALUES (10, 5);

INSERT INTO seat (number, row_id) VALUES (1, 6);
INSERT INTO seat (number, row_id) VALUES (2, 6);
INSERT INTO seat (number, row_id) VALUES (3, 6);
INSERT INTO seat (number, row_id) VALUES (4, 6);
INSERT INTO seat (number, row_id) VALUES (5, 6);
INSERT INTO seat (number, row_id) VALUES (6, 6);
INSERT INTO seat (number, row_id) VALUES (7, 6);
INSERT INTO seat (number, row_id) VALUES (8, 6);
INSERT INTO seat (number, row_id) VALUES (9, 6);
INSERT INTO seat (number, row_id) VALUES (10, 6);

INSERT INTO seat (number, row_id) VALUES (1, 7);
INSERT INTO seat (number, row_id) VALUES (2, 7);
INSERT INTO seat (number, row_id) VALUES (3, 7);
INSERT INTO seat (number, row_id) VALUES (4, 7);
INSERT INTO seat (number, row_id) VALUES (5, 7);
INSERT INTO seat (number, row_id) VALUES (6, 7);
INSERT INTO seat (number, row_id) VALUES (7, 7);
INSERT INTO seat (number, row_id) VALUES (8, 7);
INSERT INTO seat (number, row_id) VALUES (9, 7);
INSERT INTO seat (number, row_id) VALUES (10, 7);

INSERT INTO seat (number, row_id) VALUES (1, 8);
INSERT INTO seat (number, row_id) VALUES (2, 8);
INSERT INTO seat (number, row_id) VALUES (3, 8);
INSERT INTO seat (number, row_id) VALUES (4, 8);
INSERT INTO seat (number, row_id) VALUES (5, 8);
INSERT INTO seat (number, row_id) VALUES (6, 8);
INSERT INTO seat (number, row_id) VALUES (7, 8);
INSERT INTO seat (number, row_id) VALUES (8, 8);
INSERT INTO seat (number, row_id) VALUES (9, 8);
INSERT INTO seat (number, row_id) VALUES (10, 8);

INSERT INTO seat (number, row_id) VALUES (1, 9);
INSERT INTO seat (number, row_id) VALUES (2, 9);
INSERT INTO seat (number, row_id) VALUES (3, 9);
INSERT INTO seat (number, row_id) VALUES (4, 9);
INSERT INTO seat (number, row_id) VALUES (5, 9);
INSERT INTO seat (number, row_id) VALUES (6, 9);
INSERT INTO seat (number, row_id) VALUES (7, 9);
INSERT INTO seat (number, row_id) VALUES (8, 9);
INSERT INTO seat (number, row_id) VALUES (9, 9);
INSERT INTO seat (number, row_id) VALUES (10, 9);

INSERT INTO seat (number, row_id) VALUES (1, 10);
INSERT INTO seat (number, row_id) VALUES (2, 10);
INSERT INTO seat (number, row_id) VALUES (3, 10);
INSERT INTO seat (number, row_id) VALUES (4, 10);
INSERT INTO seat (number, row_id) VALUES (5, 10);
INSERT INTO seat (number, row_id) VALUES (6, 10);
INSERT INTO seat (number, row_id) VALUES (7, 10);
INSERT INTO seat (number, row_id) VALUES (8, 10);
INSERT INTO seat (number, row_id) VALUES (9, 10);
INSERT INTO seat (number, row_id) VALUES (10, 10);

INSERT INTO seat (number, row_id) VALUES (1, 11);
INSERT INTO seat (number, row_id) VALUES (2, 11);
INSERT INTO seat (number, row_id) VALUES (3, 11);
INSERT INTO seat (number, row_id) VALUES (4, 11);
INSERT INTO seat (number, row_id) VALUES (5, 11);
INSERT INTO seat (number, row_id) VALUES (6, 11);
INSERT INTO seat (number, row_id) VALUES (7, 11);
INSERT INTO seat (number, row_id) VALUES (8, 11);
INSERT INTO seat (number, row_id) VALUES (9, 11);
INSERT INTO seat (number, row_id) VALUES (10, 11);

INSERT INTO seat (number, row_id) VALUES (1, 12);
INSERT INTO seat (number, row_id) VALUES (2, 12);
INSERT INTO seat (number, row_id) VALUES (3, 12);
INSERT INTO seat (number, row_id) VALUES (4, 12);
INSERT INTO seat (number, row_id) VALUES (5, 12);
INSERT INTO seat (number, row_id) VALUES (6, 12);
INSERT INTO seat (number, row_id) VALUES (7, 12);
INSERT INTO seat (number, row_id) VALUES (8, 12);
INSERT INTO seat (number, row_id) VALUES (9, 12);
INSERT INTO seat (number, row_id) VALUES (10, 12);

INSERT INTO seat (number, row_id) VALUES (1, 13);
INSERT INTO seat (number, row_id) VALUES (2, 13);
INSERT INTO seat (number, row_id) VALUES (3, 13);
INSERT INTO seat (number, row_id) VALUES (4, 13);
INSERT INTO seat (number, row_id) VALUES (5, 13);
INSERT INTO seat (number, row_id) VALUES (6, 13);
INSERT INTO seat (number, row_id) VALUES (7, 13);
INSERT INTO seat (number, row_id) VALUES (8, 13);
INSERT INTO seat (number, row_id) VALUES (9, 13);
INSERT INTO seat (number, row_id) VALUES (10, 13);

INSERT INTO seat (number, row_id) VALUES (1, 14);
INSERT INTO seat (number, row_id) VALUES (2, 14);
INSERT INTO seat (number, row_id) VALUES (3, 14);
INSERT INTO seat (number, row_id) VALUES (4, 14);
INSERT INTO seat (number, row_id) VALUES (5, 14);
INSERT INTO seat (number, row_id) VALUES (6, 14);
INSERT INTO seat (number, row_id) VALUES (7, 14);
INSERT INTO seat (number, row_id) VALUES (8, 14);
INSERT INTO seat (number, row_id) VALUES (9, 14);
INSERT INTO seat (number, row_id) VALUES (10, 14);

INSERT INTO seat (number, row_id) VALUES (1, 15);
INSERT INTO seat (number, row_id) VALUES (2, 15);
INSERT INTO seat (number, row_id) VALUES (3, 15);
INSERT INTO seat (number, row_id) VALUES (4, 15);
INSERT INTO seat (number, row_id) VALUES (5, 15);
INSERT INTO seat (number, row_id) VALUES (6, 15);
INSERT INTO seat (number, row_id) VALUES (7, 15);
INSERT INTO seat (number, row_id) VALUES (8, 15);
INSERT INTO seat (number, row_id) VALUES (9, 15);
INSERT INTO seat (number, row_id) VALUES (10, 15);

INSERT INTO seat (number, row_id) VALUES (1, 16);
INSERT INTO seat (number, row_id) VALUES (2, 16);
INSERT INTO seat (number, row_id) VALUES (3, 16);
INSERT INTO seat (number, row_id) VALUES (4, 16);
INSERT INTO seat (number, row_id) VALUES (5, 16);
INSERT INTO seat (number, row_id) VALUES (6, 16);
INSERT INTO seat (number, row_id) VALUES (7, 16);
INSERT INTO seat (number, row_id) VALUES (8, 16);
INSERT INTO seat (number, row_id) VALUES (9, 16);
INSERT INTO seat (number, row_id) VALUES (10, 16);

INSERT INTO seat (number, row_id) VALUES (1, 17);
INSERT INTO seat (number, row_id) VALUES (2, 17);
INSERT INTO seat (number, row_id) VALUES (3, 17);
INSERT INTO seat (number, row_id) VALUES (4, 17);
INSERT INTO seat (number, row_id) VALUES (5, 17);
INSERT INTO seat (number, row_id) VALUES (6, 17);
INSERT INTO seat (number, row_id) VALUES (7, 17);
INSERT INTO seat (number, row_id) VALUES (8, 17);
INSERT INTO seat (number, row_id) VALUES (9, 17);
INSERT INTO seat (number, row_id) VALUES (10, 17);

INSERT INTO seat (number, row_id) VALUES (1, 18);
INSERT INTO seat (number, row_id) VALUES (2, 18);
INSERT INTO seat (number, row_id) VALUES (3, 18);
INSERT INTO seat (number, row_id) VALUES (4, 18);
INSERT INTO seat (number, row_id) VALUES (5, 18);
INSERT INTO seat (number, row_id) VALUES (6, 18);
INSERT INTO seat (number, row_id) VALUES (7, 18);
INSERT INTO seat (number, row_id) VALUES (8, 18);
INSERT INTO seat (number, row_id) VALUES (9, 18);
INSERT INTO seat (number, row_id) VALUES (10, 18);
