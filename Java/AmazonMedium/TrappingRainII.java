class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]); // Min-heap based on height

        // Add all boundary cells to the heap
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    heap.offer(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }

        int trappedWater = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 4 possible directions

        // Process the heap
        while (!heap.isEmpty()) {
            int[] cell = heap.poll();
            for (int[] dir : directions) {
 int x = cell[0] + dir[0];
                int y = cell[1] + dir[1];

                // Check if the neighbor is within bounds and not visited
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    // If the neighbor's height is less than the current boundary height, water can be trapped
                    if (heightMap[x][y] < cell[2]) {
                        trappedWater += cell[2] - heightMap[x][y];
                        heightMap[x][y] = cell[2]; // Update the height to the boundary height
                    }
 heap.offer(new int[]{x, y, heightMap[x][y]});
                    visited[x][y] = true;
                }
            }
        }

        return trappedWater;
    }
}
