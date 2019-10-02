package knowledge.clone;

/**
 * @author: guangxush
 * @create: 2019/09/26
 */
public class Person implements Cloneable {
    private int age;
    private String name;
    private Address address;

    public Person(int age, String name, Address address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person = (Person)super.clone();
        //手动对address属性进行clone，并赋值给新的person对象
        person.address = (Address) address.clone();
        return person;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String display() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
