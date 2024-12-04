package ListError;

public class FullError extends RuntimeException {

    public FullError(String message) {
        super(message);
    }

    public FullError() {
        super("Error: Lista llena. No se puede agregar el elemento.");
    }
}
