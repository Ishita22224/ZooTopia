package org.example;

public abstract class Animal {
    private String name;
    private final String type;
    private String noise;
    protected String briefPas;

    private int count;
    public Animal(String name, String type, String noise, String briefPassage) {
        this.name = name;
        this.type = type;
        this.noise = noise;
        this.briefPas = briefPassage;
        this.count = 1;
    }
//  getters
    public String getName() {
        return this.name;
    }
    public String getType() {
        return this.type;
    }
    public String getNoise() {
        return this.noise;
    }
    public int getCount() {return this.count;}

//    setters
    public void setName(String name) {
        this.name = name;
    }
    public void setNoise(String noise) {
        this.noise = noise;
    }
    public void setCount() {
        this.count++;
    }

    public void setBriefPassage(String briefPassage) {
        this.briefPas = briefPassage;
    }
    public abstract void makeNoise();
    public abstract String getBriefPassage();
}
