package bankManagement;

import java.util.ArrayList;
import java.util.List;

public class BankAccount implements Reportable {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private List<String> transactions;

    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        transactions.add("Account created with initial balance: " + initialBalance);
    }


    public String getAccountNumber() {
        return accountNumber;
    }


    public String getAccountHolderName() {
        return accountHolderName;
    }


    public double getBalance() {
        return balance;
    }


    public void recordTransaction(String message) {
        transactions.add(message);
    }


    public void deposit(double amount) throws InvalidInputException{
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited: " + amount);
        } else {
            throw new InvalidInputException("Invalid deposit amount.");
        }
    }


    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new RuntimeException("Insufficient funds to withdraw " + amount);
        }
        balance -= amount;
        transactions.add("Withdrew: " + amount);
    }


    public void displayTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found for this account.");
        } else {
            System.out.println("--- Transaction History ---");
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    @Override
    public String generateSummary() {
        return accountNumber.concat(" ").concat(accountHolderName).concat(" ").concat(String.valueOf(balance));
    }
}
