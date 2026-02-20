
void main() {
    BankAccount acc1 = new BankAccount("Alice");
    BankAccount acc2 = new BankAccount("Bob");
    acc1.deposit(500);
    acc1.transfer(acc2, 200);
    System.out.println(acc1);
    System.out.println(acc2);
}
