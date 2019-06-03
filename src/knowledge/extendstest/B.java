package knowledge.extendstest;

/**
 * @author: guangxush
 * @create: 2019/04/17
 */
public class B extends A{
    public B(String msg){
        this(msg,10);
    }
    public B(String msg, int age){
        //this(msg);
        super(msg);
        System.out.println("I am son!");
    }

//    public B(){
//        super("hello");
//        System.out.println("I am son!");
//    }
}
