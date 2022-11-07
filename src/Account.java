public class Account {
    private final String id;
    private String password;
    private AccountStatus status;

    public Account(String id, String password,  AccountStatus status) {
        this.id = id;
        this.password = password;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public boolean resetPassword(){
        return true;
    }
}
