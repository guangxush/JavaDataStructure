package knowledge.patterntest1;

import knowledge.patterntest1.server.HelloWorld;
import knowledge.patterntest1.server.HelloTest;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class TestPattern {
    public static void main(String[] args) {
        // server
        List<HelloWorld> list = new ArrayList<>();
        list.add(new HelloWorld("server"));
        HelloTest classInServer = new HelloTest();
        classInServer.setList(list);
        String jsonData = JSONObject.fromObject(classInServer).toString();
        System.out.println("Server Data: " + jsonData);

        // client
        JSONObject jsonObject1 = JSONObject.fromObject(jsonData);
        knowledge.patterntest1.client.HelloTest classInClient = (knowledge.patterntest1.client.HelloTest)
                JSONObject.toBean(jsonObject1, knowledge.patterntest1.client.HelloTest.class);
        System.out.println("Client Data: " + classInClient.getList().toString());
    }
}
