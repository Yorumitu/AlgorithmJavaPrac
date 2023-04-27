package 分糖;

/**
 * 题目描述
 * 有 N 个（相同的）糖果，M 个（不同的）小朋友。M 和 N 满足：1≤M≤N≤100000(105)。
 * 要求：
 * 1.每个小朋友都至少有一个糖果。
 * 2.不存在正整数 X（X>=2），使得每个小朋友的糖果数都是 X 的倍数。
 * 3.糖果不能剩余。
 * 求分糖方法总数。答案模 1000000007（109+7）
 *
 * 输入格式
 * 第一行为数据组数：T<=100000。
 * 接下来 N 行，每行 2 个如上文所示的正整数 N，M。
 *
 * 输出格式
 * 输出 T 行，每行一个整数，为答案。
 * 注意取模！
 */
public class DistributeCandy {
}


/**
 * Analysis
 * 难度不是很大的一道题啦：）
 * 正难则反
 * 我们统计每个小朋友的糖果数都是 X 的倍数的情况
 * 显然X应该是N的因数
 * 那么问题就变成了将N分解质因数
 * 然后容斥一下
 * 方案数的话就是将a个相同物品放入b个不同集合，集合非空的情况
 *
 *
 *#include<bits/stdc++.h>
 * #define int long long
 * #define re register
 * #define in read()
 * using namespace std;
 * inline int read(){
 * 	char ch;int f=1,res=0;
 * 	while((ch=getchar())<'0'||ch>'9') if(ch=='-') f=-1;
 * 	while(ch>='0'&&ch<='9'){
 * 		res=(res<<1)+(res<<3)+(ch^48);
 * 		ch=getchar();
 *        }
 * 	return f==1?res:-res;
 * }
 * const int N=1e5;
 * const int P=1e9+7;
 * typedef long long ll;
 * int T,n,m;
 * int fac[N+10],ifac[N+10];
 * inline ll ksm(ll x,ll b){
 * 	ll res=1;
 * 	while(b){
 * 		if(b&1) res=res*x%P;
 * 		x=x*x%P;
 * 		b>>=1;
 *    }
 * 	return res;
 * }
 * int mark[N+10],pri[N+10],tot=0;
 * void init(){
 * 	for(re int i=2;i<=N;++i){
 * 		if(!mark[i]) pri[++tot]=i;
 * 		for(re int j=1;j<=tot&&i*pri[j]<=N;++j){
 * 			mark[i*pri[j]]=1;
 * 			if(i%pri[j]==0) break;
 *        }
 *    }
 * 	fac[0]=1;
 * 	for(re int i=1;i<=N;++i) fac[i]=fac[i-1]*i%P;
 * 	ifac[N]=ksm(fac[N],P-2);
 * 	for(re int i=N-1;i>=0;--i) ifac[i]=ifac[i+1]*(i+1)%P;
 * }
 * int cnt=0,a[N];
 * void divide(int x){
 * 	for(re int i=1;pri[i]*pri[i]<=x&&i<=tot;++i)
 * 		if(x%pri[i]==0){
 * 			a[++cnt]=pri[i];
 * 			while(x%pri[i]==0) x/=pri[i];
 *        }
 * 	if(x>1) a[++cnt]=x;
 * }
 * ll C(ll x,ll y){
 * 	if(y>x) return 0;
 * 	return fac[x]*ifac[y]%P*ifac[x-y]%P;
 * }
 * bool cmp(const int a,const int b){return a>b;}
 * ll ans;
 * void dfs(int pos,int sum,int t){
 * 	if(pos>cnt){
 * 		int x=n/sum;
 * 		if(t) ans=(ans-C(x-1,m-1))%P;
 * 		else ans=(ans+C(x-1,m-1))%P;
 * 		return;
 *    }
 * 	dfs(pos+1,sum*a[pos],t^1);
 * 	dfs(pos+1,sum,t);
 * }
 * void work(){
 * 	cnt=0;
 * 	divide(n);
 * 	ans=0;
 * 	sort(a+1,a+cnt+1,cmp);
 * 	dfs(1,1,0);
 * 	cout<<((ans%P+P)%P)<<'\n';
 * }
 * signed main(){
 * 	T=in;
 * 	init();
 * 	while(T--){
 * 		n=in;m=in;
 * 		if(n==m) puts("1");
 * 		else work();
 *    }
 * 	return 0;
 * }
 *
 * ————————————————
 * 版权声明：本文为CSDN博主「Faithfully__xly」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_42557561/article/details/100046173
 */