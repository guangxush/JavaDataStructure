package knowledge;

/**
 * Created by gshan on 2018/11/13
 */
public class TestReferences {

    public static void main(String[] args) {
        Student s = new Student(1,"zhangsan");
        Student s1 = s ;
        System.out.println(s1.toString());
        System.out.println(s.toString());
        s1.setName( "hello");
        s1.setId(2);
        System.out.println(s1.toString());
        System.out.println(s.toString());
        Student s2 = new Student(3,"lisi");
        System.out.println(s2.toString());
        s2.update(s2);
        System.out.println(s2.toString());
        int a =1;
        updateInt(a);
        System.out.println(a);
        String str = "world";
        updateString(str);
        System.out.println(str);
        String str1 = new String("world2");
        updateString(str1);
        System.out.println(str1);



        String str3 = "string test";
        String str4 = "string test";
        str3+="test";
        System.out.println(str3);
        System.out.println(str4);

        String str5 = new String("String test");
        String str6 = new String("String test");
        str5+="test";
        System.out.println(str5);
        System.out.println(str6);


        //Student{id=1, name='zhangsan'}
        //Student{id=1, name='zhangsan'}
        //Student{id=2, name='hello'}
        //Student{id=2, name='hello'}
        //Student{id=3, name='lisi'}
        //Student{id=4, name='lisi_update'}
        //1
        //world
        //world2
        //string testtest
        //string test
        //String testtest
        //String test
    }

    public static void updateInt(int a){
        a++;
    }

    public static String updateString(String s){
        s = s + "_update";
        return s;
    }

}
class Student{
    public int id;
    public String name;

    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void update(Student s){
        s.setId(s.id+1);
        s.setName(s.name+"_update");
    }

}