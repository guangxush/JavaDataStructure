package codereview.RPCService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * 服务调用方
 * @author: guangxush
 * @create: 2019/03/25
 */
public class Consumer {
    public static void main(String[] args) {
        try{
            //接口名
            String interfaceName = RPCService.class.getName();
            //需要远程调用的方法
            Method method = RPCService.class.getMethod("showSomething", String.class);
            //要传递的参数
            Object[] params = {"hello"};

            //定义socket
            Socket socket = new Socket("127.0.0.1", 8088);

            //将方法名和参数传至服务
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeUTF(interfaceName);
            oos.writeUTF(method.getName());
            oos.writeObject(method.getParameterTypes());
            oos.writeObject(params);
            System.out.println("向服务器发送请求参数："+params[0]);

            //从远程获取方法执行结果
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Object result = ois.readObject();
            System.out.println("服务提供者返回的结果"+result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
