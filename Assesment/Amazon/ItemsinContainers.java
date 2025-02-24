import java.util.ArrayList;
import java.util.List;

public class ItemsInContainers {

    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        int n = s.length();
        int[] prefixSum = new int[n + 1]; // Prefix sum array to store cumulative count of '*'
        List<Integer> boundaries = new ArrayList<>(); // List to store positions of '|'

        // Preprocessing: Build prefix sum and record boundary positions
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + (s.charAt(i) == '*' ? 1 : 0); // Update prefix sum
            if (s.charAt(i) == '|') {
                boundaries.add(i); // Record the position of '|'
            }
        }

        // Process each query
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < startIndices.size(); i++) {
            int start = startIndices.get(i) - 1; // Convert to 0-based index
            int end = endIndices.get(i) - 1; // Convert to 0-based index

            // Find the leftmost and rightmost '|' within the range
            int left = findLeftBoundary(boundaries, start);
            int right = findRightBoundary(boundaries, end);

            // If no valid boundaries are found, add 0 to the result
            if (left == -1 || right == -1 || left >= right) {
                result.add(0);
            } else {
                // Calculate the number of '*' between the boundaries using prefix sum
                result.add(prefixSum[right + 1] - prefixSum[left + 1]);
            }
        }

        return result;
    }

    // Helper method to find the leftmost boundary >= start
    private static int findLeftBoundary(List<Integer> boundaries, int start) {
        int left = 0, right = boundaries.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (boundaries.get(mid) < start) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left < boundaries.size() ? boundaries.get(left) : -1;
    }

    // Helper method to find the rightmost boundary <= end
    private static int findRightBoundary(List<Integer> boundaries, int end) {
        int left = 0, right = boundaries.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (boundaries.get(mid) > end) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right >= 0 ? boundaries.get(right) : -1;
    }

    public static void main(String[] args) {
        String s = "|**|*|*";
        List<Integer> startIndices = List.of(1, 1);
        List<Integer> endIndices = List.of(5, 6);

        List<Integer> result = numberOfItems(s, startIndices, endIndices);
        System.out.println("Result: " + result); // Output: [2, 3]
    }
}
