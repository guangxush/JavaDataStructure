package interview.wangyi;

import java.util.Scanner;

/**
 * @author: guangxush
 * @create: 2019/08/03
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        for(int i=0;i<q;i++){
            int x = sc.nextInt();
            int y = desercase(a, x);
            System.out.println(y);
        }
    }

    private static int desercase(int[] a, int x){
        int count = 0;
        for(int i=0;i<a.length;i++){
            if(a[i]>=x){
                a[i] -- ;
                count ++;
            }
        }
        return count;
    }
}
