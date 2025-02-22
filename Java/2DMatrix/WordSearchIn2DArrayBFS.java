import java.util.LinkedList;
import java.util.Queue;

public class WordSearchIn2DArrayBFS {

    // Directions: left to right, right to left, top to bottom, bottom to top
    private static final int[][] DIRECTIONS = {
        {0, 1},  // Left to right
        {0, -1}, // Right to left
        {1, 0},  // Top to bottom
        {-1, 0}  // Bottom to top
    };

    public static void main(String[] args) {
        char[][] grid = {
            {'a', 'b', 'c', 'd'},
            {'e', 'f', 'g', 'h'},
            {'i', 'j', 'k', 'l'},
            {'m', 'n', 'o', 'p'}
        };

        String[] wordsToFind = {"abc", "fjn", "hlp", "mji", "dhl"};

        for (String word : wordsToFind) {
            boolean foundBFS = searchWordBFS(grid, word);
            System.out.println("Word \"" + word + "\" found (BFS): " + foundBFS);
        }
    }

    public static boolean searchWordBFS(char[][] grid, String word) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Iterate through each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Check if the current cell matches the first character of the word
                if (grid[i][j] == word.charAt(0)) {
                    // Search in all four directions using BFS
                    for (int[] dir : DIRECTIONS) {
                        if (bfs(grid, i, j, word, dir)) {
                            return true;
                        }
                    }
                }
            }
        }

        // Word not found
        return false;
    }

    private static boolean bfs(char[][] grid, int x, int y, String word, int[] dir) {
        int rows = grid.length;
        int cols = grid[0].length;
        int wordLength = word.length();

        // Queue for BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0}); // {x, y, index}

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int index = current[2];

            // If the entire word is matched
            if (index == wordLength) {
                return true;
            }

            // Check if the current position is out of bounds or doesn't match the word character
            if (cx < 0 || cx >= rows || cy < 0 || cy >= cols || grid[cx][cy] != word.charAt(index)) {
                continue;
            }

            // Move in the current direction
            int nx = cx + dir[0];
            int ny = cy + dir[1];
            queue.offer(new int[]{nx, ny, index + 1});
        }

        // Word not found
        return false;
    }
}
