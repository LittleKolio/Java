package iteratorpattern;

public interface Iterator {
    public void first();
    public void last();
    public void next();
    public void prevous();
    public boolean isDone();
    public Object current() throws IteratorOutOfBoundsException;
}
