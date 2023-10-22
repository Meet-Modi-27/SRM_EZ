package com.example.srm_ez2;

public class Model {
    String Name,Course,Email,Room,Surl;

    public String getSurl() {
        return Surl;
    }

    public void setSurl(String surl) {
        Surl = surl;
    }

    public Model(String surl) {
        Surl = surl;
    }

    Model(){

    }
    public Model(String name, String course, String email, String room) {
        Name = name;
        Course = course;
        Email = email;
        Room = room;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getRoom() {
        return Room;
    }

    public void setRoom(String room) {
        Room = room;
    }
}
