import java.time.LocalDate;

public class ShopWorker extends Person{

    private final String shopWorkerId;
    private final LocalDate dateOfJoin;

    public ShopWorker(String name, String email, String phone, Account account, String shopWorkerId) {
        super(name, email, phone, account);
        this.shopWorkerId = shopWorkerId;
        this.dateOfJoin=LocalDate.now();
    }

    public String getShopWorkerId() {
        return shopWorkerId;
    }

    public LocalDate getDateOfJoin() {
        return dateOfJoin;
    }
}
