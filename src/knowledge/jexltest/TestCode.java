package knowledge.jexltest;

import org.apache.commons.jexl3.*;

/**
 * @author: guangxush
 * @create: 2019/08/01
 */
public class TestCode {
    public static void main(String[] args) {
        JexlEngine engine = new JexlBuilder().create();//创建表达式引擎对象
        JexlContext context = new MapContext();//创建Context设值对象
        String expressionStr = "if(a>b){c=a;}else{c=b};";//表达式，表达式为逻辑语句
        context.set("a", 1);
        context.set("b", 2);
        JexlScript script = engine.createScript(expressionStr);//使用引擎创建表达式对象
        Object o = script.execute(context);//使用表达式对象开始计算
        System.out.println(o);//输出：2

        expressionStr = "while(a<b){a=a+b;}";
        JexlScript script1 = engine.createScript(expressionStr);//使用引擎创建表达式对象
        o = script1.execute(context);//使用表达式对象开始计算
        System.out.println(o);//输出：3

        JexlContext jc = new MapContext();
        jc.set("a", 1);
        jc.set("b", "0");
        jc.set("ans", new StringBuffer());
        JexlScript script2 = engine.createScript("while (a < 10) {a = a + 1;ans.append(b);}");
        Object result = script2.execute(jc);
        System.out.println(jc.get("ans"));
        System.out.println(result);
    }
}
