import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximizeGroupCount {

    public static int maximizeGroupCount(List<Integer> products) {
        // Sort the list in descending order
        products.sort(Collections.reverseOrder());

        int groupCount = 0;

        // Iterate through the sorted list
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) > 0) {
                groupCount++; // Form a group
            }
        }

        return groupCount;
    }

    public static void main(String[] args) {
        // Example input
        List<Integer> products = Arrays.asList(2, 3, 4, 1);

        // Calculate the maximum number of groups
        int result = maximizeGroupCount(products);

        // Output the result
        System.out.println("Maximum number of groups: " + result);
    }
}
