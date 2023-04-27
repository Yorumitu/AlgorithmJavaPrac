package 美团笔试;

/**
 *
 * 小美正在参加一个比赛。
 *
 * 这个比赛总共有 2k 个人参加（包括小美），编号为1,2,...,2k，开始的时候所有人都在同一个小组。
 * 比试的规程如下：假设当前小组有 n 个人（n 为偶数），那么编号大小前 n/2 人分为一个新的小组，后 n/2 人分为一个新的小组，
 * 然后两个小组内部分别比试，决出各自的胜者，然后两个小组的胜者进行比试，胜者作为当前小组的优胜者，直到决出最初的小组的优胜者。
 * 当然一个人的小组优胜者肯定是他自己。
 * 例如如果当前小组有 4 个人，编号为1,2,3,4，那么就会将 1,2 分为一组，3,4分为一组分别比试，然
 * 后 1,2 中的胜者和 3,4 中的胜者再进行比试，决出整个小组的胜者。
 *
 * 由于每个人的能力各不相同，小美预测了所有人两两比试时的胜者，现在小美想知道预测最终的胜者是谁。
 *
 */
public class Competition {
}

/**
 *
 * int PX(int Case)
 * {
 *   int n;
 *   cin >> n;
 *   map<pii,int> mp;
 *   for(int i=1; i<=(1<<n); i++) {
 *     for(int j=1; j<=(1<<n); j++) {
 *       int x;
 *       cin >> x;
 *       mp[{i, j}] = x;
 *     }
 *   }
 *   Ve(int) v;
 *   for(int i=1; i<=(1<<n); i++) v.push_back(i);
 *   while(v.size() > 1) {
 *     Ve(int) now;
 *     for(int i=0; i<v.size(); i+=2) {
 *       int l = v[i], r = v[i+1];
 *       now.push_back(mp[{l, r}]);
 *     }
 *     v = now;
 *   }
 *   int ans = v[0];
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