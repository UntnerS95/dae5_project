
DROP USER IF EXISTS user_admin;
DROP USER IF EXISTS user_main;

CREATE USER user_admin WITH ENCRYPTED PASSWORD 'admin';
CREATE USER user_main WITH ENCRYPTED PASSWORD 'main';

ALTER DATABASE postgres OWNER TO user_admin;
GRANT INSERT, SELECT, UPDATE, DELETE
    ON  driver,
        motorcycle,
        track,
        points,
        police_control,
        radartrap
    TO user_main;
