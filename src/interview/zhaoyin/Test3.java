package interview.zhaoyin;

import java.util.Scanner;

/**
 * @author: guangxush
 * @create: 2019/04/09
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            sum |= a[i];
            //!=1时，cnt++
            while(a[i]/2!=0){
                a[i] = a[i]/2;
                cnt++;
            }
        }
        int cnt2 = 0;
        while(sum!=0){
            sum = sum <<1;
            cnt2++;
        }
        int cnt3 = 32-cnt2;
        int ans = cnt-cnt3*n;
        System.out.println(ans);
    }
}
