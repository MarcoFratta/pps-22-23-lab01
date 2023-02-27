import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest {

    private static final double ATM_FEE = SimpleBankAccountAtm.FEE;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        this.accountHolder = new AccountHolder("Mario", "Rossi", 1);
        this.bankAccount = new SimpleBankAccountAtm(this.accountHolder, 0);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, this.bankAccount.getBalance());
    }
    @Test
    void testDeposit(){
        final int depositValue = 10;
        this.bankAccount.deposit(this.accountHolder.getId(), depositValue);
        assertEquals(depositValue - ATM_FEE, this.bankAccount.getBalance());
    }

    @Test
    void testWithdraw(){
        final int depositValue = 50;
        this.bankAccount.deposit(this.accountHolder.getId(), depositValue);
        final int withdrawValue = 10;
        this.bankAccount.withdraw(this.accountHolder.getId(), withdrawValue);
        assertEquals(depositValue - withdrawValue - (2*ATM_FEE), this.bankAccount.getBalance());
    }

    @Test
    void testWrongValueWithdraw(){
        final int depositValue = 50;
        this.bankAccount.deposit(this.accountHolder.getId(), depositValue);
        this.bankAccount.withdraw(this.accountHolder.getId(), depositValue - ATM_FEE);
        assertEquals(depositValue - ATM_FEE, this.bankAccount.getBalance());
    }

    @Test
    void testWrongIdWithdraw(){
        final int depositValue = 50;
        this.bankAccount.deposit(this.accountHolder.getId(), depositValue);
        this.bankAccount.withdraw(this.accountHolder.getId() + 1, depositValue - ATM_FEE);
        assertEquals(depositValue - ATM_FEE, this.bankAccount.getBalance());
    }
}
