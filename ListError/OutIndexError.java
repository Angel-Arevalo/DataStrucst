package ListError;

public class OutIndexError extends RuntimeException {
    
    public OutIndexError(String message) {
        super(message);
    }

    public OutIndexError() {
        super("Error: Índice no válido.");
    }
}
