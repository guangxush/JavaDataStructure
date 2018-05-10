package codingInterviews;
/**
 * 题目：输入数字n，按顺序打印出从1到最大的n位进制数。比如输入3，则打印出1、2、3一直到999.
 */
public class PrintToMaxOfNDigits {
	public static void printToMaxOfNDigits(int n) {
		int[] array = new int[n];
		if(n<=0)
			return;
		printArray(array, 0);
	}
	private static void printArray(int[] array,int n) {
		for(int i=0;i<10;i++) {//从高位到低位
			if(n!=array.length) {
				array[n]=i;//数字的每一位都可能是0-9的任意一个数字，所以这一位要从0-9全部遍历一遍
				printArray(array,n+1);//数字的下一位也是递归调用该函数，直到最后一位停止迭代
			}else {
				boolean isFirstNo0=false;//设置当前位是否为0，为0的话打印
				for(int j=0;j<array.length;j++){//从第一位到最后一位打印数组，因为当前数组已经存在了所有的位数
					if(array[j]!=0){
						System.out.print(array[j]);
						if(!isFirstNo0)
							isFirstNo0=true;//最高位已经不为0了，那么后面的0全部可以打印出来，设置为true
					}else {//如果当前位是不0而且前面已经出现非0，可以打印
						if(isFirstNo0)//如果当前是0而且前面没有出现非0数字，可以打印 
							System.out.print(array[j]);
					}
				}
				System.out.println();
				return;
			}
		}
	}
	public static void main(String[] args) {
		printToMaxOfNDigits(2);
	}
}
/**
 * n位所有的十进制其实就是n个从0到9的全排列，也就是说，我们把数字的每一位都从0-9排列一边
 * 就得到了所有的十进制数，只是打印的时候0在前面的话不打印罢了
 * 实现全排列用递归的方法很容易表达，数字的每一位都可能是0-9中的一个数字，然后设置下一位
 * 递归结束的条件是我们已经设置了数字的最后一位。
 * 此题注意防止溢出。
 */
