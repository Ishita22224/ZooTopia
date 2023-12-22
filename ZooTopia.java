package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
public class ZooTopia {
    private int id;
    private ArrayList<Attraction> listAttraction;
    private ArrayList<Animal> listAnimal;
    private ArrayList<Visitor> listVisitor;
    private ArrayList<Deal> listDeal;
    private ArrayList<SpecialDeal> listSpecialDeal;
    private ArrayList<String> listFeedback;
    private float revenue;

    public ZooTopia() {
        this.listAttraction = new ArrayList<>();
        this.listAnimal = new ArrayList<>();
        this.listVisitor = new ArrayList<>();
        this.listDeal = new ArrayList<>();
        this.listSpecialDeal = new ArrayList<>();
        this.listFeedback = new ArrayList<>();
        this.revenue = 0;
        this.id = 0;
    }
//    getters
    public float getRevenue() {return this.revenue;}
    public ArrayList<String> getListFeedback() {return this.listFeedback;}
    public ArrayList<Attraction> getListAttraction() {
        return this.listAttraction;
    }
    public ArrayList<Animal> getListAnimal() {
        return this.listAnimal;
    }
    public ArrayList<Visitor> getListVisitor() {
        return this.listVisitor;
    }
    public ArrayList<Deal> getListDeal() {
        return this.listDeal;
    }
    public ArrayList<SpecialDeal> getListSpecialDeal() {
        return this.listSpecialDeal;
    }
    public int getId() {
        this.id = this.id + 1;
        return this.id;
    }
//    setters

    public void setRevenue(float revenue) {
        this.revenue = this.revenue + revenue;
    }

//    methods
    public static boolean isAlphab(String str) {
        if (str == null) {
            return false; // Return false if the input is null
        }

        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                return false; // Return false if a non-alphabetic character (other than space) is found
            }
        }

        return true; // Return true if all characters are alphabetic or spaces
    }

    private static boolean isPhone(String str) {
        if (str.length() != 10) {
            return false;
        }

        for (int i=0; i<10; i++) {
            char c = str.charAt(i);
            if (!Character.isDigit((c))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMail(String str) {
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '@') {
                return false;
            }
        }
        return true;
    }
    public static boolean isPrice(int price) {
        return price > 0;
    }

    public static boolean isStatus(int i) {
        return (i == 0 || i == 1);
    }
    public boolean adminLogin(BufferedReader reader) throws IOException {
        System.out.print("Enter Admin Username : ");
        String userName = reader.readLine();

        if (!isAlphab(userName)) {
            System.out.println("Invalid Name Entered\n");
            return false;
        }

        System.out.print("Enter Admin Password : ");
        String password = reader.readLine();

        String realName = Admin.getUserName();
        String realPass = Admin.getPassword();

        return (realName.equals(userName) && realPass.equals(password));
    }


        public void visitorRegister(BufferedReader reader) throws IOException {
            System.out.println();
            System.out.print("Enter Visitor Name: ");
            String name = reader.readLine();

            if (!isAlphab(name)) {
                System.out.println("Invalid Name");
                return;
            }
            System.out.print("Enter Visitor Age: ");
            int age = Integer.parseInt(reader.readLine());

            System.out.print("Enter Visitor Phone Number: ");
            String phone = reader.readLine();

            if (!isPhone(phone)) {
                System.out.println("Invalid Phone No.");
                return;
            }

            System.out.print("Enter Visitor Balance: ");
            int balance = Integer.parseInt(reader.readLine());

            System.out.print("Enter Visitor Mail: ");
            String mail = reader.readLine();

            if (isMail(mail)) {
                System.out.println("Invalid Mail ID");
                return;
            }

            System.out.print("Enter Visitor Password: ");
            String pass = reader.readLine();

            for (Visitor v : this.listVisitor) {
                if (v.getEmail().equals(mail) && v.getPassword().equals(pass)) {
                    System.out.println("Member already registered as Visitor");
                    return;
                }
            }

            Visitor newVisitor = new Visitor(name, age, phone, balance, mail, pass);
            this.listVisitor.add(newVisitor);
            System.out.println();
            System.out.println(name + " registered successfully!");

        }

        public Visitor visitorLogin() {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Visitor Email: ");
            String mail = sc.next();

            if (isMail(mail)) {
                System.out.println("Invalid e-Mail\n");
                return null;
            }
            System.out.print("Enter Visitor Password: ");
            String pass = sc.next();

            for (Visitor visitor : this.listVisitor) {
                String currEmail = visitor.getEmail();
                String currPass = visitor.getPassword();

                if (currEmail.equals(mail) && currPass.equals(pass)) {
                    return visitor;
                }
            }
            return null;
        }

        public void viewSpecialDeals() {
            if (!this.listSpecialDeal.isEmpty()) {
                for (int i=0; i<this.listSpecialDeal.size(); i++) {
                    SpecialDeal d = this.listSpecialDeal.get(i);
                    System.out.println((i+1) + ". "  + d.getMsg());
                }
            }
        }
}
