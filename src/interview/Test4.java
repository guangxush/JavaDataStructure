package interview;

import java.util.Scanner;

/**
 * @Description
 * @auther guangxush
 * @create 2019/3/10
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int max = 0;
        int[][] array = new int[n][2];
        for(int i=0; i<n; i++){
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(array[i][0] - array[j][0] >= d || array[j][0] - array[i][0] >= d){
                    int sum = array[i][1]+array[j][1];
                    max = sum > max ? sum : max;
                }
            }
        }
        System.out.println(max);
    }
}
