package iteratorpattern;

public class CollectionIterator implements Iterator{

    private Repository repo;
    private int index;
    
    public CollectionIterator(Repository repo){
        this.repo = repo;
        this.first();
    }
    
    @Override
    public void first() {
        this.index = 0;
    }

    @Override
    public void last() {
        this.index = this.repo.getCount() - 1;
    }

    @Override
    public void next() {
        this.index++;
    }

    @Override
    public void prevous() {
        this.index--;
    }

    @Override
    public boolean isDone() {
        boolean isDone = false;
        if (this.index < 0 || this.index >= this.repo.getCount()){
            isDone = true;
        }
        return isDone;
    }

    @Override
    public Object current() throws IteratorOutOfBoundsException{
        if (this.isDone()){
            throw new IteratorOutOfBoundsException();
        }
        return this.repo.getValue(this.index);
    }
    
}
