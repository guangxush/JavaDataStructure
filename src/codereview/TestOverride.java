package codereview;

/**
 * @Description
 * @auther guangxush
 * @create 2019/3/7
 */
public class TestOverride {
    public void print(){
        System.out.println("father");
    }
    public void print(String str){
        System.out.println(str+"overload");
    }
}
class TestOverrideSon extends TestOverride{
    @Override
    public void print(){
        System.out.println("son");
    }
}
