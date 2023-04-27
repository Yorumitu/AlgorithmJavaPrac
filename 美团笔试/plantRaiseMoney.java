package 美团笔试;

/**
 * 小美最近在玩一个种田类游戏。
 *
 * 这个游戏的目的是赚尽可能多的钱，游戏中有 n 种作物，
 * 其中第 i 种作物从种植到作物成熟采摘需要 ti 天时间，种子买入价格为ai ，作物卖出价格为 bi（一个种子只会产出一个作物，种子可以重复购买）。
 * 而游戏内总时间为 m 天，作物的种子种植和采摘、卖出等不耗时间，成熟之前作物没有价值。
 *
 * 假设小美只有一块土地（即每个时间只能有一个作物在生长），初始的钱足够多，小美想知道她最多能赚多少钱。
 *
 */
public class plantRaiseMoney {
}

/**
 *
 * int PX(int Case)
 * {
 *   int n, m;
 *   cin >> n >> m;
 *   Ve(int) t(n), a(n), b(n), v(n);
 *   for(auto &i:t) cin >> i;
 *   for(auto &i:a) cin >> i;
 *   for(auto &i:b) cin >> i;
 *   for(int i=0; i<n; i++) {
 *     v[i] = b[i] - a[i];
 *   }
 *   Ve(int) dp(m*10);
 *   for(int i=0; i<n; i++) {
 *     for(int j=t[i]; j<=m; j++) {
 *       dp[j] = max(dp[j], dp[j-t[i]] + v[i]);
 *     }
 *   }
 *   int ans = 0;
 *   for(int i=0; i<=m; i++) ans = max(ans, dp[i]);
 *   cout << ans << '\n';
 *   return 1;
 * }
 *
 * int main()
 * {
 *   ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
 *   int T = 1;
 *   // cin >> T;
 *   for(int t=1; t<=T; t++) {
 *     PX(t);
 *   }
 *   return 0;
 * }
 *
 */