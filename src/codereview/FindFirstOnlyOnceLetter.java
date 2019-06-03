package codereview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: guangxush
 * @create: 2019/03/13
 */
public class FindFirstOnlyOnceLetter {
    public static void main(String[] args) {
        String str= "abaccdefd";
        System.out.println(find(str));
    }

    public static char find(String str){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i)+1));
            }else{
                map.put(str.charAt(i),1);
            }
        }
        for(int i=0;i<str.length();i++){
            if(map.get(str.indexOf(i))==1){
                return (char) str.indexOf(i);
            }
        }
        return ' ';
    }
}
