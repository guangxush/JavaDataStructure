package interview;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Description
 * @auther guangxush
 * @create 2019/3/10
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeMap<Character, Integer> map1 = new TreeMap<>();
        TreeMap<Character, Integer> map2 = new TreeMap<>();
        while (in.hasNextLine()) {
            String str = in.nextLine();
            str = toLower(str);
            char[] c = str.toCharArray();
            for(int i=0;i<c.length;i++){
                if(!map1.containsKey(c[i])){
                    map1.put(c[i],1);
                }else{
                    map2.put(c[i],2);
                }
            }
            System.out.println(map2.firstKey());
        }
    }
    private static String toLower(String a){
        char[] c = a.toCharArray();
        int diff = 'a' - 'A';
        for(int i=0;i<c.length;i++){
            if('A'<=c[i]&&c[i]<='Z'){
                c[i] = (char)(c[i] + diff);
            }
        }
        return String.valueOf(c);
    }
}
