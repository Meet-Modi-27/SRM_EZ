package com.example.srm_ez2;

public class Club_Model {
    String C_name, Des, Surl;

    Club_Model(){

    }
    public Club_Model(String c_name, String des, String surl) {
        C_name = c_name;
        Des = des;
        Surl = surl;
    }

    public String getC_name() {
        return C_name;
    }

    public void setC_name(String c_name) {
        C_name = c_name;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String des) {
        Des = des;
    }

    public String getSurl() {
        return Surl;
    }

    public void setSurl(String surl) {
        Surl = surl;
    }
}