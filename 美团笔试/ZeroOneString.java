package 美团笔试;

/**
 * 小美给你一个长度为 n 的01串（仅包含字符0和1的串），你可以删除这个串的一个前缀和一个后缀（可以为空），即保留一个原串的连续子串，操作之后整个串的代价为下面两部分之和：
 *
 * 1. 被删除的字符1的个数；
 *
 * 2. 剩下的子串的字符0的个数
 *
 * 你需要最小化操作的代价，并将其输出。
 *
 * 输入仅一行，一个长度为 n 的01字符串。
 *
 * 对于所有数据，1≤n≤105
 *
 * 101110110
 *   111011
 *
 */

public class ZeroOneString {
}

/**
 *先特判全删和不删的情况，再考虑部分保留。
 *
 * 枚举保留s_i，考虑前缀i-1和后缀i+1，预处理dp然后取最小。
 *
 * pre_dp[i][0]：前i个前缀去掉的最小费用
 *
 * pre_dp[i][1]：第i个保留的最小费用
 *
 * 取min(pre_dp[i-1][1],pre_dp[i-1][0])即可。
 *
 * suf_dp同理。
 *
 * 有更短的写法，无脑dp比较显然也好写。
 * int PX(int Case)
 * {
 *   string s;
 *   cin >> s;
 *   int n = s.size();
 *   Ve(int) pre_0(n+3, 0), pre_1(n+3, 0);
 *   for(int i=1; i<=n; i++) {
 *     pre_0[i] = pre_0[i-1] + (s[i-1]=='0');
 *     pre_1[i] = pre_1[i-1] + (s[i-1]=='1');
 *   }
 *   Ve(int) suf_0(n+3, 0), suf_1(n+3, 0);
 *   for(int i=n; i>0; i--) {
 *     suf_0[i] = suf_0[i+1] + (s[i-1]=='0');
 *     suf_1[i] = suf_1[i+1] + (s[i-1]=='1');
 *   }
 *   vector<vector<int>> pre_dp(n+3, Ve(int)(2, 0));
 *   for(int i=1; i<=n; i++) {
 *     pre_dp[i][0] = pre_1[i];
 *     pre_dp[i][1] = min(pre_dp[i-1][0], pre_dp[i-1][1]) + (s[i-1]=='0');
 *   }
 *   vector<vector<int>> suf_dp(n+3, Ve(int)(2, 0));
 *   for(int i=n; i>=1; i--) {
 *     suf_dp[i][0] = suf_1[i];
 *     suf_dp[i][1] = min(suf_dp[i+1][0], suf_dp[i+1][1]) + (s[i-1]=='0');
 *   }
 *   int ans = min(pre_1[n], pre_0[n]);
 *   for(int i=1; i<=n; i++) {
 *     //  保留i 考虑pre[i-1] 和 suf[i+1]
 *     int l = min(pre_dp[i-1][0], pre_dp[i-1][1]);
 *     int r = min(suf_dp[i+1][0], suf_dp[i+1][1]);
 *     int res = l+r + (s[i-1]=='0');
 *     ans = min(ans, res);
 *   }
 *   cout << ans << '\n';
 *   return 1;
 * }
 *
 * int main()
 * {
 *   // freopen("in.txt", "r", stdin);
 *   // freopen("out.txt", "w", stdout);
 *   ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
 *   int T = 1;
 *   // cin >> T;
 *   for(int t=1; t<=T; t++) {
 *     PX(t);
 *   }
 *   return 0;
 * }
 */