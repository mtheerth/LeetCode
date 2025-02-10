public class MaxProduct{
    // Example usage:

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Swap maxProduct and minProduct if the current number is negative
            if (nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            // Update maxProduct and minProduct
            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);

            // Update the result
            result = Math.max(result, maxProduct);
        }

        return result;
    }
    public static void main(String[] args) {
        MaxProduct solution = new MaxProduct();
        int[] nums = {-2, 3,-4};
        System.out.println(solution.maxProduct(nums));  // Output: 24
    }
} 
