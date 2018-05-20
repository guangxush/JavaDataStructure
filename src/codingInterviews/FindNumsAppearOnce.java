package codingInterviews;

import java.util.*;

/**
 *一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 *请写程序找出这两个只出现一次的数字。要求时间复杂度是O（n），空间复杂度为O（1）
 */
public class FindNumsAppearOnce {
	public void findNumsAppearOnce(int[] array){
		if(array==null) return;
		int number=0;
		for(int i:array)
			number^=i;
		int index=findFirstBitIs1(number);
		int number1=0;
		int number2=0;
		for(int i:array){
			if(isBit1(i,index))
				number1^=i;
			else
				number2^=i;
		}
		System.out.println(number1);
		System.out.println(number2);
	}
	private int findFirstBitIs1(int number) {
		int indexBit=0;
		while((number&1)==0){
			number=number>>1;
			++indexBit;
		}
		return indexBit;
	}
	private boolean isBit1(int number, int index) {
		number=number>>index;
		return (number&1)==0;
	}
	//采用辅助数组的方法
	public void FindNumsAppearOnceUseList(int [] array,int num1[] , int num2[]) {
        ArrayList<Integer>list=new ArrayList<Integer>();
        for(int i=0;i<array.length;i++)
        {
            if(!list.contains(array[i]))
                list.add(array[i]);
            else
                list.remove(new Integer(array[i]));
        }
        if(list.size()>1)
        {
            num1[0]=list.get(0);
            num2[0]=list.get(1);
        }
	}
	//使用HashMap
	public void findNumsAppearOnceuseMap(int[] array){
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<array.length;i++) {
			if(!map.containsKey(array[i])) {
				map.put(array[i], 1);
			}else {
				map.put(array[i], map.get(array[i])+1);
			}
		}
		for(int key:map.keySet()) {
			if(map.get(key)==1)
				System.out.println(map.get(key));
		}
	}
	public static void main(String[] args) {
		int[] array={2,4,3,6,3,2,5,5};
		FindNumsAppearOnce p=new FindNumsAppearOnce();
		p.findNumsAppearOnce(array);
	}
}
/**
//1. 除了有两个数字只出现了一次，其他数字都出现了两次。异或运算中，任何一个数字和自己本身异或都是0，任何一个数字和0异或都是本身。 
//2. 如果尝试把原数组分成两个子数组，且刚好每个子数组中各自包含一个只出现一次的数字。则在该前提下，每个子数组中，只有一个数字出现了一次，其他数字都出现了两次。 
//3. 针对每个子数组，从头到尾依次异或每个数字，则最后留下来的就是只出现了一次的数字。因为出现两次的都抵消掉了。 
//4. 怎样实现子数组的划分呢。若对原数组从头到尾的进行异或，则最后得到的结果就是两个只出现一次的数字的异或运算结果。这个结果的二进制表示中，至少有一位为1，因为这两个数不相同。该位记为从最低位开始计数的第n位。 
//5. 则分组的标准定为从最低位开始计数的第n位是否为1。因为出现两次的同一个数字，各个位数上都是相同的，所以一定被分到同一个子数组中，且每个子数组中只包含一个出现一次的数字。
 */
