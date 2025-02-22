public class WordSearchIn2DArrayDFS {

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
            boolean foundDFS = searchWordDFS(grid, word);
            System.out.println("Word \"" + word + "\" found (DFS): " + foundDFS);
        }
    }

    public static boolean searchWordDFS(char[][] grid, String word) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Iterate through each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Check if the current cell matches the first character of the word
                if (grid[i][j] == word.charAt(0)) {
                    // Search in all four directions using DFS
                    for (int[] dir : DIRECTIONS) {
                        if (dfs(grid, i, j, word, 0, dir)) {
                            return true;
                        }
                    }
                }
            }
        }

        // Word not found
        return false;
    }

    private static boolean dfs(char[][] grid, int x, int y, String word, int index, int[] dir) {
        // Base case: If the entire word is matched
        if (index == word.length()) {
            return true;
        }

        // Check if the current position is out of bounds or doesn't match the word character
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != word.charAt(index)) {
            return false;
        }

        // Move in the current direction
        return dfs(grid, x + dir[0], y + dir[1], word, index + 1, dir);
    }
}
