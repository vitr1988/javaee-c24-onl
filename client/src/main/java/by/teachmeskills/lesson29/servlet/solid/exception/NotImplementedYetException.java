package by.teachmeskills.lesson29.servlet.solid.exception;

public class NotImplementedYetException extends RuntimeException {

    public NotImplementedYetException(String message) {
        super("Not implemented yet for %s!".formatted(message));
    }
}
