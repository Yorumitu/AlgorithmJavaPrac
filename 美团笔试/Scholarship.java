package 美团笔试;

/**
 *
 * 小美是个勤奋努力的大学生。小美想要获得奖学金。
 *
 * 小美总共修习了 n 门课程，每门课程都有一个学分 ai ，而这门课小美的成绩是 bi 。
 *
 * 小美所在的学校对于奖学金的评定非常简单：只要所有课程的均分不低于一个给定的标准 X，而且没有任何课程挂科，就可以申请奖学金。
 *
 * 均分是指所有课程的成绩按照学分加权的平均值，而一门课挂科即该课成绩低于60分。
 *
 * 现在小美会给你总共若干次询问，询问在每种课业情况下她能否申请奖学金。
 *
 *
 * */
public class Scholarship {
}


/**
 * int PX(int Case)
 * {
 *   ll n, x;
 *   cin >> n >> x;
 *   Ve(int) a(n), b(n);
 *   for(auto &i:a) cin >> i;
 *   for(auto &i:b) cin >> i;
 *   ll s1=0, s2=0;
 *   for(int i=0; i<n; i++) {
 *     if(b[i] < 60) return cout << "No\n", 0;
 *     s1 += (a[i]*b[i]);
 *     s2 += a[i];
 *   }
 *   // s1 / s2 >= x
 *   // s1 >= x*s2
 *   ll res = s2*x;
 *   if(s1 >= res) return cout << "Yes\n", 0;
 *   else return cout << "No\n", 0;
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
 *
 *
 */
