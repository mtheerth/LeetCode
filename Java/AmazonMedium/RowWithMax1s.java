public class RowWithMax1s {
    public static int findRowWithMax1s(int[][] arr) {
        int n = arr.length;    // Number of rows
        int m = arr[0].length; // Number of columns
        int maxRowIndex = -1;  // Initialize result
        int maxCount = 0;      // Initialize maximum count of 1s

        int row = 0;           // Start from the first row
        int col = m - 1;       // Start from the last column

        while (row < n && col >= 0) {
            if (arr[row][col] == 1) {
                // Move left to find the first occurrence of 0
                col--;
                // Update the maximum count and row index
                maxCount = m - col - 1;
                maxRowIndex = row;
            } else {
                // Move down to the next row
                row++;
            }
        }

        return maxRowIndex;
    }

    public static void main(String[] args) {
        int[][] arr = {
            {0, 1, 1, 1},
            {0, 0, 1, 1},
            {1, 1, 1, 1},
            {0, 0, 0, 0}
        };

        int result = findRowWithMax1s(arr);
        System.out.println("Row with maximum 1s: " + result); // Output: 2
    }
}
