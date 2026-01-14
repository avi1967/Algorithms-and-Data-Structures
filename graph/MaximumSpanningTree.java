// Algorithm: Maximum Spanning Tree (Kruskal's Algorithm)
// Time Complexity: O(E log E)
// Space Complexity: O(V)
// Key Idea: Greedily select highest-weight edges that do not form cycles
//
// Correctness (Cut Property):
// - For any cut, the maximum-weight edge crossing the cut
//   is safe to include in a maximum spanning tree.

package graphs;

import java.util.Arrays;

public class MaximumSpanningTree {

    /**
     * Computes the total weight of a maximum spanning tree.
     *
     * @param n     number of vertices
     * @param edges list of edges
     * @return total weight of the maximum spanning tree
     */
    public static int compute(int n, Edge[] edges) {

        // Sort edges by descending weight
        Arrays.sort(edges, (a, b) -> b.weight - a.weight);

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int totalWeight = 0;
        int edgesUsed = 0;

        for (Edge edge : edges) {
            if (edgesUsed == n - 1) break;

            int pu = find(parent, edge.u);
            int pv = find(parent, edge.v);

            if (pu != pv) {
                parent[pu] = pv;
                totalWeight += edge.weight;
                edgesUsed++;
            }
        }
        return totalWeight;
    }

    // Union-Find: find with path compression
    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}
