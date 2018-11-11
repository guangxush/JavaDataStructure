package codingInterviews;

public class DuplicateNumbers {
    //使用hashmap实现
    public static boolean getDuplicateNumbers(int[] numbers,int length, int[] duplication){
        if(length<=1) return false;
        boolean[] k = new boolean[length];
        for(int i=0;i<length;i++){
            if(k[numbers[i]]==true){
                duplication[0] = numbers[i];
                return true;
            }
            k[numbers[i]] = true;
        }
        return false;
    }

    //改变原来数组元素顺序，将按照数组元素的大小放到数组对应的下标位置
    //将数组元素4放到下标numbers[4]中。当遇到numbers[i] == numbers[numbers[i]]时，说明数组中出现了重复
    public static boolean getDupNumByPosition(int[] numbers,int length, int[] duplication){
        if(numbers==null||length==0) return false;
        //判断数组里面的元素在0-n之间
        for(int i=0;i<length;i++){
            if(numbers[i]<0||numbers[i]>length)
                return false;
        }
        for(int i=0;i<length;i++){
            while (numbers[i]!=i){
                if(numbers[i]==numbers[numbers[i]]){
                    duplication[0]=numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }

    //不改变原数组的情况下，把0~n-1的数字从中间的数字m,分为两部分，一部分为0~m，一部分为m+1~n-1，如果整个数组中0~m之间的数字超过m个，
    // 那么这半区间肯定包含重复的数字，否则就在后一半中，这个过程和二分法很像。

    public static void main(String[] args) {
        int[] numbers = {2,3,1,5,1,4,3};
        int length = numbers.length;
        int[] duplication = new int[1];
        System.out.println(getDuplicateNumbers(numbers,length,duplication));
        System.out.println(duplication[0]);
        System.out.println(getDupNumByPosition(numbers,length,duplication));
        System.out.println(duplication[0]);
    }
}
