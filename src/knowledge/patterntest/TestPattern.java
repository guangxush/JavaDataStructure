package knowledge.patterntest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class TestPattern {
    public static void main(String[] args) {
        List<AInServer> list = new ArrayList<>();
        ClassInServer classInServer = new ClassInServer();
        classInServer.setList(list);
        String json = classInServer;
        ClassInClient classInClient = new ClassInClient();
    }
}
