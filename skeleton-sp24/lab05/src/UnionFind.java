public class UnionFind {
    int[] parents;


    /* Creates a UnionFind data structure holding N items. Initially, all
       items are in disjoint sets. */
    public UnionFind(int N) {
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = -1;
        }

    }

    /* Returns the size of the set V belongs to. */
    public int sizeOf(int v) {
        int parent = parents[v];
        if (parent < 0) return Math.abs(parent);
        return sizeOf(parent);
    }

    /* Returns the parent of V. If V is the root of a tree, returns the
       negative size of the tree for which V is the root. */
    public int parent(int v) {
        return parents[v];
    }

    /* Returns true if nodes/vertices V1 and V2 are connected. */
    public boolean connected(int v1, int v2) {
        int root1 = find(v1);
        int root2 = find(v2);

        return root1 == root2;
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. If invalid items are passed into this
       function, throw an IllegalArgumentException. */
    public int find(int v) {
        if (v >= parents.length) {
            throw new IllegalArgumentException("out of bounds");
        }
        int parent = parents[v];
        if (parent < 0) {
            return v;
        } else {
            int root = find(parent);
            while (parent(v) >= 0) {
                parents[v] = root;
                v = parent(v);
            }
            return root;
        }
    }

    /* Connects two items V1 and V2 together by connecting their respective
       sets. V1 and V2 can be any element, and a union-by-size heuristic is
       used. If the sizes of the sets are equal, tie break by connecting V1's
       root to V2's root. Union-ing an item with itself or items that are
       already connected should not change the structure. */
    public void union(int v1, int v2) {
        if (!connected(v1, v2)) {
            int root1 = find(v1);
            int root2 = find(v2);
            if (parents[root1] >= parents[root2]) {
                parents[root2] = parents[root1] + parents[root2];
                parents[root1] = root2;
            } else {
                parents[root1] = parents[root1] + parents[root2];
                parents[root2] = root1;
            }
        }
    }
}
