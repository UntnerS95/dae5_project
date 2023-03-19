SET SEARCH_PATH TO tms;

SET TIME ZONE 'Europe/Vienna';

BEGIN TRANSACTION;
/* ----------------------------- */
/* ---------- DRIVERS ---------- */
INSERT INTO driver VALUES(
    'unti95',
    TO_DATE('02-01-1995', 'dd-MM-yyyy'),
    'AUT',
    'Stefan',
    'Untner'
);
INSERT INTO driver VALUES(
    'maxi01',
    TO_DATE('16-04-1967', 'dd-MM-yyyy'),
    'USA',
    'Maximimlian',
    'Smith'
);
INSERT INTO driver VALUES(
    'Sunnyboy',
    TO_DATE('23-08-2001', 'dd-MM-yyyy'),
    'AUT',
    'Klaus',
    'Sonnberger'
);
INSERT INTO driver VALUES(
    'choperGangster',
    TO_DATE('18-11-1956', 'dd-MM-yyyy'),
    'DE',
    'Franz',
    'Maier'
);
INSERT INTO driver VALUES(
    'deathOn2Wheels',
    TO_DATE('19-06-1978', 'dd-MM-yyyy'),
    'IT',
    'Giovanni',
    'Fontana'
);
/* ----------------------------- */

/* ----------------------------- */
/* -------- MOTORCYCLES -------- */
INSERT INTO motorcycle VALUES(
    DEFAULT,
    'CB650R',
    'Honda',
    'Naked-Bike',
    'unti95'
);
INSERT INTO motorcycle VALUES(
    DEFAULT,
    'CB650F',
    'Honda',
    'Naked-Bike',
    'maxi01'
);
INSERT INTO motorcycle VALUES(
    DEFAULT,
    'Streetfighter V4',
    'Ducati',
    'Naked-Bike',
    'Sunnyboy'
);
INSERT INTO motorcycle VALUES(
    DEFAULT,
    'Fat Bob',
    'Harley-Davidson',
    'Cruiser',
    'choperGangster'
);
INSERT INTO motorcycle VALUES(
    DEFAULT,
    'Panigale V4',
    'Ducati',
    'Supersportler',
    'deathOn2Wheels'
);
INSERT INTO motorcycle VALUES(
    DEFAULT,
    'GS 1200',
    'BMW',
    'Sporttourer',
    'maxi01'
);
INSERT INTO motorcycle VALUES(
    DEFAULT,
    'Scout Bobber',
    'Indian',
    'Cruiser',
    'unti95'
);
/* ----------------------------- */

/* ----------------------------- */
/* ----------- TRACK ----------- */
INSERT INTO track VALUES(
    'Donauuferstrasse',
    0.5,
    TO_TIMESTAMP('14-02-2023 19:10:59', 'dd-mm-yyyy hh24:mi:ss'),
    TO_TIMESTAMP('15-02-2023 10:53:59', 'dd-MM-yyyy hh24:mi:ss'),
    1,
    'unti95',
    1
);
INSERT INTO track VALUES(
    'Timmelsjoch',
    1.5,
    TO_TIMESTAMP('07-06-2022 12:05:03', 'dd-MM-yyyy hh24:mi:ss'),
    TO_TIMESTAMP('23-06-2022 10:53:00', 'dd-MM-yyyy hh24:mi:ss'),
    3,
    'deathOn2Wheels',
    5
);
INSERT INTO track VALUES(
    'Postalm',
    0.8,
    TO_TIMESTAMP('19-05-2022 09:15:46', 'dd-mm-yyyy hh24:mi:ss'),
    TO_TIMESTAMP('15-02-2023 10:36:22', 'dd-mm-yyyy hh24:mi:ss'),
    3,
    'unti95',
    1
);
INSERT INTO track VALUES(
    'Weissenbachstrasse',
    0.3,
    TO_TIMESTAMP('14-02-2023 07:55:18', 'dd-mm-yyyy hh24:mi:ss'),
    TO_TIMESTAMP('15-02-2023 18:47:22', 'dd-mm-yyyy hh24:mi:ss'),
    2,
    'Sunnyboy',
    3
);
INSERT INTO track VALUES(
    'Stilfser Joch',
    2.1,
    TO_TIMESTAMP('24-08-2022 08:45:18', 'dd-mm-yyyy hh24:mi:ss'),
    NULL,
    4,
    'choperGangster',
    4
);
INSERT INTO track VALUES(
    'Rout 66',
    5.5,
    TO_TIMESTAMP('01-09-2019 20:05:00', 'dd-mm-yyyy hh24:mi:ss'),
    NULL,
    2,
    'maxi01',
    6
);
/* ----------------------------- */

/* ----------------------------- */
/* ----------- POINTS ---------- */
INSERT INTO points VALUES(
    1,
    POINT(48.123456, 12.098765),
    'Startpunkt',
    NULL,
    'Donauuferstrasse'
);
INSERT INTO points VALUES(
    2,
    POINT(47.123456, 13.098765),
    'Wegpunkt',
    'rechts abbiegen',
    'Donauuferstrasse'
);
INSERT INTO points VALUES(
    3,
    POINT(46.123456, 14.098765),
    'Wegpunkt',
    'gerade aus weiter',
    'Donauuferstrasse'
);
INSERT INTO points VALUES(
    4,
    POINT(45.123456, 10.098765),
    'Polizeikontrolle',
    'Fahrzeugcheck',
    'Donauuferstrasse'
);
INSERT INTO points VALUES(
    5,
    POINT(45.123456, 15.098765),
    'Wegpunkt',
    'links abbiegen',
    'Donauuferstrasse'
);
INSERT INTO points VALUES(
    6,
    POINT(45.123456, 15.098765),
    'gefährliche Stelle',
    'unübersichtliche Kreuzung',
    'Donauuferstrasse'
);
INSERT INTO points VALUES(
    7,
    POINT(46.999885, 14.859363),
    'Radarfalle',
    NULL,
    'Donauuferstrasse'
);
INSERT INTO points VALUES(
    8,
    POINT(51.020103, 11.019238),
    'Polizeikontrolle',
    'Planquadrat',
    'Donauuferstrasse'
);
INSERT INTO points VALUES(
    9,
    POINT(44.123456, 96.098765),
    'Endpunkt',
    NULL,
    'Donauuferstrasse'
);
/* ----- */
INSERT INTO points VALUES(
    10,
    POINT(38.123456, 92.098765),
    'Startpunkt',
    NULL,
    'Timmelsjoch'
);
INSERT INTO points VALUES(
    11,
    POINT(37.123456, 93.098765),
    'Wegpunkt',
    NULL,
    'Timmelsjoch'
);
INSERT INTO points VALUES(
    12,
    POINT(37.123456, 93.098765),
    'gefährliche Stelle',
    'Kurve - Ende ist nicht einsehbar',
    'Timmelsjoch'
);
INSERT INTO points VALUES(
    13,
    POINT(36.123456, 94.098765),
    'Wegpunkt',
    NULL,
    'Timmelsjoch'
);
INSERT INTO points VALUES(
    14,
    POINT(36.123456, 94.098765),
    'Radarfalle',
    NULL,
    'Timmelsjoch'
);
INSERT INTO points VALUES(
    15,
    POINT(36.564738, 92.987654),
    'Polizeikontrolle',
    'mobiles Radar',
    'Timmelsjoch'
);
INSERT INTO points VALUES(
    16,
    POINT(35.123456, 95.098765),
    'Wegpunkt',
    NULL,
    'Timmelsjoch'
);
INSERT INTO points VALUES(
    17,
    POINT(35.369147, 95.246802),
    'Polizeikontrolle',
    'Fahrzeugcheck',
    'Timmelsjoch'
);
INSERT INTO points VALUES(
    18,
    POINT(34.123456, 96.098765),
    'Endpunkt',
    NULL,
    'Timmelsjoch'
);
/* ----- */
INSERT INTO points VALUES(
    19,
    POINT(98.123456, 52.098765),
    'Startpunkt',
    NULL,
    'Postalm'
);
INSERT INTO points VALUES(
    20,
    POINT(97.654321, 53.123456),
    'gefährliche Stelle',
    'Kurve - schliesst sich ab dem Scheitelpunkt sehr schnell',
    'Postalm'
);
INSERT INTO points VALUES(
    21,
    POINT(97.123456, 53.098765),
    'Wegpunkt',
    NULL,
    'Postalm'
);
INSERT INTO points VALUES(
    22,
    POINT(96.654321, 53.098765),
    'Polizeikontrolle',
    'mobiles Radar',
    'Postalm'
);
INSERT INTO points VALUES(
    23,
    POINT(95.123456, 54.098765),
    'Wegpunkt',
    NULL,
    'Postalm'
);
INSERT INTO points VALUES(
    24,
    POINT(94.123456, 55.098765),
    'Radarfalle',
    NULL,
    'Postalm'
);
INSERT INTO points VALUES(
    25,
    POINT(93.123456, 55.098765),
    'Wegpunkt',
    NULL,
    'Postalm'
);
INSERT INTO points VALUES(
    26,
    POINT(92.654321, 55.098765),
    'Polizeikontrolle',
    'Planquadrat',
    'Postalm'
);
INSERT INTO points VALUES(
    27,
    POINT(91.123456, 56.098765),
    'Endpunkt',
    NULL,
    'Postalm'
);
/* ----- */
INSERT INTO points VALUES(
    28,
    POINT(38.123456, 10.098765),
    'Startpunkt',
    NULL,
    'Weissenbachstrasse'
);
INSERT INTO points VALUES(
    29,
    POINT(37.123456, 12.098765),
    'Polizeikontrolle',
    'Fahrzeugcheck',
    'Weissenbachstrasse'
);
INSERT INTO points VALUES(
    30,
    POINT(36.123456, 14.098765),
    'Wegpunkt',
    NULL,
    'Weissenbachstrasse'
);
INSERT INTO points VALUES(
    31,
    POINT(35.123456, 16.098765),
    'Polizeikontrolle',
    'mobiles Radar',
    'Weissenbachstrasse'
);
INSERT INTO points VALUES(
    32,
    POINT(34.123456, 18.098765),
    'Wegpunkt',
    NULL,
    'Weissenbachstrasse'
);
INSERT INTO points VALUES(
    33,
    POINT(33.010245, 19.456852),
    'Radarfalle',
    NULL,
    'Weissenbachstrasse'
);
INSERT INTO points VALUES(
    34,
    POINT(32.123456, 20.098765),
    'Wegpunkt',
    NULL,
    'Weissenbachstrasse'
);
INSERT INTO points VALUES(
    35,
    POINT(31.987654, 21.098765),
    'gefährliche Stelle',
    'Kupel - gefahr abzuheben',
    'Weissenbachstrasse'
);
INSERT INTO points VALUES(
    36,
    POINT(30.123456, 22.098765),
    'Endpunkt',
    NULL,
    'Weissenbachstrasse'
);
/* ----- */
INSERT INTO points VALUES(
    37,
    POINT(70.123456, 30.098765),
    'Startpunkt',
    NULL,
    'Stilfser Joch'
);
INSERT INTO points VALUES(
    38,
    POINT(71.123456, 35.098765),
    'Polizeikontrolle',
    'Fahrzeugcheck',
    'Stilfser Joch'
);
INSERT INTO points VALUES(
    39,
    POINT(71.123456, 38.976340),
    'gefährliche Stelle',
    'gefährliche Engstelle - Platz für nur 1 Fahrzeug',
    'Stilfser Joch'
);
INSERT INTO points VALUES(
    40,
    POINT(71.990125, 40.098765),
    'Wegpunkt',
    NULL,
    'Stilfser Joch'
);
INSERT INTO points VALUES(
    41,
    POINT(72.123456, 45.098765),
    'Wegpunkt',
    NULL,
    'Stilfser Joch'
);
INSERT INTO points VALUES(
    42,
    POINT(73.000032, 51.943703),
    'Radarfalle',
    NULL,
    'Stilfser Joch'
);
INSERT INTO points VALUES(
    43,
    POINT(73.123456, 50.098765),
    'Polizeikontrolle',
    'Planquadrat',
    'Stilfser Joch'
);
INSERT INTO points VALUES(
    44,
    POINT(74.123456, 55.098765),
    'Endpunkt',
    NULL,
    'Stilfser Joch'
);
/* ----- */
INSERT INTO points VALUES(
    45,
    POINT(55.123456, 60.098765),
    'Startpunkt',
    NULL,
    'Rout 66'
);
INSERT INTO points VALUES(
    46,
    POINT(60.582934, 60.998765),
    'Radarfalle',
    NULL,
    'Rout 66'
);
INSERT INTO points VALUES(
    47,
    POINT(65.123456, 61.098765),
    'Polizeikontrolle',
    'Fahrzeugcheck',
    'Rout 66'
);
INSERT INTO points VALUES(
    48,
    POINT(75.990125, 61.345678),
    'Wegpunkt',
    NULL,
    'Rout 66'
);
INSERT INTO points VALUES(
    49,
    POINT(85.123456, 61.678901),
    'Polizeikontrolle',
    'mobiles Radar',
    'Rout 66'
);
INSERT INTO points VALUES(
    50,
    POINT(90.990125, 61.945678),
    'gefährliche Stelle',
    'unübersichtliche Gabelung - Autos kreuzen',
    'Rout 66'
);
INSERT INTO points VALUES(
    51,
    POINT(95.123456, 62.123456),
    'Endpunkt',
    NULL,
    'Rout 66'
);
/* ----------------------------- */

/* ----------------------------- */
/* ------ POLICE CONTROLES ----- */
INSERT INTO police_control VALUES(
    4,
    30
);
INSERT INTO police_control VALUES(
    8,
    50
);
/* ----- */
INSERT INTO police_control VALUES(
    15,
    65
);
INSERT INTO police_control VALUES(
    17,
    50
);
/* ----- */
INSERT INTO police_control VALUES(
    22,
    60
);
INSERT INTO police_control VALUES(
    26,
    15
);
/* ----- */
INSERT INTO police_control VALUES(
    29,
    12
);
INSERT INTO police_control VALUES(
    31,
    80
);
/* ----- */
INSERT INTO police_control VALUES(
    38,
    45
);
INSERT INTO police_control VALUES(
    43,
    59
);
/* ----- */
INSERT INTO police_control VALUES(
    47,
    69
);
INSERT INTO police_control VALUES(
    49,
    89
);
/* ----------------------------- */

/* ----------------------------- */
/* --------- RADARTRAP --------- */
INSERT INTO radartrap VALUES(
    7,
    70
);
INSERT INTO radartrap VALUES(
    14,
    50
);
INSERT INTO radartrap VALUES(
    24,
    80
);
INSERT INTO radartrap VALUES(
    33,
    100
);
INSERT INTO radartrap VALUES(
    42,
    40
);
INSERT INTO radartrap VALUES(
    46,
    65
);
/* ----------------------------- */

COMMIT;