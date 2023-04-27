package 美团笔试;

/**
 * 小美最近喜欢上了玩套娃。具体的，小美有 n 个套娃，第i个套娃的大小为 ai，内部空间为 bi(bi<=ai)。
 * 对于两个套娃x,y， x能放入y中当且仅当ax<=by，且放入后会占据y 大小为ax 的内部空间，即 y 的内部空间剩下 b-ax，
 * 每个套娃只能放在另外的一个套娃内，每个套娃内部也只能放一个套娃 (当然内部放的这个套娃可以内部还有套娃)。
 * 显然套娃是套的越多越好，于是小美给每个套娃定义了一个价值 Ci，如果套完之后套娃i还剩k 的内部空间，
 * 小美需要付出Ci*k 的花费，总花费为所有套娃的花费之和，现在小美想知道最小的花费为多少。
 *
 * 输入描述
 * 第一行一个正整数 n，表示套娃的个数
 * 接下来三行每行 n 个整数，分别为
 * a1a2—an
 * b1b2—bn
 * C1C2—Cn
 *
 * 1<=n,ai,bi,Ci<100000，bi<=ai
 *
 *
 *
 * n个套娃，每个套娃有属性 体积a、容积b、单位价值c。
 *  如果套娃内部是空的，则满价值，如果有其他套娃占位，只计算空的部分的价值。
 *  比如单位价值2的容积5的套娃原价2*5，被体积3的填了，则价值改为2*2
 *  套娃可以互相套也可以不套完，求一种方式使得所有套娃总价值最低。
 *
 *  样例：3
 *  5 4 3
 *  4 2 2
 *  3 2 1
 *
 *  第二个放第一个里第一个没有价值，后两个2*2+2*1 输出6
 */
public class LassoDoll {
}

/**
 *  贪心法过82%
 * import java.util.*;
 * public class Main {
 *     public static void main(String[] args) {
 *         Scanner scan = new Scanner(System.in);
 *         int n=scan.nextInt();
 *         int[] x=new int[n];
 *         int[] y=new int[n];
 *         int[] c=new int[n];
 *         for (int j = 0; j < n; j++) {
 *             x[j]= scan.nextInt();
 *         }
 *         for (int j = 0; j < n; j++) {
 *             y[j]= scan.nextInt();
 *         }
 *         for (int j = 0; j < n; j++) {
 *             c[j]= scan.nextInt();
 *         }
 *         int temp[][]=new int[n][2];
 *         for (int i = 0; i < n; i++) {
 *             temp[i][0]=c[i];
 *             temp[i][1]=y[i];
 *         }
 *         Arrays.sort(x);Arrays.sort(temp, (o1, o2) -> {
 *             if(o1[0]==o2[0]) return o1[1]-o2[1];
 *             return o1[0]-o2[0];
 *         });int cost=0;
 *         boolean[] flag=new boolean[x.length];
 *         for (int i = x.length-1; i >= 0; i--) {
 *             int price=temp[i][0];
 *             int volume=temp[i][1];
 *             for (int j = x.length-1; j >=0 ; j--) {
 *                 if(j==0&&(x[j]>volume||flag[j])){
 *                     cost+=price*volume;
 *                 }
 *                 if(flag[j]){
 *                     continue;
 *                 }
 *                 if(x[j]<=volume){
 *                     flag[j]=true;
 *                     cost+=price*(volume-x[j]);
 *                     break;
 *                 }
 *             }
 *         }
 *         System.out.println(cost);
 *     }
 * }
 *
 *
 */
