import java.util.*;

public class Main {
    static void removeAnagrams(String arr[], int N) {
        Vector<String> ans = new Vector<>();
        HashSet<String> found = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String word = sort(arr[i]);
            if (!found.contains(word)) {
                ans.add(arr[i]);
                found.add(word);
            }
        }
        Collections.sort(ans);
        for (String s : ans) {
            System.out.print(s + " ");
        }
    }

    static String sort(String inputString) {
        char tempArray[] = inputString.toLowerCase().toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

    public static void main(String[] args) {
        String arr[] = { "Scaler", "Lacers", "Aacdemy", "Academy" };
        int N = 4;
        removeAnagrams(arr, N);
    }
}

