import java.util.*;

class BankService {
    private Map<String, Account> accountMap = new HashMap<>();
    private List<Transaction> transactionHistory = new ArrayList<>();
    private int transactionCounter = 1000;

    public void createAccount(Account account) {
        if (accountMap.containsKey(account.getAccountNumber())) {
            System.out.println("Account with this number already exists.");
            return;
        }
        accountMap.put(account.getAccountNumber(), account);
        System.out.println("Account registered successfully for: " + account.getHolderName());
    }

    public void deposit(String accountNumber, double amount) {
        Account acc = accountMap.get(accountNumber);
        if (acc == null) {
            System.out.println("Error: Account not found!");
            return;
        }
        acc.deposit(amount);
        recordTransaction(accountNumber, "DEPOSIT", amount);
    }

    public void withdraw(String accountNumber, double amount) {
        Account acc = accountMap.get(accountNumber);
        if (acc == null) {
            System.out.println("Error: Account not found!");
            return;
        }
        try {
            acc.withdraw(amount);
            recordTransaction(accountNumber, "WITHDRAWAL", amount);
        } catch (InsufficientFundException e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        }
    }

    public void transfer(String fromAccNum, String toAccNum, double amount) {
        Account source = accountMap.get(fromAccNum);
        Account target = accountMap.get(toAccNum);

        if (source == null || target == null) {
            System.out.println("Error: One or both account numbers are invalid.");
            return;
        }

        try {
            source.withdraw(amount);
            target.deposit(amount);
            recordTransaction(fromAccNum, "TRANSFER OUT TO " + toAccNum, amount);
            recordTransaction(toAccNum, "TRANSFER IN FROM " + fromAccNum, amount);
            System.out.println("Successfully transferred $" + amount + " from " + fromAccNum + " to " + toAccNum);
        } catch (InsufficientFundException e) {
            System.out.println("Transfer Failed: " + e.getMessage());
        }
    }

    private void recordTransaction(String accNum, String type, double amount) {
        String txId = "TXN" + (++transactionCounter);
        transactionHistory.add(new Transaction(txId, accNum, type, amount));
    }

    public void printAccountDetails(String accountNumber) {
        Account acc = accountMap.get(accountNumber);
        if (acc != null) {
            System.out.println("Account: " + acc.getAccountNumber() + " | Owner: " +
                    acc.getHolderName() + " (" + acc.getBalance() + ") | Balance: $" + acc.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public void printTransactionHistory() {
        System.out.println("\n--- All Bank Transactions ---");
        for (Transaction t : transactionHistory) {
            System.out.println(t);
        }
    }
}