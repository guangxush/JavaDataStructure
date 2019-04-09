package interview.zhaoyin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: guangxush
 * @create: 2019/04/09
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int w = in.nextInt();
            int a[] = new int[2*n];
            for(int i=0;i<2*n;i++){
                a[i] = in.nextInt();
            }
            Arrays.sort(a);
            double girl = a[0];
            double boy = a[n];
//            double boy = a[0];
//            for(int i=1;i<n;i++){
//                if(a[i]<boy){
//                    boy = a[i];
//                }
//            }
//            double girl = a[n];
//            for(int i=n+1;i<2*n;i++){
//                if(a[i]>girl){
//                    girl = a[i];
//                }
//            }
            double boy_temp = boy/2.0;
            double min = Math.min(boy_temp, girl);
            double res = w/(3.0*n);
            double ans = 0.0;
            if(res>min){
                ans = min*3.0*n;
            }else{
                ans = res*3.0*n;
            }
            System.out.println(String.format("%.6f",ans));
        }
    }
}
