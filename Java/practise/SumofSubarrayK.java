class SumofSubarrayK {
public static long sumOfAllSubarrays(int[] nums, int k) {
    if (nums == null || nums.length < k || k <= 0) {
        return 0;
    }
    
    long totalSum = 0;
    int windowSum = 0;
    
    // Calculate sum of first window
    for (int i = 0; i < k; i++) {
        windowSum += nums[i];
    }
    totalSum += windowSum;
    
    // Slide the window and update sums
    for (int i = k; i < nums.length; i++) {
        windowSum = windowSum - nums[i - k] + nums[i];
        totalSum += windowSum;
    }
    
    return totalSum;
}
public static void main(String[] args) 
{ 
    int arr[] = { 1, 2, 3, 4, 5, 6 }; 
    int n = arr.length; 
    int k = 3; 
   sumOfAllSubarrays(arr,k);
}
}
