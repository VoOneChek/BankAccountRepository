import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

public class BankAccount {

    private String ownerName;
    private int balance;
    private LocalDateTime createdAt;
    private boolean blocked;
    private String number; // номер счета XXXXXXXX

    // Конструктор принимает только имя владельца
    public BankAccount(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0;
        this.createdAt = LocalDateTime.now();
        this.blocked = false;
        this.number = generateAccountNumber();
    }

    // Генерация номера счета XXXXXXXX
    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }

    // Пополнение счета
    public boolean deposit(int amount) {
        if (blocked || amount <= 0) {
            return false;
        }

        balance += amount;
        return true;
    }

    // Снятие денег
    public boolean withdraw(int amount) {
        if (blocked || amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }

    // Перевод на другой счет
    public boolean transfer(BankAccount otherAccount, int amount) {
        if (otherAccount == null) {
            return false;
        }

        if (withdraw(amount)) {
            return otherAccount.deposit(amount);
        }

        return false;
    }

    // toString
    @Override
    public String toString() {
        return "BankAccount{" +
                "ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", blocked=" + blocked +
                ", number='" + number + '\'' +
                '}';
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount other)) return false;
        return Objects.equals(number, other.number);
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
