/**
 * 快速幂
 *
 * 实现 pow(x n) ，即计算 x 的 n 次幂函数（即，x^n）。不得使用库函数，同时不需要考虑大数问题。
 *
 * 这个简单题需要考虑一些特殊情况：
 *  n正负性
 *  边界(int最大和最小)
 */
public class powAchieve {
    public static double pow(double a, int b) {
        if (b == 0) return 1;
        if (b == 1) return a;
        if (b < 0)
            return (1/a) * pow(1/a, -(b+1));
        if (b%2 == 0)
            return pow(a * a, b/2);
        else
            return a * pow(a * a, (b - 1)/2 );
    }

}
