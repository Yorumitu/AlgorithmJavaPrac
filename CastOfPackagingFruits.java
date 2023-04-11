/**
 *
 小美不干外卖配送了，转行开了一家水果店。

 一天她接到了一个大单，客户订购了 n 个水果，并且要求打包成多个果篮，一个果篮最多装 m 个水果。

 为了包装方便，水果按从 1 到 n 编号，同一个果篮里装的水果编号必须是连续的。果篮的成本与容积成线性关系。
 为了估计容积，小美简单地用样本中点估计了一下。
 具体来说，假设一个果篮中装的最大的水果体积是 u，最小的是 v，那么这个果篮的成本就是 k × floor((u+v)/2) + s，
 其中 k 是果篮中装入水果的个数，s 是一个常数，floor(x) 是下取整函数，比如 floor(3.8)=3, floor(2)=2。

 客户并没有规定果篮的数量，但是希望果篮的成本越小越好，毕竟买水果就很贵了。请求出小美打包这 n 个水果所用的最小花费。

 输入描述
 第一行三个正整数 n, m, s。意义如题面所示。

 第二行 n 个正整数 a1, a2, ..., an，表示每个水果的体积。

 对于全部数据，1 ≤ n ≤ 1e4,   1 ≤ m ≤ 1e3,   m ≤ n,   1 ≤ ai, s ≤ 1e4。

 输出描述
 输出一个整数，表示打包这 n 个水果果篮的最小成本。


 样例输入
 6 4 3
 1 4 5 1 4 1
 样例输出
 21

 */
public class CastOfPackagingFruits {

}