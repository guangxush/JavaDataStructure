package knowledge.compareto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author: guangxush
 * @create: 2019/10/02
 */
public class Test2 {
    public String PrintMinNumber(int [] numbers) {
        StringBuffer sb = new StringBuffer();
        ArrayList<Integer> list = new ArrayList<>();
        int len = numbers.length;
        for(int i=0;i<len;i++){
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer str1, Integer str2) {
                String s1 = ""+str1+str2;
                String s2 = ""+str2+str1;
                return s1.compareTo(s2);
            }
        });
        for(int j : list){
            sb.append(j);
        }
        return sb.toString();
    }
}
