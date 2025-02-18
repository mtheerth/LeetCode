package practise.leetcode;

public class ShortestDistance3 {
	public static int shortestDistanceIII(String[] words, String word1, String word2) {
	    int minDistance = Integer.MAX_VALUE; // Stores the minimum distance

	    if (word1.equals(word2)) {
            for (int i = 0, prevIndex = -1; i < words.length; ++i) {
                if (words[i].equals(word1)) {
                    if (prevIndex != -1) {
                        // Update the shortest distance between two occurrences of word1
                    	minDistance = Math.min(minDistance, i - prevIndex);
                    }
                    prevIndex = i; // Update prevIndex to the current index
                }
            }
        }

	    return minDistance;
	}
	public static void main(String args[]) {
		String [] s = {"practice","makes", "perfect", "coding", "makes","makes"}; //assumes word1 and word2 are different.
		String word1 = "makes";
		String word2 = "makes";
		System.out.print(shortestDistanceIII(s, word1,word2));
	}


}

