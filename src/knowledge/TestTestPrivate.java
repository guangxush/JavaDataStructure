package knowledge;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by gshan on 2018/11/7
 */
public class TestTestPrivate extends TestCase {

    @Test
    public void testPrivate(){
        TestPrivate testPrivate = new TestPrivate();
        //得到class对象
        Class<TestPrivate> clazz = TestPrivate.class;
        //得到方法
        try{
            Method method = clazz.getDeclaredMethod("method",new Class[]{String.class});
            method.setAccessible(true);
            Object result = method.invoke(testPrivate,new Object[]{"hello"});
            Assert.assertEquals("hello",result);
        }catch(Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
}
