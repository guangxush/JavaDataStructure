package knowledge.patterntest2.client;


import java.util.List;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class HelloTest {
    private List<HelloA> list;

    public List<HelloA> getList() {
        return list;
    }

    public void setList(List<HelloA> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "HelloTest{" +
                "list=" + list +
                '}';
    }
}
