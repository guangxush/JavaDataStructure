package chapterZero;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gshan on 2018/11/3
 * 将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。
 * 这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列。
 */
public class RadixSort {
    public static void radixSort(int[] array){
        //首先确定排序的趟数
        int max = array[0];
        for(int i=1;i<array.length;i++){
            if(array[i]>max){
                max = array[i];
            }
        }
        int time = 0;
        //判断位数
        while(max>0){
            max /= 10;
            time++;
        }
        //建立10个队列
        List<ArrayList> queue = new ArrayList<>();
        for(int i=0;i<10;i++){
            ArrayList<Integer> queue_temp = new ArrayList<>();
            queue.add(queue_temp);
        }

        //进行time次分配和收集
        for(int i=0;i<time;i++){
            //分配数组元素
            for(int j=0;j<array.length;j++){
                //得到数字的第time+1位数
                int x = array[j]%(int)Math.pow(10,i+1)/(int)Math.pow(10,i);
                ArrayList<Integer> queue_temp = queue.get(x);
                queue_temp.add(array[j]);
                queue.set(x, queue_temp);
            }
        }
        int count = 0;//元素计数器
        //收集队列元素
        for(int k=0;k<10;k++){
            while(queue.get(k).size()>0){
                ArrayList<Integer> queue_result = queue.get(k);
                array[count++] = queue_result.get(0);
                queue.remove(0);
            }
        }
    }
}
