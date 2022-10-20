package com.example.planner.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity(name = "toDoLists")
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "title")
    private String title;

    @Column (name = "date")
    private Date date;

    @Column (name = "time")
    private Time time;

    @Column (name = "details")
    private String details;

    @Column (name = "colour")
    private List colour;

    @Column (name = "notification")
    private boolean notification;

    @Column (name = "location")
    private String location;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"toDoList"})
    private User user;

    public ToDoList(String title, Date date, Time time, String details, List colour, boolean notification, String location){
        this.title = title;
        this.date = date;
        this.time = time;
        this.details = details;
        this.colour = new ArrayList<>();
        this.notification = notification;
        this.location = location;
    }

    public ToDoList(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List getColour() {
        return colour;
    }

    public void setColour(List colour) {
        this.colour = colour;
    }

    public boolean isNotification() {
        return notification;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
