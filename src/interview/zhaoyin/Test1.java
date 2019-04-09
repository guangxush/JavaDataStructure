package interview.zhaoyin;

import java.util.Scanner;

/**
 * @author: guangxush
 * @create: 2019/04/09
 */
public class Test1 {
    static final int mod = 666666666;

    public static int B(int n, int k){
        if(k>n || n<=0){
            return 0;
        }
        if(k == 1 || k == n){
            return 1;
        }
        int sum = 0;
        int num = n-k;
        for(int i=1; i<=k; i++){
            sum += B(num,i) % mod;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        if(n <= 5){
            System.out.println(0);
        }else{
            for(int i=6; i<=n; i++){
                int sumi = 0;
                for(int j=1; j<=n-1; j++){
                    if(n-i == 0){
                        break;
                    }
                    int tmp = B(n-i, j);
                    if(tmp == 0){
                        break;
                    }else{
                        sumi += tmp % mod;
                    }
                }
                if(n-i != 0){
                    sum += sumi % mod;
                }else{
                    sum += 1 % mod;
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}
