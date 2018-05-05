package codingInterviews;

public class Fibonacci {
	//时间复杂度太大
	public long Fibonacci1(int n) {
		if(n<=0)
			return 0;
		if(n==1)
			return 1;
		return Fibonacci1(n-1)+Fibonacci1(n-2);
	}
	//去掉一些重复计算，把数列的中间项保存起来
	public long Fibonacci2(int n) {
		long result = 0,one = 0, two =1;
		if(n==0)return one;
		if(n==1)return two;
		for(int i=2;i<=n;i++) {
			result = one+two;
			one = two;
			two = result;
		}
		return result;
	}
	//青蛙跳台阶
	//每次只能爬一步或者两步，请问到达n时可以有几种方法
	public int climbStairs(int n) {
		int f[] = new int[n+3];
		f[0]=0;f[1]=1;f[2]=2;
		for(int i=0;i<=n;i++) {
			f[i] = f[i-1]+f[i-2];
		}
		return f[n];
	}
}
