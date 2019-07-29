package knowledge.jsontest;

import net.sf.json.JSONObject;

/**
 * @Description
 * @auther guangxush
 * @create 2019/7/29
 */
public class Test {
    public static void main(String[] args) {
        Student stu1 = new Student("lwc", "111111");
        JSONObject jsonObject = JSONObject.fromObject(stu1);
        System.out.println(jsonObject);

        // json字符串转JavaBean
        String jsonData = "{\"password\":\"111111\",\"username\":\"lwc\"}";
        JSONObject jsonObject1 = JSONObject.fromObject(jsonData);
        Student stu2 = (Student) JSONObject.toBean(jsonObject1, Student.class);
        System.out.println(stu2);
    }
}
