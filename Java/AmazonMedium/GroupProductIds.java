import java.util.*;

public class GroupProductIds {

    public static List<List<Integer>> groupProductIds(int[][] pairs) {
        // Build the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : pairs) {
            int u = pair[0];
            int v = pair[1];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        // Track visited nodes
        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        // Traverse the graph to find connected components
        for (int node : graph.keySet()) {
            if (!visited.contains(node)) {
                List<Integer> group = new ArrayList<>();
                dfs(node, graph, visited, group);
                result.add(group);
            }
        }

        return result;
    }

    private static void dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited, List<Integer> group) {
        visited.add(node);
        group.add(node);
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, group);
            }
        }
    }

    public static void main(String[] args) {
        int[][] pairs = {{1, 2}, {2, 5}, {3, 4}, {4, 6}, {6, 8}, {5, 7}, {5, 2}, {5, 2}};
        List<List<Integer>> result = groupProductIds(pairs);

        // Print the result
        for (List<Integer> group : result) {
            System.out.println(group);
        }
    }
}
