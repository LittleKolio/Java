package lists;

public class IteratorOutOfBoundsException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Current (index) out of bounds!";
    }
}
