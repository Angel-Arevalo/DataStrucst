class OutIndexError extends RuntimeException {
    
    public OutIndexError(String message) {
        super(message);
    }

    public OutIndexError() {
        super("Error: Índice no válido.");
    }
}

class EmptyError extends RuntimeException {

    public EmptyError(String message) {
        super(message);
    }

    public EmptyError() {
        super("Error: Lista vacía. No se puede eliminar el elemento.");
    }
}

class FullError extends RuntimeException {

    public FullError(String message) {
        super(message);
    }

    public FullError() {
        super("Error: Lista llena. No se puede agregar el elemento.");
    }
}
