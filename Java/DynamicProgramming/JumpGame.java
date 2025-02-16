public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= n - 1) {
                return true;
            }
        }
        return maxReach >= n - 1;
    }

    public static void main(String[] args) {
        JumpGame game = new JumpGame();
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(game.canJump(nums1)); // true

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(game.canJump(nums2)); // false
    }
}
