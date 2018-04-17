package com.example.mangeshaher.admin;

/**
 * Created by mangeshaher on 16/4/18.
 */

public class Row {
    private String Date,Item1,Item2;

    public Row(){
        this.setDate("");
        this.setItem1("");
        this.setItem2("");
    }
    public Row(String Date,String Item1, String Item2) {
        this.setDate(Date);
        this.setItem1(Item1);
        this.setItem2(Item2);
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public String getItem1() {
        return Item1;
    }

    public void setItem1(String it1) {
        this.Item1 = it1;
    }

    public String getItem2() {
        return Item2;
    }

    public void setItem2(String it2) {
        this.Item2 = it2;
    }
}
