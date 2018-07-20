package iteratorpattern;

public class FilterIterator implements IIterator{
    private IIterator _iterator;
    private IPredicate _predicate;
    
    public FilterIterator(IIterator iterator, IPredicate predicate) {
        assert iterator != null : "Iterator can not be null!";
        assert predicate != null : "Predicate can not be null!";
        _iterator = iterator;
        _predicate = predicate;
    }
    
    @Override
    public void first() {
        _iterator.first();
        filterForwards();
    }

    @Override
    public void last() {
        _iterator.last();
        filterBackwards();
    }

    @Override
    public void next() {
        _iterator.next();
        filterForwards();
    }

    @Override
    public void prevous() {
        _iterator.prevous();
        filterBackwards();
    }

    @Override
    public boolean isDone() {
        return _iterator.isDone();
    }

    @Override
    public Object current() throws IteratorOutOfBoundsException {
        return _iterator.current();
    }

    private void filterForwards() {
        while(!_iterator.isDone() && !_predicate.evaluate(_iterator.current())) {
            _iterator.next();
        }
    }

    private void filterBackwards() {
        while(!_iterator.isDone() && !_predicate.evaluate(_iterator.current())) {
            _iterator.prevous();
        }
    }
    
}
