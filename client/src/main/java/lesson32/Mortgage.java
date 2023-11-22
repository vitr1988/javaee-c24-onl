package lesson32;

import java.math.BigDecimal;

public class Mortgage extends Loan {
    @Override
    protected boolean checkCredit(BigDecimal value) {
        return false;
    }

    @Override
    protected void transferMoney(BigDecimal value) {

    }

    @Override
    protected boolean checkCoCustomers() {
        //TODO: здесь логика проверки созаемщиков
        return true;
    }
}
