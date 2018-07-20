package lists;

import java.util.Iterator;

public class CustomArrayList implements ICustomList{
    private static int INITIAL_CAPACITY = 16;
    private int _capacity;
    private Object[] _array;
    private int _size;
    
    public CustomArrayList() {
        this(INITIAL_CAPACITY);
    }
    
    public CustomArrayList(int capacity) {
        assert capacity > 0 : "capacity must be greate than 1";
        
        _capacity = capacity;
        clear();
    }
    
    private void ensureCapacity(int capacity) {
        assert capacity > 0 : "capacity must be greater than 0";
        
        if(_array.length < capacity) {
            Object[] copy = new Object[capacity + capacity / 2];
            System.arraycopy(_array, 0, copy, 0, _size);
            _array = copy;
        }
    }
    
    @Override
    public void insert(int index, Object value) throws IndexOutOfBoundsException {
        assert value != null : "value can not be null";
        
        if(index < 0 || index > _size) {
            throw new IndexOutOfBoundsException();
        }
        
        ensureCapacity(_size + 1);
        System.arraycopy(_array, index, _array, index + 1, _size - index);
        _array[index] = value;
        _size++;
    }

    @Override
    public void add(Object value) {
        insert(_size, value);
    }

    @Override
    public Object delete(int index) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        _array = new Object[_capacity];
        _size = 0;
    }

    @Override
    public Object set(int index, Object value) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexOf(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
