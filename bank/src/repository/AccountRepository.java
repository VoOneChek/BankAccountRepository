package repository;

import domain.BankAccount;
import java.util.HashSet;
import java.util.Set;

public class AccountRepository {
    private final Set<String> accountHashes = new HashSet<>();

    public boolean exists(String hash) {
        return accountHashes.contains(hash);
    }

    public void save(BankAccount account) {
        accountHashes.add(account.getAccountNumberHash());
    }
}
