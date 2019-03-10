package interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Description
 * @auther guangxush
 * @create 2019/3/10
 */
public class Test3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[][] bankInfo = new int[n][2];
        for (int i = 0; i < n; i++) {
            bankInfo[i][0] = sc.nextInt();
            bankInfo[i][1] = sc.nextInt();
        }
        Arrays.sort(bankInfo, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] pos = new int[n];
        int[] profit = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = bankInfo[i][0];
            profit[i] = bankInfo[i][1];
        }
        int basePos = pos[0];
        int startIndex = 0;
        for (; startIndex < n; startIndex++) {
            if (pos[startIndex] - basePos >= d) {
                break;
            }
        }
        int frontMaxProfit = profit[0];
        int headIndex = 0;
        int res = 0;
        for (int i = startIndex; i < n; i++) {
            while (true) {
                frontMaxProfit = Math.max(frontMaxProfit, profit[headIndex]);
                if (pos[i] - pos[headIndex + 1] < d) {
                    break;
                } else {
                    headIndex++;
                }
            }
            res = Math.max(res, frontMaxProfit + profit[i]);
        }
        System.out.println(res);
    }
}
