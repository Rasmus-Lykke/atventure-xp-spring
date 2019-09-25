-- Drop the database if it already exists and create the database
DROP DATABASE IF EXISTS AtventureDB;
CREATE DATABASE AtventureDB;

-- Select the database
USE AtventureDB;

-- Create the tables
CREATE TABLE Aktiviteter
(
    aktivitetsID		INT				NOT NULL	AUTO_INCREMENT 	PRIMARY KEY,
    aktivitetsNavn		VARCHAR(50) 	NOT NULL,
    aldersbegrænsning	INT				NOT NULL
);