package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Visitor implements User{
    private final String name;
    private final int age;
    private final String phone;
    private float balance;
    private final String email;
    private final String password;
    private String feedback = null;
    public String memberShip = null;
    public ArrayList<Attraction> listTicketBought;
    public ArrayList<Attraction> listAttractionVisited;
    public ArrayList<Animal> listAnimalVisited;

    public Visitor(String name, int age, String phone, float balance, String email, String password) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.balance = balance;
        this.email = email;
        this.password = password;

        this.listTicketBought = new ArrayList<>();
        this.listAttractionVisited = new ArrayList<>();
        this.listAnimalVisited = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getPhone() {
        return this.phone;
    }

    public float getBalance() {
        return this.balance;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getFeedBack() {
        return this.feedback;
    }

    @Override
    public void viewAnimals(ZooTopia zootopia) {
        ArrayList<Animal> a = zootopia.getListAnimal();
        if (a.isEmpty()) {
            System.out.println("No Animals Currently in the ZOO");
            return;
        }
        for (int i=0; i<a.size(); i++) {
            System.out.println((i+1) + ". Name: " + a.get(i).getName() + ", Type: " + a.get(i).getType());
        }
    }

    @Override
    public void viewAttractions(ZooTopia zootopia) throws IOException {
        ArrayList<Attraction> a = zootopia.getListAttraction();
        if (a.isEmpty()) {
            System.out.println("No Attractions in the ZOO");
            return;

        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<a.size(); i++) {
            System.out.println((i+1) + ". ID: " + a.get(i).getID() + ", Name: " + a.get(i).getName());
        }

        System.out.println();
        System.out.print("Enter Attraction ID: ");
        int n = Integer.parseInt(reader.readLine());

        for (Attraction a1 : a) {
            if (a1.getID() == n) {
                if (this.memberShip == null || this.memberShip.equals("Basic")) {
                    System.out.println(a1.getWelcomeMsg() + "Buy Your ticket Now!");
                } else {
                    System.out.println(a1.getWelcomeMsg() + "You are a premium Member, You don't need to buy tickets. Visit the attractions now!");
                }

                return;
            }
        }

        System.out.println("Incorrect Attraction ID");

    }

    @Override
    public void viewDiscounts(ZooTopia zootopia) {
        ArrayList<Deal> d = zootopia.getListDeal();
        if (d.isEmpty()) {
            System.out.println("No Discounts Available");
            return;
        }

        int i = 1;
        for (Deal d1 : d) {
            System.out.println((i+1) + ". " + d1.getMsg());
            i++;
        }
    }

    @Override
    public void viewSpecialDeals(ZooTopia zootopia) {
        ArrayList<SpecialDeal> d = zootopia.getListSpecialDeal();

        if (d.isEmpty()) {
            System.out.println("No Special Deals Available");
            return;
        }

        int i=1;
        for (SpecialDeal d1 : d) {
            System.out.println((i+1) + ". " + d1.getMsg());
            i++;
        }
    }

//    EXPLORE THE ZOO
    public void exploreTheZoo(ZooTopia zootopia, BufferedReader reader) throws IOException {

        do {
            System.out.println("Explore the Zoo: ");
            System.out.println("1. View Attractions");
            System.out.println("2. View Animals");
            System.out.println("3. Exit");

            System.out.println();
            System.out.print("Enter Your Choice: ");

            try {
                int n = Integer.parseInt(reader.readLine());
                System.out.println();
                switch (n) {
                    case 1 -> {
                        System.out.println("Attractions in the Zoo: ");
                        this.viewAttractions(zootopia);
                        System.out.println();
                    }
                    case 2 -> {
                        System.out.println("Animals in the Zoo: ");
                        this.viewAnimals(zootopia);
                        System.out.println();
                    }
                    case 3 -> {
                        return;
                    }
                    default -> {
                        System.out.println("Invalid Choice");

                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input (Enter an integer)");
            }

        } while (true);

    }

//    BUY MEMBERSHIP
    private void buyBasic(String discount, ZooTopia zootopia) {

        if (discount.equalsIgnoreCase("none")) {
            if (this.balance > 20) {
                this.balance = this.balance - 20;
                System.out.println();
                System.out.println("Basic MemberShip Purchased without any Discount Code");
                this.memberShip = "Basic";
                System.out.println("Balance left: " + this.balance);
                zootopia.setRevenue(20);
            } else {
                System.out.println("Insufficient Balance");
            }
        } else {
            ArrayList<Deal> d = zootopia.getListDeal();
            for (Deal d1 : d) {
                if (d1.getCodeName().equals(discount)) {

                    if ((d1.getCategory().equalsIgnoreCase("minor") && this.age < 18) || (d1.getCategory().equalsIgnoreCase("Senior") && this.age > 60)) {
                        float dis = 20 - 20 * ((float) d1.getPercentage() /100);
                        if (this.balance > dis) {
                            this.balance = this.balance - dis;
                            System.out.println();
                            System.out.println("Basic MemberShip Purchased using Discount Code: " + discount);
                            this.memberShip = "Basic";
                            System.out.println("Balance left: " + this.balance);
                            zootopia.setRevenue(dis);
                            return;
                        } else {
                            System.out.println("Insufficient Balance");
                            return;
                        }

                    } else if (!d1.getCategory().equalsIgnoreCase("minor") && !d1.getCategory().equalsIgnoreCase("Senior")) {
                        float dis = 20 - 20 * ((float) d1.getPercentage() /100);
                        if (this.balance > dis) {
                            this.balance = this.balance - dis;
                            System.out.println();
                            System.out.println("Basic MemberShip Purchased using Discount Code: " + discount);
                            this.memberShip = "Basic";
                            System.out.println("Balance left: " + this.balance);
                            zootopia.setRevenue(dis);
                            return;
                        } else {
                            System.out.println("Insufficient Balance");
                            return;
                        }
                    } else {
                        System.out.println("Condition for applying Discount Code not match\n");
                        return;
                    }
                }
            }
            System.out.println("Invalid Discount Code");
        }
    }

    private void buyPremium (String discount, ZooTopia zootopia){

        if (discount.equalsIgnoreCase("None")) {

            if (this.balance > 50) {
                this.balance = this.balance - 50;
                System.out.println();
                System.out.println("Premium MemberShip Purchased without any Discount Code");
                System.out.println("Balance left: " + this.balance);
                zootopia.setRevenue(50);
                this.memberShip = "Premium";
            } else {
                System.out.println("Insufficient Balance");
            }
        } else {
            ArrayList<Deal> d = zootopia.getListDeal();
            for (Deal d1 : d) {
                if (d1.getCodeName().equals(discount)) {

                    if ((d1.getCategory().equalsIgnoreCase("minor") && this.age < 18) || (d1.getCategory().equalsIgnoreCase("Senior") && this.age > 60)) {
                        float dis = 50 - ((float) (50 * d1.getPercentage()) /100);
                        if (this.balance > dis) {
                            this.balance = this.balance - dis;
                            System.out.println();
                            System.out.println("Premium MemberShip Purchased using Discount Code: " + discount);
                            System.out.println("Balance left: " + this.balance);
                            zootopia.setRevenue(dis);
                            this.memberShip = "Premium";
                        } else {
                            System.out.println("Insufficient Balance");
                            return;
                        }
                    }
                } else if (!d1.getCategory().equalsIgnoreCase("minor") && !d1.getCategory().equalsIgnoreCase("Senior")) {
                    float dis = 50 - ((float) (50 * d1.getPercentage()) /100);
                    if (this.balance > dis) {
                        this.balance = this.balance - dis;
                        System.out.println();
                        System.out.println("Premium MemberShip Purchased using Discount Code: " + discount);
                        System.out.println("Balance left: " + this.balance);
                        zootopia.setRevenue(dis);
                        this.memberShip = "Premium";
                    } else {
                        System.out.println("Insufficient Balance");
                        return;
                    }
                } else {
                    System.out.println("Condition for applying Discount Code not match\n");
                    return;
                }
            }
            System.out.println("Invalid Discount Code");
        }
    }

    public void buyMemberShip(ZooTopia zootopia, BufferedReader reader) throws IOException {

        if (this.memberShip != null) {
            System.out.println("You already have bought membership: " + this.memberShip);
            return;
        }

        System.out.println("Buy Membership: ");
        System.out.println("1. Basic MemberShip (Rs. 20)");
        System.out.println("2. Premium MemberShip (Rs. 50)");
        System.out.println();
        System.out.print("Enter Your Choice: ");
        int n = Integer.parseInt(reader.readLine());

        if (n == 1) {
            System.out.print("Apply Discount Code: ");
            String discount = reader.readLine();
            buyBasic(discount, zootopia);
        } else if (n == 2) {
            System.out.print("Apply Discount Code: ");
            String discount = reader.readLine();
            buyPremium(discount, zootopia);
        } else {
            System.out.println("Invalid Choice");
        }
    }

//    BUY TICKETS
    private void viewAttractionsPrices(ZooTopia zootopia) {
        ArrayList<Attraction> a = zootopia.getListAttraction();

        if (a.isEmpty()) {
            System.out.println("No Attractions in the ZOO");
            return;
        }

        for (int i=0; i<a.size(); i++) {
            System.out.println((i+1) + ". ID: " + a.get(i).getID() + ", Name: " + a.get(i).getName() + "(Rs. " + a.get(i).getTicketPrice() + ")");
        }
    }
    public void buyTickets(ZooTopia zootopia, BufferedReader reader) throws IOException {

        if (this.memberShip!= null && this.memberShip.equals("Premium")) {
            System.out.println("Do not need to buy ticket as you are a premium member");
        } else {
            ArrayList<Attraction> a = zootopia.getListAttraction();
            int count = 0;
            float total = 0;
            boolean flag = false;
            boolean fA = false;
            System.out.println();
            System.out.println("Discounts Available : ");
            this.viewDiscounts(zootopia);
            System.out.println();
            System.out.print("Enter the number of Tickets: ");

            try {
                int num = Integer.parseInt(reader.readLine());

                if (num <= 0) {
                    System.out.println("Invalid Number of Tickets");
                    return;
                }

                System.out.println("Buy Tickets: ");
                this.viewAttractionsPrices(zootopia);
                System.out.println();


                for (int i=0; i<num; i++) {
                    System.out.print("Enter Attraction ID: ");
                    int n = Integer.parseInt(reader.readLine());

                    for (Attraction a1 : a) {
                        if (a1.getID() == n) {
                            System.out.print("Enter Discount Code: ");
                            String code = reader.readLine();

                            if (code.equalsIgnoreCase("none")) {

                                if (this.balance > a1.getTicketPrice()) {
                                    total += a1.getTicketPrice();
                                    this.listTicketBought.add(a1);
                                    this.balance = this.balance - a1.getTicketPrice();
                                    System.out.println("The ticket for " + a1.getName() + " was purchased successfully.\n");
                                    count++;
                                } else {
                                    System.out.println("Insufficient Balance");
                                    return;
                                }

                            } else {

                                ArrayList<Deal> d = zootopia.getListDeal();
                                for (Deal d1 : d) {
                                    if (d1.getCodeName().equals(code)) {

                                        if ((d1.getCategory().equalsIgnoreCase("minor") && this.age < 18) || (d1.getCategory().equalsIgnoreCase("Senior") && this.age > 60)) {

                                            int p = a1.getTicketPrice();
                                            float fp = p - p * ((float) d1.getPercentage() / 100);

                                            if (this.balance > fp) {
                                                this.listTicketBought.add(a1);
                                                System.out.println("The ticket for " + a1.getName() + " was purchased successfully.\n");
                                                total += fp;
                                                this.balance = this.balance - fp;
                                                count++;
                                            } else {
                                                System.out.println("Insufficient balance");
                                                return;
                                            }
                                        } else if (!d1.getCategory().equalsIgnoreCase("minor") && !d1.getCategory().equalsIgnoreCase("Senior")) {

                                            int p = a1.getTicketPrice();
                                            float fp = p - p * ((float) d1.getPercentage() / 100);

                                            if (this.balance > fp) {
                                                this.listTicketBought.add(a1);
                                                System.out.println("The ticket for " + a1.getName() + " was purchased successfully.\n");
                                                total += fp;
                                                this.balance = this.balance - fp;
                                                count++;
                                            } else {
                                                System.out.println("Insufficient balance");
                                                return;
                                            }
                                        } else {
                                            System.out.println("Condition for applying Discount Code not match\n");
                                        }
                                    }
                                }
                            }
                            fA = true;
                        }
                        flag = true;
                    }
                    if (!fA) {
                        System.out.println("Attraction with ID: " + n + " Not Found!\n");
                    } else {
                        fA = false;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input (Enter an integer)");
            }

            if (flag) {
                ArrayList<SpecialDeal> sd = zootopia.getListSpecialDeal();
                int max = 0;
                SpecialDeal s = null;
                for (SpecialDeal sd1 : sd) {
                    if ((count) >= sd1.getNumTickets()) {
                        if (sd1.getNumTickets() > max) {
                            s = sd1;
                        }
                    }
                }
                float val = 0;
                if (s != null) {
                    val = (total *(float) s.getPercentage() /100);
                    System.out.println("You are eligible for a special deal. " + s.getMsg());
                }

                this.balance = this.balance + val;
                zootopia.setRevenue(total - val);
                System.out.println("LEFT BALANCE: " + this.balance);
            } else {
                System.out.println("Invalid discount code, Could not buy ticket. Unsuccessful");
            }
        }
    }


//    VISIT ANIMALS
    public void visitAnimals(ZooTopia zootopia, BufferedReader reader) throws IOException {

        this.viewAnimals(zootopia);
        System.out.print("Enter Animal Serial No: ");
        int n = Integer.parseInt(reader.readLine());

        if ((n-1) < zootopia.getListAnimal().size()) {
            Animal a1 = zootopia.getListAnimal().get(n);
            System.out.println();
            System.out.println("Visit Animal: ");
            System.out.println("1. Feed the Animal");
            System.out.println("2. Read About the Animal");

            System.out.println("\nEnter your choice: ");
            int i = Integer.parseInt(reader.readLine());
            switch (i) {
                case 1 -> {
                    a1.makeNoise();
                    this.listAnimalVisited.add(a1);
                }
                case 2 -> {
                    System.out.println(a1.getBriefPassage());
                    this.listAnimalVisited.add(a1);
                }
                default -> {
                    System.out.println("Invalid Choice");
                }
            }
        } else {
            System.out.println("Invalid No for the Animal");
        }

    }

    public void printAttractionList(ZooTopia zootopia) {
        ArrayList<Attraction> a= zootopia.getListAttraction();
        if (a.isEmpty()) {
            System.out.println("No Attractions in the ZOO");
            return;
        }
        for (Attraction a1 : a) {
            System.out.println("Id: " + a1.getID() + ", Name: " + a1.getName());
        }
    }
    public void visitAttraction(ZooTopia zootopia, BufferedReader reader) throws IOException {
        this.printAttractionList(zootopia);
        ArrayList<Attraction> a = zootopia.getListAttraction();

        if (a.isEmpty()) {
            return;
        }
        System.out.print("Enter THe ID of Attraction: ");
        int id = Integer.parseInt(reader.readLine());

        Attraction vis = null;
        for (Attraction a1 : a) {
            if (a1.getID() == id) {
                vis = a1;
                break;
            }
        }

        if (vis != null) {

            if (vis.getStatus() == 1) {
                if (this.memberShip.equals("Premium")) {
                    System.out.println(vis.getThankyouMsg());
                    this.listAttractionVisited.add(vis);
                    vis.setNumVisitors();
                } else {
                    for (Attraction attraction : this.listTicketBought) {
                        if (attraction == vis) {
                            System.out.println(vis.getThankyouMsg());
                            this.listAttractionVisited.add(vis);
                            vis.setNumVisitors();
                            this.listTicketBought.remove(vis);
                            return;
                        }
                    }
                    System.out.println("Ticket Not available. Basic Members need to buy separate Tickets for the attractions");
                }
            } else {
                System.out.println("The Attraction is currently closed");
            }
        } else {
            System.out.println("No attraction present with the entered ID");
        }
    }

//    LEAVE FEEDBACK
    public void setFeedback(ZooTopia zootopia, BufferedReader reader) throws IOException {
        System.out.print("Enter your Feedback (max 200 characters): ");
        String fb = reader.readLine();

        this.feedback = fb;
        zootopia.getListFeedback().add(fb);
        System.out.println("Thankyou for your feedback");
    }
}
