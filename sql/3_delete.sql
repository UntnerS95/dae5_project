SET SEARCH_PATH TO MS;

DELETE FROM radartrap;
DELETE FROM police_control WHERE posibility = 65;
DELETE FROM points WHERE track_name = 'Rout 66';
DELETE FROM points WHERE description = 'Fahrzeugcheck';
DELETE FROM points WHERE number = 4;
DELETE FROM track WHERE username = 'unti95';
DELETE FROM motorcycle WHERE brand = 'Honda';
DELETE FROM driver WHERE username = 'unti95';

COMMIT;