import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a hashmap to store the value and its index
        Map<Integer, Integer> indexMap = new HashMap<>();

        // Iterate over the array elements
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i]; // Current element value
            int complement = target - current; // The complement which, when added to 'current', equals 'target'

            // Check if the complement is already in the map
            if (indexMap.containsKey(complement)) {
                // If complement is found, return the indices of the two numbers
                return new int[] {indexMap.get(complement), i};
            }

            // Store the current value and its index in the map
            indexMap.put(current, i);
        }
        // Note: The problem statement guarantees that there will always be exactly one solution,
        // so no need to return null or throw an exception here.
        throw new IllegalArgumentException("No two sum solution found");
    }
}
