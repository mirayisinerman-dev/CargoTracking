import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
//Kargo teslim edildikten sonra dosyadan silinsin

public class Main {

    static ArrayList<Cargo> cargos = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static Random random = new Random();
    static String adminPassword = "1234";

    public static void main(String[] args) {

        cargos = loadFromFile();

        while (true) {

            System.out.println("\n=== SMART CARGO SYSTEM ===");
            System.out.println("1- Admin Login");
            System.out.println("2- Customer Panel");
            System.out.println("3- Exit");
            System.out.print("Choose: ");

            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) adminPanel();
            else if (choice == 2) customerPanel();
            else if (choice == 3) {
                saveToFile();
                System.out.println("System saved. Goodbye!");
                break;
            }
        }
    }

    // ================= ADMIN =================
    static void adminPanel() {

        System.out.print("Enter Password: ");
        String pass = input.nextLine();

        if (!pass.equals(adminPassword)) {
            System.out.println("Wrong password!");
            return;
        }

        while (true) {

            System.out.println("\n--- ADMIN PANEL ---");
            System.out.println("1- Create Cargo");
            System.out.println("2- Update Status");
            System.out.println("3- List All");
            System.out.println("4- Back");
            System.out.print("Choose: ");

            int c = input.nextInt();
            input.nextLine();

            if (c == 1) {

                System.out.print("Sender: ");
                String sender = input.nextLine();

                System.out.print("Receiver: ");
                String receiver = input.nextLine();

                System.out.print("From City: ");
                String from = input.nextLine();

                System.out.print("To City: ");
                String to = input.nextLine();

                String tracking = "TR" + (1000 + random.nextInt(9000));

                Cargo cargo = new Cargo(tracking, sender, receiver, from, to);
                cargos.add(cargo);

                saveToFile();

                System.out.println("Created: " + tracking);
            }

            else if (c == 2) {

                System.out.print("Tracking No: ");
                String no = input.nextLine();

                for (Cargo cgo : cargos) {

                    if (cgo.trackingNumber.equals(no)) {

                        System.out.println("1 PREPARING");
                        System.out.println("2 PICKED_UP");
                        System.out.println("3 IN_TRANSIT");
                        System.out.println("4 AT_BRANCH");
                        System.out.println("5 OUT_FOR_DELIVERY");
                        System.out.println("6 DELIVERED");

                        int s = input.nextInt();
                        input.nextLine();

                        cgo.updateStatus(Status.values()[s - 1]);

                        saveToFile();

                        System.out.println("Updated!");
                    }
                }
            }

            else if (c == 3) {
                for (Cargo cgo : cargos) {
                    cgo.showInfo();
                }
            }

            else if (c == 4) {
                break;
            }
        }
    }

    // ================= CUSTOMER =================
    static void customerPanel() {

        System.out.print("Enter Tracking Number: ");
        String no = input.nextLine();

        for (Cargo c : cargos) {

            if (c.trackingNumber.equals(no)) {
                c.showInfo();
                return;
            }
        }

        System.out.println("Cargo not found.");
    }

    // ================= FILE SAVE =================
    static void saveToFile() {

        try {
            FileWriter writer = new FileWriter("cargos.txt");

            for (Cargo c : cargos) {
                writer.write(
                        c.trackingNumber + "|" +
                                c.sender + "|" +
                                c.receiver + "|" +
                                c.fromCity + "|" +
                                c.toCity + "|" +
                                c.currentStatus + "\n"
                );
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Save error!");
        }
    }

    // ================= FILE LOAD =================
    static ArrayList<Cargo> loadFromFile() {

        ArrayList<Cargo> list = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("cargos.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] p = line.split("\\|");

                Cargo c = new Cargo(p[0], p[1], p[2], p[3], p[4]);
                c.currentStatus = Status.valueOf(p[5]);

                list.add(c);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("No previous data.");
        }

        return list;
    }
}