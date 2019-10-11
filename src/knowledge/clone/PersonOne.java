package knowledge.clone;

/**
 * @author: guangxush
 * @create: 2019/10/02
 */
public class PersonOne extends DeepClone{
    private static final long serialVersionUID = 1L;
    private int age;
    private String name;
    private Address address;

    public PersonOne(int age, String name, Address address) {
        this.age = age;
        this.name = name;
        this.address = address;
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
        return "Person [age=" + age + ", name=" + name + ", address=" + address + "]";
    }
}