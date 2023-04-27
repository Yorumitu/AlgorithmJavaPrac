package 美团笔试;

/**

题目描述：
有一棵 n 个节点的树，树上每个点都有红绿蓝三种颜色中的一种。
 定义一棵树是多彩的，当且仅当这棵树同时存在一个红色节点，一个蓝色节点和一个绿色节点。

保证最初这棵树是多彩的，现在要砍掉这棵树的某一条边，请问有多少种砍法，使得砍完之后形成的两棵树都是多彩的。

输入描述
第一行一个整数 n，表示节点个数。————>int[n][n]

第二行 n-1 个整数 p2, p3, ..., pn，pi 表示树上 i 和 pi 两点之间有一条边。保证给出的一定是一棵树。————>int[i][pi] = 1

第三行一个长度为 n 的字符串，第 i 个字符表示第 i 个节点的初始颜色。其中 R 表示红色，G 表示绿色，B 表示蓝色。保证字符串只由这三种大写字母构成。————>char[i] = ' '

对于全部数据，3≤n≤1e5。

输出描述
输出一行，一个正整数，表示答案。


样例输入
7
1 2 3 1 5 5
GBGRRBB
样例输出
1
*/

public class colorfulTree{

}


/**
 * 感觉跟 B 题差不多，因为求的是有多少条边能满足条件，不妨枚举边，先预处理子树下RGB三种颜色的个数就可以了。
 *
 *#include<bits/stdc++.h>
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
 * int tot;
 * vi G[100005];
 * char color[100005];
 * struct Edge {
 *   int u, v;
 * } edge[100005];
 * int szR[100005], szG[100005], szB[100005];
 * void dfs(int u, int par) {
 *   szR[u] = color[u] == 'R';
 *   szG[u] = color[u] == 'G';
 *   szB[u] = color[u] == 'B';
 *   for (auto v : G[u]) {
 *     if (v == par) {
 *       continue;
 *     }
 *     dfs(v, u);
 *     szR[u] += szR[v];
 *     szG[u] += szG[v];
 *     szB[u] += szB[v];
 *   }
 * }
 * void solve(int cas) {
 *   int n;
 *   std::cin >> n;
 *   for (int i = 2; i <= n; i++) {
 *     int fa;
 *     std::cin >> fa;
 *     ++tot;
 *     edge[tot].u = i, edge[tot].v = fa;
 *     G[i].emplace_back(fa);
 *     G[fa].emplace_back(i);
 *   }
 *   std::string s;
 *   std::cin >> s;
 *   s = ' ' + s;
 *   int R = 0, G = 0, B = 0;
 *   for (int i = 1; i <= n; i++) {
 *     color[i] = s[i];
 *     R += color[i] == 'R';
 *     G += color[i] == 'G';
 *     B += color[i] == 'B';
 *   }
 *   dfs(1, 0);
 *   int ans = 0;
 *   for (int i = 1; i <= tot; i++) {
 *     int u = edge[i].u, v = edge[i].v;
 *     if (szR[u] and szG[u] and szB[u]) {
 *       if (R - szR[u] > 0 and G - szG[u] > 0 and B - szB[u] > 0) {
 *         ++ans;
 *       }
 *     }
 *   }
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
 */
