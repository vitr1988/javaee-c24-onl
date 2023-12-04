package lesson34.log.service;

public class CalculatorService {

    private final Integer operand1;
    private final Integer operand2;

    public CalculatorService(Integer operand1, Integer operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public Integer sum() {
        return operand1 + operand2;
    }

    public Integer minus() {
        return operand1 - operand2;
    }

    public Integer div() {
        return  operand1 / operand2;
    }
}
