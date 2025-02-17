package practise.Assesment;

public class CalculateMinCost {
    public static int minCostToRemove(String password, String reference, int[] cost) {
        // frequency arrays for password and reference
        int[] freqPassword = new int[26];
        int[] freqReference = new int[26];
        
        for (char ch : password.toCharArray()) {
            freqPassword[ch - 'a']++;
        }
        for (char ch : reference.toCharArray()) {
            freqReference[ch - 'a']++;
        }
        
        int minCost = Integer.MAX_VALUE;
        
        // For every character that appears in the reference, check if we need removals.
        // Removing enough copies of one such character will break the subsequence condition.
        for (int i = 0; i < 26; i++) {
            if (freqReference[i] > 0) {
                // If the password contains at least as many copies as needed,
                // then we can remove enough to make it impossible to form the reference.
                if (freqPassword[i] >= freqReference[i]) {
                    // To break the subsequence, we need remaining copies < freqReference[i].
                    // So removals needed = freqPassword[i] - (freqReference[i] - 1)
                    int removalsNeeded = freqPassword[i] - freqReference[i] + 1;
                    int currentCost = removalsNeeded * cost[i];
                    minCost = Math.min(minCost, currentCost);
                }
            }
        }
        
        // If no candidate letter needed any removals, password is already safe.
        return (minCost == Integer.MAX_VALUE) ? 0 : minCost;
    }
    
    public static void main(String[] args) {
        // Example 1
        String password1 = "adefgh";
        String reference1 = "hf";
        int[] cost1 = {1, 0, 0, 2, 4, 4, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println("Example 1 answer: " + minCostToRemove(password1, reference1, cost1)); // Expected output: 4* 1 = 1 i.e f
        
        // Example 2
        String password2 = "abcdcbcb";
        String reference2 = "bcb";
        int[] cost2 = {2, 3, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println("Example 2 answer: " + minCostToRemove(password2, reference2, cost2)); // Expected output: 3*1 = 3 i.e c
    }
}


