package com.example.atventurexp_spring.Model;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Booking {

    @Id
    int bookingID;
    int activityID;
    int participants;
    Date date;
    String contactName;
    String contactPhone;
    String contactEmail;
    int timeLimitID;

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public int getParticipantsID() {
        return participants;
    }

    public void setParticipantsID(int participantsID) {
        this.participants = participantsID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getTimeLimitID() {
        return timeLimitID;
    }

    public void setTimeLimitID(int timeLimitID) {
        this.timeLimitID = timeLimitID;
    }



}
