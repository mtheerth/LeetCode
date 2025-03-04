class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        int totalCost = 0;
        int n = costs.length / 2;

        // Sum the costs for the first n people to go to City A and the last n to go to City B
        for (int i = 0; i < n; i++) {
            totalCost += costs[i][0];  // Cost for City A
        }
        for (int i = n; i < costs.length; i++) {
            totalCost += costs[i][1];  // Cost for City B
        }

        return totalCost;
    }
}
