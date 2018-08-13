package lists;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public abstract class ListTest {
    protected static Object VALUE_A = "A";
    protected static Object VALUE_B = "B";
    protected static Object VALUE_C = "C";
    
    protected ICustomList _list;

    protected ListTest() {
    }
    
    //@Before
    //public void setUp() {
    //   _list = new CustomArrayList();
    //}
    
    @Test
    public void testInsertInToEmptyList() {
        assertEquals(0, _list.size());
        assertTrue(_list.isEmpty());
        
        _list.insert(0, VALUE_A);
        
        assertEquals(1, _list.size());
        assertFalse(_list.isEmpty());
        assertSame(VALUE_A, _list.get(0));
    }
    
    @Test
    public void testInsertBetweenElements() {
        _list.insert(0, VALUE_A);
        _list.insert(1, VALUE_B);
        _list.insert(1, VALUE_C);
        
        assertEquals(3, _list.size());
        assertSame(VALUE_A, _list.get(0));
        assertSame(VALUE_C, _list.get(1));
        assertSame(VALUE_B, _list.get(2));
    }
    
    @Test
    public void testInsertBeforeFirstElement() {
        _list.insert(0, VALUE_A);
        _list.insert(0, VALUE_B);
        
        assertEquals(2, _list.size());
        assertSame(VALUE_B, _list.get(0));
        assertSame(VALUE_A, _list.get(1));
    }
    
    @Test
    public void testInsertAfterLastElement() {
        _list.insert(0, VALUE_A);
        _list.insert(1, VALUE_B);
        
        assertEquals(2, _list.size());
        assertSame(VALUE_A, _list.get(0));
        assertSame(VALUE_B, _list.get(1));
    }
    
    @Test
    public void testInsertOutOfBounds() {
        try {
            _list.insert(-1, VALUE_A);
            fail();
        } catch(IndexOutOfBoundsException ex) {
            // expected
        }

        try {
            _list.insert(1, VALUE_B);
            fail();
        } catch(IndexOutOfBoundsException ex) {
            // expected
        }
    }
    
    @Test
    public void testAdd() {
        _list.add(VALUE_A);
        _list.add(VALUE_B);
        _list.add(VALUE_C);

        assertEquals(3, _list.size());
        assertSame(VALUE_A, _list.get(0));
        assertSame(VALUE_B, _list.get(1));
        assertSame(VALUE_C, _list.get(2));
    }
    
    @Test
    public void testSet() {
        _list.insert(0, VALUE_A);
        assertSame(VALUE_A, _list.get(0));

        assertSame(VALUE_A, _list.set(0, VALUE_B));
        assertSame(VALUE_B, _list.get(0));
    }
    
    @Test
    public void testGetOutOfBounds() {
        try {
            _list.get(-1);
            fail();
        } catch(IndexOutOfBoundsException ex) {
            // expected
        }

        try {
            _list.get(0);
            fail();
        } catch(IndexOutOfBoundsException ex) {
            // expected
        }
        
        _list.add(VALUE_A);
        
        try {
            _list.get(-1);
            fail();
        } catch(IndexOutOfBoundsException ex) {
            // expected
        }
    }
    
    @Test
    public void testSetOutOfBounds() {
        try {
            _list.set(-1, VALUE_A);
            fail();
        } catch(IndexOutOfBoundsException ex) {
            // expected
        }

        try {
            _list.set(0, VALUE_B);
            fail();
        } catch(IndexOutOfBoundsException ex) {
            // expected
        }
        
        _list.insert(0, VALUE_C);
        
        try {
            _list.set(1, VALUE_C);
            fail();
        } catch(IndexOutOfBoundsException ex) {
            // expected
        }
    }
    
    @Test
    public void testDeleteOnlyElement() {
        _list.add(VALUE_A);

        assertEquals(1, _list.size());
        assertSame(VALUE_A, _list.get(0));
        
        assertSame(VALUE_A, _list.delete(0));
        
        assertEquals(0, _list.size());
    }
    
    @Test
    public void testDeleteFirstElement() {
        _list.add(VALUE_A);
        _list.add(VALUE_B);
        _list.add(VALUE_C);

        assertEquals(3, _list.size());
        assertSame(VALUE_A, _list.delete(0));
        
        assertEquals(2, _list.size());
        assertSame(VALUE_B, _list.get(0));
        assertSame(VALUE_C, _list.get(1));
    }
    
    @Test
    public void testDeleteLastElement() {
        _list.add(VALUE_A);
        _list.add(VALUE_B);
        _list.add(VALUE_C);

        assertEquals(3, _list.size());
        assertSame(VALUE_C, _list.delete(2));
        
        assertEquals(2, _list.size());
        assertSame(VALUE_A, _list.get(0));
        assertSame(VALUE_B, _list.get(1));
    }
    
    @Test
    public void testDeleteMiddleElement() {
        _list.add(VALUE_A);
        _list.add(VALUE_B);
        _list.add(VALUE_C);

        assertEquals(3, _list.size());
        assertSame(VALUE_B, _list.delete(1));
        
        assertEquals(2, _list.size());
        assertSame(VALUE_A, _list.get(0));
        assertSame(VALUE_C, _list.get(1));
    }
    
    @Test
    public void testDeleteOutOfBoundsElement() {
        try {
            _list.delete(-1);
            fail();
        } catch(IndexOutOfBoundsException ex) {
            // expected
        }
        
        try {
            _list.delete(0);
            fail();
        } catch(IndexOutOfBoundsException ex) {
            // expected
        }
    }
    
    @Test
    public void testDeleteByValue() {
        _list.add(VALUE_A);
        _list.add(VALUE_B);
        _list.add(VALUE_A);
        
        assertEquals(3, _list.size());
        assertTrue(_list.delete(VALUE_A));
        
        assertEquals(2, _list.size());
        assertSame(VALUE_B, _list.get(0));
        assertSame(VALUE_A, _list.get(1));
        
        assertTrue(_list.delete(VALUE_A));
        
        assertEquals(1, _list.size());
        assertSame(VALUE_B, _list.get(0));
        
        assertTrue(_list.delete(VALUE_B));
        
        assertEquals(0, _list.size());
    }
    
    @Test
    public void testIndexOf() {
        _list.add(VALUE_A);
        _list.add(VALUE_B);
        _list.add(VALUE_A);
        
        assertEquals(0, _list.indexOf(VALUE_A));
        assertEquals(1, _list.indexOf(VALUE_B));
        assertEquals(-1, _list.indexOf(VALUE_C));
    }
    
    @Test
    public void testContains() {
        _list.add(VALUE_A);
        _list.add(VALUE_B);
        _list.add(VALUE_A);
        
        assertTrue(_list.contains(VALUE_A));
        assertTrue(_list.contains(VALUE_B));
        assertFalse(_list.contains(VALUE_C));
    }
    
    @Test
    public void testClear() {
        _list.add(VALUE_A);
        _list.add(VALUE_B);
        _list.add(VALUE_C);
        
        assertEquals(3, _list.size());
        assertFalse(_list.isEmpty());
        
        _list.clear();
        
        assertEquals(0, _list.size());
        assertTrue(_list.isEmpty());
    }
}
