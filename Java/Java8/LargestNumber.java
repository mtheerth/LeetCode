import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class LargestNumber {
    public static void main(String[] args) {
        int[] arr = {3, 4, 9, 5, 30, 34};

        String result = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> (b + a).compareTo(a + b)) // Descending order by concatenation
                .collect(Collectors.joining());

        // Edge case: handle numbers like [0,0]
        if (result.startsWith("0")) {
            result = "0";
        }

        System.out.println(result); // Output: 95434330
    }
}

