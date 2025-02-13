import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class SortRev {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Banana", "Apple", "Cherry", "Avocado");
        List<String> sortedWords = words.stream()
                                        .sorted(Comparator.reverseOrder())
                                        .collect(Collectors.toList());
        System.out.println("Sorted words: " + sortedWords);
    }
}
