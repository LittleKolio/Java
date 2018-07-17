package iteratorpattern;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FilterIteratorTest {
    
    private static String[] array = {"A","B","C","D","E","F","G"};
    
    private class DummyPredicate implements IPredicate{
        private IIterator _iterator;
        private boolean _result;
        
        public DummyPredicate(boolean result, IIterator iterator) {
            _iterator = iterator;
            _result = result;
            _iterator.first();
        }
        
        @Override
        public boolean evaluate(Object object) {
            assertSame(_iterator.current(), object);
            _iterator.next();
            return _result;
        }
        
    }
    
    public FilterIteratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void hello() {}
}
