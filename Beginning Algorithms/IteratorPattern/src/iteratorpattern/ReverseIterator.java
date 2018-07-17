package iteratorpattern;

public class ReverseIterator implements IIterator{

    private IIterator _iter;
    
    public ReverseIterator(IIterator iterator) {
        assert iterator != null : "Iterator can not be null!";
        this._iter = iterator;
    }
    
    @Override
    public void first() {
        this._iter.last();
    }

    @Override
    public void last() {
        this._iter.first();
    }

    @Override
    public void next() {
        this._iter.prevous();
    }

    @Override
    public void prevous() {
        this._iter.next();
    }

    @Override
    public boolean isDone() {
        return this._iter.isDone();
    }

    @Override
    public Object current() throws IteratorOutOfBoundsException {
        return this._iter.current();
    }
    
}
