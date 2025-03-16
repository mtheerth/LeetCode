import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int minKnightMoves(int x, int y) {
        // Handle symmetry by working with absolute values
        x = Math.abs(x);
        y = Math.abs(y);
        
        // All possible knight moves
        int[][] directions = {{-2,1}, {-1,2}, {1,2}, {2,1},
                             {2,-1}, {1,-2}, {-1,-2}, {-2,-1}};
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        boolean[][] visited = new boolean[305][305];
        visited[0][0] = true;
        int moves = 0;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int[] current = queue.poll();
                int currX = current[0], currY = current[1];
                
                // Check if we've reached the target
                if (currX == x && currY == y) {
                    return moves;
                }
                
                // Explore all possible moves
                for (int[] dir : directions) {
                    int newX = currX + dir[0];
                    int newY = currY + dir[1];
                    
                    // Check boundaries and whether position was visited
                    if (newX >= -1 && newY >= -1 && 
                        newX <= x + 2 && newY <= y + 2 && 
                        !visited[newX][newY]) {
                        
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            moves++;
        }
        return -1; // Should never reach here for valid inputs
    }

    public static void main(String[] args) {
        Solution knight = new Solution();
        
        System.out.println("(0, 0): " + knight.minKnightMoves(0, 0));    // 0
        System.out.println("(1, 1): " + knight.minKnightMoves(1, 1));    // 2
        System.out.println("(2, 1): " + knight.minKnightMoves(2, 1));    // 1
        System.out.println("(5, 5): " + knight.minKnightMoves(5, 5));    // 4
        System.out.println("(-1, -2): " + knight.minKnightMoves(-1, -2));// 1
        System.out.println("(300, 300): " + knight.minKnightMoves(300, 300));// 200
    }
}

