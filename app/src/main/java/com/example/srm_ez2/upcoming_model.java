package com.example.srm_ez2;

public class upcoming_model {

    String image,title,date,time,reg;

    upcoming_model(){

    }

    public upcoming_model(String image, String title, String date,String time,String reg) {
        this.image = image;
        this.title = title;
        this.date = date;
        this.time=time;
        this.reg=reg;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

}
