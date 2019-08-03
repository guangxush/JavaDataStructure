package interview.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: guangxush
 * @create: 2019/08/03
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        double[] b = calRatio(a);
        int q = sc.nextInt();
        for(int i=0;i<q;i++){
            int x = sc.nextInt();
            System.out.println(String.format("%.6f", b[x-1]));
        }
    }

    private static double[] calRatio(int[] a){
        int totalCount = a.length;
        double[] b = new double[a.length];
        for(int i=0;i<a.length;i++){
            b[i] = countMore(a[i], a);
        }
        return b;
    }

    private static double countMore(int score, int[] a){
        double count = 0;
        double sum = a.length;
        for(int i=0;i<a.length;i++){
            if(a[i]<=score){
                count++;
            }
        }
        count --;
        return (count/sum)*100;
    }
}
