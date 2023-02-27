import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        this.accountHolder = new AccountHolder("Mario", "Rossi", 1);
        this.bankAccount = new SimpleBankAccount(this.accountHolder, 0);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, this.bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        this.bankAccount.deposit(this.accountHolder.getId(), 100);
        assertEquals(100, this.bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        this.bankAccount.deposit(this.accountHolder.getId(), 100);
        this.bankAccount.deposit(2, 50);
        assertEquals(100, this.bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        this.bankAccount.deposit(this.accountHolder.getId(), 100);
        this.bankAccount.withdraw(this.accountHolder.getId(), 70);
        assertEquals(30, this.bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        this.bankAccount.deposit(this.accountHolder.getId(), 100);
        this.bankAccount.withdraw(2, 70);
        assertEquals(100, this.bankAccount.getBalance());
    }
}
