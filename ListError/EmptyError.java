package ListError;

public class EmptyError extends RuntimeException {

    public EmptyError(String message) {
        super(message);
    }

    public EmptyError() {
        super("Error: Lista vacía. No se puede eliminar el elemento.");
    }
}