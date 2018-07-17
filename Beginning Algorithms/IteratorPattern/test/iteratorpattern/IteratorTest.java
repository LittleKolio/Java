package iteratorpattern;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class IteratorTest {
    
    private static String[] array = {"A","B","C","D","E","F","G"};
    private static Repository repo;
    
    public IteratorTest() {
        repo = new Repository();
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
        
        for (int i = 0; i < array.length; i++) {
            repo.add(array[i]);
        }
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
        IIterator iter = repo.getIterator(1, 3);

        iter.first();
        assertFalse(iter.isDone());
        assertSame(array[1], iter.current());
        
        iter.next();
        assertFalse(iter.isDone());
        assertSame(array[2], iter.current());
        
        iter.next();
        assertFalse(iter.isDone());
        assertSame(array[3], iter.current());
        
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
