package iteratorpattern;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class IteratorTest {
    
    private static String[] _array = {"A","B","C","D","E","F","G"};
    private static Repository _repo;
    
    public IteratorTest() {
        _repo = new Repository();
    }
    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
    
    @Before
    public void setUp() {
        for (int i = 0; i < _array.length; i++) {
            _repo.add(_array[i]);
        }
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testIterationBounds() {
        IIterator iter = _repo.getIterator(1, 3);

        iter.first();
        assertFalse(iter.isDone());
        assertSame(_array[1], iter.current());
        
        iter.next();
        assertFalse(iter.isDone());
        assertSame(_array[2], iter.current());
        
        iter.next();
        assertFalse(iter.isDone());
        assertSame(_array[3], iter.current());
        
        iter.next();
        assertTrue(iter.isDone());
        try {
            iter.current();
            fail();
        } catch (IteratorOutOfBoundsException ex){
            assertSame("Current (index) out of bounds!", ex.getMessage());
        }
    }
}
