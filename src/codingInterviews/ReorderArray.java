package codingInterviews;
/**
 * 输入一个整数数组，实现一个函数来调整该函数数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，
 * 所有的数组位于数组的后半部分。
 */
public class ReorderArray {
	public void reorderArray(int[] nums) {
		if(nums==null||nums.length==0) return;
		int start = 0,end = nums.length-1;
		while(start<end) {
			while(start<end&&!isEven(nums[start])) {//前面的是奇数
				start++;
			}
			while(start<end&&isEven(nums[end])) {//后面的是偶数
				end--;
			}
			if(start<end) {
				int temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
			}
		}
	}
	private boolean isEven(int n) {//even表示偶数odd表示奇数
		return n%2==0;
	}
	public static void main(String args[])
	{
		int[] array={1,2,3,4,5,6,7};
		ReorderArray test=new ReorderArray();
		test.reorderArray(array);
		for(int item:array)
			System.out.println(item);
	}
}
