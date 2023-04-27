package 美团笔试;

/**
题目描述：
有一棵 n 个节点的树，有一条边被选定。
 小美想知道对于所有经过这条选定边的所有树上简单路径，最长的那条有多长。
 一条简单的路径的长度指这条简单路径上的边的个数。

输入描述
第一行一个整数 n，表示树的节点个数。

第二行 n-1 个整数，第 i 个整数 pi 表示节点 i+1 和 pi 之间有一条边相连。

第三行两个整数 x, y，表示这条选定的边。保证这条边一定是树上的一条边。

对于全部数据，2 ≤ n ≤ 1e5, 1 ≤ pi ≤ n, 1 ≤ x, y ≤ n, x ≠ y。保证输入数据正确描述一棵树，并且 (x, y) 是树上的一条边。

输出描述
输出一行，一个整数，表示所有经过选定边的树上简单路径中，最长的那条的长度。


样例输入
7
1 2 3 4 5 3
3 7
样例输出
4
*/
public class longestPathOfTree{

}









/**
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
 * vi G[100005];
 * int dist[100005], res = 0;
 * void dfs(int u, int par) {
 *   res = std::max(res, dist[u]);
 *   for (auto v : G[u]) {
 *     if (v == par) {
 *       continue;
 *     }
 *     dist[v] = dist[u] + 1;
 *     dfs(v, u);
 *   }
 * }
 *
 * void solve(int cas) {
 *   int n;
 *   std::cin >> n;
 *   for (int i = 2; i <= n; i++) {
 *     int fa;
 *     std::cin >> fa;
 *     G[fa].emplace_back(i);
 *     G[i].emplace_back(fa);
 *   }
 *   int from, to;
 *   int ans = 1;
 *   std::cin >> from >> to;
 *   dfs(from, to);
 *   ans += res;
 *   res = 0;
 *   dfs(to, from);
 *   ans += res;
 *   std::cout << ans << '\n';
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
 *
 */