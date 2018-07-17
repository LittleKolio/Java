package iteratorpattern;

import java.util.ArrayList;

public class Repository implements IContainer{

    private ArrayList _items;

    public Repository(){
        this._items = new ArrayList();
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
        this._items.add(value);
    }
    
    public Object getValue(int index) {
        return this._items.get(index);
    }

    public void setValue(int index, Object value) {
        this._items.set(index, value);
    }
    
    public int getCount() {
        return this._items.size();
    }
}
