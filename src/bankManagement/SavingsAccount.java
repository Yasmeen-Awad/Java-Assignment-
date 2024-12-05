package bankManagement;

public class SavingsAccount extends BankAccount {
    private static final double MINIMUM_BALANCE = 500.0;

    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance) throws InvalidInputException {
        super(accountNumber, accountHolderName, initialBalance);
        if(initialBalance< MINIMUM_BALANCE){
            throw new InvalidInputException("invald initial balance");
        }
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (getBalance() - amount < MINIMUM_BALANCE) {
            throw new InsufficientFundsException("Withdrawal would violate minimum balance of " + MINIMUM_BALANCE);
        }
        super.withdraw(amount);
    }

}
