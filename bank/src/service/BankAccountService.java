package service;

import domain.BankAccount;
import java.util.logging.Logger;
import validation.BankAccountValidator;

public class BankAccountService {

    private static final Logger logger =
            Logger.getLogger(BankAccountService.class.getName());

    public boolean deposit(BankAccount acc, int amount) {
        if (!BankAccountValidator.canDeposit(acc, amount)) {
            logger.warning("Пополнение отклонено");
            return false;
        }

        acc.setBalance(acc.getBalance() + amount);
        logger.info("Пополнение на сумму: " + amount);
        return true;
    }

    public boolean withdraw(BankAccount acc, int amount) {
        if (!BankAccountValidator.canWithdraw(acc, amount)) {
            logger.warning("Снятие отклонено");
            return false;
        }

        acc.setBalance(acc.getBalance() - amount);
        logger.info("Снятие на сумму: " + amount);
        return true;
    }

    public boolean transfer(BankAccount from, BankAccount to, int amount) {
        if (!BankAccountValidator.canTransfer(from, to, amount)) {
            logger.warning("Перевод отклонён");
            return false;
        }

        withdraw(from, amount);
        deposit(to, amount);

        logger.info("Перевод " + amount + " выполнен");
        return true;
    }
}
