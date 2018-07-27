package by.epam.training.exception;

public class InitializeException extends Exception {

    public InitializeException(String message) {
        super(message);
    }

    public InitializeException(String message, Exception e) {
        super(message, e);
    }
}
