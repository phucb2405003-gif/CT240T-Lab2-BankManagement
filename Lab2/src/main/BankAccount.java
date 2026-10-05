package main;

public abstract class BankAccount {

    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getter
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Setter
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Nạp tiền
    public void deposit(double amount) throws InvalidAmountException {

        // Pre-condition: amount > 0
        if (amount <= 0) {
            throw new InvalidAmountException(
                    "So tien nap phai lon hon 0!"
            );
        }

        double oldBalance = balance;

        balance += amount;

        // Post-condition
        assert balance == oldBalance + amount;

        // Invariant
        assert balance >= 0;
    }

    // Rút tiền
    public abstract void withdraw(double amount)
            throws InsufficientBalanceException, InvalidAmountException;
}