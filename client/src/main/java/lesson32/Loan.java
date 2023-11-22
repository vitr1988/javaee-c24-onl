package lesson32;

import java.math.BigDecimal;

public abstract class Loan {

    private BigDecimal creditAmount;
    private String bankId;
    private String customer;

    public void take(BigDecimal value) {
        if (checkCredit(value) && checkCoCustomers()) {
            transferMoney(value);
            congrats();
        }
    }

    protected abstract boolean checkCredit(BigDecimal value);

    protected boolean checkCoCustomers() {
        return true;
    }

    protected abstract void transferMoney(BigDecimal value);

    public void congrats() {
        System.out.println("Congrats " + customer);
    }

}
