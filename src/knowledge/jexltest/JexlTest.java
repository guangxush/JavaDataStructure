package knowledge.jexltest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: guangxush
 * @create: 2019/07/31
 */
public class JexlTest {
    public static void main(String[] args) {
        //1.创建jexl
        JexlEngine jexl = new JexlBuilder().create();

        // 2.做一个jexlContext并把它放入其中, MapConext类clear方法可以清空set过的值
        JexlContext jc = new MapContext();

        // 3.设置变量的值,这个值可以在执行的表达式中调用
        jc.set("i",3);
        jc.set("j",4);

        // 4.创建一个将要执行的表达式
        JexlExpression e = jexl.createExpression("i+j");
        // 5.执行并返回结果
        Object o = e.evaluate(jc);
        System.out.println(jc.get("i") + "+"+ jc.get("j") + " = " + o);

        //一个正则的执行方式
        jc.set("str", "jacktan");
        jc.set("HDI_Board", "yes");
        e = jexl.createExpression("str=~\".*tan\"");
        o = e.evaluate(jc);
        System.out.println(o);

        //执行多个条件
        e=jexl.createExpression("str=~'.*tan' && str != 'jacktan'");
        System.out.println(e.evaluate(jc) + "  aaa");

        e=jexl.createExpression("HDI_Board=='yes'");
        System.out.println(e.evaluate(jc) + "  bbb");

        //执行对象方法
        JexlTest sjt = new JexlTest();
        jc.set("SimpleJexlTest",sjt);
        jc.set("UDA_NAME", "HDI_Board");
        jc.set("UDA_VALUE", "yes");

        e = jexl.createExpression("SimpleJexlTest.current(UDA_NAME,UDA_VALUE)");

        o = e.evaluate(jc);
        System.out.println(o);

        //List测试
        List<Object> l = new ArrayList<Object>();
        l.add("Hello from location 0");
        Integer two = new Integer(2);
        l.add(two);
        jc.set("array", l);
        //list的元素
        e = jexl.createExpression("array[1]");
        o = e.evaluate(jc);
        System.out.println(o);
        // list元素的长度
        e = jexl.createExpression("array[0].length()");
        o = e.evaluate(jc);
        System.out.println(o);
        //out.print("The length of the string at location 0 is : ", o, Integer.valueOf(21));
    }

    public static boolean current(String uda,String val) {
        System.out.println(uda + "  " + val);
        Map<String, String> map = new HashMap<String, String>();
        map.put("abc", "yes");
        map.put("HDI_Board", "no");
        map.put("customer_num", "9175350");
        for ( Map.Entry<String, String> entry : map.entrySet() ) {
            if ( entry.getKey().equals(uda) && entry.getValue().matches(val) ) {
                return true;
            }
        }
        return false;
    }
}
