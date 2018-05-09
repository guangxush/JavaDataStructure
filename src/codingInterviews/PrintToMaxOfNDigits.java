package codingInterviews;
/**
 * 题目：输入数字n，按顺序打印出从1到最大的n位进制数。比如输入3，则打印出1、2、3一直到999.
 */
public class PrintToMaxOfNDigits {
	public void printToMaxOfNDigits(int n) {
		int[] array = new int[n];
		if(n<=0)
			return;
		printArray(array, 0);
	}
	private void printArray(int[] array,int n) {
		for(int i=0;i<10;i++) {
			if(n!=array.length) {
				array[n]=i;
				printArray(array,n+1);
			}else {
				boolean isFirstNo0=false;
				for(int j=0;j<array.length;j++){
					if(array[j]!=0){
						System.out.print(array[j]);
						if(!isFirstNo0)
							isFirstNo0=true;
					}else{
						if(isFirstNo0) 
							System.out.print(array[j]);
					}
				}
				System.out.println();
				return;
			}
		}
	}
}
/**
 * n位所有的十进制其实就是n个从0到9的全排列，也就是说，我们把数字的每一位都从0-9排列一边
 * 就得到了所有的十进制数，只是打印的时候0在前面的话不打印罢了
 * 实现全排列用递归的方法很容易表达，数字的每一位都可能是0-9中的一个数字，然后设置下一位
 * 递归结束的条件是我们已经设置了数字的最后一位。
 * 此题注意防止溢出。
 */
