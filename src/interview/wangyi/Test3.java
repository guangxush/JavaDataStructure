package interview.wangyi;

import java.util.Scanner;

/**
 * @author: guangxush
 * @create: 2019/08/03
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((a[i]+a[j])%2!=0&&compare(a[j], a[i])){
                    swap(a, i, j);
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }

    private static boolean compare(int x, int y){
        String a = String.valueOf(x);
        String b = String.valueOf(y);
        if(a.compareTo(b)<0){
            return true;
        }
        return false;
    }

    private static int[] swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return a;
    }
}
