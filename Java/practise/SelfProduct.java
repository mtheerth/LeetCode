class SelfProduct {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        // ans = { 1,1,1,1}
        int curr = 1;
        for(int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        } 
        // ans = { 1,1,2,6}
        curr = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        // ans = {1(*24),1(*12)),2(*4),6(*1)} 
        //ans = {24,12,8,6}
        return ans;
    }
    public static void main(String args[]){
        int[] input = {1,2,3,4};
       System.out.println( productExceptSelf(input));
    }
}
