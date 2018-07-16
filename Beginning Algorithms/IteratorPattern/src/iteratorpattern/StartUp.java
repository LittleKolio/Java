package iteratorpattern;

public class StartUp {

    public static void main(String[] args) {
        
        Repository repo = new Repository();
        
        repo.add("A");
        repo.add("B");
        repo.add("C");
        repo.add("D");
        repo.add("E");

        IIterator iter = repo.getIterator(1, 3);
        
//        iter.first();
        
//        while(!iter.isDone()){
//            String symbol = (String)iter.current();
//            print(symbol);
//            iter.next();
//        }
        
        for(iter.first(); !iter.isDone(); iter.next()){
             String symbol = (String)iter.current();
             print(symbol);
        } 
    }
    
    public static void print(String symbol){
        System.out.println("Symbol : " + symbol);
    }
}
