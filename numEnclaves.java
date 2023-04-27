/**
 *
 * 1020. 飞地的数量
 * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
 *
 * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
 *
 * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
 *
 *
 * 方法三：并查集
 * 除了深度优先搜索和广度优先搜索的方法以外，也可以使用并查集判断每个陆地单元格是否和网格边界相连。
 *
 * 并查集的核心思想是计算网格中的每个陆地单元格所在的连通分量。对于网格边界上的每个陆地单元格，其所在的连通分量中的所有陆地单元格都不是飞地。如果一个陆地单元格所在的连通分量不同于任何一个网格边界上的陆地单元格所在的连通分量，则该陆地单元格是飞地。
 *
 * 并查集的做法是，遍历整个网格，对于网格中的每个陆地单元格，将其与所有相邻的陆地单元格做合并操作。由于需要判断每个陆地单元格所在的连通分量是否和网格边界相连，因此并查集还需要记录每个单元格是否和网格边界相连的信息，在合并操作时更新该信息。
 *
 * 在遍历网格完成并查集的合并操作之后，再次遍历整个网格，通过并查集中的信息判断每个陆地单元格是否和网格边界相连，统计飞地的数量。
 *
 */
public class numEnclaves {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int index = i * n + j;
                    if (j + 1 < n && grid[i][j + 1] == 1) {
                        uf.union(index, index + 1);
                    }
                    if (i + 1 < m && grid[i + 1][j] == 1) {
                        uf.union(index, index + n);
                    }
                }
            }
        }
        int enclaves = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !uf.isOnEdge(i * n + j)) {
                    enclaves++;
                }
            }
        }
        return enclaves;
    }
}

class UnionFind {
    private int[] parent;
    private boolean[] onEdge;
    private int[] rank;

    public UnionFind(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        parent = new int[m * n];
        onEdge = new boolean[m * n];
        rank = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int index = i * n + j;
                    parent[index] = index;
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        onEdge[index] = true;
                    }
                }
            }
        }
    }

    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
                onEdge[rootx] |= onEdge[rooty];
            } else if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
                onEdge[rooty] |= onEdge[rootx];
            } else {
                parent[rooty] = rootx;
                onEdge[rootx] |= onEdge[rooty];
                rank[rootx]++;
            }
        }
    }

    public boolean isOnEdge(int i) {
        return onEdge[find(i)];
    }
}