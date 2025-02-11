public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        // If the array is not rotated, return the first element
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        
        // Binary search to find the minimum element
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Check if the mid element is greater than the right element
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return nums[left];
    }

    // Example usage
    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray solution = new FindMinimumInRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(solution.findMin(nums));  // Output: 0
    }
}
