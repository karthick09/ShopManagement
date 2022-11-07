public class SalesMan extends Person{
    private final String salesManId;

    public SalesMan(String name, String email, String phone, Account account, String salesManId) {
        super(name, email, phone, account);
        this.salesManId = salesManId;
    }

    public String getSalesManId() {
        return salesManId;
    }
}
