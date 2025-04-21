import java.util.*;

public class BridgeCarProblem {
    public static int minRemovals(int[] weights, int capacity) {
        List<Integer> filtered = new ArrayList<>();
        int removals = 0;

        for (int w : weights) {
            int size = filtered.size();
            if (size == 0) {
                filtered.add(w);
            } else {
                int last = filtered.get(size - 1);
                if (last + w > capacity) {
                    // Remove heavier of the two
                    if (last > w) {
                        filtered.remove(size - 1); // remove last
                        filtered.add(w);           // keep current
                    }
                    // else: implicitly skip current (do not add w)
                    removals++;
                } else {
                    filtered.add(w);
                }
            }
        }

        return removals;
    }

    public static void main(String[] args) {
        int[] weights1 = {3, 5, 2, 6, 1};
        int[] weights2 = {3, 7, 2, 6, 1};

        System.out.println(minRemovals(weights1, 8)); // Output: 0
        System.out.println(minRemovals(weights2, 8)); // Output: 1
    }
}

