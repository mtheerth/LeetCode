import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Count {

 public static void main(String[] args) {
   int [] arr = {1,0,1,0,1,0,1};
   int count = (int) Arrays.stream(arr).filter(x -> x == 1).count(); 
   System.out.println(count);
  }

}

