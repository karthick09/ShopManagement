import java.time.LocalDate;

public class Manger extends Person{
    private final String mangerId;
    private final LocalDate dateOfJoin;

    public Manger(String name, String email, String phone, Account account, String mangerId) {
        super(name, email, phone, account);
        this.mangerId = mangerId;
        this.dateOfJoin=LocalDate.now();
    }

    public String getMangerId() {
        return mangerId;
    }

    public LocalDate getDateOfJoin() {
        return dateOfJoin;
    }
}
