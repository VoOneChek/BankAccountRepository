package service;

import domain.BankAccount;
import repository.AccountRepository;
import security.AccountHashService;
import util.AccountNumberGenerator;

public class BankAccountFactory {

    private final AccountRepository repository;

    public BankAccountFactory(AccountRepository repository) {
        this.repository = repository;
    }

    public BankAccount createAccount(String ownerName) {

        String number;
        String hash;

        do {
            number = AccountNumberGenerator.generate();
            hash = AccountHashService.hash(number);
        } while (repository.exists(hash));

        BankAccount account = new BankAccount(ownerName, hash);
        repository.save(account);

        return account;
    }
}
