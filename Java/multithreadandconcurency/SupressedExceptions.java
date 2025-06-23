import java.io.*;

public class OverriddenByFinally {
    public static void main(String[] args) {
        try {
            readFile();
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e);
        }
    }

    static void readFile() {
        FileInputStream fis = null;
       Exception original = null; 
       try {
            fis = new FileInputStream("nonexistent.txt");
        } catch (FileNotFoundException e) {
         //   throw new RuntimeException("File not found wrapped", e);
          originial = e;
        } finally {
            // This will override any above exception
           // throw new RuntimeException("Runtime in finally");
          // above line will supress the catch block exception
          RuntimeException cleanupEx = new RuntimeException("Runtime in finally");
        if (original != null) {
            cleanupEx.addSuppressed(original); // keep both
        }
        throw cleanupEx;
        }
    }
}

