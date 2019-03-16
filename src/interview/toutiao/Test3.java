package interview.toutiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: guangxush
 * @create: 2019/03/16
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int m = sc.nextInt();
            int[] a = new int[m];
            int[] b = new int[m];
            for(int j = 0; j < m; j++){
                a[j] = sc.nextInt();
                b[j] = 1;
            }
            for(int j=1;j<m;j++){
                if(a[j-1]<=a[j]){
                    b[j] = b[j-1]+1;
                }
            }
            int sum = 0;
            for(int j=0;j<m;j++){
                sum+=b[j];
            }
            System.out.println(sum);
        }
    }
}
