package codingInterviews;
/**
 * 我们把只包含因子2,3,和5的称为丑数。求按从小到大的顺序的第1500个丑数。
 * 例如6、8都是丑数，但14不是，因为它包含因子7.习惯上我们把1当做第一个丑数。
 */
public class GetUglyNumber {
	public int getUglyNumber(int n){
		if(n<0) return 0;
		int[] uglyArray = new int[n];
		uglyArray[0] = 1;
		int multiply2 =1;
		int multiply3 =1;
		int multiply5 =1;
		for(int i=0;i<uglyArray.length;i++) {
			int min = min(multiply2*2,multiply3*3,multiply5*5);
			uglyArray[i] = min;
			while(multiply2*2<=min)
				multiply2++;
			while(multiply3*3<=min)
				multiply3++;
			while(multiply5*5<=min)
				multiply5++;
		}
		return uglyArray[n-1];
	}
	private int min(int i, int j, int k) {
		int min=(i<j)?i:j;
		return (min<k)?min:k;
	}
	public static void main(String[] args) {
		GetUglyNumber p=new GetUglyNumber(); 
		System.out.println(p.getUglyNumber(1500));
	}
}
/**
 * 根据丑数的定义， 丑数应该是另一个丑数乘以 2、3 或者 5 的结果（1 除外）。
 * 因此我们可以创建一个数组，里面的数字是排好序的丑数，每一个丑数都是前面的丑数乘以 2、3 或者 5 得到的。
 * 根据丑数的定义，我们可以知道丑数可以由另外一个丑数乘以2，3或者5得到。因此我们可以创建一个数组，里面的数字是排好序的丑数，每一个丑数都是前面的丑数乘以2，3或者5得到的。
 * 我们把得到的第一个丑数乘以2以后得到的大于M的结果记为M2。
 * 同样，我们把已有的每一个丑数乘以3和5，能得到第一个大于M的结果M3和M5。
 * 那么M后面的那一个丑数应该是M2,M3和M5当中的最小值：Min(M2,M3,M5)。
 * 比如将丑数数组中的数字按从小到大乘以2，直到得到第一个大于M的数为止，那么应该是2*2=4<M，3*2=6>M，
 * 所以M2=6。同理，M3=6，M5=10。所以下一个丑数应该是6。
 * */
