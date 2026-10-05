package main;

public class SavingAccount extends BankAccount {

    private double interestRate;

    public SavingAccount(
            String accountNumber,
            String holderName,
            double balance,
            double interestRate) {

        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount)
            throws InsufficientBalanceException, InvalidAmountException {

        // Pre-condition
        if (amount <= 0) {
            throw new InvalidAmountException(
                    "So tien rut phai lon hon 0!"
            );
        }

        // Tai khoan phai con toi thieu 50.000
        if (getBalance() - amount < 50000) {
            throw new InsufficientBalanceException(
                    "Tai khoan phai con toi thieu 50.000 VND!"
            );
        }

        double oldBalance = getBalance();

        setBalance(getBalance() - amount);

        // Post-condition
        assert getBalance() == oldBalance - amount;

        // Invariant
        assert getBalance() >= 50000;
    }
}