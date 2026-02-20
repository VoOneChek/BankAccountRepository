package domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class BankAccount {

    private final String ownerName;
    private int balance;
    private final LocalDateTime createdAt;
    private final boolean blocked;
    private final String accountNumberHash;

    public BankAccount(String ownerName, String accountNumberHash) {
        this.ownerName = ownerName;
        this.balance = 0;
        this.createdAt = LocalDateTime.now();
        this.blocked = false;
        this.accountNumberHash = accountNumberHash;
    }

    public int getBalance() { return balance; }
    public boolean isUnblocked() { return !blocked; }
    public String getAccountNumberHash() { return accountNumberHash; }

    public void setBalance(int balance) { this.balance = balance; }

    @Override
    public String toString() {
        return "BankAccount{" +
                "owner='" + ownerName + '\'' +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", blocked=" + blocked +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount other)) return false;
        return Objects.equals(accountNumberHash, other.accountNumberHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumberHash);
    }
}
