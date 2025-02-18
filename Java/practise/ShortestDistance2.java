package practise.leetcode;

import java.util.HashMap;
import java.util.ArrayList;

class WordDistance {
    private HashMap<String, ArrayList<Integer>> wordIndices;

    public WordDistance(String[] words) {
        wordIndices = new HashMap<>();
        // Preprocess the list to store indices of each word
        for (int i = 0; i < words.length; i++) {
            wordIndices.putIfAbsent(words[i], new ArrayList<>());
            wordIndices.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> indices1 = wordIndices.get(word1);
        ArrayList<Integer> indices2 = wordIndices.get(word2);
        int minDistance = Integer.MAX_VALUE;

        // Use two pointers to find the minimum distance
        int i = 0, j = 0;
        while (i < indices1.size() && j < indices2.size()) {
            int dist = Math.abs(indices1.get(i) - indices2.get(j));
            minDistance = Math.min(minDistance, dist);

            // Move the pointer with the smaller index
            if (indices1.get(i) < indices2.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        return minDistance;
    }
}
public class ShortestDistance2 {
	public static void main(String args[]) {
		String [] s = {"practice","makes", "perfect", "coding", "makes"}; //assumes word1 and word2 are different.
		WordDistance wd = new WordDistance(s);
		String word1 = "makes";
		String word2 = "perfect";
		System.out.print(wd.shortest(word1,word2));
	}

}

