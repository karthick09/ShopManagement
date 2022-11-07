public class Manger extends Person{
    private final String mangerId;

    public Manger(String name, String email, String phone, Account account, String mangerId) {
        super(name, email, phone, account);
        this.mangerId = mangerId;
    }

    public String getMangerId() {
        return mangerId;
    }
}
