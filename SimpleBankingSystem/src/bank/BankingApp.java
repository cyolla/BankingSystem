package bank;

import java.util.Scanner;

public class BankingApp {
    static Account[] accounts = new Account[5];
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("🏦 Welcome to Simple Banking System");

        // Add some default users
        accounts[count++] = new Account("1001", "Alice", 5000);
        accounts[count++] = new Account("1002", "Bob", 3000);

        do {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount(sc);
                    break;
                case 2:
                    deposit(sc);
                    break;
                case 3:
                    withdraw(sc);
                    break;
                case 4:
                    transfer(sc);
                    break;
                case 5:
                    displayAll();
                    break;
                case 6:
                    System.out.println("👋 Thank you for using Simple Banking System!");
                    break;
                default:
                    System.out.println("❌ Invalid choice.");
            }
        } while (choice != 6);

        sc.close();
    }

    // Create a new account
    static void createAccount(Scanner sc) {
        if (count < accounts.length) {
            System.out.print("Enter account number: ");
            String accNo = sc.next();
            System.out.print("Enter name: ");
            String name = sc.next();
            System.out.print("Enter initial balance: ");
            double bal = sc.nextDouble();

            accounts[count++] = new Account(accNo, name, bal);
            System.out.println("✅ Account created successfully!");
        } else {
            System.out.println("❌ Cannot create more accounts (limit reached).");
        }
    }

    // Deposit money
    static void deposit(Scanner sc) {
        Account acc = findAccount(sc);
        if (acc != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = sc.nextDouble();
            acc.deposit(amount);
        }
    }

    // Withdraw money
    static void withdraw(Scanner sc) {
        Account acc = findAccount(sc);
        if (acc != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = sc.nextDouble();
            acc.withdraw(amount);
        }
    }

    // Transfer money
    static void transfer(Scanner sc) {
        System.out.print("Enter your account number: ");
        String fromAccNo = sc.next();
        Account from = findAccountByNumber(fromAccNo);

        System.out.print("Enter receiver account number: ");
        String toAccNo = sc.next();
        Account to = findAccountByNumber(toAccNo);

        if (from != null && to != null) {
            System.out.print("Enter amount to transfer: ");
            double amt = sc.nextDouble();
            from.transfer(to, amt);
        } else {
            System.out.println("❌ Account not found.");
        }
    }

    // Display all accounts
    static void displayAll() {
        System.out.println("\n📋 All Accounts:");
        for (int i = 0; i < count; i++) {
            accounts[i].display();
        }
    }

    // Helper method: find account
    static Account findAccount(Scanner sc) {
        System.out.print("Enter account number: ");
        String accNo = sc.next();
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber().equals(accNo))
                return accounts[i];
        }
        System.out.println("❌ Account not found.");
        return null;
    }

    static Account findAccountByNumber(String accNo) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber().equals(accNo))
                return accounts[i];
        }
        return null;
    }
}
