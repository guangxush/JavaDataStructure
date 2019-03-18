package knowledge;

/**
 * @author: guangxush
 * @create: 2019/03/18
 * 测试引用和值
 */
public class ReferenceAndValueTest {
    public static void main(String[] args) {
        A a = new A();
        System.out.print(a+" ");
        System.out.println(a.val);


        a.val=2;
        System.out.print(a+" ");
        System.out.println(a.val);


        updateValue(a);
        System.out.print(a+" ");
        System.out.println(a.val);

        System.out.print(a+" ");
        System.out.println(a.next);

        updateNext(a);

        System.out.print(a+" ");
        System.out.print(a.next+" ");
        System.out.println(a.next.val);

        a.next = null;
        System.out.println(a.next+" ");

//        updateNext(a.next);
//        System.out.print(a+" ");
//        System.out.print(a.next.next+" ");
//        System.out.println(a.next.next.val);

        String str = "hello";
        updateString(str);
        System.out.println(str);

//        String str1 = new String("change");
//        updateString(str1);
//        System.out.println(str1);
    }

    public static void updateValue(A a){
        a.val = 3;
    }

    public static void updateNext(A a){
        A a1 = new A(4);
        a.next = a1;
    }

    public static void updateString(String str){
        str = "world";
        System.out.println(str);
    }

}
class A{
    int val = 1;
    A next;
    public A(int x){
        this.val = x;
    }
    public A(){

    }
}
