import java.util.*;

public class CombinationSumFinder {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // optional but helps with optimization
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, 
                           List<Integer> tempList, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(tempList)); // found a valid combination
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break; // prune the search space
            tempList.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, tempList, result); // not i+1 because we can reuse
            tempList.remove(tempList.size() - 1); // backtrack
        }
    }

    // Test it
    public static void main(String[] args) {
        CombinationSumFinder finder = new CombinationSumFinder();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinations = finder.combinationSum(candidates, target);
        System.out.println(combinations); // [[2, 2, 3], [7]]
    }
}

