class Solution {
    public int[] sortedSquares(int[] nums) {
        int [] result = new int[nums.length];
        int left =0 ;
        int right = nums.length-1;
        int arrayLast = right;
        while (left <= right){
            if (Math.abs(nums[left]) > Math.abs(nums[right])){
                result[arrayLast--] =  nums[left] * nums[left];
                left++;
            } else {
                result[arrayLast--] =  nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
}
