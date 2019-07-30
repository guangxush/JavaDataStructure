package knowledge.patterntest2;

import knowledge.patterntest2.server.HelloA;
import knowledge.patterntest2.server.HelloTest;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class TestPattern {
    public static void main(String[] args) {
        // server
        List<HelloA> list = new ArrayList<>();
        list.add(new HelloA("Server A"));
        HelloTest classInServer = new HelloTest();
        classInServer.setList(list);
        String jsonData = JSONObject.fromObject(classInServer).toString();
        System.out.println("Server Data: " + jsonData);

        // client
        JSONObject jsonObject1 = JSONObject.fromObject(jsonData);
        knowledge.patterntest2.client.HelloTest classInClient = (knowledge.patterntest2.client.HelloTest)
                JSONObject.toBean(jsonObject1, knowledge.patterntest2.client.HelloTest.class);
        try{
            // 不支持list复制
            System.out.println("Client Data: " + classInClient.getList().get(0).toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }

        // object trans
        if(jsonObject1!=null){
            knowledge.patterntest2.client.HelloTest clientClass =  new knowledge.patterntest2.client.HelloTest();
            try {
                BeanUtils.copyProperties(clientClass, classInServer);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 不支持list直接复制
                System.out.println("Client Data: " + clientClass.getList().get(0).toString());
            }
        }

        // object trans
        if(jsonObject1!=null){
            knowledge.patterntest2.client.HelloA clientClassA =  new knowledge.patterntest2.client.HelloA();
            try {
                BeanUtils.copyProperties(clientClassA, classInServer.getList().get(0));
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                // 单独取出来复制
                System.out.println("Client Data: " + clientClassA.getValue().toString());
            }
        }
    }
}
