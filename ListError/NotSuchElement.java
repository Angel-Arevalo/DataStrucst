package ListError;

public class NotSuchElement  extends RuntimeException {
    
    public NotSuchElement(String e) {
        super(e);
    }

    public NotSuchElement() {
        super("No está el elemento en la lista");
    }
}
