package ui;

import domain.BankAccount;

public class ConsolePrinter {

    public static void printAccount(BankAccount acc) {
        System.out.println(acc);
    }

    public static void printResult(boolean success) {
        System.out.println(success ? "Операция успешна" : "Ошибка операции");
    }
}
