import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return false;
        }
        
        // Create a map to store the possible jump sizes for each stone
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        // Initialize the map with the first stone
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }
        
        // The frog starts at the first stone and can make a jump of size 1
        map.get(0).add(1);
        
        // Iterate through each stone
        for (int stone : stones) {
            // Get the possible jump sizes from the current stone
            for (int jump : map.get(stone)) {
                // Calculate the next stone position
                int nextStone = stone + jump;
                
                // If the next stone is the last stone, return true
                if (nextStone == stones[stones.length - 1]) {
                    return true;
                }
                
                // If the next stone exists in the map, update the possible jump sizes
                if (map.containsKey(nextStone)) {
                    if (jump - 1 > 0) {
                        map.get(nextStone).add(jump - 1);
                    }
                    map.get(nextStone).add(jump);
                    map.get(nextStone).add(jump + 1);
                }
            }
        }
        
        // If we reach here, the frog cannot reach the last stone
        return false;
    }

    public static void main(String[] args) {
        FrogJump solution = new FrogJump();
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println(solution.canCross(stones)); // Output: true
    }
}
