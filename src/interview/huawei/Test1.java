package interview.huawei;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author: guangxush
 * @create: 2019/04/10
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            TreeSet<String> set = new TreeSet<>();
            for(int i=0;i<n;i++){
                String str = in.next();
                while(str.length()>8){
                    String temp = str.substring(0,8);
                    set.add(temp);
                    str = str.substring(8);
                }
                while(str.length()<=8){
                    str+='0';
                }
                set.add(str);
            }
            String[] arr = (String[])set.toArray(new String[0]);
            for(int i=0;i<arr.length-1;i++){
                System.out.print(arr[i]+' ');
            }
            System.out.println(arr[arr.length-1]);
            System.out.println();
        }
    }
}
