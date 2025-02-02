package practise.leetcode;

public class ShortestDistance1 {
	public static int shortestDistanceI(String[] words, String word1, String word2) {
	    int index1 = -1; // Tracks the most recent position of word1
	    int index2 = -1; // Tracks the most recent position of word2
	    int minDistance = Integer.MAX_VALUE; // Stores the minimum distance

	    for (int i = 0; i < words.length; i++) {
	        if (words[i].equals(word1)) {
	            index1 = i; // Update index1
	        } else if (words[i].equals(word2)) {
	            index2 = i; // Update index2
	        }

	        // If both indices are valid, calculate the distance
	        if (index1 != -1 && index2 != -1) {
	            minDistance = Math.min(minDistance, Math.abs(index1 - index2));
	        }
	    }

	    return minDistance;
	}
	public static void main(String args[]) {
		String [] s = {"practice", "perfect", "coding", "makes"}; //assumes word1 and word2 are different.
		String word1 = "practice";
		String word2 = "perfect";
		System.out.print(shortestDistanceI(s,word1,word2));
	}
}

