package org.example;

public class Amphibian extends Animal {

    private static final String briefPassage = "These are amphibians. They lay eggs in water, have smooth skin and undergo metamorphosis.\n";

    public Amphibian(String name, String noise, String brief) {
        super(name, "Amphibian", noise,brief);
    }

    @Override
    public void makeNoise() {
        System.out.println(this.getNoise() + "\n" + this.getName() + " (Amphibian) has eaten!");
    }
    @Override
    public String getBriefPassage() {
        return briefPassage + this.briefPas;
    }
}
