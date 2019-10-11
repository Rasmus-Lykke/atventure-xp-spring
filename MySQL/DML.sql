
-- Select the database
USE AtventureDB;

INSERT INTO AtventureDB.activity (`activity_name`,`restrictions`, activityID)
VALUES ('Go-Kart','Skal være over 150cm høj og under 220cm høj',1);

INSERT INTO AtventureDB.equipment(equipmentID, activityID, equipment_name, equipment_amount)
VALUES (1,1,'Hjelm',3),
        (2,1,'2 handsker',4);

INSERT INTO AtventureDB.booking(bookingID, activityID, participants, date, time, contact_name, contact_phone, contact_email, instructor, corporate)
VALUES (1, 1, 4,"2019-09-09","08:00","Jason","12345678","jason@derulo.com", "Peter", "false");

INSERT INTO AtventureDB.booking(bookingID, activityID, participants, date, time, contact_name, contact_phone, contact_email, instructor, corporate)
VALUES (2, 1, 7,"2020-10-11","09:15","Vladimir","987658","vlad@mail.com", "Igor", "true");



