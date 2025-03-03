class Solution {
    public int sumSubarrayMins(int[] arr) {
         int mod = (int) 1e9 + 7;
        Stack<Integer> minStack = new Stack<Integer>();
        int sum =0;
        int n = arr.length;
        for (int i=0; i<= n; i++){
            while (!minStack.isEmpty() && (i==n || arr[minStack.peek()]>arr[i])){
                int mid = minStack.pop();
                int left = minStack.isEmpty()? -1 : minStack.peek();
                int right = i;
                sum = (sum + (arr[mid] *(mid-left) * (right - mid))) % mod;
            }
            minStack.push(i);
        }
        return (int) (sum % mod);       
    }
}
