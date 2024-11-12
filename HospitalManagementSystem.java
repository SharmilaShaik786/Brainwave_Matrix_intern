import java.util.ArrayList;
import java.util.Scanner;

class HospitalManagementSystem {

    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Staff> staffMembers = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static ArrayList<InventoryItem> inventoryItems = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Register Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. View Electronic Health Records (EHR)");
            System.out.println("4. Billing and Invoicing");
            System.out.println("5. Inventory Management");
            System.out.println("6. Staff Management");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    scheduleAppointment();
                    break;
                case 3:
                    viewEHR();
                    break;
                case 4:
                    billing();
                    break;
                case 5:
                    manageInventory();
                    break;
                case 6:
                    manageStaff();
                    break;
                case 0:
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (choice != 0);
    }

    static void registerPatient() {
        System.out.print("Enter Patient Name: ");
        String name = scanner.next();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Contact Number: ");
        String contact = scanner.next();

        Patient newPatient = new Patient(name, age, contact);
        patients.add(newPatient);
        System.out.println("Patient registered successfully.");
    }

    static void scheduleAppointment() {
        System.out.print("Enter Patient Name: ");
        String patientName = scanner.next();
        System.out.print("Enter Doctor Name: ");
        String doctorName = scanner.next();
        System.out.print("Enter Appointment Date: ");
        String date = scanner.next();

        Appointment appointment = new Appointment(patientName, doctorName, date);
        appointments.add(appointment);
        System.out.println("Appointment scheduled successfully.");
    }

    static void viewEHR() {
        System.out.print("Enter Patient Name to view EHR: ");
        String patientName = scanner.next();

        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(patientName)) {
                System.out.println("EHR for " + patient.getName());
                System.out.println("Age: " + patient.getAge());
                System.out.println("Contact: " + patient.getContact());
                return;
            }
        }
        System.out.println("Patient not found.");
    }

    static void billing() {
        System.out.print("Enter Patient Name for billing: ");
        String patientName = scanner.next();
        System.out.print("Enter amount to be billed: ");
        double amount = scanner.nextDouble();

        System.out.println("Billing for " + patientName + ": $" + amount);
        System.out.println("Invoice generated successfully.");
    }

    static void manageInventory() {
        System.out.println("1. Add Inventory Item");
        System.out.println("2. View Inventory");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter Item Name: ");
                String itemName = scanner.next();
                System.out.print("Enter Quantity: ");
                int quantity = scanner.nextInt();

                InventoryItem item = new InventoryItem(itemName, quantity);
                inventoryItems.add(item);
                System.out.println("Inventory item added.");
                break;
            case 2:
                System.out.println("Inventory List:");
                for (InventoryItem i : inventoryItems) {
                    System.out.println(i.getName() + " - Quantity: " + i.getQuantity());
                }
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }

    static void manageStaff() {
        System.out.println("1. Add Staff Member");
        System.out.println("2. View Staff Members");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter Staff Name: ");
                String name = scanner.next();
                System.out.print("Enter Role: ");
                String role = scanner.next();

                Staff staff = new Staff(name, role);
                staffMembers.add(staff);
                System.out.println("Staff member added.");
                break;
            case 2:
                System.out.println("Staff Members:");
                for (Staff s : staffMembers) {
                    System.out.println(s.getName() + " - Role: " + s.getRole());
                }
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }
}

class Patient {
    private String name;
    private int age;
    private String contact;

    public Patient(String name, int age, String contact) {
        this.name = name;
        this.age = age;
        this.contact = contact;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getContact() { return contact; }
}

class Appointment {
    private String patientName;
    private String doctorName;
    private String date;

    public Appointment(String patientName, String doctorName, String date) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
    }
}

class InventoryItem {
    private String name;
    private int quantity;

    public InventoryItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
}

class Staff {
    private String name;
    private String role;

    public Staff(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() { return name; }
    public String getRole() { return role; }
}
