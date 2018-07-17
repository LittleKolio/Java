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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void last() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void prevous() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object current() throws IteratorOutOfBoundsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
