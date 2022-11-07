import java.util.ArrayList;

public class Owner {
    private static ArrayList<Person> personNameList =new ArrayList<>();
    private static ArrayList<Item> itemList = new ArrayList<>();
    private static ArrayList<Manger> managerList = new ArrayList<>();
    private static ArrayList<ShopWorker> shopWorkerList =new ArrayList<>();
    private static ArrayList<SalesMan> salesManList = new ArrayList<>();

    public static void addPerson (Person person){
        personNameList.add(person);
    }

    public static Person getPerson(String name){
        for (Person p : personNameList) {
            if (name.equals(p.getName())) {
                return p;
            }
        }
        return null;
    }
    void assignManger(){
    }
    void assignShopWorker(){
    }
    void assignSalesMan(){
    }

    public static boolean getLoginDetails(String id,String password){
        return true;
    }
    public static boolean addItem(Item item,Person person){
        if(person instanceof Manger) {
            itemList.add(item);
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean deleteItem(Item item,Person person){
        if(person instanceof Manger){
            itemList.remove(item);
            return true;
        }
        else{
            return false;
        }
    }

}
