package lists;

import java.util.Iterator;

public class CustomLinkedList implements ICustomList{

    private static class Element {
        private Object _value;
        private Element _previous;
        private Element _next;
        
        public Element(Object value) {
            setValue(value);
        }

        public void setValue(Object value) {
            _value = value;
        }
        
        public Object getValue() {
            return _value;
        }
        
        public void setPrevious(Element previous) {
            assert previous != null : "previous can not be null";
            
            _previous = previous;
        }
        
        public Element getPrevious() {
            return _previous;
        }
        
        public void setNext(Element next) {
            assert next != null : "next can not be null";
            
            _next = next;
        }
        
        public Element getNext() {
            return _next;
        }
        
        public void attachBefore(Element next) {
            assert next != null : "element can not be null";
            
            Element previous = next.getPrevious();
            setNext(next);
            setPrevious(previous);
            
            next.setPrevious(this);
            previous.setNext(this);
        }
        
        public void detach() {
            _next.setPrevious(_previous);
            _previous.setNext(_next);
        }
    }
        
    private Element _headAndTail;
    private int _size;
    
    public CustomLinkedList() {
        _headAndTail = new Element(null);
        clear();
    }
    
    private Element getElement(int index) {
        Element element = _headAndTail.getNext();
        int count = index;

        if(index > _size / 2) {
            
            element = _headAndTail.getPrevious();
            count = _size - index;
            
            for (int i = count; i > 0; i--) {
                element = element.getPrevious();
            }
        } else if (index <= _size / 2) {
            
            for (int i = count; i > 0; i--) {
                element = element.getNext();
            }
        }
        
        return element;
    }

    private void checkOutOfBounds(int index) {
        if(index < 0 || index >= _size) {
            throw new IndexOutOfBoundsException();
        }
    }
    
    @Override
    public void insert(int index, Object value) throws IndexOutOfBoundsException {
        assert value != null : "Value cannot be null!";
        
        if(index < 0 || index > _size) {
            throw new IndexOutOfBoundsException();
        }
        
        Element element = new Element(value);
        element.attachBefore(getElement(index));
        _size++;
    }

    @Override
    public void add(Object value) {
        insert(_size, value);
    }

    @Override
    public Object delete(int index) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        
        Element element = getElement(index);
        element.detach();
        _size--;
        
        return element.getValue();
    }

    @Override
    public boolean delete(Object value) {
        assert value != null : "Value cannot be null!";
        
        for (Element e = _headAndTail.getNext(); 
            e != _headAndTail; 
            e = e.getNext()) {
            
            if(value.equals(e.getValue())) {
                e.detach();
                _size--;
                
                return true;
            }
        }
        
        return false;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object set(int index, Object value) throws IndexOutOfBoundsException {
        assert value != null : "Value cannot be null!";
        checkOutOfBounds(index);
        Element element = getElement(index);
        Object oldValue = element.getValue();
        element.setValue(value);
        
        return oldValue;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        return getElement(index).getValue();
    }

    @Override
    public int indexOf(Object value) {
        assert value != null : "Value cannot be null!";
        
        int index = 0;
        
        for (Element e = _headAndTail.getNext(); 
            e != _headAndTail; 
            e = e.getNext()) {
            
            if(value.equals(e.getValue())) {
                return index;
            }
            
            index++;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
