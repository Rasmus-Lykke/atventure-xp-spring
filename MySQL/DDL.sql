-- DDL --

-- Drop the database if it already exists and create the database
DROP DATABASE IF EXISTS AtventureDB;
CREATE DATABASE AtventureDB;

-- Select the database
USE AtventureDB;

-- Create the tables
CREATE TABLE Activity
(
    activityID		INT				NOT NULL	AUTO_INCREMENT 	PRIMARY KEY,
    activity_name	VARCHAR(50) 	NOT NULL,
    restrictions VARCHAR(300)


);


CREATE TABLE Booking
(
	bookingID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    activityID INT NOT NULL,
    FOREIGN KEY (activityID) REFERENCES Activity (activityID) ON DELETE CASCADE,
	participants INT NOT NULL,
    date VARCHAR(50) NOT NULL,
    time VARCHAR(4) NOT NULL,
    contact_name VARCHAR(50) NOT NULL,
    contact_phone VARCHAR(10) NOT NULL,
    contact_email VARCHAR(75) NOT NULL
);

CREATE TABLE Equipment
(
	equipmentID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    activityID INT NOT NULL,
    FOREIGN KEY (activityID) REFERENCES Activity (activityID) ON DELETE CASCADE,
    equipment_name varchar(30) NOT NULL,
    equipment_amount INT NOT NULL
);