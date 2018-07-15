package iteratorpattern;

import java.util.ArrayList;

public class Repository implements Container{

    public ArrayList items;
    
    public Repository(){
        this.items = new ArrayList();
    }
    
    @Override
    public Iterator getIterator() {
        return new CollectionIterator(this);
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
