package interview.huawei;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author: guangxush
 * @create: 2019/04/10
 */
public class Test1_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            TreeSet<String> set = new TreeSet<>();
            int count = 0;
            for(int i=0;i<n;i++){
                String str = in.next();
                while(str.length()>8){
                    String temp = str.substring(0,8);
                    if(set.contains(temp)){
                        set.add(temp+(count++));
                    }
                    set.add(temp);
                    str = str.substring(8);
                }
                while(str.length()<=8){
                    if(set.contains(str)){
                        set.add(str+(count++));
                    }
                    str+='0';
                }
                set.add(str);
            }
            String[] arr = (String[])set.toArray(new String[0]);
            for(int i=0;i<arr.length-1;i++){
                if(arr[i].length()>8){
                    System.out.print(arr[i].substring(0,8)+' ');
                }else{
                    System.out.print(arr[i]+' ');
                }
            }
            System.out.println(arr[arr.length-1]);
            System.out.println();
        }
    }
}
