import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Handle edge case where k is zero
        if (k == 0) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0 && nums[i - 1] == 0) {
                    return true;
                }
            }
            return false;
        }
       Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1); // Initialize with remainder 0 at index -1

        int cumulativeSum = 0;
        int remainder =0;
        for (int i = 0; i < nums.length; i++) {
            cumulativeSum = remainder + nums[i];
             remainder = cumulativeSum % k;

            // If remainder is negative, adjust it to be positive
            if (remainder < 0) {
                remainder += k;
            }

            // Check if this remainder has been seen before
            if (remainderMap.containsKey(remainder)) {
                // Ensure the subarray has at least two elements
                if (i - remainderMap.get(remainder) > 1) {
                    return true;
                }
            } else {
                // Store the first occurrence of this remainder
                remainderMap.put(remainder, i);
            }
        }

        return false;
    }
}
