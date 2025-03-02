class Solution {
    public long subArrayRanges(int[] arr) {
        int n = arr.length;
        long sumMax = 0, sumMin = 0;

        // Monotonic increasing stack (for minimum elements)
        Stack<Integer> minStack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!minStack.isEmpty() && (i == n || arr[minStack.peek()] > arr[i])) {
                int j = minStack.pop();
                int left = minStack.isEmpty() ? -1 : minStack.peek();
                int right = i;
                System.out.println(left + " " + j + " " +right);
                sumMin += (long) arr[j] * (j - left) * (right - j);
                System.out.println(sumMin );
            }
             System.out.println(i);
            minStack.push(i);
        }
        System.out.println(sumMin + "summin");

        // Monotonic decreasing stack (for maximum elements)
        Stack<Integer> maxStack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!maxStack.isEmpty() && (i == n || arr[maxStack.peek()] < arr[i])) {
                int j = maxStack.pop();
                int left = maxStack.isEmpty() ? -1 : maxStack.peek();
                int right = i;
                sumMax += (long) arr[j] * (j - left) * (right - j);
            }
            maxStack.push(i);
        }
System.out.println(sumMax + "sumMax");
        return sumMax - sumMin;
    }
}

