class MinLenSubArray {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = n + 1;
        int sum = 0;
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        
        return minLength <= n ? minLength : 0;
    }
    public static void main(String args[]){
        int target = 5;
        int[] nums = {4,4,4}; //out to be 2 i.e 4+4 8 >= 5.
        System.out.println(minSubArrayLen(target,nums));
    }
}

