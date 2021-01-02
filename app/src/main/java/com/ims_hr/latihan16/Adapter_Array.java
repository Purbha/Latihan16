package com.ims_hr.latihan16;

public class Adapter_Array {

    String Header, Role, Desc;
    int ResID;
    float Rating;

    public Adapter_Array(String nama, String role, int resID, float rating, String desc) {
        Header = nama;
        Role = role;
        ResID = resID;
        Rating = rating;
        Desc = desc;
    }

    public String getHeader() {
        return Header;
    }

    public String getRole() {
        return Role;
    }

    public int getResID() {
        return ResID;
    }

    public float getRating() {
        return Rating;
    }

    public String getDesc() {
        return Desc;
    }

}
