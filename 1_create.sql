CREATE SCHEMA TMS; /* TMS = Track Management System */

SET SEARCH_PATH TO tms;

/* ***************************** */
/* ***** DRIVER */
CREATE TABLE IF NOT EXISTS driver(
    username VARCHAR PRIMARY KEY,
    date_of_birth DATE NOT NULL,
    origin VARCHAR(3),
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL
);

/* ***************************** */
/* ***** MOTORCYCLE */
CREATE TABLE IF NOT EXISTS motorcycle(
    number SERIAL PRIMARY KEY,
    model_description VARCHAR NOT NULL,
    brand VARCHAR NOT NULL,
    type_description VARCHAR,
    username VARCHAR,
    CONSTRAINT username_fk 
        FOREIGN KEY (username)
        REFERENCES driver(username)
        ON DELETE SET NULL
);

/* ***************************** */
/* ***** TRACK */
CREATE TABLE IF NOT EXISTS track(
    name VARCHAR PRIMARY KEY,
    duration NUMERIC(2,1) NOT NULL,
    date_of_creation TIMESTAMP(2) NOT NULL,
    date_of_change TIMESTAMP(2),
    difficulty INTEGER NOT NULL,
    username VARCHAR,
    bike_number SERIAL,
    CONSTRAINT username_fk 
        FOREIGN KEY (username)
        REFERENCES driver(username)
        ON DELETE SET NULL,
    CONSTRAINT bike_number_fk
        FOREIGN KEY (bike_number)
        REFERENCES motorcycle(number)
        ON DELETE SET NULL,
    CONSTRAINT check_duration
        CHECK(duration > 0.0),
    CONSTRAINT check_difficulty
        CHECK(difficulty BETWEEN 1 AND 5),
    CONSTRAINT check_date
        CHECK(date_of_creation < date_of_change)
);

/* ***************************** */
/* ***** POINTS */
CREATE TYPE point_type AS ENUM(
    'Startpunkt',
    'Wegpunkt',
    'Endpunkt',
    'Polizeikontrolle',
    'Radarfalle',
    'gefährliche Stelle'
);
CREATE TABLE IF NOT EXISTS points(
    number SERIAL PRIMARY KEY,
    location POINT NOT NULL,
    type point_type NOT NULL,
    description VARCHAR,
    track_name VARCHAR,
    CONSTRAINT track_name_fk 
        FOREIGN KEY (track_name)
        REFERENCES track(name)
        ON DELETE SET NULL
);

/* ***************************** */
/* ***** POLICE CONTROL */
CREATE TABLE IF NOT EXISTS police_control(
    point_id SERIAL PRIMARY KEY,
    possibility INTEGER NOT NULL,
    CONSTRAINT point_id_fk 
        FOREIGN KEY (point_id)
        REFERENCES points(number)
        ON DELETE SET NULL,
    CONSTRAINT check_possibility
        CHECK(possibility BETWEEN 0 AND 100)
);

/* ***************************** */
/* ***** RADARTRAP */
CREATE TABLE IF NOT EXISTS radartrap(
    point_id SERIAL PRIMARY KEY,
    speed_limit INTEGER NOT NULL,
    CONSTRAINT point_id_fk 
        FOREIGN KEY (point_id)
        REFERENCES points(number)
        ON DELETE SET NULL
);

/* ***************************** */
/* ***** TRACK DETAILS VIEW */
CREATE OR REPLACE VIEW track_details_view(
    name,
    duration,
    difficulty,
    id,
    location,
    type,
    description,
    username,
    brand,
    model_description
) AS
SELECT
    t.name,
    t.duration,
    t.difficulty,
    p.number,
    p.location,
    p.type,
    p.description,
    d.username,
    m.brand,
    m.model_description
FROM
    track t,
    points p,
    driver d,
    motorcycle m
WHERE
    t.name = p.track_name
    AND t.username = d.username
    AND t.bike_number = m.number;

/* ***************************** */
/* ***** DRIVER AND MOTORCYCLE VIEW */
CREATE OR REPLACE VIEW driver_motorcycle_view(
    username,
    first_name,
    last_name,
    date_of_birth,
    origin,
    brand,
    model_description,
    type_description
) AS
SELECT
    d.username,
    d.first_name,
    d.last_name,
    d.date_of_birth,
    d.origin,
    m.brand,
    m.model_description,
    m.type_description
FROM
    driver d,
    motorcycle m
WHERE
    d.username = m.username;

COMMIT;