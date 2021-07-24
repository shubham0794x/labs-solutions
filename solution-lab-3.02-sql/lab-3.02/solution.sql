
-- EXERCISE 1 --
-- Normalize the following blog database and write the DDL scripts to create the database tables:
DROP SCHEMA IF EXISTS demo;
CREATE SCHEMA demo;

USE demo;

CREATE TABLE author (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE post (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    word_count INT,
    views INT,
    author_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (author_id)
        REFERENCES author (id)
);

-- EXERCISE 2 --
-- Normalize the following airline database and write the DDL scripts to create the database tables:
DROP SCHEMA IF EXISTS demo;
CREATE SCHEMA demo;
USE demo;

CREATE TABLE aircraft (
	model VARCHAR(100) NOT NULL,
    seats INT,
    PRIMARY KEY (model)
);

CREATE TABLE flight (
	number VARCHAR(20) NOT NULL,
    mileage BIGINT,
    aircraft VARCHAR(100),
    PRIMARY KEY (number),
    FOREIGN KEY (aircraft) REFERENCES aircraft(model)
);

CREATE TABLE customer (
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    status ENUM('None', 'Silver', 'Gold'),
    mileage INT,
    PRIMARY KEY (id)
);

CREATE TABLE registry (
	id INT NOT NULL AUTO_INCREMENT,
    customer_id INT,
    flight_number VARCHAR(20),
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (flight_number) REFERENCES flight(number)
);

INSERT INTO
	aircraft(model, seats)
VALUES
	('Boeing 747', 400),
    ('Airbus A330', 236),
    ('Boeing 777', 264);

INSERT INTO
	flight(number, mileage, aircraft)
VALUES
	('DL143', 135, 'Boeing 747'),
    ('DL122', 4370, 'Airbus A330'),
    ('DL53', 2078, 'Boeing 777'),
    ('DL222', 1765, 'Boeing 777'),
    ('DL37', 531, 'Boeing 747');

INSERT INTO
	customer(name, status, mileage)
VALUES
	('Agustine Riviera', 'Silver', 115235),
    ('Alaina Sepulvida', 'None', 6008),
    ('Tom Jones', 'Gold', 205767),
    ('Sam Rio', 'None', 2653),
    ('Jessica James', 'Silver', 127656),
    ('Ana Janco', 'Silver', 136773),
    ('Jennifer Cortez', 'Gold', 300582),
    ('Christian Janco', 'Silver', 14642);

INSERT INTO
	registry(customer_id, flight_number)
VALUES
	(1, 'DL143'),
    (1, 'DL122'),
    (2, 'DL122'),
    (1, 'DL143'),
    (3, 'DL122'),
    (3, 'DL53'),
    (1, 'DL143'),
    (4, 'DL143'),
    (1, 'DL143'),
    (3, 'DL222'),
    (5, 'DL143'),
    (4, 'DL143'),
    (6, 'DL222'),
    (7, 'DL222'),
    (5, 'DL122'),
    (4, 'DL37'),
    (8, 'DL222');

SELECT * FROM aircraft;
SELECT * FROM customer;
SELECT * FROM flight;
SELECT * FROM registry;


-- In the Airline database write the SQL script to get the total number of flights in the database
SELECT COUNT(*) FROM flight;

-- In the Airline database write the SQL script to get the average flight distance
SELECT AVG(mileage) FROM flight;

-- In the Airline database write the SQL script to get the average number of seats
SELECT AVG(seats) FROM aircraft;

-- In the Airline database write the SQL script to get the average number of miles flown by customers grouped by status
SELECT status, AVG(mileage) FROM customer GROUP BY status;

-- In the Airline database write the SQL script to get the maximum number of miles flown by customers grouped by status
SELECT status, MAX(mileage) FROM customer GROUP BY status;

-- In the Airline database write the SQL script to get the total number of aircraft with a name containing Boeing
SELECT COUNT(*) FROM aircraft WHERE model LIKE 'Boeing%';

-- In the Airline database write the SQL script to find all flights with a distance between 300 and 2000 miles
SELECT *  FROM flight WHERE mileage BETWEEN 300 AND 2000;

-- In the Airline database write the SQL script to find the average flight distance booked grouped by customer status (this should require a join)
SELECT AVG(f.mileage), c.status FROM registry r JOIN (customer c, flight f) ON (r.customer_id = c.id AND r.flight_number = f.number) GROUP BY c.status;

-- In the Airline database write the SQL script to find the most aircraft most often booked by gold status members (this should require a join)
SELECT MAX(aircraft) FROM registry r JOIN (customer c, flight f) ON (r.customer_id = c.id AND r.flight_number = f.number) WHERE c.status = 'Gold';