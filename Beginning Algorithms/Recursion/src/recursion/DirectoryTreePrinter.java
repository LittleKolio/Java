package recursion;

import java.io.File;
import java.util.Arrays;

public final class DirectoryTreePrinter {
    private static final String SPACES = "  ";
    
    public static void main(String[] args) {
        assert args != null : "args can not be null!";
        
        System.out.println(Arrays.toString(args));
        
        if (args.length != 1) {
            System.err.println("Usage: DirectoryTreePrinter <dir>");
            System.exit(4);
        }
        
        print(new File(args[0]), "");
    }

    private static void print(File file, String indent) {
        assert file != null : "file can not be null";
        assert indent != null : "indent can not be null";
        
        System.out.print(indent);
        System.out.println(file.getName());
        
        if(file.isDirectory()) {
            print(file.listFiles(), indent + SPACES);
        }
    }
    
        private static void print(File[] files, String indent) {
        assert files != null : "file can not be null";
        
        for (int i = 0; i < files.length; i++) {
            print(files[i], indent);
        }
    }
}
