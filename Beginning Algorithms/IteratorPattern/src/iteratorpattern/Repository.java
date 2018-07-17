package iteratorpattern;

import java.util.ArrayList;

public class Repository implements IContainer{

    private ArrayList items;

    public Repository(){
        this.items = new ArrayList();
    }
    
    @Override
    public IIterator getIterator(int start, int length) {
        return new Iterator(this, start, length);
    }
    
    @Override
    public IIterator getIterator() {
        return new Iterator(this);
    }
    
    @Override
    public IIterator getReverseIterator(int start, int length){
        return new ReverseIterator(
            this.getIterator(start - (length - 1), length)
        );
    }
    
    @Override
    public IIterator getReverseIterator(){
        return new ReverseIterator(this.getIterator());
    }
    
    public void add(Object value) {
        this.items.add(value);
    }
    
    public Object getValue(int index) {
        return this.items.get(index);
    }

    public void setValue(int index, Object value) {
        this.items.set(index, value);
    }
    
    public int getCount() {
        return this.items.size();
    }
}
