package knowledge.jexltest;

import org.apache.commons.jexl3.*;

import java.beans.Expression;

/**
 * @author: guangxush
 * @create: 2019/08/01
 */
public class TestMethod {
    public static void main(String[] args) {
        JexlEngine engine = new JexlBuilder().create();//创建表达式引擎对象
        JexlContext context = new MapContext();//创建Context设值对象
        String expressionStr = "person.getInfo()";//表达式，表达式为对象调用方法，当然也可以是类调用方法
        Person person = new Person("hliu","M");
        context.set("person", person);
        JexlScript script = engine.createScript(expressionStr);//使用引擎创建表达式对象
        Object o = script.execute(context);//使用表达式对象开始计算
        System.out.println(o);
        //输出：hliu+M

        JexlContext jc = new MapContext();
        expressionStr = "System.out.println(\"123123\");";//表达式为类调用方法
        script = engine.createScript(expressionStr);//使用引擎创建表达式对象
        o = script.callable(jc);//使用表达式对象开始计算
        System.out.println(o);
        //输出：123123
    }
}
