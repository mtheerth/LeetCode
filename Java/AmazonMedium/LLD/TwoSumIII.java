import java.util.HashMap;
import java.util.Map;

class TwoSumIII {
    private Map<Integer, Integer> countMap;

    // Constructor to initialize the data structure
    public TwoSum() {
        countMap = new HashMap<>();
    }

    // Adds a number to the data structure
    public void add(int number) {
        countMap.put(number, countMap.getOrDefault(number, 0) + 1);
    }

    // Finds if there exists any pair of numbers that sum up to the given value
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int num = entry.getKey();
            int complement = value - num;

            if (countMap.containsKey(complement)) {
                // If num and complement are the same, ensure there are at least two occurrences
                if (num != complement || entry.getValue() > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    // Example usage
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        twoSum.add(1);
        twoSum.add(3);
        twoSum.add(5);

        System.out.println(twoSum.find(4)); // Output: true (1 + 3 = 4)
        System.out.println(twoSum.find(7)); // Output: true (3 + 4 = 7)
        System.out.println(twoSum.find(10)); // Output: false
    }
}

