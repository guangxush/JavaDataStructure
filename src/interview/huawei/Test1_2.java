package interview.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: guangxush
 * @create: 2019/04/10
 */
public class Test1_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = in.next();
                while (str.length() > 8) {
                    String temp = str.substring(0, 8);
                    list.add(temp);
                    str = str.substring(8);
                }
                while (str.length() < 8) {
                    str += '0';
                }
                list.add(str);
            }
            String[] array = (String[]) list.toArray(new String[list.size()]);
            Arrays.sort(array);
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + ' ');
            }
        }
    }
}
