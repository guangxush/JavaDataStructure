package knowledge.jexltest;

/**
 * @author: guangxush
 * @create: 2019/08/01
 */
public class Person{
    private String name;
    private String sex;
    public Person(String name,String sex){
        this.name=name;
        this.sex = sex;
    }
    public String getInfo(){
        return this.name+"+"+this.sex;
    }
}