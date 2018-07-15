package iteratorpattern;

public class StartUp {

    public static void main(String[] args) {
        Repository repo = new Repository();
        repo.items.add("A");
        repo.items.add("B");
        repo.items.add("C");
        repo.items.add("D");
        repo.items.add("F");
        repo.items.add("G");

        Iterator iter = repo.getIterator();
        
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
