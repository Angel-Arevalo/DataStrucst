package ListError;

public class NotComparableElement extends RuntimeException {
    
    public NotComparableElement(String e) {
        super(e);
    }

    public NotComparableElement() {
        super("Implementación de clase no comparable");
    }
}
