package com.example.mangeshaher.admin;

/**
 * Created by mangeshaher on 19/4/18.
 */

public class ListContainer {
    private String date,id,t1,t2;

    public ListContainer(){
        this.setdate("");
        this.setid("");
        this.sett1("");
        this.sett2("");
    }
    public ListContainer(String date,String id,String t1,String t2) {
        this.setdate(date);
        this.setid(id);
        this.sett1(t1);
        this.sett2(t2);
    }

    public String getdate() {
        return date;
    }

    public void setdate(String date) {
        this.date=date;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id=id;
    }

    public String gett1() {
        return t1;
    }

    public void sett1(String t1) {
        this.t1 = t1;
    }

    public String gett2() {
        return t2;
    }

    public void sett2(String t2) {
        this.t2 = t2;
    }
}
