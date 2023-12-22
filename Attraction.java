package org.example;

public class Attraction {
    private String name;
    private String description;
    private int ticketPrice;
    private final int ID;
    private int numVisitors;
    private int status;

    public Attraction(String name, String description, int price, int id) {
        this.name = name;
        this.description = description;
        this.ticketPrice = price;
        this.numVisitors = 0;
        this.status = 1;
        this.ID = id;
    }

//    getters
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public int getTicketPrice() {
        return this.ticketPrice;
    }
    public int getID() {
        return this.ID;
    }
    public int getNumVisitors() {
        return this.numVisitors;
    }
    public int getStatus() {
        return this.status;
    }

//    setters
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setTicketPrice(int price) {
        this.ticketPrice = price;
    }
    public void setNumVisitors() {
        this.numVisitors++;
    }
    public void setStatus(int i) {
        this.status = i;
    }

//    methods
    public String getWelcomeMsg() {
        return "Welcome! " + this.name + ": " + this.description + ".";
    }
    public String getThankyouMsg() {
        return "Thank you for visiting " + this.name + ". Hope you enjoyed the attraction!";
    }

}
