package com.bjsxt.pojo;

public class Airplane {
    private int id;
    private String airno;
    private int time;
    private double price;
    private int takeid;
    private int landid;
    private Airport takePort;
    private Airport landPort;

    public Airport getTakePort() {
        return takePort;
    }

    public void setTakePort(Airport takePort) {
        this.takePort = takePort;
    }

    public Airport getLandPort() {
        return landPort;
    }

    public void setLandPort(Airport landPort) {
        this.landPort = landPort;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirno() {
        return airno;
    }

    public void setAirno(String airno) {
        this.airno = airno;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTakeid() {
        return takeid;
    }

    public void setTakeid(int takeid) {
        this.takeid = takeid;
    }

    public int getLandid() {
        return landid;
    }

    public void setLandid(int landid) {
        this.landid = landid;
    }
}
