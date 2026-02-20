package validation;

import domain.BankAccount;

public class BankAccountValidator {

    public static boolean canWithdraw(BankAccount acc, int amount) {
        return amount > 0 && acc.getBalance() >= amount && acc.isUnblocked();
    }

    public static boolean canDeposit(BankAccount acc, int amount) {
        return amount > 0 && acc.isUnblocked();
    }

    public static boolean canTransfer(BankAccount from, BankAccount to, int amount) {
        return canWithdraw(from, amount) && to != null;
    }

}
