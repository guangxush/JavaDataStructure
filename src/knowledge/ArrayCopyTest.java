package knowledge;

import java.util.Arrays;

public class ArrayCopyTest {
    public static void main(String[] args) {
        int[] origin = {1,0,3,4,0,2,5,6,7,0,9};
        System.out.println(Arrays.toString(origin));
        int[] traget = new int[origin.length];
        int j = 0;
        for(int i=0;i<origin.length;i++){
            if(origin[i]==0) continue;
            traget[j++] = origin[i];
        }
        System.out.println(Arrays.toString(traget));
        int[] target2 = Arrays.copyOfRange(traget,0,j);
        System.out.println(Arrays.toString(target2));
        int[] traget3 = new int[origin.length];
        int k = 0;
        for(int m=0;origin[m]!=0&&m<origin.length;m++){
            traget3[k++] = origin[m];
        }
        System.out.println(Arrays.toString(traget3));
        System.out.println(Arrays.toString(origin));
    }
}
