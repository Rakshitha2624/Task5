package task5;

import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountSimulation {

    // Inner BankAccount class
    static class BankAccount {
        private String accountHolder;
        private double balance;
        private ArrayList<String> transactionHistory;

        public BankAccount(String accountHolder, double initialBalance) {
            this.accountHolder = accountHolder;
            this.balance = initialBalance;
            this.transactionHistory = new ArrayList<>();
            transactionHistory.add("Account successfully created with opening balance: Rs " + initialBalance);
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                transactionHistory.add("➕ Deposited: Rs " + amount);
                System.out.println("Transaction Successful: Rs " + amount + " deposited to your account.");
            } else {
                System.out.println("Deposit failed: Please enter a valid amount greater than Rs 0.");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                transactionHistory.add(" Withdrawn: Rs " + amount);
                System.out.println("Transaction Successful: Rs " + amount + " withdrawn from your account.");
            } else {
                System.out.println("Withdrawal failed: Insufficient balance or invalid amount.");
            }
        }

        public double getBalance() {
            return balance;
        }

        public void showTransactionHistory() {
            System.out.println("\nTransaction Summary for Account Holder: " + accountHolder);
            System.out.println("-------------------------------------------");
            for (String txn : transactionHistory) {
                System.out.println(txn);
            }
            System.out.println("-------------------------------------------");
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println(" Welcome to SecureBank ");
        System.out.println("  Your Trusted Partner in Finance ");
        System.out.println("=========================================");

        System.out.print("Enter your full name to create an account: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial deposit amount (Rs): ");
        double initialAmount = scanner.nextDouble();

        BankAccount account = new BankAccount(name, initialAmount);
        System.out.println("Account successfully created for " + name + "!");

        int choice;
        do {
            System.out.println("\n============= Main Menu =============");
            System.out.println("1️ Deposit Funds");
            System.out.println("2️ Withdraw Funds");
            System.out.println("3️ Check Balance");
            System.out.println("4️ View Transaction History");
            System.out.println("5️ Exit");
            System.out.println("========================================");
            System.out.print("Please select an option (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount (Rs): ");
                    account.deposit(scanner.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount (Rs): ");
                    account.withdraw(scanner.nextDouble());
                    break;
                case 3:
                    System.out.println("Available Balance: Rs" + account.getBalance());
                    break;
                case 4:
                    account.showTransactionHistory();
                    break;
                case 5:
                    System.out.println("\nLogging out...");
                    System.out.println("Thank you for choosing SecureBank™️.");
                    System.out.println("Have a financially smart day!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
