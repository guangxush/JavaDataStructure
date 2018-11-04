package knowledge;

/**
 * Created by gshan on 2018/11/4
 */

public class TestStatic {
    public static String value1 = null;

    static{
        value1 = "hello!";
    }

    public static String value2 = null;


    public static void init(){
        value2 = "world!";
    }

    public static void main(String[] args) {
        System.out.println(value1);
        System.out.println(value2);
    }
}
