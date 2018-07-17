package iteratorpattern;

public class StartUp {

    public static void main(String[] args) {
        
        Repository repo = new Repository();
        
        repo.add("A");
        repo.add("B");
        repo.add("C");
        repo.add("D");
        repo.add("E");

        IIterator iterator = repo.getIterator(1, 3);
        
//        iter.first();
//        while(!iter.isDone()){
//            String symbol = (String)iter.current();
//            print(symbol);
//            iter.next();
//        }
        
        for(iterator.first(); !iterator.isDone(); iterator.next()){
             String symbol = (String)iterator.current();
             print(symbol);
        }
        
        IIterator revIterator = repo.getReverseIterator(3, 3);

        for(revIterator.first(); !revIterator.isDone(); revIterator.next()){
             String symbol = (String)revIterator.current();
             print(symbol);
        } 
    }
    
    public static void print(String symbol){
        System.out.println("Symbol : " + symbol);
    }
}
