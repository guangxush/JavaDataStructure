package interview.toutiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: guangxush
 * @create: 2019/03/16
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }
        int min =1;
        int max = 20000000*n/m;
        int mid = 0;
        int c = 0;
        while(min<max){
            mid = (min+max+1)/2;
            c = 0;
            for(int i=0;i<n;i++){
                c+=a[i]/mid;
            }
            if(c<m){
                max = mid-1;
            }else{
                min = mid;
            }
        }
        System.out.println((float) min);
    }
}
