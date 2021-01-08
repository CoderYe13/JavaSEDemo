package cn.henuer;

/**
 * withdraw()线程不安全。解决方法，方法上加锁synchronized
 */
public class AccountUnsafe implements Account{
    private Integer balance;

    public AccountUnsafe(Integer balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
        Account.demo(new AccountUnsafe(10000));
    }

    @Override
    public Integer getBalance() {
        return balance;
    }

    @Override
    public void withdraw(Integer amount) {
        balance-=amount;
    }
}
