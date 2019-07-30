package knowledge.patterntest1.client;

import java.util.List;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class HelloTest {
    private List<HelloWorld> list;

    public List<HelloWorld> getList() {
        return list;
    }

    public void setList(List<HelloWorld> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "HelloTest{" +
                "list=" + list +
                '}';
    }
}
