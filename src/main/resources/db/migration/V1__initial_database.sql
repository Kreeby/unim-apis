-- ----------------------------
-- Schema unimdb
-- ----------------------------
CREATE SCHEMA IF NOT EXISTS unimdb;


-- -- ----------------------------
-- Table unimdb.faculties
-- -- ----------------------------

CREATE TABLE IF NOT EXISTS unimdb.faculties (
    id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    faculty_name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

-- -- ----------------------------
-- Table unimdb.university
-- -- ----------------------------

CREATE TABLE IF NOT EXISTS unimdb.university (
    id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    uni_name VARCHAR (64) NOT NULL,
    created_at TIMESTAMP default current_timestamp,
    updated_at TIMESTAMP default current_timestamp,
    enabled       BOOLEAN,
    PRIMARY KEY (id)
);


-- -- ----------------------------
-- Table unimdb.country
-- -- ----------------------------

CREATE TABLE IF NOT EXISTS unimdb.countries
(
    id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    country_name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);


-- -- ----------------------------
-- Table unimdb.states
-- -- ----------------------------

CREATE TABLE IF NOT EXISTS unimdb.states
(
    id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    country_id INT,
    state_name VARCHAR(50),
    PRIMARY KEY (id),
        CONSTRAINT fk_state_state1
    FOREIGN KEY (country_id)
        REFERENCES unimdb.countries(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);


-- -- ----------------------------
-- Table unimdb.cities
-- -- ----------------------------

CREATE TABLE IF NOT EXISTS unimdb.cities
(
    id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    state_id INT,
    city_name VARCHAR(50),
    PRIMARY KEY (id),
        CONSTRAINT fk_city_city1
    FOREIGN KEY (state_id)
        REFERENCES unimdb.states(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);


-- -- ----------------------------
-- Table unimdb.locations
-- -- ----------------------------

CREATE TABLE IF NOT EXISTS unimdb.locations
(
    id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    country_id INT,
    state_id INT,
    city_id INT,
    PRIMARY KEY (id),
        CONSTRAINT fk_city_city1
    FOREIGN KEY (country_id)
        REFERENCES unimdb.countries(id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    FOREIGN KEY (state_id)
        REFERENCES unimdb.states(id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    FOREIGN KEY (city_id)
        REFERENCES unimdb.cities(id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);


-- -- ----------------------------
-- Table unimdb.interests
-- -- ----------------------------

CREATE TABLE IF NOT EXISTS unimdb.interests (
    id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    interest_name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

-- ----------------------------
-- Table unimdb.user
-- ----------------------------

CREATE TYPE gender_option AS ENUM ('Male', 'Female', 'Other');
CREATE TYPE degree_option AS ENUM ('Associate', 'Bachelor', 'Master', 'Doctoral');

CREATE TABLE IF NOT EXISTS unimdb.users
(
    id            INT         NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    first_name    VARCHAR(50) NOT NULL,
    middle_name   VARCHAR(50) NOT NULL,
    last_name     VARCHAR(50) NOT NULL,
    phone_number  VARCHAR(15) NOT NULL,
    email         VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(64) NOT NULL,
    gender gender_option NOT NULL,
    degree degree_option NOT NULL,
    interest_id INT NOT NULL,
    faculty_id INT NOT NULL,
    enabled       BOOLEAN,
    registered_at timestamp default current_timestamp,
    last_login    timestamp default current_timestamp,
    intro         TEXT,
    profile       TEXT,
    uni_id INT NOT NULL,
    location_id INT NOT NULL,
    PRIMARY KEY (id),
        CONSTRAINT fk_user_user1
    FOREIGN KEY (uni_id)
        REFERENCES unimdb.university(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    FOREIGN KEY (location_id)
        REFERENCES unimdb.locations(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    FOREIGN KEY (interest_id)
        REFERENCES unimdb.interests(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    FOREIGN KEY (faculty_id)
        REFERENCES unimdb.faculties(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);

CREATE INDEX fk_user_university_idx ON unimdb.university(id);


-- ----------------------------
-- Table unimdb.user_posts
-- ----------------------------

CREATE TABLE IF NOT EXISTS unimdb.user_posts (
    id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    user_id INT NOT NULL,
    message TEXT NULL ,
    created_at TIMESTAMP default current_timestamp,
    updated_at TIMESTAMP default current_timestamp,
    PRIMARY KEY (id),
        CONSTRAINT fk_user_user_posts1
    FOREIGN KEY (user_id)
        REFERENCES unimdb.users(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION);

CREATE INDEX fk_user_user_posts1_idx ON unimdb.user_posts(user_id);

-- ----------------------------
-- Table unimdb.user_roles
-- ----------------------------

CREATE TABLE IF NOT EXISTS unimdb.roles (
    id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    role_name VARCHAR (50) NOT NULL,
    PRIMARY KEY (id)
);

-- -- ----------------------------
-- Table unimdb.users_roles
-- -- ----------------------------

CREATE TABLE IF NOT EXISTS unimdb.users_roles (
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (user_id)
        REFERENCES unimdb.users(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    FOREIGN KEY (role_id)
        REFERENCES unimdb.roles(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION);

CREATE INDEX fk_user_user_roles1_idx on unimdb.users_roles(user_id);
CREATE INDEX fk_role_user_roles2_idx on unimdb.users_roles(role_id);
