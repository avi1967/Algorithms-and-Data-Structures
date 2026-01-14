// Algorithm: Depth-First Search (DFS)
// Time Complexity: O(V^2) using adjacency matrix
// Space Complexity: O(V) recursion stack
// Key Idea: Recursively explore reachable vertices before backtracking
//
// Correctness:
// - DFS explores all vertices reachable from the source.
// - Parent pointers record a valid path in the DFS tree.

package graphs;

public class DFS {

    /**
     * Performs DFS to record a path from source to target.
     *
     * @param u       current vertex
     * @param target  target vertex
     * @param visited visited array
     * @param parent  parent pointers for path reconstruction
     * @param adj     adjacency matrix
     */
    public static void dfs(int u, int target, boolean[] visited, int[] parent, int[][] adj) {
        visited[u] = true;
        if (u == target) return;

        for (int v = 0; v < adj.length; v++) {
            if (adj[u][v] != 0 && !visited[v]) {
                parent[v] = u;
                dfs(v, target, visited, parent, adj);
            }
        }
    }

    /**
     * Reconstructs path from source to target using parent array.
     *
     * @return array representing the path, or null if no path exists
     */
    public static int[] getPath(int source, int target, int[] parent) {
        if (source != target && parent[target] == -1) {
            return null;
        }

        int[] path = new int[parent.length];
        int idx = 0;
        int curr = target;

        while (curr != -1) {
            path[idx++] = curr;
            curr = parent[curr];
        }

        int[] result = new int[idx];
        for (int i = 0; i < idx; i++) {
            result[i] = path[idx - i - 1];
        }
        return result;
    }
}
