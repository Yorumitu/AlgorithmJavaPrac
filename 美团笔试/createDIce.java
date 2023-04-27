package 美团笔试;

/**
 *
 * 小美需要制作一个骰子。
 *
 * 与一般的六面骰子不同，小美需要的骰子总共有 n 面，而且每一面的数字也不同于一般的，这n面的数字需要分别是a1,a2,......an 。当然，骰子是一个正n面体，而且唯一合法的要求是所有相对的两面之和都需要相等，比如一个数字分别为 1,2,3,4,2,3 的六面骰子，那么上面1，下面4，前面2，后面3，左边2，右边3就是合法的方案。
 *
 * 因为方案可以很多，所以小美并不在乎究竟是怎么做出这样一个骰子，小美只想知道是否能做出一个合法的骰子。
 *
 * 当然，保证n为偶数。
 *
 *
 */
public class createDIce {
}

/**
 *
 * int PX(int Case)
 * {
 *   int n;
 *   cin >> n;
 *   Ve(int) v(n);
 *   for(auto &i:v) cin >> i;
 *   sort(all(v));
 *   int s = v[0] + v[n-1];
 *   int l=1, r=n-2;
 *   while(l<r) {
 *     if(v[l]+v[r] != s) return cout << "NO\n", 0;
 *     l++, r--;
 *   }
 *   cout << "YES\n";
 *   return 1;
 * }
 *
 * int main()
 * {
 *   ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
 *   int T = 1;
 *   cin >> T;
 *   for(int t=1; t<=T; t++) {
 *     PX(t);
 *   }
 *   return 0;
 * }
 */