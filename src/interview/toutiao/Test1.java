package interview.toutiao;

import java.util.Scanner;

/**
 * @author: guangxush
 * @create: 2019/03/16
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = 1024-n;
            int count = 0;
            int x = m/64;
            count += x;
            m = m%64;
            x = m/16;
            count += x;
            m = m%16;
            x = m/4;
            count += x;
            m = m%4;
            x = m/1;
            count += x;
            System.out.println(count);
        }
    }
}
