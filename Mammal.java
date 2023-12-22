package org.example;

public class Mammal extends Animal {
    private static final String briefPassage = "These are Mammals. They have hair, give birth to babies, and feed them with milk.\n";

    public Mammal(String name, String noise, String brief) {
        super(name, "Mammal", noise,brief);
    }

    @Override
    public void makeNoise() {
        System.out.println(this.getNoise() + "\n" + this.getName() + " (Mammal) has eaten!");
    }
    @Override
    public String getBriefPassage() {
        return briefPassage + this.briefPas;
    }
}
