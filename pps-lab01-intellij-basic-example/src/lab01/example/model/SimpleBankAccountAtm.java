package lab01.example.model;

public class SimpleBankAccountAtm implements BankAccount {

    public static final double FEE = 1;
    private final BankAccount account;

    public SimpleBankAccountAtm(final AccountHolder accountHolder, final int id) {
        this(new SimpleBankAccount(accountHolder, id));
    }

    public SimpleBankAccountAtm(final BankAccount bankAccount){
        this.account = bankAccount;
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
        if(amount > 0) this.account.deposit(userID, amount - FEE);
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if(amount > FEE ) this.account.withdraw(userID, amount + FEE);
    }
}
