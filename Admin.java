package org.example;

import java.io.BufferedReader;
import java.io.IOException;

import java.util.*;
public class Admin implements User  {
    public static final String userName = "Ishita";
    public static final String password = "1234@ishita";

//    getters
    public static String getUserName() {
        return userName;
    }
    public static String getPassword() {
        return password;
    }

//    prints all the attractions with their details
    @Override
    public void viewAttractions(ZooTopia zootopia) {
        ArrayList<Attraction> a = zootopia.getListAttraction();

//        checks if no attractions present
        if (a.isEmpty()) {
            System.out.println("No Attractions exist!");
            return;
        }
        for (Attraction a1 : a) {
            System.out.println("Name : " + a1.getName());
            System.out.println("ID : " + a1.getID());
            System.out.println("TicketPrice: " + a1.getTicketPrice());
            System.out.println("Description : " + a1.getDescription());
            if (a1.getStatus() == 0) {
                System.out.println("Status : Closed");
            } else {
                System.out.println("Status : Open");
            }

            System.out.println();
            System.out.println("      *****");
            System.out.println();
        }
    }

//    prints all the animals along with their details
    @Override
    public void viewAnimals(ZooTopia zootopia) {
        ArrayList<Animal> a = zootopia.getListAnimal();

//        checks if no animals present
        if (a.isEmpty()) {
            System.out.println("No animals in the zoo yet!");
        }
        for (Animal a1 : a) {
            System.out.println("Name : " + a1.getName());
            System.out.println("Type : " + a1.getType());
            System.out.println("Brief History : " + a1.getBriefPassage());
            System.out.println("Noise it Makes : " + a1.getNoise());

            System.out.println();
            System.out.println("      *****");
            System.out.println();

        }
    }

//    prints all discounts available along with their details
    @Override
    public void viewDiscounts(ZooTopia zootopia) {
        ArrayList<Deal> d = zootopia.getListDeal();
        if (d.isEmpty()) {
            System.out.println("No Discounts Available");
            return;
        }

        for (Deal d1 : d) {
            System.out.println("Discount Code: " + d1.getCodeName());
            System.out.println("Category: " + d1.getCategory());
            System.out.println("Percentage: " + d1.getPercentage() + "%");

            System.out.println();
            System.out.println("      *****");
            System.out.println();
        }

    }

//    prints all special deals available along with their details
    @Override
    public void viewSpecialDeals(ZooTopia zootopia) {
        ArrayList<SpecialDeal> sd = zootopia.getListSpecialDeal();
        if (sd.isEmpty()) {
            System.out.println("No special deal Available");
            return;
        }
        for (SpecialDeal sd1 : sd) {
            System.out.println("Minimum Number of Tickets Required: " + sd1.getNumTickets());
            System.out.println("Percentage: " + sd1.getPercentage() + "%");

            System.out.println();
        }
    }


    //    MANAGE ATTRACTIONS
    public void addAttraction(ZooTopia zootopia, BufferedReader reader) throws IOException {

        System.out.print("Enter the Attraction Name: ");
        String name = reader.readLine();

        System.out.print("Enter Attraction Description: ");
        String des = reader.readLine();

        System.out.print("Enter Ticket Price: ");
        int price = Integer.parseInt(reader.readLine());

        Attraction a = new Attraction(name, des, price, zootopia.getId());
        zootopia.getListAttraction().add(a);
    }

    private void printAttractionList(ZooTopia zootopia) {
        ArrayList<Attraction> a = zootopia.getListAttraction();
        if (a.isEmpty()) {
            System.out.println("No Attractions Exist!!");
            return;
        }
        for (int i=0; i<a.size(); i++) {
            System.out.println((i+1) + ". ID: " + a.get(i).getID() + ", Name: " + a.get(i).getName());
        }
    }
    public void modifyAttraction(ZooTopia zootopia, BufferedReader reader) throws IOException {

//        prints list of attractions to choose from
        this.printAttractionList(zootopia);
        ArrayList<Attraction> a = zootopia.getListAttraction();

//        checks if no attractions present
        if (a.isEmpty()) {
            return;
        }
        System.out.print("Enter ID of Attraction : ");
        int id = Integer.parseInt(reader.readLine());

        Attraction mod = null;
        for (Attraction a1 : a) {
            if (a1.getID() == id) {
                mod = a1;
                break;
            }
        }

//        checks if the id entered exists or not
        if (mod == null) {
            System.out.println("Invalid ID entered");
        } else {
            System.out.println();
            System.out.println("Modifiable Properties: ");
            System.out.println("1. Name");
            System.out.println("2. Ticket Price");
            System.out.println("3. Description");
            System.out.println("4. Status");

            System.out.println();
            System.out.print("Enter Your Choice: ");
            int n = Integer.parseInt(reader.readLine());
            System.out.println();

            switch (n) {
                case 1 -> {
                    System.out.print("Enter new Name: ");
                    String name = reader.readLine();
                    mod.setName(name);
                }
                case 2 -> {
                    System.out.print("Enter New Ticket Price: ");
                    int price = Integer.parseInt(reader.readLine());
                    if (!ZooTopia.isPrice(price)) {
                        System.out.println("Invalid Price Entered");
                        return;
                    }
                    mod.setTicketPrice(price);
                }
                case 3 -> {
                    System.out.print("Enter new Description: ");
                    String des = reader.readLine();
                    mod.setDescription(des);
                }
                case 4 -> {
                    System.out.println("Enter Status (Open: 1, Close: 0): ");
                    int s = Integer.parseInt(reader.readLine());
                    if (!ZooTopia.isStatus(s)) {
                        System.out.println("Invalid Status Entered (enter 0 or 1)");
                        return;
                    }
                    mod.setStatus(s);
                }
                default -> {
                    System.out.println("Invalid Choice");
                }
            }
        }
    }

    public void removeAttraction(ZooTopia zootopia, BufferedReader reader) throws IOException {
        this.printAttractionList(zootopia);
        ArrayList<Attraction> a = zootopia.getListAttraction();
        if (a.isEmpty()) {
            return;
        }

        System.out.print("Enter ID of Attraction: ");
        int id = Integer.parseInt(reader.readLine());

        for (int i=0; i<a.size(); i++) {
            Attraction a1 = a.get(i);
            if (a1.getID() == id) {
                System.out.println("Attraction: " + a1.getName() + " Removed");
                a.remove(a1);
                return;
            }
        }
        System.out.println("Attraction with ID: " + id + " does not exists!");
    }

//    MANAGE ANIMALS
    public void addAnimal(ZooTopia zooTopia, BufferedReader reader) throws IOException {
        System.out.print("Enter Animal Name: ");
        String name = reader.readLine();

        if (!ZooTopia.isAlphab(name)) {
            System.out.println("Invalid Animal Name");
            return;
        }

        System.out.print("Enter Animal Type: ");
        String type = reader.readLine();
        ArrayList<Animal> a = zooTopia.getListAnimal();

        for (Animal a1 : a) {
            if (a1.getName().equalsIgnoreCase(name) && a1.getType().equalsIgnoreCase(type)) {
                a1.setCount();
                return;
            }
        }

//        checks if the type entered is among the valid types
        if (type.equalsIgnoreCase("mammal") || type.equalsIgnoreCase("reptile") || type.equalsIgnoreCase("amphibian")) {
            System.out.print("Enter Animal Description: ");
            String brief = reader.readLine();

            System.out.print("Enter the Noise it Makes: ");
            String noise = reader.readLine();

            switch (type.toLowerCase()) {
                case "mammal" -> {
                    Mammal m = new Mammal(name, noise, brief);
                    a.add(m);
                }
                case "amphibian" -> {
                    Amphibian a1 = new Amphibian(name, noise, brief);
                    a.add(a1);
                }
                case "reptile" -> {
                    Reptile r = new Reptile(name, noise, brief);
                    a.add(r);
                }
                default -> {
                    System.out.println("Invalid Type of Animal");
                }
            }
        } else {
            System.out.println("Invalid Type of Animal");
        }
    }

    private void printAnimalList(ZooTopia zootopia) {
        ArrayList<Animal> a = zootopia.getListAnimal();
        if (a.isEmpty()) {
            System.out.println("No Animals Exist in the ZOO Currently");
            return;
        }

        for (int i=0; i<a.size(); i++) {
            System.out.println((i+1) + ". " + a.get(i).getName());
        }
        System.out.println();
    }
    public void updateAnimalDetail(ZooTopia zootopia, BufferedReader reader) throws IOException {
        this.printAnimalList(zootopia);
        ArrayList<Animal> a = zootopia.getListAnimal();
        if (a.isEmpty()) {
            return;
        }
        System.out.print("Enter Animal Serial No.: ");
        int n = Integer.parseInt(reader.readLine());

       if ((n-1)<a.size()) {
           Animal mod = a.get(n-1);
           System.out.println();
           System.out.println("Modifiable Properties: ");
           System.out.println("1. Noise");
           System.out.println("2. Brief Passage");

           System.out.print("\nEnter Your Choice: ");
           int i = Integer.parseInt(reader.readLine());
           System.out.println();

           switch (i) {
               case 1 -> {
                   System.out.print("Enter Animal Noise: ");
                   String noise = reader.readLine();
                   mod.setNoise(noise);
               }
               case 2 -> {
                   System.out.print("Enter Brief Passage: ");
                   String brief = reader.readLine();
                   mod.setBriefPassage(brief);
               }
               default -> {
                   System.out.println("Invalid Choice");
               }
           }
       } else {
           System.out.println("Invalid Choice Entered");
       }
    }

    public void removeAnimal(ZooTopia zootopia, BufferedReader reader) throws IOException {
        this.printAnimalList(zootopia);
        ArrayList<Animal> a = zootopia.getListAnimal();
        if (a.isEmpty()) {
            return;
        }
        System.out.print("Enter Animal Serial No.: ");
        int n = Integer.parseInt(reader.readLine());

        if ((n-1) < a.size()) {
            System.out.println("Animal: " + a.get(n-1).getName() + " Removed");
            a.remove(a.get(n-1));
            return;
        }
        System.out.println("Invalid Animal No.");
    }


//    SCHEDULE EVENTS
    public void scheduleEvent(ZooTopia zootopia, BufferedReader reader) throws IOException {
        this.printAttractionList(zootopia);
        ArrayList<Attraction> a = zootopia.getListAttraction();

        if (a.isEmpty()) {
            return;
        }

        System.out.print("Enter Id of Attraction: ");
        int n = Integer.parseInt(reader.readLine());

        Attraction a2 = null;
        for (Attraction a1 : a) {
            if (a1.getID() == n) {
                a2 = a1;
                break;
            }
        }

        if (a2 != null) {
            System.out.println("1. Update Status of Attraction (Open/Close)");
            System.out.println("2. Update Ticket Price");

            System.out.print("Enter your choice: ");
            int i =  Integer.parseInt(reader.readLine());


            switch (i) {
                case 1 -> {
                    System.out.print("Want to (Open=1) or (Close=0): ");
                    int status = Integer.parseInt(reader.readLine());
                    if (!ZooTopia.isStatus(status)) {
                        System.out.println("Invalid Status input");
                        return;
                    }
                    a2.setStatus(status);
                    System.out.println("Status updated to : " + status);
                }
                case 2 -> {
                    System.out.println("Enter new ticket price: ");
                    int p = Integer.parseInt(reader.readLine());

                    if (p<=0) {
                        System.out.println("Invalid Ticket Price");
                        return;
                    }

                    a2.setTicketPrice(p);
                    System.out.println("Ticket Prices updated to: " + p);
                }
                default-> {
                    System.out.println("Invalid input");
                }
            }
            return;
        }
        System.out.println("Invalid ID of Attraction");
    }

//    DISCOUNTS
    public void addDiscount(ZooTopia zootopia, BufferedReader reader) throws IOException {

        System.out.println();
        System.out.print("Enter Discount Category: ");
        String cat = reader.readLine();

        System.out.print("Enter Discount Percentage: ");
        int discount = Integer.parseInt(reader.readLine());
        if (!ZooTopia.isPrice(discount)) {
            System.out.println("Invalid Discount Percentage");
            return;
        }
        Deal dis = new Deal(cat, discount);
        zootopia.getListDeal().add(dis);
    }

    private void printDiscountList(ZooTopia zootopia) {
        ArrayList<Deal> d = zootopia.getListDeal();
        if (d.isEmpty()) {
            System.out.println("No Discounts Available");
            return;
        }
        for (int i=0; i<d.size(); i++) {
            System.out.println((i+1) + ". " + d.get(i).getCodeName());
        }
    }

    public void modifyDiscount(ZooTopia zootopia, BufferedReader reader) throws IOException {
        ArrayList<Deal> d = zootopia.getListDeal();
        this.printDiscountList(zootopia);

        if (d.isEmpty()) {
            return;
        }
        System.out.println();
        System.out.print("Enter Code No.: ");
        int code = Integer.parseInt(reader.readLine());

        if ((code-1) < d.size()) {
            Deal mod = d.get(code-1);
            System.out.println("Modifiable Properties: ");
            System.out.println("1. Category");
            System.out.println("2. Discount");

            System.out.print("Enter Your Choice: ");
            int n = Integer.parseInt(reader.readLine());

            switch (n) {
                case 1 -> {
                    System.out.print("Enter the new Category: ");
                    String cat = reader.readLine();
                    mod.setCategory(cat);
                }
                case 2 -> {
                    System.out.println("Enter the new Discount: ");
                    int dis = Integer.parseInt(reader.readLine());
                    if (!ZooTopia.isPrice(dis)) {
                        System.out.println("Invalid Discount Percentage");
                        return;
                    }
                    mod.setPercentage(dis);
                }
                default -> {
                    System.out.println("Invalid Choice");

                }
            }
        } else {
            System.out.println("Invalid Discount Code No.");
        }
    }

    public void removeDiscount(ZooTopia zootopia, BufferedReader reader) throws IOException {
        ArrayList<Deal> d = zootopia.getListDeal();
        this.printDiscountList(zootopia);

        if (d.isEmpty()) {
            return;
        }

        System.out.print("Enter Code No.: ");
        int code = Integer.parseInt(reader.readLine());

        if ((code - 1) < d.size()) {
            System.out.println("Deleted the Discount: " + d.get(code-1).getCodeName());
            d.remove(d.get(code-1));
            return;
        }
        System.out.println("Invalid Discount Code No.");
    }

//    DEAL
    private void printSpecialDealList(ZooTopia zootopia) {
        ArrayList<SpecialDeal> d = zootopia.getListSpecialDeal();
        if (d.isEmpty()) {
            System.out.println("No Special Deals Available");
            return;
        }

        for (int i=0; i<d.size(); i++) {
            System.out.println((i+1) + ". " + d.get(i).getMsg());
        }
    }
    public void addDeal(ZooTopia zootopia, BufferedReader reader) throws IOException {

        System.out.print("Minimum Number of Tickets to Avail the Deal: ");
        int num = Integer.parseInt(reader.readLine());

        if (!ZooTopia.isPrice(num)) {
            System.out.println("Invalid Number of Tickets");
            return;
        }
        System.out.print("Enter Discount Percentage: ");
        int discount = Integer.parseInt(reader.readLine());

        if (!ZooTopia.isPrice(discount)) {
            System.out.println("Invalid Discount Percentage");
            return;
        }
        SpecialDeal d = new SpecialDeal(num, discount);
        zootopia.getListSpecialDeal().add(d);
    }

    public void modifyDeal(ZooTopia zootopia, BufferedReader reader) throws IOException {
        ArrayList<SpecialDeal> d = zootopia.getListSpecialDeal();
        this.printSpecialDealList(zootopia);

        if (d.isEmpty()) {
            return;
        }
        System.out.print("Enter Deal No.: ");
        int n = Integer.parseInt(reader.readLine());

        if ((n-1) < d.size()) {
            SpecialDeal sd = d.get(n-1);

            System.out.println("Modifiable Properties: ");
            System.out.println("1. Minimum Number of Tickets");
            System.out.println("2. Discount");

            System.out.println();
            System.out.print("Enter Your Choice: ");
            int i = Integer.parseInt(reader.readLine());

            switch (i) {
                case 1 -> {
                    System.out.print("Enter the Number of Tickets: ");
                    int num = Integer.parseInt(reader.readLine());
                    if (!ZooTopia.isPrice(num)) {
                        System.out.println("Invalid Number of Tickets");
                        return;
                    }
                    sd.setNumTickets(num);
                }
                case 2 -> {
                    System.out.println("Enter the new Discount: ");
                    int dis = Integer.parseInt(reader.readLine());
                    if (!ZooTopia.isPrice(dis)) {
                        System.out.println("Invalid Discount Percentage");
                        return;
                    }
                    sd.setPercentage(dis);
                }
                default -> {
                    System.out.println("Invalid Choice");
                }
            }
        } else {
            System.out.println("Invalid Special Deal Number");
        }
    }

    public void removeDeal(ZooTopia zootopia, BufferedReader reader) throws IOException {
        ArrayList<SpecialDeal> d = zootopia.getListSpecialDeal();
        this.printSpecialDealList(zootopia);
        if (d.isEmpty()) {
            return;
        }
        System.out.print("Enter Deal No.: ");
        int n = Integer.parseInt(reader.readLine());

        if ((n-1) < d.size()) {
            d.remove(d.get(n-1));
            System.out.println("Deal Removed");
        } else {
            System.out.println("Invalid Special Deal Number");
        }
    }

//    VIEW VISITOR STATISTICS
    public void viewVisitorStats(ZooTopia zootopia) {
        System.out.println();
        System.out.println("Visitor Statistics: ");
        System.out.println(" - Total Visitors: " + zootopia.getListVisitor().size());
        System.out.println(" - Total Revenue: " + zootopia.getRevenue());
        ArrayList<Attraction> a = zootopia.getListAttraction();

        Attraction max = a.get(0);
        for (Attraction a1: a) {
            if (a1.getNumVisitors() > max.getNumVisitors() ) {
                max = a1;
            }
        }
        if (max.getNumVisitors() == 0) {
            System.out.println(" - Most Popular Attraction : No attractions Visited Yet");
        } else {
            System.out.println(" - Most Popular Attraction : " + max.getName());
        }
    }

    public void viewFeedback(ZooTopia zootopia) {
        ArrayList<String> f = zootopia.getListFeedback();
        if (f.isEmpty()) {
            System.out.println("No feedbacks yet!");
            return;
        }
        for (int i=0; i<f.size(); i++) {
            System.out.println((i+1) + ". " + f.get(i));
        }
    }

}
