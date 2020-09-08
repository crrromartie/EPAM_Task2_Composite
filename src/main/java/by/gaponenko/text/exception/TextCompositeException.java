package by.gaponenko.text.exception;

public class TextCompositeException extends Exception {
    public TextCompositeException() {
    }

    public TextCompositeException(String message) {
        super(message);
    }

    public TextCompositeException(String message, Throwable cause) {
        super(message, cause);
    }

    public TextCompositeException(Throwable cause) {
        super(cause);
    }
}
