-- DDL --

-- Drop the database if it already exists and create the database
DROP DATABASE IF EXISTS AtventureDB;
CREATE DATABASE AtventureDB;

-- Select the database
USE AtventureDB;

-- Create the tables
CREATE TABLE Activities
(
    activityID		INT				NOT NULL	AUTO_INCREMENT 	PRIMARY KEY,
    activityName	VARCHAR(50) 	NOT NULL,
    ageRestriction INT	NOT NULL
);

CREATE TABLE TimeLimit
(
	timeLimitID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    time INT NOT NULL
);

CREATE TABLE Booking
(
	bookingID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    activityID INT NOT NULL,
    FOREIGN KEY (activityID) REFERENCES Activities (activityID) ON DELETE CASCADE,
	participants INT NOT NULL,
    date DATETIME NOT NULL,
    contactName VARCHAR(50) NOT NULL,
    contactPhone VARCHAR(10) NOT NULL,
    contactEmail VARCHAR(75) NOT NULL,
    timeLimitID INT NOT NULL,
    FOREIGN KEY (timeLimitID) REFERENCES TimeLimit (timeLimitID) ON DELETE CASCADE
);

