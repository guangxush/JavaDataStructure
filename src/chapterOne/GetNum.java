package chapterOne;

import java.util.LinkedList;

/**
 * 给定数组arr和整数num,共返回有多少个子数组满足如下情况
 * max(arr[i..j]-min(arr[i..j])<=num)
 */
public class GetNum {
    public int getNum(int[] arr, int num){
        if(arr==null||arr.length==0) return 0;
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int i=0,j=0,res=0;
        while(i<arr.length){
            while(j<arr.length){
                while(!qmin.isEmpty()&&arr[qmin.peekLast()]>=arr[j]){
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while(!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[j]){
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if(arr[qmax.getFirst()]-arr[qmin.getFirst()]>num){
                    break;
                }
                j++;
            }
            if(qmin.peekFirst()==i){
                qmin.pollFirst();
            }
            if(qmax.peekFirst()==i){
                qmax.pollFirst();
            }
            res+=j-i;
            i++;
        }
        return res;
    }
}
