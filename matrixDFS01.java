/**
 * 给定一个 n 行 m 列矩阵 matrix ，矩阵内所有数均为非负整数。 你需要在矩阵中找到一条最长路径，使这条路径上的元素是递增的。并输出这条最长路径的长度。
 * 这个路径必须满足以下条件：
 *
 * 1. 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外。
 * 2. 你不能走重复的单元格。即每个格子最多只能走一次。
 *
 * 数据范围：1 \le n,m \le 10001≤n,m≤1000，0 \le matrix[i][j] \le 10000≤matrix[i][j]≤1000
 * 进阶：空间复杂度 O(nm)O(nm) ，时间复杂度 O(nm)O(nm)
 *
 * 例如：当输入为[[1,2,3],[4,5,6],[7,8,9]]时，对应的输出为5，
 */
public class matrixDFS01 {
    /**
     * DFS————>时间复杂度高
     * 递增路径的最大长度
     * @param matrix int整型二维数组 描述矩阵的每个数
     * @return int整型
     */
    static int [] move = {0, -1, 0, 1, 0};
    static int max = 0;
    public static int solve(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int length = 1;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length ; j++){
                dfs(matrix, i, j, length);
            }
        return max;
    }
    public static void dfs (int[][] matrix, int x, int y, int length) {
        if (length > max) max = length;
        for (int i = 0; i < move.length-1 ; i++) {
            int x_n = x + move[i], y_n = y + move[i + 1];
            if (x_n >= 0 && x_n < matrix.length && y_n >= 0 && y_n < matrix[0].length
                    && matrix[x_n][y_n] > matrix[x][y] ) {
                dfs(matrix, x_n, y_n, length+1);
            }
        }
    }


    public static void main(String[] args) {
        int [][] matrix = {{1,2} , {4,3}};
        System.out.println(solve(matrix));
    }


//    动态规划+dfs
//    引入dp进行剪枝
//    int [] move = {0, -1, 0, 1, 0};
//    int dp[][];
//    public int solve (int[][] matrix) {
//        if (matrix.length == 0 || matrix[0].length == 0) return 0;
//        int max = 0;
//        dp = new int [matrix.length][matrix[0].length];
//        for (int i = 0; i < matrix.length; i++)
//            for (int j = 0; j < matrix[0].length ; j++){
//                max = Math.max(max,  dfs(matrix, i, j));
//            }
//        return max;
//    }
//    public int dfs (int[][] matrix, int x, int y) {
//        if (dp[x][y] != 0) return dp[x][y];
//        dp[x][y]++;
//        for (int i = 0; i < move.length-1 ; i++) {
//            int x_n = x + move[i], y_n = y + move[i + 1];
//            if (x_n >= 0 && x_n < matrix.length && y_n >= 0 && y_n < matrix[0].length
//                    && matrix[x_n][y_n] > matrix[x][y]  ) {
//                dp[x][y] = Math.max(dp[x][y], dfs(matrix, x_n, y_n) + 1);
//            }
//        }
//        return dp[x][y];
//    }
}