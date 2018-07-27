package by.epam.training.exception;

public class CreationException extends Exception {

    public CreationException(String message) {
        super(message);
    }

    public CreationException(String message, Exception e) {
        super(message, e);
    }
}
