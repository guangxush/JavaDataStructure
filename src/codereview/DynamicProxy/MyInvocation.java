package codereview.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by gshan on 2018/11/18
 */
public class MyInvocation implements InvocationHandler {

    private Object target;

    public MyInvocation(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)throws Throwable{
        //前置通知
        System.out.println("before");
        //返回代理对象
        Object resultObject = method.invoke(target,args);
        //后置通知
        System.out.println("after");
        return resultObject;
    }

}
