package by.teachmeskills.lesson30;

public class FactoryRunner {

    public static void main(String[] args) {
        Integer one = Integer.valueOf(1); // кэш работает!
        Integer oneHundredAndThirtySix = Integer.valueOf(136); // кэш не работает!
        Integer anotherOne = new Integer(136);
    }
}
