package interview;

import java.util.Scanner;

/**
 * @Description
 * @auther guangxush
 * @create 2019/3/10
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        int ans = 0;
        for(int i = 0; i < n; i++){
             a[i] = sc.nextInt();
        }
        sort_up(a);
        for(int i = 0; i < n; i++){
             b[i] = sc.nextInt();
        }
        sort_down(b);
        for(int i=0;i<n;i++){
             ans+=a[i]*b[i];
        }
        System.out.println(ans);
    }
    private static void sort_up(int[] a){
        int n = a.length;
        for(int j=0;j<n;j++){
            for(int i=0;i<n-1-j;i++){
                if(a[i]>a[i+1]){
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                }
            }
        }
    }
    private static void sort_down(int[] a){
        int n = a.length;
        for(int j=0;j<n;j++){
            for(int i=0;i<n-1-j;i++){
                if(a[i]<a[i+1]){
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                }
            }
        }
    }
}
