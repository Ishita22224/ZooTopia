package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void manageAttractions(Admin admin, ZooTopia zootopia, BufferedReader reader) throws IOException {

        do {
            System.out.println("1. Add Attraction");
            System.out.println("2. View Attraction");
            System.out.println("3. Modify Attraction");
            System.out.println("4. Remove Attraction");
            System.out.println("5. Exit");

            try {
                System.out.println();
                System.out.print("Enter your choice: ");
                int n = Integer.parseInt(reader.readLine());

                switch (n) {
                    case 1 -> admin.addAttraction(zootopia, reader);
                    case 2 -> admin.viewAttractions(zootopia);
                    case 3 -> admin.modifyAttraction(zootopia, reader);
                    case 4 -> admin.removeAttraction(zootopia, reader);
                    case 5 -> {return;}
                    default -> System.out.println("Invalid input");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input (Enter an integer)");
            }

        } while (true);

    }

    public static void manageAnimals(Admin admin, ZooTopia zootopia, BufferedReader reader) throws IOException {

        do {
            System.out.println("1. Add Animal");
            System.out.println("2. Update Animal");
            System.out.println("3. Remove Animal");
            System.out.println("4. View Animal");
            System.out.println("5. Exit");

            try {
                System.out.print("Enter Your Choice: ");
                int n = Integer.parseInt(reader.readLine());

                switch (n) {
                    case 1 -> admin.addAnimal(zootopia, reader);
                    case 2 -> admin.updateAnimalDetail(zootopia, reader);
                    case 3 -> admin.removeAnimal(zootopia, reader);
                    case 4 -> admin.viewAnimals(zootopia);
                    case 5 -> {return;}
                    default -> System.out.println("Invalid Option Entered");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input (Enter an integer)");
            }

        } while (true);

    }

    public static void setDiscount(Admin admin, ZooTopia zootopia, BufferedReader reader) throws IOException {

        do {
            System.out.println("1. Add Discount");
            System.out.println("2. Modify Discount");
            System.out.println("3. Remove Discount");
            System.out.println("4. View Discounts");
            System.out.println("5. Exit");

            try {
                System.out.print("Enter your Choice: ");
                int n = Integer.parseInt(reader.readLine());

                switch (n) {
                    case 1 -> admin.addDiscount(zootopia, reader);
                    case 2 -> admin.modifyDiscount(zootopia, reader);
                    case 3 -> admin.removeDiscount(zootopia, reader);
                    case 4 -> admin.viewDiscounts(zootopia);
                    case 5 -> {return;}
                    default -> System.out.println("Invalid Choice");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input (Enter an integer)");
            }

        } while (true);

    }

    public static void setDeal(Admin admin, ZooTopia zootopia, BufferedReader reader) throws IOException {

        do {
            System.out.println("1. Add Special Deal");
            System.out.println("2. Remove Special Deal");
            System.out.println("3. View Special Deals");
            System.out.println("4. Modify Special Deal");
            System.out.println("5. Exit");

            try {
                System.out.println();
                System.out.print("Enter your choice : ");
                int n = Integer.parseInt(reader.readLine());

                switch (n) {
                    case 1 -> admin.addDeal(zootopia, reader);
                    case 2 -> admin.removeDeal(zootopia, reader);
                    case 3 -> admin.viewSpecialDeals(zootopia);
                    case 4 -> admin.modifyDeal(zootopia, reader);
                    case 5 -> {return;}
                    default -> System.out.println("Invalid Choice");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input (Enter an integer)");
            }

        } while (true);

    }
    public static void forAdmin(Admin admin, ZooTopia zootopia, BufferedReader reader) throws IOException {
        do {
            System.out.println("ADMIN MENU: ");
            System.out.println("1. Manage Attractions");
            System.out.println("2. Manage Animals");
            System.out.println("3. Schedule Events");
            System.out.println("4. Set Discounts");
            System.out.println("5. Set Special Deal");
            System.out.println("6. View Visitor Stats");
            System.out.println("7. View Feedback");
            System.out.println("8. Exit");

            System.out.println();
            System.out.print("Enter you choice: ");

            try {
                int n = Integer.parseInt(reader.readLine());

                switch (n) {
                    case 1 -> manageAttractions(admin, zootopia, reader);
                    case 2 -> manageAnimals(admin, zootopia, reader);
                    case 3 -> admin.scheduleEvent(zootopia, reader);
                    case 4 -> setDiscount(admin, zootopia, reader);
                    case 5 -> setDeal(admin, zootopia, reader);
                    case 6 -> admin.viewVisitorStats(zootopia);
                    case 7 -> admin.viewFeedback(zootopia);
                    case 8 -> { return; }
                    default -> System.out.println("Invalid Choice\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input (Enter an integer)");
            }

        } while (true);
    }


    public static void forVisitor(Visitor visitor, ZooTopia zootopia, BufferedReader reader) throws IOException {

        do {
            System.out.println("VISITOR MENU: ");
            System.out.println("1. Explore the Zoo");
            System.out.println("2. Buy MemberShip");
            System.out.println("3. Buy Tickets");
            System.out.println("4. View Discounts");
            System.out.println("5. View Special Deals");
            System.out.println("6. Visit Animals");
            System.out.println("7. Visit Attractions");
            System.out.println("8. Leave Feedback");
            System.out.println("9. Log Out");

            System.out.println();
            System.out.print("Enter you choice: ");

            try {
                int n = Integer.parseInt(reader.readLine());

                switch (n) {
                    case 1 -> visitor.exploreTheZoo(zootopia, reader);
                    case 2 -> visitor.buyMemberShip(zootopia, reader);
                    case 3 -> {
                        System.out.println("Buy Tickets: ");
                        visitor.buyTickets(zootopia, reader);
                    }
                    case 4 -> {
                        System.out.println("View Discounts: ");
                        visitor.viewDiscounts(zootopia);
                    }
                    case 5 -> {
                        System.out.println("View Special Deals: ");
                        visitor.viewSpecialDeals(zootopia);
                    }
                    case 6 -> {
                        System.out.println("Visit Animals");
                        visitor.visitAnimals(zootopia, reader);
                    }
                    case 7 -> {
                        System.out.println("Select An Attraction to Visit: ");
                        visitor.visitAttraction(zootopia, reader);
                    }
                    case 8 -> {
                        System.out.println("Leave Feedback");
                        visitor.setFeedback(zootopia, reader);
                    }
                    case 9 -> {
                        return;
                    }
                    default -> System.out.println("Invalid Choice");                    }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input (Enter an integer)");
            }

        } while (true);

    }

    public static void initialiseAnimals(ZooTopia zootopia) {
        Animal a1 = new Mammal("Lion",  "Roar", "Lions are large, carnivorous cats known for their distinctive manes (in males) and are often referred to as 'king of the jungle.'");
        Animal a2 = new Mammal("Elephant", "Trumpet", "Elephants are the largest land animals and are known for their long trunks, tusks, and social behavior in herds.");

        Animal a3 = new Reptile("Snake", "Hiss", " Snakes are legless reptiles with elongated bodies and are known for their unique hunting methods.");
        Animal a4 = new Reptile("Lizard", "Hiss","Lizards are diverse reptiles found in a wide range of habitats, from deserts to rainforests, and come in various shapes and sizes." );

        Animal a5 = new Amphibian("Red Eyed Tree Frog", "Quank", "These frogs have bright red eyes that stand out against their bright green body. Red-eyed tree frogs are arboreal, or tree-dwelling frogs that live in the rainforests of Central America.");
        Animal a6 = new Amphibian("Wood Frog", "Quacking", "Wood frogs are very well adapted to inhabiting the cooler temperatures of the Northern United States as well as most of Canada. In fact, they have a very high freeze tolerance and can actually withstand freezing of their blood and body tissues during winter months. Wood frogs are commonly found in vernal pools in wooded areas.");

        ArrayList<Animal> a = zootopia.getListAnimal();
        a.add(a1);
        a.add(a2);
        a.add(a3);
        a.add(a4);
        a.add(a5);
        a.add(a6);
    }

    public static void initialiseDiscounts(ZooTopia zootopia) {
        ArrayList<Deal> d = zootopia.getListDeal();

        Deal d1 = new Deal("Minor", 10);
        Deal d2 = new Deal("Senior", 20);
        d.add(d1);
        d.add(d2);
    }

    public static void initialiseSpecialDeals(ZooTopia zootopia) {
        ArrayList<SpecialDeal> sd = zootopia.getListSpecialDeal();

        SpecialDeal sd1 = new SpecialDeal(2, 15);
        SpecialDeal sd2 = new SpecialDeal(3, 30);

        sd.add(sd1);
        sd.add(sd2);
    }

    public static void initialiseAttractions(ZooTopia zootopia) {
        ArrayList<Attraction> a = zootopia.getListAttraction();

        Attraction a1 = new Attraction("Jungle Safari", "An adventurous expedition into the wilderness, providing an opportunity to observe and \nexperience the diverse flora and fauna of a natural habitat.", 10, zootopia.getId());
        Attraction a2 = new Attraction("Botanical Garden", "A curated space dedicated to the cultivation, study, and preservation of \nvarious plant species, showcasing the beauty and diversity of the plant kingdom.", 15, zootopia.getId());
        Attraction a3 = new Attraction("Dinosaur Show", "An exciting and educational experience that brings prehistoric creatures back to life \nthrough animatronics and exhibits, allowing visitors to step into the ancient world of dinosaurs.", 12, zootopia.getId());

        a.add(a1);
        a.add(a2);
        a.add(a3);
    }

    public static void main(String[] args) {

        ZooTopia zootopia = new ZooTopia();

//        INITIALISING ZOOTOPIA
        initialiseAttractions(zootopia);
        initialiseAnimals(zootopia);
        initialiseDiscounts(zootopia);
        initialiseSpecialDeals(zootopia);

//        RUN ZOOTOPIA
        System.out.println("Welcome to ZOOtopia!");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("1. Enter as Admin");
            System.out.println("2. Enter as a Visitor");
            System.out.println("3. View Special Deals");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Enter you choice: ");

            try {
                int n = Integer.parseInt(reader.readLine());

                switch (n) {
                    case 1 -> {
                        if (zootopia.adminLogin(reader)) {
                            System.out.println("Logged in as Admin!");
                            Admin admin = new Admin();
                            forAdmin(admin, zootopia, reader);
                        } else {
                            System.out.println("Incorrect Username or Password");
                        }

                    }
                    case 2 -> {
                        System.out.println("1. Register");
                        System.out.println("2. Login");

                        System.out.println();
                        System.out.print("Enter you choice: ");
                        int a = Integer.parseInt(reader.readLine());

                        switch (a) {
                            case 1 -> {
                                zootopia.visitorRegister(reader);
                                System.out.println();
                            }
                            case 2 -> {
                                Visitor visitor = zootopia.visitorLogin();
                                if (visitor != null) {
                                    System.out.println("\nWelcome " + visitor.getName() + "!");
                                    System.out.println();
                                    forVisitor(visitor, zootopia, reader);
                                } else {
                                    System.out.println("Visitor with entered e-Mail and Password does not exists");
                                }
                            }
                            default -> {
                                System.out.println("Invalid choice");
                            }
                        }
                    }
                    case 3 -> {
                        zootopia.viewSpecialDeals();
                        System.out.println();
                    }
                    case 4 -> {
                        try {
                            reader.close();
                        } catch (IOException e1) {
                            System.out.println("Error closing input reader: " + e1.getMessage());
                        }
                        return;
                    }
                    default -> {
                        System.out.println("Invalid Choice!!");
                        System.out.println();
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());

            } catch (NumberFormatException e) {
                System.out.println("Invalid Input (Enter an integer)");

            }

        } while (true);
    }
}