package iteratorpattern;

public class Iterator implements IIterator{

    private Repository _repo;
    private int _current = -1;
    private int _first;
    private int _last;

    public Iterator(Repository repo){
        assert repo.getCount() > 0 : "Collection can not be empty!";
        
        this._repo = repo;
        this._first = 0;
        this._last = repo.getCount() - 1;
    }
    
    public Iterator(Repository repo, int start, int length){
        assert repo.getCount() > 0 : "Collection can not be empty!";
        assert start >= 0 : "Start index can not be less than 0!";
        assert start < repo.getCount() : "Start index can not be more than collection length!";
        assert length >= 1 : "Length to iterate can not be less than 1!";
        
        this._repo = repo;
        this._first = start;
        this._last = start + length - 1;
        
        assert this._last < repo.getCount() : "Start index + length can not be more than collection length!";
    }
    
    @Override
    public void first() {
        this._current = this._first;
    }

    @Override
    public void last() {
        this._current = this._last;
    }

    @Override
    public void next() {
        this._current++;
    }

    @Override
    public void prevous() {
        this._current--;
    }

    @Override
    public boolean isDone() {
        return this._current < this._first || this._current > this._last;
    }

    @Override
    public Object current() throws IteratorOutOfBoundsException{
        if (this.isDone()){
            throw new IteratorOutOfBoundsException();
        }
        return this._repo.getValue(this._current);
    }
    
}
