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
    
    private void ensureIndexBounds(int index) {
        if(index < 0 || index >= _size) {
            throw new IndexOutOfBoundsException();
        }
    }
    
    private void ensureCapacity(int capacity) {
        assert capacity > 0 : "capacity must be greater than 0";
        
        //if(_array.length < capacity)
        if(_capacity < capacity) {
            _capacity = capacity + capacity / 2;
            Object[] copy = new Object[_capacity];
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
        ++_size;
    }

    @Override
    public void add(Object value) {
        insert(_size, value);
    }

    @Override
    public Object delete(int index) throws IndexOutOfBoundsException {
        ensureIndexBounds(index);
        
        Object value = _array[index];
        if(index < _size - 1) {
            System.arraycopy(_array, index + 1, _array, index, _size - index);
        }
        _array[--_size] = null;
        
        return value;
    }

    @Override
    public boolean delete(Object value) {
        int index = indexOf(value);
        if(index != -1) {
            delete(index);
            return true;
        }
        
        return false;
    }

    @Override
    public void clear() {
        _array = new Object[_capacity];
        _size = 0;
    }

    @Override
    public Object set(int index, Object value) throws IndexOutOfBoundsException {
        assert value != null : "value can not be null";
        ensureIndexBounds(index);
        
        Object oldValue = _array[index];
        _array[index] = value;
        return oldValue;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        ensureIndexBounds(index);
        
        return _array[index];
    }

    @Override
    public int indexOf(Object value) {
        assert value != null : "value can not be null";
        
        for (int i = 0; i < _size; i++) {
            if(value.equals(_array[i])) {
                return i;
            }
        }
        
        return -1;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public boolean isEmpty() {
        return _size == 0;
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
        //return new ArrayIterator(_array, 0, _size);
    }
}
