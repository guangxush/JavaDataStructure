package interview.wangyi;

import java.util.Scanner;

/**
 * @author: guangxush
 * @create: 2019/08/03
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            long n = sc.nextLong();
            long a[] = new long[(int) n];
            for(int j = 0; j < n; j++){
                a[j] = sc.nextLong();
            }
            for(int j=1;j<n-1;j++){
                if(a[j]>a[j-1]+a[j+1]){
                    System.out.println("NO");
                }
            }
            if(a[0]>a[1]+a[(int) (n-1)]||a[(int) (n-1)]>a[(int) (n-2)]+a[0]){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }
}
