package org.example;

public class Reptile extends Animal {
    private static final String briefPassage = "These are reptiles. They lay eggs on land, have dry, scaly skin and do not go through metamorphosis.\n";

    public Reptile(String name, String noise, String brief) {
        super(name, "Reptile", noise, brief);
    }

    @Override
    public void makeNoise() {
        System.out.println(this.getNoise() + "\n" + this.getName() + " (Reptile) has eaten!");
    }

    @Override
    public String getBriefPassage() {
        return briefPassage + this.briefPas;
    }
}
