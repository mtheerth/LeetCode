class Solution {
    public int maxArea(int[] height) {
        int output =0 ;
        int left = 0;
        int right = height.length -1;
        while (left < right){
            int val1 = Math.min(height[left], height[right]);
            int val2 = right - left;
            output = Math.max(output, val1 * val2);
            if (height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return output;
    }
}
