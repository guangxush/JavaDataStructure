package knowledge;

/**
 * Created by gshan on 2018/11/4
 */
public class TestException{
    public static void test1() throws Exception1{
        System.out.println("hello!");
        try{
            System.out.println("hello!");
        }catch(Exception e){
            throw new Exception1("");
        }
    }

    public static void test2() throws Exception2{
        System.out.println("world!");
        try{
            System.out.println("world!");
        }catch(Exception e){
            throw new Exception2("");
        }
    }

    public static void test3(){
        try {
            test1();
        } catch (Exception1 exception1) {
            exception1.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception1 {
        test1();//if main don't throws will error
        test2();
        test3();
    }
}

class Exception1 extends Exception{
    public Exception1(String msg){
        super(msg);
    }
    public Exception1(String msg,Exception e){
        super(msg, e);
    }
}

class Exception2 extends RuntimeException{
    public Exception2(String msg){
        super(msg);
    }
    public Exception2(String msg,Exception e){
        super(msg, e);
    }
}
