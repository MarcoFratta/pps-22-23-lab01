package lab01.example.model;

import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;

public class SimpleBankAccountAtm implements BankAccount {

    public static final double FEE = 1;
    private final BankAccount account;

    public SimpleBankAccountAtm(final AccountHolder accountHolder, final int id) {
        this.account = new SimpleBankAccount(accountHolder, id);
    }

    @Override
    public AccountHolder getHolder() {
        return this.account.getHolder();
    }

    @Override
    public double getBalance() {
        return this.account.getBalance();
    }

    @Override
    public void deposit(final int userID, final double amount) {
        this.account.deposit(userID, amount - FEE);
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        this.account.withdraw(userID, amount + FEE);
    }
}
