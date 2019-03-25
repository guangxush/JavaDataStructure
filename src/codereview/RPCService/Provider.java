package codereview.RPCService;


import codereview.RPCService.impl.RPCServiceImpl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: guangxush
 * @create: 2019/03/25
 */
public class Provider {
    public static void main(String[] args) {
        try{
            System.out.println("服务器提供者等待客户端调用....");

            //服务注册
            Map<Object, Object> serviceRegister = new HashMap<>();
            serviceRegister.put(RPCService.class, new RPCServiceImpl());

            //使用循环等待模式模拟服务器等待过程
            ServerSocket server = new ServerSocket(8088);
            while(true){
                Socket socket = server.accept();
                //读取服务信息
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //获取接口名称
                String interfaceName = ois.readUTF();
                //获取方法名称
                String methodName = ois.readUTF();
                //获取参数类型
                Class<?>[] paramType = (Class<?>[]) ois.readObject();
                //获取参数对象
                Object[] argsObj = (Object[]) ois.readObject();
                //获取方法调用，调用本地服务
                Class serviceInterfaceClass = Class.forName(interfaceName);
                Object service = serviceRegister.get(serviceInterfaceClass);
                Method method = serviceInterfaceClass.getMethod(methodName, paramType);
                Object result = method.invoke(service, argsObj);
                //服务提供着发送给服务调用者result
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(result);
                System.out.println("服务提供者返回结果："+result);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
