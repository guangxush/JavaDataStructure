package codingInterviews;
/**
 * 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 */
public class RotatetheMinimumNumberofArrays {
	public static Integer findMinNum(int[] array) {
		if(array==null)
			return null;
		int left = 0;
		int right = array.length-1;
		int mid = left+(right-left)/2;
		while(array[left]>=array[right]) {
			if(right-left<=1) {
				mid = right;
				break;
			}
			mid = left+(right-left)/2;
			//如果下标三个数字相同，那么只能顺序查找
			if(array[left]==array[right]&&array[left]==array[right]) {
				return orderSearch(array,left,right);
			}
			if(array[left]<=array[mid])
				left = mid;
			else if(array[right]>=array[mid])
				right = mid;
		}
		return array[mid];
	}
	public static int orderSearch(int[] array,int left,int right) {
		int result = array[left];
		for(int i=left+1;i<=right;i++) {
			if(result>array[i])
				result = array[i];
		}
		return result;
	}
	public static void main(String[] args) {
		int[] array = {1,1,1,2,0};
		int[] array1 = {3,4,5,1,2};
		int[] array2 = {1,0,1,1,1};
		System.out.println(findMinNum(array));
		System.out.println(findMinNum(array1));
		System.out.println(findMinNum(array2));
	}
}
/**
 * 旋转之后的数组其实是两个排好序的子数组，前面的组数组元素都大于等于后面子数组的元素
 * 最小元素刚好是前面数组和后面数组的分解线，在排序的数组中可以用二分查找方法实现
 * 两个指针分别指向数组第一个元素和最后一个元素
 * 如果中间元素大于前面的一个元素，说明中间元素属于前面一部分，左指针指向中间元素
 * 如果中间元素小于前面的一个元素，说明中间元素属于后面的一部分，右指针指向中间元素
 * 如果左右指针指向的两个相邻的数字，那么右指针指向的是数组中最小的数字
 * 当两个指针指向的数字以及他们的中间数字相同的时候无法判断中间数字是位于前面的还是后面的
 * 这时不得不采取顺序查找的方法
 */