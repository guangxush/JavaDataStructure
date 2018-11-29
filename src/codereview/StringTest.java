package codereview;

public class StringTest {
    public static void main(String[] args) {
        String a = "hello";
        System.out.println(a);
        modifyString(a);
        System.out.println(a);
        System.out.println("---------------");

        String b = new String("world");
        System.out.println(b);
        modifyString(b);
        System.out.println(b);
        System.out.println("---------------");

        String c = b;
        b += "test";
        System.out.println(c);
        System.out.println(b);
        System.out.println("---------------");

        String d = new String("");
        b += "hello b";
        d = b;
        System.out.println(d);
        System.out.println(b);
        System.out.println("---------------");
    }
    public static void modifyString(String str){
        str += "modify";
    }
}
