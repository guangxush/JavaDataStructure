package knowledge.compareto;

import java.util.*;
import java.util.Map.Entry;

/**
 * @author: guangxush
 * @create: 2019/10/02
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        String str = "abbsdd 2339001";
        Map map = test.statistics(str, "small2big");
        test.print(map);
        System.out.println("--------------");
        test.sortPrint(map);
    }

    public Map statistics(String str, String sort) {
        Map<Character, Integer> map = null;
        switch (sort) {
            case "big2small":
                map = new TreeMap<>(new Comparator<Character>() {
                    @Override
                    public int compare(Character o1, Character o2) {
                        return o1.compareTo(o2);
                    }
                });
                break;
            case "small2big":
                map = new TreeMap<>(new Comparator<Character>() {
                    @Override
                    public int compare(Character o1, Character o2) {
                        return o2.compareTo(o1);
                    }
                });
                break;
            default:
                map = new TreeMap<>();
        }
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (!('a' <= c && c <= 'z' || 'A' <= c && c <= 'Z' || '0' <= c && c <= '9')) {
                continue;
            }
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    public void print(Map map) {
        for (Object entry : map.keySet()) {
            System.out.println(entry + "出现的次数是:" + map.get(entry));
        }
    }

    public void sortPrint(Map map) {
        /**
         * 通过List进行排序
         */
        List<Entry<Character, Integer>> entries = new ArrayList<Entry<Character, Integer>>(map.entrySet());
        Collections.sort(entries, new Comparator<Entry<Character, Integer>>() {
            @Override
            public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
                int result = o1.getValue().compareTo(o2.getValue());
                if (result == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return result;
            }
        });
        /**
         * 循环输出
         */
        for (Entry<Character, Integer> entry : entries) {
            System.out.println(entry.getKey() + "出现的次数是:" + entry.getValue());
        }
    }

}