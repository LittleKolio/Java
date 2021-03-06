package lists;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayListTest extends ListTest{
   
    public ArrayListTest() {
    }
    
    @Before
    public void setUp() {
        _list = new CustomArrayList();
    }
    
    @Test
    public void testResizeBeyondInitialCapacity() {
        _list = new CustomArrayList(1);
        
        _list.add(VALUE_A);
        _list.add(VALUE_A);
        _list.add(VALUE_A);
        
        assertEquals(3, _list.size());
        
        assertSame(VALUE_A, _list.get(0));
        assertSame(VALUE_A, _list.get(1));
        assertSame(VALUE_A, _list.get(2));
    }
    
    @Test
    public void testDeleteFromLastElementInArray() {
        _list = new CustomArrayList(1);
        
        _list.add(new Object());
        
        _list.delete(0);
    }
}
