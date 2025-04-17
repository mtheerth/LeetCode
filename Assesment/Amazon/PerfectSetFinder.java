/*Given a set of numbers
Find Maximum size of a perfect set
A perfect set of size n satifies the condition perfect[i+1]=perfect[i]*perfect[i]
where 1<=i<=n and n<=10^5
Perfect set should have atleast 2 numbers
[625,2,4,5,25] has 2 perfect sets [2,4] and [5,25,625]
Answer will be 3 in this case. in java
*/

import java.util.*;

public class PerfectSetFinder {

    public static int maxPerfectSetSize(int[] nums) {
        Set<Long> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add((long) num);
        }

        int maxSize = 0;

        for (int num : nums) {
            int size = 1;
            long curr = num;
            while (numSet.contains(curr * curr)) {
                curr = curr * curr;
                size++;
            }
            if (size >= 2) {
                maxSize = Math.max(maxSize, size);
            }
        }

        return maxSize;
    }

    public static void main(String[] args) {
        int[] nums = {625, 2, 4, 5, 25};
        System.out.println("Max perfect set size: " + maxPerfectSetSize(nums));
    }
}

