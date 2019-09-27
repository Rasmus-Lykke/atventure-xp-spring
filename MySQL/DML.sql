
-- Select the database
USE AtventureDB;

INSERT INTO Activities (activityName, ageRestriction)
VALUES ('Go-Kart', 17);


INSERT INTO TimeLimit (time)
VALUES (45);

INSERT INTO TimeLimit (time)
VALUES (90);


INSERT INTO Booking (activityID, participants, date, contactName, contactPhone,
			contactEmail, timeLimitID)
VALUES (1, 6, '2019-11-11 08:00:00','Bosil', '38373829', 'hosiwk@kdjje.sj', 1 );

INSERT INTO Equipment (activityID, equipmentName, equipmentAmount)
VALUES (1, 'GoCart', 12);

INSERT INTO Equipment (activityID, equipmentName, equipmentAmount)
VALUES (1, 'Hjelm', 12);

INSERT INTO Equipment (activityID, equipmentName, equipmentAmount)
VALUES (1, 'Dragt', 12);


