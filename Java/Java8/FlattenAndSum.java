import java.util.Arrays;
import java.util.List;

public class FlattenAndSum {
    public static void main(String[] args) {
        List<List<Integer>> listOfLists = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5, 6),
            Arrays.asList(7, 8, 9)
        );
        int sum = listOfLists.stream()
                            .flatMap(List::stream)
                            .mapToInt(Integer::intValue)
                            .sum();
        System.out.println("Sum of all elements: " + sum);
    }
}
