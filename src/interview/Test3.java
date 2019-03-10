package interview;

import java.util.Scanner;

/**
 * @Description
 * @auther guangxush
 * @create 2019/3/10
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.toLowerCase();
        int i=0;
        while(i<str.length()-1){
            if(str.charAt(i) > str.charAt(i+1) && str.lastIndexOf(str.charAt(i))-i>0){
                str = str.substring(0, i) + str.substring(i+1);
                i--;
            }
            i++;
        }
        System.out.println(str.charAt(0));
    }
}
