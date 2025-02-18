import java.util.*;

public class ParenthesesPerfection {
    public static int findMaxToBalance(String s, String kitParentheses, int[] efficiencyRatings) {
        // Step 1: Calculate imbalance using stack
        Stack<Character> stack = new Stack<>();
        int imbalanceOpen = 0, imbalanceClose = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // Matched pair
                } else {
                    imbalanceClose++; // Extra ')'
                }
            }
        }
        imbalanceOpen = stack.size(); // Remaining '(' are unmatched

        // Step 2: Use PriorityQueue (Max-Heap) to pick best efficiency ratings
        PriorityQueue<Integer> openHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> closeHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < kitParentheses.length(); i++) {
            if (kitParentheses.charAt(i) == '(') {
                openHeap.offer(efficiencyRatings[i]);
            } else {
                closeHeap.offer(efficiencyRatings[i]);
            }
        }

        // Step 3: Balance the sequence while maximizing efficiency score
        int maxEfficiencyScore = 0;

        // Add needed '(' with the best efficiency scores
        while (imbalanceOpen > 0 && !openHeap.isEmpty()) {
            maxEfficiencyScore += openHeap.poll();
            imbalanceOpen--;
        }

        // Add needed ')' with the best efficiency scores
        while (imbalanceClose > 0 && !closeHeap.isEmpty()) {
            maxEfficiencyScore += closeHeap.poll();
            imbalanceClose--;
        }

        return maxEfficiencyScore;
    }

    // Main function to test Sample Case 0
    public static void main(String[] args) {
        String s = "()";
        String kitParentheses = "(())";
        int[] efficiencyRatings = {4, 2, -3, -3};

        int result = findMaxToBalance(s, kitParentheses, efficiencyRatings);
        System.out.println(result); // Expected Output: 1
    }
}

