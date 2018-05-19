package codingInterviews;
/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字的最小的一个。例如输入{3,32,321}，则打印最小的数字是321323.
 */
public class ArraytoMinNumber {
	public void printMin(int[] array){
		int[] clone=array.clone();
		printMinNumber(clone,0,clone.length-1);
		for(int i:clone)
		System.out.print(i);
	}
	private void printMinNumber(int[] array, int start, int end) {
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array.length;j++) {
				String pre = String.valueOf(array[i])+String.valueOf(array[j]);//12 34
				String last = String.valueOf(array[j])+String.valueOf(array[i]);//34 21
				if(isSmall(pre,last)) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	private boolean isSmall(String m, String n) {
		String left=m+n;
		String right=n+m;
		boolean result=false;
		for(int i=0;i<left.length();i++)
		{
			if(left.charAt(i)<right.charAt(i))
				return true;
			else if(left.charAt(i)>right.charAt(i))
				return false;
		}
		return result;
	}
	public static void main(String[] args) {
		ArraytoMinNumber test=new ArraytoMinNumber();
		int[] array={3,32,321};
		test.printMin(array);
	}
}
