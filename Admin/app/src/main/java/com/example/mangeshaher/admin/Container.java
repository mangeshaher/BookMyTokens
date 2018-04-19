package com.example.mangeshaher.admin;

/**
 * Created by mangeshaher on 19/4/18.
 */

public class Container {
    private String t1,t2;

    public Container(){
        this.sett1("");
        this.sett2("");
    }
    public Container(String t1,String t2) {
        this.sett1(t1);
        this.sett2(t2);
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
