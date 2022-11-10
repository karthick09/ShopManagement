public class Person {
    private final String name;
    private String email;
    private String phone;
    private  Account account;

    public Person(String name, String email, String phone, Account account) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Account getAccount() {
        return account;
    }
}
