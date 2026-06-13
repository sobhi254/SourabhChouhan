package javaoops;

public class EncapsulationExample {

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(1000);

        System.out.println("Balance: " + account.getBalance());
    }
}

class BankAccount {
    private int balance;

    void deposit(int amount) {
        balance = balance + amount;
    }

    int getBalance() {
        return balance;
    }
}
