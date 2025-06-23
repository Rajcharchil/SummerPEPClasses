package BankingSystem;

public class BankingAccount {
    private int accountNo;
    private String name;
    private double balance;
    private double fdAmount;

    public BankingAccount(int accountNo, String name) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = 0;
        this.fdAmount = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void createFD(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            fdAmount += amount;
            System.out.println("FD created for ₹" + amount);
        } else {
            System.out.println("Not enough balance for FD.");
        }
    }

    public double getAvailableBalance() {
        return balance;
    }

    public void showDetails() {
        System.out.println("Account No: " + accountNo);
        System.out.println("Name: " + name);
        System.out.println("Balance: ₹" + balance);
        System.out.println("FD Amount: ₹" + fdAmount);
    }

    public int getAccountNo() {
        return accountNo;
    }
}
