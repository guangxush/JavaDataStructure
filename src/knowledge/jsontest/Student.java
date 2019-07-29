package knowledge.jsontest;

/**
 * @Description
 * @auther guangxush
 * @create 2019/7/29
 */
public class Student {
    private String username;
    private String password;

    public Student(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsrname() {
        return username;
    }

    public void setUsrname(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
