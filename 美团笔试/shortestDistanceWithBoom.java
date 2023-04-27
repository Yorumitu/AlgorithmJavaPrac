package 美团笔试;

/**

题目描述：
有一片 n × m 大小的网格，共 n 行 m 列，其中行和列都用从 1 开始的整数编号，网格中有 k 个格子中埋有地雷。
 我们记第 a 行第 b 列的格子为 (a, b)。小美现在位于 (x1, y1)，她想要移动到 (x2, y2) 处。
 小美每次移动可以移动到与她所处格子的相邻的一格中，
 形式化地说，如果小美位于 (x, y)，则小美可以移动到 (x-1, y), (x+1, y), (x, y-1), (x, y+1) 的格子之一，但小美不能移动到网格之外。

小美想要在移动过程中，离这些地雷越远越好，而不是走最短路径。
 这里定义两个格子之间的距离为曼哈顿距离，即格子 (a, b) 和 (c, d) 之间的距离是 |a-c|+|b-d|。
 小美想知道，移动中与地雷之间距离的最小值最大可能是多少。
 请注意，如果无论小美如何移动，都会进入一个有地雷的格子的话，这个最大可能值为 0。

输入描述
第一行三个整数 n, m, k，分别表示网格的行数，列数和地雷个数。

接下来 k 行，每行两个整数 p, q，表示一个地雷放置在格子 (p, q) 中。任意两地雷的放置位置不同。

接下来一行四个整数 x1, y1, x2, y2，表示小美的出发位置和目的位置。保证小美的出发位置和目的位置上没有地雷。

对于全部数据，1 ≤ n, m ≤ 500, n × m ≥ 3, 1 ≤ k ≤ min{n × m-2, 400},
 1 ≤ p, x1, x2 ≤ n, 1 ≤ q, y1, y2 ≤ m, (x1, y1) ≠ (x2, y2)，保证 (x1, y1) 和 (x2, y2) 中没有地雷，并且一个格子中最多放置一个地雷。

输出描述
输出一行一个整数，表示移动过程中与地雷之间距离的最小值的可能最大值。


样例输入
5 6 2
2 1
2 3
1 1 5 1
样例输出
1

3 3 9
1 1
2 2
3 3
4 4
5 5
6 6
7 7
8 8
9 9
1 1 3 3
*/

public  class shortestDistanceWithBoom {

}


/**
 *考虑先对每个点求离他最近的地雷的距离，然后类似于 Dijkstra 的做法跑个 dp 就行了。
 * #include<bits/stdc++.h>
 *
 * #define debug(x) std::cerr << "debug: " << x << '\n';
 * #define all(x) x.begin(), x.end()
 *
 * using pii = std::pair<int, int>;
 * using i64 = long long;
 * using vi = std::vector<int>;
 * using vp = std::vector<pii>;
 * using vl = std::vector<i64>;
 *
 * int X[405], Y[405];
 * int dist[505][505], dp[505][505];
 * bool vis[505][505];
 * int dir[4][2] = {0, 1, 0, -1, 1, 0, -1, 0};
 * void solve(int cas) {
 *   int n, m, k;
 *   std::cin >> n >> m >> k;
 *   memset(dist, 0x3f, sizeof(dist));
 *   for (int i = 1; i <= k; i++) {
 *     std::cin >> X[i] >> Y[i];
 *   }
 *   for (int i = 1; i <= n; i++) {
 *     for (int j = 1; j <= m; j++) {
 *       for (int u = 1; u <= k; u++) {
 *         int distance = std::abs(i - X[u]) + std::abs(j - Y[u]);
 *         dist[i][j] = std::min(dist[i][j], distance);
 *       }
 *     }
 *   }
 *   int _x1, _y1, _x2, _y2;
 *   std::cin >> _x1 >> _y1 >> _x2 >> _y2;
 *   std::priority_queue<std::tuple<int, int, int> > que;
 *   que.emplace(dist[_x1][_y1], _x1, _y1);
 *   dp[_x1][_y1] = dist[_x1][_y1];
 *   while (!que.empty()) {
 *     auto [cost, x, y] = que.top();
 *     que.pop();
 *     if (vis[x][y]) {
 *       continue;
 *     }
 *     vis[x][y] = true;
 *     for (int i = 0; i < 4; i++) {
 *       int nx = x + dir[i][0], ny = y + dir[i][1];
 *       if (nx <= 0 or ny <= 0 or nx > n or ny > m) {
 *         continue;
 *       }
 *       if (!vis[nx][ny] and dp[nx][ny] < std::min(dist[nx][ny], dp[x][y])) {
 *         dp[nx][ny] = std::min(dist[nx][ny], dp[x][y]);
 *         que.emplace(dp[nx][ny], nx, ny);
 *       }
 *     }
 *   }
 *   std::cout << dp[_x2][_y2] << '\n';
 * }
 *
 * int main() {
 *   int T = 1;
 *   //std::cin >> T;
 *   while (T--) {
 *     solve(T);
 *   }
 *   return 0;
 * }
 *
 */