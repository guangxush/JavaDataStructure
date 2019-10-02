package knowledge.clone;

/**
 * @author: guangxush
 * @create: 2019/10/02
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person(23, "zhangsan", new Address("上海", "曹安公路4800"));

        Person clonePerson = (Person) person.clone();

        int i = 1;

        System.out.println(i++ +" "+person);
        System.out.println(i++ +" "+clonePerson);

        System.out.println(i++ +" "+person.display());
        System.out.println(i++ +" "+clonePerson.display());

        clonePerson.setName("lisi");
        clonePerson.setAge(20);
        Address address = clonePerson.getAddress();
        address.setStreet("四平路");
        System.out.println(i++ +" "+clonePerson.display());
        System.out.println(i++ +" "+person.display());

    }
}
