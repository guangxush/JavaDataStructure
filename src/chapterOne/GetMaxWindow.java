package chapterOne;

import java.util.LinkedList;

/**
 * 复杂度O(n)情况下求窗口的最大值
 */
public class GetMaxWindow {
	public int[] getMaxWindow(int[] arr,int w) {
		if(arr==null||w<1||arr.length<w) {
			return null;
		}
		LinkedList<Integer> qmax = new LinkedList<Integer>();//双端队列用于存放数组的下标
		int[] res = new int[arr.length-w+1];
		int index =0;
		for(int i=0;i<arr.length-1;i++) {
			while(!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[i]) {
				qmax.pollLast();
			}
			qmax.addLast(i);
			if(qmax.peekFirst()==i-w) {
				qmax.pollFirst();
			}
			if(i>=w-1) {
				res[index++]=arr[qmax.peekFirst()];
			}
		}
		return res;
	}
}
