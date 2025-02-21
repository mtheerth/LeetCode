import java.util.List;
import java.util.stream.Collectors;

public class ListToArrayExample {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5); // Immutable List (Java 9+)

        // Convert List<Integer> to int[]
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();

        // Print result
        for (int num : array) {
            System.out.print(num + " ");  // Output: 1 2 3 4 5
        }
    }
}

