package interview;

import java.util.Scanner;

/**
 * @Description
 * @auther guangxush
 * @create 2019/3/10
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}
