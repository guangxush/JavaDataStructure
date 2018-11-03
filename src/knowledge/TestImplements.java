package knowledge;

/**
 * Created by gshan on 2018/11/3
 * 测试一个类实现两个接口中相同名称的方法
 */
public class TestImplements implements I1,I2{

    @Override
    public void run(){
        System.out.println("hello");
    }

    public static void main(String[] args) {
        I1 i1 = new TestImplements();
        i1.run();
        I2 i2 = new TestImplements();
        i2.run();
    }
}

interface I1{
    void run();
}

interface I2{
    void run();
}

/**
 * 测试接口
 * 方法和属性尽量不要加任何修饰符
 */
interface I3{

    public static final String TEST = "123";

    public abstract void run();

}