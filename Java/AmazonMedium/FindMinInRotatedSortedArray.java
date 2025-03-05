public class FindMinInRotatedSortedArray {

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // If the array is not rotated, return the first element
        if (nums[left] < nums[right]) {
            return nums[left];
        }

        // Perform binary search to find the smallest element
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if the mid element is greater than the right element
            if (nums[mid] > nums[right]) {
                left = mid + 1; // The smallest element is in the right half
            } else {
                right = mid; // The smallest element is in the left half (including mid)
            }
        }

        // When left == right, we've found the smallest element
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2}; // Example rotated sorted array
        int minElement = findMin(nums);
        System.out.println("The smallest element is: " + minElement);
    }
}
