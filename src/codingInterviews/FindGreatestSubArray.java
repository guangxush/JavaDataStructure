package codingInterviews;
/**
 * 输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。
 * 求所有子数组的和的最大值。要求时间复杂度为O(n)。
 * 例如输入的数组为{1，-2,3,10，-4,7,2，-5}，和最大的子数组为{3,10，-4,7,2}。
 */
public class FindGreatestSubArray {
	public int findGreatestSubArray(int[] nums){
		if(nums==null) return 0;
		int cursum =0,sum=0;
		for(int i=0;i<nums.length;i++) {
			if(cursum<=0) {
				cursum=nums[i];
			}else {
				cursum += nums[i];
			}
			if(cursum>sum)
				sum=cursum;
		}
		return sum;
	}
	public static void main(String[] args) {
		FindGreatestSubArray p=new FindGreatestSubArray();
		int[] array={1,-2,3,10,-4,7,2,-5};
		System.out.println(p.findGreatestSubArray(array));
	}
}
