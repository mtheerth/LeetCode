import java.util.Arrays;
import java.util.stream.Collectors;

public class StringJoin {
    public static void main(String[] args) {
        String input = "how are you ";
        
        String output = Arrays.stream(input.split(" "))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining("-", "[", "]"));
                
        System.out.println(output); // Output: [how-are-you]
    }
}
