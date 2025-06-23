package BankingSystem;
import java.util.Scanner;

public class BankCLI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankManager manager = new BankManager();

        while (true) {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Create FD");
            System.out.println("5. View Balance");
            System.out.println("6. List All Accounts");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account No: ");
                    int accNo = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    manager.createAccount(accNo, name);
                    break;
                case 2:
                    System.out.print("Enter Account No: ");
                    accNo = sc.nextInt();
                    BankingAccount acc = manager.getAccount(accNo);
                    if (acc != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amt = sc.nextDouble();
                        acc.deposit(amt);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account No: ");
                    accNo = sc.nextInt();
                    acc = manager.getAccount(accNo);
                    if (acc != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amt = sc.nextDouble();
                        acc.withdraw(amt);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account No: ");
                    accNo = sc.nextInt();
                    acc = manager.getAccount(accNo);
                    if (acc != null) {
                        System.out.print("Enter FD amount: ");
                        double amt = sc.nextDouble();
                        acc.createFD(amt);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter Account No: ");
                    accNo = sc.nextInt();
                    acc = manager.getAccount(accNo);
                    if (acc != null) {
                        System.out.println("Available Balance: ₹" + acc.getAvailableBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 6:
                    manager.listAllAccounts();
                    break;
                case 7:
                    System.out.println("Thanks for using our banking system!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
