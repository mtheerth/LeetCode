class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0; // Current boundary of the current jump
        int farthest = 0;   // Farthest index we can reach

        // Loop through the array, but stop at the second-to-last index
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]); // Update the farthest reachable index

            // If we reach the current boundary, make a jump
            if (i == currentEnd) {
                jumps++;              // Increment jump count
                currentEnd = farthest; // Update the boundary to the farthest reachable index

                // If we can already reach the end, break early
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
}
}
