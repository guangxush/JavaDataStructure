package codereview;

/**
 * Created by gshan on 2018/11/17
 */
public class DPtest {
    //计算最大子段和
    public static int findGreatestSubArray(int[] a){
        if(a==null) return 0;
        int sum = 0;
        int max = 0;
        for(int i=0;i<a.length;i++){
            if(sum<=0)
                sum = a[i];
            else
                sum += a[i];
            if(sum>max)
                max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array={1,-2,3,10,-4,7,2,-5};
        System.out.println(findGreatestSubArray(array));
    }
}
