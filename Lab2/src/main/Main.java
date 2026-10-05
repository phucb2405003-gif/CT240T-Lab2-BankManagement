package main;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        BankManager manager = new BankManager();

        // ==============================
        // TẠO TÀI KHOẢN
        // ==============================

        SavingAccount acc1 = new SavingAccount(
                "TK001",
                "Nguyen Van A",
                500000,
                0.05
        );

        SavingAccount acc2 = new SavingAccount(
                "TK002",
                "Tran Thi B",
                1000000,
                0.06
        );

        manager.addAccount(acc1);
        manager.addAccount(acc2);

        System.out.println("===== DANH SACH TAI KHOAN =====");

        System.out.println(
                acc1.getAccountNumber()
                        + " - "
                        + acc1.getHolderName()
                        + " - "
                        + acc1.getBalance()
        );

        System.out.println(
                acc2.getAccountNumber()
                        + " - "
                        + acc2.getHolderName()
                        + " - "
                        + acc2.getBalance()
        );


        // ==============================
        // 1. TEST NẠP TIỀN HỢP LỆ
        // ==============================

        System.out.println("\n===== TEST NAP TIEN =====");

        try {

            acc1.deposit(200000);

            System.out.println(
                    "Nap tien thanh cong!"
            );

            System.out.println(
                    "So du TK001: "
                            + acc1.getBalance()
            );

        } catch (InvalidAmountException e) {

            System.out.println(
                    "Loi: " + e.getMessage()
            );
        }


        // ==============================
        // 2. TEST NẠP TIỀN SAI
        // amount <= 0
        // ==============================

        System.out.println("\n===== TEST NAP TIEN SAI =====");

        try {

            acc1.deposit(-50000);

            System.out.println(
                    "Nap tien thanh cong!"
            );

        } catch (InvalidAmountException e) {

            System.out.println(
                    "Bat duoc loi: "
                            + e.getMessage()
            );
        }


        // ==============================
        // 3. TEST RÚT TIỀN HỢP LỆ
        // ==============================

        System.out.println("\n===== TEST RUT TIEN =====");

        try {

            acc1.withdraw(100000);

            System.out.println(
                    "Rut tien thanh cong!"
            );

            System.out.println(
                    "So du TK001: "
                            + acc1.getBalance()
            );

        } catch (InvalidAmountException e) {

            System.out.println(
                    "Loi so tien: "
                            + e.getMessage()
            );

        } catch (InsufficientBalanceException e) {

            System.out.println(
                    "Loi so du: "
                            + e.getMessage()
            );
        }


        // ==============================
        // 4. TEST RÚT TIỀN <= 0
        // ==============================

        System.out.println("\n===== TEST RUT TIEN SAI =====");

        try {

            acc1.withdraw(0);

            System.out.println(
                    "Rut tien thanh cong!"
            );

        } catch (InvalidAmountException e) {

            System.out.println(
                    "Bat duoc loi: "
                            + e.getMessage()
            );

        } catch (InsufficientBalanceException e) {

            System.out.println(
                    "Loi so du: "
                            + e.getMessage()
            );
        }


        // ==============================
        // 5. TEST RÚT QUÁ SỐ DƯ
        // ==============================

        System.out.println("\n===== TEST RUT VUOT SO DU =====");

        try {

            acc1.withdraw(1000000);

            System.out.println(
                    "Rut tien thanh cong!"
            );

        } catch (InvalidAmountException e) {

            System.out.println(
                    "Loi so tien: "
                            + e.getMessage()
            );

        } catch (InsufficientBalanceException e) {

            System.out.println(
                    "Bat duoc loi: "
                            + e.getMessage()
            );
        }


        // ==============================
        // 6. TEST VI PHẠM SỐ DƯ TỐI THIỂU
        // SavingAccount phải còn >= 50.000
        // ==============================

        System.out.println("\n===== TEST SO DU TOI THIEU =====");

        try {

            acc1.withdraw(460000);

            System.out.println(
                    "Rut tien thanh cong!"
            );

        } catch (InvalidAmountException e) {

            System.out.println(
                    "Loi so tien: "
                            + e.getMessage()
            );

        } catch (InsufficientBalanceException e) {

            System.out.println(
                    "Bat duoc loi: "
                            + e.getMessage()
            );
        }


        // ==============================
        // 7. TEST CHUYỂN TIỀN
        // ==============================

        System.out.println("\n===== TEST CHUYEN TIEN =====");

        try {

            manager.transferMoney(
                    "TK001",
                    "TK002",
                    100000
            );

            System.out.println(
                    "Chuyen tien thanh cong!"
            );

            System.out.println(
                    "TK001: "
                            + acc1.getBalance()
            );

            System.out.println(
                    "TK002: "
                            + acc2.getBalance()
            );

        } catch (InvalidAmountException e) {

            System.out.println(
                    "Loi so tien: "
                            + e.getMessage()
            );

        } catch (InsufficientBalanceException e) {

            System.out.println(
                    "Loi so du: "
                            + e.getMessage()
            );
        }


        // ==============================
        // 8. TEST CHUYỂN TIỀN SAI
        // ==============================

        System.out.println("\n===== TEST CHUYEN TIEN SAI =====");

        try {

            manager.transferMoney(
                    "TK001",
                    "TK002",
                    -10000
            );

            System.out.println(
                    "Chuyen tien thanh cong!"
            );

        } catch (InvalidAmountException e) {

            System.out.println(
                    "Bat duoc loi: "
                            + e.getMessage()
            );

        } catch (InsufficientBalanceException e) {

            System.out.println(
                    "Loi so du: "
                            + e.getMessage()
            );
        }


        // ==============================
        // 9. TEST TÀI KHOẢN KHÔNG TỒN TẠI
        // ==============================

        System.out.println("\n===== TEST TAI KHOAN KHONG TON TAI =====");

        try {

            manager.transferMoney(
                    "TK999",
                    "TK002",
                    100000
            );

            System.out.println(
                    "Chuyen tien thanh cong!"
            );

        } catch (InvalidAmountException e) {

            System.out.println(
                    "Loi so tien: "
                            + e.getMessage()
            );

        } catch (InsufficientBalanceException e) {

            System.out.println(
                    "Loi so du: "
                            + e.getMessage()
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Bat duoc loi: "
                            + e.getMessage()
            );
        }


        // ==============================
        // 10. TÍNH TỔNG SỐ DƯ
        // ==============================

        System.out.println("\n===== TONG SO DU =====");

        List<BankAccount> accounts =
                manager.getAllAccounts();

        double total =
                manager.calculateTotalBalance(accounts);

        System.out.println(
                "Tong so du: " + total
        );
    }
}
