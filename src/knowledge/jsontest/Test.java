package knowledge.jsontest;

import net.sf.json.JSONObject;

/**
 * @Description
 * @auther guangxush
 * @create 2019/7/29
 */
public class Test {
    public static void main(String[] args) {
        Student student = new Student("zhangsan", "123456");
        JSONObject jsonObject = JSONObject.fromObject(student);
        System.out.println(jsonObject);

        // json字符串转JavaBean
        String jsonData = "{\"password\":\"123456\",\"username\":\"zhangsan\"}";
        JSONObject jsonObject1 = JSONObject.fromObject(jsonData);
        Student stu2 = (Student) JSONObject.toBean(jsonObject1, Student.class);
        System.out.println(stu2);
    }
}
