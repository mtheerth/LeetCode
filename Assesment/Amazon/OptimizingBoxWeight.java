import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptimizingBoxWeight {

    public static List<Integer> optimizingBoxWeights(int[] arr) {
        // Sort the array in descending order
        Arrays.sort(arr);
        reverseArray(arr);

        // Calculate the total sum of the array
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // Greedily select the largest elements until the subset sum > totalSum / 2
        int subsetSum = 0;
        List<Integer> subset = new ArrayList<>();
        for (int num : arr) {
            subsetSum += num;
            subset.add(num);
            if (subsetSum > totalSum / 2) {
                break;
            }
        }

        return subset;
    }

    // Helper function to reverse the array
    private static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 5, 6, 2};
        List<Integer> result = optimizingBoxWeights(arr);
        System.out.println(result); // Output: [7, 6]
    }
}
