import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayToListExample {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        // Convert int[] to List<Integer>
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());

        // Print result
        System.out.println(list);  // Output: [1, 2, 3, 4, 5]
    }
}

