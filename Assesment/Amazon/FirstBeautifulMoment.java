package practise.Assesment;


import java.util.*;

public class FirstBeautifulMoment {

    public static int findFirstBeautifulMoment(int n, int m, int k, int[][] paint) {
       int[][] visited = new int[n][m];
       for (int i =0; i< paint.length ; i++) {
    	   int row = paint[i][0]-1;
    	   int col = paint[i][1]-1;
    		   visited[row][col] = 1;
    		   if (hasPrefixSumKxKSquare(visited,k)) return i+1;
       }
        return 0;
    }
    //
    public static boolean hasPrefixSumKxKSquare(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (k > rows || k > cols) return false; // Edge case: k is larger than matrix

        // Step 1: Build Prefix Sum Matrix
        int[][] prefix = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                prefix[i][j] = matrix[i - 1][j - 1] 
                             + prefix[i - 1][j] 
                             + prefix[i][j - 1] 
                             - prefix[i - 1][j - 1];
            }
        }

        // Step 2: Check for any k × k submatrix with sum == k*k
        for (int i = k; i <= rows; i++) {
            for (int j = k; j <= cols; j++) {
                int sum = prefix[i][j] 
                        - prefix[i - k][j] 
                        - prefix[i][j - k] 
                        + prefix[i - k][j - k];

                if (sum == k * k) return true; // Found k × k square of 1s
            }
        }

        return false;
    }
    //
    private static boolean isKxKSquare(int[][] matrix, int row, int col, int k) {
        for (int i = row; i < row + k; i++) {
            for (int j = col; j < col + k; j++) {
                if (matrix[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean hasKxKSquare(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Ensure k is within bounds
        if (k > rows || k > cols) {
            return false;
        }

        // Iterate through possible top-left positions
        for (int i = 0; i <= rows - k; i++) {
            for (int j = 0; j <= cols - k; j++) {
                if (isKxKSquare(matrix, i, j, k)) {
                    return true;
                }
            }
        }

        return false;
    }
   public static void main(String[] args) {
        int n = 2;
        int m = 3;
        int k = 2;
        int[][] paint = {
                {1, 2}, {2, 3}, {2, 1},
                {1, 3}, {2, 2}, {1, 1}
        };
        System.out.println(findFirstBeautifulMoment(n, m, k, paint)); // Output: 5 as 5th input made it beautiful.
    }
}
