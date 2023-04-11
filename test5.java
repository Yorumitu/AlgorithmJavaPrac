/*

题目描述：
有一棵 n 个节点的树，树上每个点都有红绿蓝三种颜色中的一种。定义一棵树是多彩的，当且仅当这棵树同时存在一个红色节点，一个蓝色节点和一个绿色节点。

保证最初这棵树是多彩的，现在要砍掉这棵树的某一条边，请问有多少种砍法，使得砍完之后形成的两棵树都是多彩的。



输入描述
第一行一个整数 n，表示节点个数。

第二行 n-1 个整数 p2, p3, ..., pn，pi 表示树上 i 和 pi 两点之间有一条边。保证给出的一定是一棵树。

第三行一个长度为 n 的字符串，第 i 个字符表示第 i 个节点的初始颜色。其中 R 表示红色，G 表示绿色，B 表示蓝色。保证字符串只由这三种大写字母构成。

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