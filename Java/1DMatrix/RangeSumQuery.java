public class RangeSumQuery {
    public static int[] computePrefixSum(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        return prefix;
    }

    public static int getRangeSum(int[] prefix, int L, int R) {
        if (L == 0) return prefix[R];
        return prefix[R] - prefix[L - 1];
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 8, 7, 4};
        int[] prefixSum = computePrefixSum(arr);

        System.out.println(getRangeSum(prefixSum, 1, 3)); // Output: 16 (6+2+8)
        System.out.println(getRangeSum(prefixSum, 2, 5)); // Output: 21 (2+8+7+4)
    }
}

