package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class BankManager {

    private Map<String, BankAccount> accounts;

    public BankManager() {
        accounts = new HashMap<>();
    }

    // Thêm tài khoản
    public void addAccount(BankAccount account) {

        accounts.put(
                account.getAccountNumber(),
                account
        );
    }

    // Tìm tài khoản
    public BankAccount findAccount(String accountNumber) {

        return accounts.get(accountNumber);
    }

    // Tính tổng số dư
    public double calculateTotalBalance(
            List<? extends BankAccount> accounts) {

        double total = 0.0;

        for (BankAccount acc : accounts) {
            total += acc.getBalance();
        }

        return total;
    }

    // Chuyển tiền
    public void transferMoney(
            String fromAcc,
            String toAcc,
            double amount)
            throws InvalidAmountException,
            InsufficientBalanceException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "So tien chuyen phai lon hon 0!"
            );
        }

        BankAccount sender = findAccount(fromAcc);
        BankAccount receiver = findAccount(toAcc);

        if (sender == null) {
            throw new IllegalArgumentException(
                    "Khong tim thay tai khoan nguoi gui!"
            );
        }

        if (receiver == null) {
            throw new IllegalArgumentException(
                    "Khong tim thay tai khoan nguoi nhan!"
            );
        }

        // Rút tiền người gửi
        sender.withdraw(amount);

        // Nạp tiền người nhận
        try {
            receiver.deposit(amount);
        } catch (InvalidAmountException e) {

            // Hoan lai tien neu nap that bai
            try {
                sender.deposit(amount);
            } catch (InvalidAmountException ignored) {
            }

            throw e;
        }
    }

    // Lấy danh sách tài khoản
    public List<BankAccount> getAllAccounts() {

        return new ArrayList<>(accounts.values());
    }
}