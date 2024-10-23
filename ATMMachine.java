import java.util.Scanner;

class ATM {
    float Balance;
    int PIN; 
    Scanner sc = new Scanner(System.in);
    
    public void setPin() {
        System.out.print("Set your new PIN: ");
        PIN = sc.nextInt();
        System.out.println("PIN set successfully!");
    }

    public void checkpin() {
        System.out.println("Enter your PIN:");
        int enteredpin = sc.nextInt();

        if (enteredpin == PIN) {
            menu();
        } else {
            System.out.println("Incorrect PIN. Please try again.");
        }
    }

    public void menu() {
        System.out.println("Enter your choice:");
        System.out.println("1. Check A/C Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. EXIT");

        int opt = sc.nextInt();

        if (opt == 1) {
            checkBalance();
        } else if (opt == 2) {
            withdrawMoney();
        } else if (opt == 3) {
            depositMoney();
        } else if (opt == 4) {
            return;
        } else {
            System.out.println("Enter a valid choice");
        }
    }

    public void checkBalance() {
        System.out.println("Balance: " + Balance);
        menu();
    }

    public void withdrawMoney() {
        System.out.println("Enter Amount to withdraw:");
        float amount = sc.nextFloat();

        if (amount > Balance) {
            System.out.println("Insufficient Balance");
        } else {
            Balance = Balance - amount;
            System.out.println("Money withdrawal Successful");
        }
        menu();
    }

    public void depositMoney() {
        System.out.println("Enter the Amount: ");
        float amount = sc.nextFloat();
        Balance = Balance + amount;
        System.out.println("Money Deposited Successfully");
        menu();
    }
}

public class ATMMachine {
    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.setPin();   
        obj.checkpin(); 
    }
}
