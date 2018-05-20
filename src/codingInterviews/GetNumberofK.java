package codingInterviews;
/**
 * 统计一个数字在排序数组中出现的次数。
 * 例如输入排序数组{1,2,3,3,3，3,3,4,5}和数字3，
 * 由于3在这个数组中出现了4次，因此输出4。
 */
public class GetNumberofK {
	private int getNumberOfK(int[] array, int k) {
		int number=0;
		if(array!=null){
			//找到开始位置
			int first=getFirstK(array,k,0,array.length-1);
			//找到结束位数
			int last=getLastK(array,k, 0, array.length-1);
			if(first>-1&&last>-1)
				number=last-first+1;
		}
		return number;
	}
	private int getFirstK(int[] array, int k,int start, int end) {
		if(start>end) return -1;
		int mid = start+(end-start)/2;
		if(array[mid]==k) {
			if(mid>0&&array[mid-1]!=k||mid==0) {
				return mid;
			}else {
				end = mid-1;
			}
		}else if(array[mid]>k) {
			end = mid-1;
		}else {
			start = mid+1;
		}
		return getFirstK(array, k, start, end);
	}
	private int getLastK(int[] array,int k, int start, int end) {
		if(start>end) return -1;
		int mid = start+(end-start)/2;
		if(array[mid]==k) {
			if(mid<array.length-1&&array[mid+1]!=k||mid==array.length-1) {
				return mid;
			}else {
				start = mid+1;
			}
		}else if(array[mid]<k) {
			start=mid+1;
		}else {
			end= mid-1;
		}
		return getLastK(array, k, start, end);
	}
	public static void main(String[] args) {
		GetNumberofK p=new GetNumberofK();
		int[] array={1,2,3,3,3,3,4,5};
		System.out.println(p.getNumberOfK(array, 3));
	}
}
