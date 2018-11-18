package codereview.DynamicProxy;

import java.lang.reflect.Proxy;

/**
 * Created by gshan on 2018/11/18
 */
public class TestDynamicProxy {

    public static void main(String[] args) {
        MyInvocation myInvocationHadler = new MyInvocation(new Test());
        ITest proxy = (ITest) Proxy.newProxyInstance(MyInvocation.class.getClassLoader()
                ,new Class[]{ITest.class},myInvocationHadler);
        proxy.example();
    }
}
