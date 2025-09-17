-- Create the sequence for user IDs
CREATE SEQUENCE users_table_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;

-- Create the users table
CREATE TABLE users_table (
    id BIGINT PRIMARY KEY DEFAULT nextval('user_seq'),
    name VARCHAR(32) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    mobileExt VARCHAR(15) NOT NULL,
    mobile VARCHAR(10) NOT NULL,
    password VARCHAR(255) NOT NULL,
    bloodType VARCHAR(3) NOT NULL,
    organDonor BOOLEAN NOT NULL DEFAULT FALSE,
    createdAt TIMESTAMP NOT NULL
);

ALTER TABLE users_table MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;