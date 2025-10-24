package bank;

public class Account {
    private String accountNumber;
    private String name;
    private double balance;

    // Constructor
    public Account(String accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposited: ₹" + amount);
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✅ Withdrawn: ₹" + amount);
        } else {
            System.out.println("❌ Invalid or insufficient balance.");
        }
    }

    // Transfer money to another account
    public void transfer(Account receiver, double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            receiver.balance += amount;
            System.out.println("✅ ₹" + amount + " transferred to " + receiver.name);
        } else {
            System.out.println("❌ Transfer failed. Check amount or balance.");
        }
    }

    // Display account info
    public void display() {
        System.out.println("Account: " + accountNumber + " | Name: " + name + " | Balance: ₹" + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
