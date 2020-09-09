package com.example.gadsproject;

public class myinfo {

    private  String fname;
    private String fmail;
    private String flname;
    private String flink;

    public String getFname() {
        return fname;
    }

    public String getFmail() {
        return fmail;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setFmail(String fmail) {
        this.fmail = fmail;
    }

    public void setFlname(String flname) {
        this.flname = flname;
    }

    public void setFlink(String flink) {
        this.flink = flink;
    }

    public String getFlname() {
        return flname;
    }

    public String getFlink() {
        return flink;
    }

    public myinfo(String fname, String fmail, String flname, String flink) {
        this.fname = fname;
        this.fmail = fmail;
        this.flname = flname;
        this.flink = flink;
    }
}
