public class ShopWorker extends Person{

    private final String shopWorkerId;

    public ShopWorker(String name, String email, String phone, Account account, String shopWorkerId) {
        super(name, email, phone, account);
        this.shopWorkerId = shopWorkerId;
    }

    public String getShopWorkerId() {
        return shopWorkerId;
    }
}
