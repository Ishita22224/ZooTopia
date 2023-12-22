package org.example;

public class SpecialDeal {
    private int numTickets;
    private int percentage;
    private String msg;

//    constructor
    public SpecialDeal(int numTickets, int percent) {
        this.numTickets = numTickets;
        this.percentage = percent;
        this.msg = "Buy " + numTickets + " and get " + percent + "% off!";
    }

//    getters
    public int getNumTickets() {
        return this.numTickets;
    }
    public int getPercentage() {
        return this.percentage;
    }
    public String getMsg() {
        return this.msg;
    }

//    setters
    private void setMsg() {
        this.msg = "Buy " + this.numTickets + " and get " + this.percentage + "% off!";
    }
    public void setNumTickets(int num) {
        this.numTickets = num;
        setMsg();
    }
    public void setPercentage(int percent) {
        this.percentage = percent;
        setMsg();
    }
}
