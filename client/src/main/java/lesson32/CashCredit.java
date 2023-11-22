package lesson32;

import java.math.BigDecimal;

public class CashCredit extends Loan {
    @Override
    protected boolean checkCredit(BigDecimal value) {
        return false;
    }

    @Override
    protected void transferMoney(BigDecimal value) {

    }
}
