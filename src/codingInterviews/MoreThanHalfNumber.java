package codingInterviews;
/**
 * 数组中有一个数字出现次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 2出现的次数超过数组长度的一半，因此输出2.
 */
public class MoreThanHalfNumber {
	//快速排序的方式，然后找到中间节点即可
	public int MoreThanHalfNumber1(int[] nums) {
		quickSort(nums,0,nums.length-1);
		int result = nums[nums.length/2];
		System.out.println(result);
		return result;
	}
	/**
	 * 快速排序
	 * @param src
	 * @param begin
	 * @param end
	 */
	public static void quickSort(int[] src, int begin, int end) {
		if(begin<end) {
			int key = src[begin];//选一个基准位置
			int i = begin;
			int j = end;
			while(i<j) {
				while(i<j&&src[j]>key) {
					j--;
				}
				if(i<j) {
					src[i]=src[j];
					src[j]=key;
					i++;
				}
				while(i<j&&src[i]<key) {
					i++;
				}
				if(i<j) {
					src[j]=src[i];
					src[i]=key;
					j--;
				}
			}
			quickSort(src,begin,i-1);
			quickSort(src,i+1,end);
		}
	}
	/* 
     * 方法1：如果输入数组符合要求，那么所求数字的出现次数要多于其他所有数字次数之和 
     *      该方法不需要对输入数组进行操作 
     */  
    public int MoreThanHalfNum2(int[] array) {  
        if(array==null)  
            return 0;  
        int N=array.length;  
        int root=0;  
        int count=0;  
        for(int i=0;i<N;i++){  
            if(count==0){  
                root=array[i];  
                count=1;  
            }  
            if(array[i]==root){  
                count++;  
            }else{  
                count--;  
            }  
        }  
        //判断数组中是否存在出现次数大于一半的数字  
        if (checkArray(array, root)) {  
            return root;  
        } else  
            return 0;  
    } 
    //检查数组是否存在出现次数超过一半的数字  
    private boolean checkArray(int[] array, int root) {  
        int N = array.length;  
        int num = 0;  
        for (int i = 0; i < N; i++) {  
            if (array[i] == root) {  
                num++;  
            }  
        }  
        if (num * 2 > N)  
            return true;  
        else  
            return false;  
    }
    /* 
     * 方法二：利用快速排序的partition方法找到处于N/2位置的元素，如果输入数组符合要求 
     *       那么该元素即为所求数字 
     *       该方法会对输入数组进行操作 
     */  
    public int MoreThanHalfNum3(int[] array) {  
        //判空  
        if (array == null)  
            return 0;  
        int N = array.length;  
        int middle = N / 2;  
        int index = partition(array, 0, N - 1);  
        while (index != middle) {  
            if (index > middle) {  
                index = partition(array, 0, index - 1);  
            } else  
                index = partition(array, index + 1, N - 1);  
        }  
        // 判断数组是否存在出现次数超过一般的数字  
        if (checkArray(array, array[index])) {  
            return array[index];  
        } else  
            return 0;  
    }
    //快速排序中的partition方法  
    private int partition(int[] array, int left, int right) {  
        // 判断数组是否只有一个元素  
        if (left == right)  
            return left;  
        int root = array[left];  
        int i = left;
        int j = right + 1;  
        while (true) {  
            while (array[++i] <= root) {  
                if (i == right)  
                    break;  
            }  
            while (array[--j] >= root) {  
                if (j == left)  
                    break;  
            }  
            if (i < j)  
                exch(array, i, j);  
            else  
                break;  
        }  
        exch(array, left, j);  
        return j;  
    } 
    //数组中两个元素交换顺序
    private void exch(int[] array, int i, int j) {  
        int tmp = array[i];  
        array[i] = array[j];  
        array[j] = tmp;  
    }
    public static void main(String[] args) {
    	int[] array={1,2,3,2,2,2,5,4,2};
    	MoreThanHalfNumber p=new MoreThanHalfNumber();
    	System.out.println(p.MoreThanHalfNumber1(array));
    }
}
