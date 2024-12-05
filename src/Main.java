import bankManagement.InsufficientFundsException;
import bankManagement.InvalidInputException;
import bankManagement.SavingsAccount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SavingsAccount account = null;

        while (true) {
            System.out.println("--- Bank Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. view transactions history");
            System.out.println("6. exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Account Number: ");
                        String accountNumber = scanner.next();
                        System.out.print("Enter Holder Name: ");
                        String holderName = scanner.next();
                        System.out.print("Enter Initial Balance: ");
                        double balance = scanner.nextDouble();
                        account = new SavingsAccount(accountNumber, holderName, balance);
                        break;
                    case 2:
                        if (account != null) {
                            System.out.print("Enter amount to deposit: ");
                            double amount = scanner.nextDouble();
                            account.deposit(amount);
                        }else{
                            System.out.print("no account created");
                        }
                        break;
                    case 3:
                        if (account != null) {
                            System.out.print("Enter amount to withdraw: ");
                            double amount = scanner.nextDouble();
                            account.withdraw(amount);
                        } else{
                            System.out.print("no account created");
                        }
                        break;
                    case 4:
                        if (account != null) {
                            System.out.print("Enter amount to withdraw: ");
                            System.out.print(account.getBalance());
                        }else{
                            System.out.print("no account created");
                        }
                        break;
                    case 5:
                        if (account != null) {
                            System.out.print("Enter amount to withdraw: ");
                            account.displayTransactionHistory();
                        }else{
                            System.out.print("no account created");
                        }
                        break;
                    case 6:
                        System.out.println("exiting");
                        return;

                }
            } catch (InvalidInputException | InsufficientFundsException e){
                System.out.println(e.getMessage());
            }
        }
    }
}