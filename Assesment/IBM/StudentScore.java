import java.util.Arrays;

public class StudentScores {
    public int maxSubjectsPass(int[] scores, int[] requiredScores, int additionalScore) {
        if (scores.length != requiredScores.length) {
            throw new IllegalArgumentException("Scores and required scores arrays must have the same length");
        }

        int n = scores.length;
        int[] differences = new int[n];
        int passedSubjects = 0;

        // Calculate differences and count initially passed subjects
        for (int i = 0; i < n; i++) {
            if (scores[i] >= requiredScores[i]) {
                passedSubjects++;
                differences[i] = 0;
            } else {
                differences[i] = requiredScores[i] - scores[i];
            }
        }

        // Sort differences in ascending order
        Arrays.sort(differences);

        // Distribute additional score
        for (int i = 0; i < n && additionalScore > 0; i++) {
            if (differences[i] > 0 && additionalScore >= differences[i]) {
                additionalScore -= differences[i];
                passedSubjects++;
            }
        }

        return passedSubjects;
    }
    public static void main(String[] args) {
        StudentScores solution = new StudentScores();

        // Test case 1
        int[] scores1 = {70, 85, 90, 60};
        int[] requiredScores1 = {65, 80, 85, 70};
        int additionalScore1 = 15;
        int result1 = solution.maxSubjectsPass(scores1, requiredScores1, additionalScore1);
        System.out.println("Test case 1 result: " + result1);

        // Test case 2
        int[] scores2 = {50, 60, 70, 80, 90};
        int[] requiredScores2 = {55, 65, 75, 85, 95};
        int additionalScore2 = 20;
        int result2 = solution.maxSubjectsPass(scores2, requiredScores2, additionalScore2);
        System.out.println("Test case 2 result: " + result2);

        // Test case 3
        int[] scores3 = {40, 50, 60};
        int[] requiredScores3 = {70, 80, 90};
        int additionalScore3 = 100;
        int result3 = solution.maxSubjectsPass(scores3, requiredScores3, additionalScore3);
        System.out.println("Test case 3 result: " + result3);
    }
}

