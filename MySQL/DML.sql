
-- Select the database
USE AtventureDB;

INSERT INTO `atventuredb`.`activity` (`activity_name`,`restrictions`, activityID)
VALUES ('Go-Kart','This is a test restriction',1);

INSERT INTO atventuredb.equipment(equipmentID, activityID, equipment_name, equipment_amount)
VALUES (1,1,'Hjelm',3);

