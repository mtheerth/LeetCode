import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class PredicateFilter {
    public static void main(String[] args) {
        // Generate random numbers (1 to 10)
        List<Integer> numbers = new Random()
                .ints(10, 1, 11)  // 10 random numbers (1-10)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Original List: " + numbers);

        // Define a Predicate to check if number > 2
        Predicate<Integer> greaterThanTwo = num -> num > 2;

        // Apply the Predicate in filter()
        List<Integer> filteredNumbers = numbers.stream()
                .filter(greaterThanTwo)
                .collect(Collectors.toList());

        System.out.println("Numbers > 2: " + filteredNumbers);
    }
}
