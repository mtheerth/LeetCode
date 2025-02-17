public class MatrixDFS {
    // Directions for moving in 4 directions (up, down, left, right)
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void dfs(int[][] matrix, int row, int col, boolean[][] visited) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Check if the current position is valid and not visited
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col]) {
            return;
        }

        // Mark the current cell as visited and process it
        visited[row][col] = true;
        System.out.print(matrix[row][col] + " ");

        // Explore all 4 directions
        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            dfs(matrix, newRow, newCol, visited);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        MatrixDFS dfs = new MatrixDFS();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        dfs.dfs(matrix, 0, 0, visited); // Start DFS from (0, 0)
    }
}
