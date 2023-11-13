package by.teachmeskills.lesson29.servlet.solid;

public interface Validator<T> {

    boolean isValid(T t);
}
