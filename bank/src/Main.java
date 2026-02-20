
import domain.BankAccount;
import repository.AccountRepository;
import service.BankAccountFactory;
import service.BankAccountService;
import ui.ConsolePrinter;

void main() {
    AccountRepository repository = new AccountRepository();
    BankAccountFactory factory = new BankAccountFactory(repository);
    BankAccountService service = new BankAccountService();

    BankAccount acc1 = factory.createAccount("Alice");
    BankAccount acc2 = factory.createAccount("Bob");

    ConsolePrinter.printAccount(acc1);
    ConsolePrinter.printAccount(acc2);

    boolean depositResult = service.deposit(acc1, 1000);
    ConsolePrinter.printResult(depositResult);

    boolean transferResult = service.transfer(acc1, acc2, 300);
    ConsolePrinter.printResult(transferResult);

    boolean withdrawResult = service.withdraw(acc2, 200);
    ConsolePrinter.printResult(withdrawResult);

    ConsolePrinter.printAccount(acc1);
    ConsolePrinter.printAccount(acc2);
}
