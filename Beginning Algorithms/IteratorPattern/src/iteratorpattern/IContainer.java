package iteratorpattern;

public interface IContainer {
    public IIterator getIterator(int start, int length);
    public IIterator getIterator();
    public IIterator getReverseIterator(int start, int length);
    public IIterator getReverseIterator();
}
