package iteratorpattern;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FilterIteratorTest {
    
    private static String[] _array = {"A","B","C"};
    private static Repository _repo;
    private IIterator _expectedIterator;
    private IIterator _underlyingIterator;

    
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
    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
    
    @Before
    public void setUp() {
        _repo = new Repository();
        for (int i = 0; i < _array.length; i++) {
            _repo.add(_array[i]);
        }
        
        _expectedIterator = new Iterator(_repo);
        _underlyingIterator = new Iterator(_repo);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testIterationWhenPredicateReturnsTrue() {
        IIterator iterator = new FilterIterator(
            _underlyingIterator,
            new DummyPredicate(true, _expectedIterator)
        );
        
        iterator.first();
        assertFalse(iterator.isDone());
        assertSame(_array[0], iterator.current());
        
        iterator.next();
        assertFalse(iterator.isDone());
        assertSame(_array[1], iterator.current());
        
        iterator.next();
        assertFalse(iterator.isDone());
        assertSame(_array[2], iterator.current());
        
        iterator.next();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch(IteratorOutOfBoundsException ex) {
            assertSame("Current (index) out of bounds!", ex.getMessage());
        }
        
        assertTrue(_expectedIterator.isDone());
        assertTrue(_underlyingIterator.isDone());

    }
    
    @Test
    public void testIterationWhenPredicateReturnsFalse() {
        IIterator iterator = new FilterIterator(
            _underlyingIterator,
            new DummyPredicate(false, _expectedIterator)
        );
        
        iterator.first();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch(IteratorOutOfBoundsException ex) {
            assertSame("Current (index) out of bounds!", ex.getMessage());
        }
        
        assertTrue(_expectedIterator.isDone());
        assertTrue(_underlyingIterator.isDone());
    }
}
