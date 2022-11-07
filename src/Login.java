import java.util.HashMap;
import java.util.Map;

public class Login {
    private static HashMap<String,String > loginDetails =new HashMap<>();

    public static boolean login(String id,String password){
        for(Map.Entry<String, String> entry: loginDetails.entrySet()){
            if(entry.getKey().equals(id) && entry.getValue().equals(password)){
                return true;
            }
        }
        return false;
    }
    public static void addLoginDetails(String id,String password){
        loginDetails.put(id,password);
    }
    public static void removeLoginDetails(String id){
        loginDetails.remove(id);
    }
}
