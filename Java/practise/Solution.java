import java.util.HashMap;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Test case 1:");
        System.out.println("Input: nums = [1, 1, 1], k = 2");
        System.out.println("Output: " + solution.subarraySum(nums1, k1));

        // Test case 2
        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("\nTest case 2:");
        System.out.println("Input: nums = [1, 2, 3], k = 3");
        System.out.println("Output: " + solution.subarraySum(nums2, k2));

        // Test case 3
        int[] nums3 = {1, -1, 0};
        int k3 = 0;
        System.out.println("\nTest case 3:");
        System.out.println("Input: nums = [1, -1, 0], k = 0");
        System.out.println("Output: " + solution.subarraySum(nums3, k3));
    }
}

