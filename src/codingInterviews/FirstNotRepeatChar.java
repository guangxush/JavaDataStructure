package codingInterviews;
import java.util.*;
/**
 * 在字符串中找出第一个只出现一次的字符。如果输入“abaccdeff”,则输出‘b’。
 */
public class FirstNotRepeatChar {
	public Character firstNotRepeatChar(String str){
		LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
		for(int i=0;i<str.length();i++) {
			if(map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			}else {
				map.put(str.charAt(i), 1);
			}
		}
		for(char key:map.keySet()) {
			if(map.get(key)==1)
				return key;
		}
		return null;
	}
	public static void main(String[] args) {
		FirstNotRepeatChar p=new FirstNotRepeatChar();
		System.out.println(p.firstNotRepeatChar("agbaccdeff"));
	}
}
