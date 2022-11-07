public class Login {
    public boolean login(String id,String password){
        return Owner.getLoginDetails(id,password);
    }
}
