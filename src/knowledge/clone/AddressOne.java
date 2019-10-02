package knowledge.clone;

/**
 * @author: guangxush
 * @create: 2019/10/02
 */
public class AddressOne extends DeepClone{
    private static final long serialVersionUID = 1L;
    private String province;
    private String street;

    public AddressOne(String province, String street) {
        this.province = province;
        this.street = street;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address [province=" + province + ", street=" + street + "]";
    }

}

