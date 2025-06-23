package BankingSystem;
import java.util.*;

public class BankManager {
    private Map<Integer, BankingAccount> accounts = new HashMap<>();

    public void createAccount(int accountNo, String name) {
        if (accounts.containsKey(accountNo)) {
            System.out.println("Account already exists.");
            return;
        }
        accounts.put(accountNo, new BankingAccount(accountNo, name));
        System.out.println("Account created successfully.");
    }

    public BankingAccount getAccount(int accountNo) {
        return accounts.get(accountNo);
    }

    public void listAllAccounts() {
        for (BankingAccount acc : accounts.values()) {
            acc.showDetails();
            System.out.println("------");
        }
    }
}
