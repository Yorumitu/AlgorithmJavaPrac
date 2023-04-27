package 分糖;

/**
 * 一种糖果a个，另一种b个。分给n个人（a+b>n每人至少一个），每人的糖果只能全部为一种。
 * 求怎么分可以让每个人都尽可能多，即分得最少的人的糖果数也尽可能多，输出这个数量。
 *
 * 样例：
 *      5 2 3     5个人分 2+3 每人一个  输出1
 *
 *      4 7 10    a(3+4) b(5+5)  输出3
 *          x:1.64       y:2.35
 *          1               2
 *   least: a:7 b:3     a:3  b:5
 *
 *      4 4 15    a(4)b(5+5+5) 输出4
 *          x:0.84       y:3.15
 *          0               3
 *   least: a:0 b:3     a:4  b:5
 *
 *
 *  思路： 可无限再分状态下，x = a/(a+b)*n人得到a，y = b/(a+b)*n人得到b，理想平均。
 *  由于人不可再分，得到a和得到b的人数必定有一个舍一个进。
 *  即 x下取整人 得a，y上取整人得b，或x上取整人得b，y下取整得a。
 *  有了xy，直接用a//x，b//y得到 a糖果的最少分配和b糖果的最少分配。
 *  两者取最小得到一种分配情况下的最小值，两种情况求大者得到最终答案。
 *  注意对全部分a和全部分b作特判，不然会除0异常。
 */

public class LeastCandyMost {
    public static int function(int n, int a, int b){
        int res = 0;
        int minA, minB;
        //求理想情况下平均分配a：x人， b：y人
        double x = n * a/(a + b);
        double y = n * b/(a + b);
        //由于人不可再分，得到a和b的人数必定有一个舍一个进，即双方有一个多一个少，直接对双方向下取整，得到各自最少分配，在两者取最小得到一种分配情况下的最小值，两种情况求大者得到答案
        int resA = (int)Math.floor(x);
        int resB = (int)Math.floor(y);
        //在各自取小的两种情况下能得到的最少分配，结果取大的
        minA = (resA == 0)? 0 : Math.min(a/resA, b/(n - resA));
        minB = (resB == 0)? 0 : Math.min(a/(n - resB), b/resB);
        res = Math.max(minA, minB);

        return res;
    }
    public static void main(String[] args) {
        System.out.println(function(4, 4, 15));
    }
}
