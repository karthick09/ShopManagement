import java.util.ArrayList;

public class Owner {
    private static ArrayList<Person> personNameList =new ArrayList<>();
    private static ArrayList<Item> itemList = new ArrayList<>();
    private static ArrayList<Manger> managerList = new ArrayList<>();
    private static ArrayList<ShopWorker> shopWorkerList =new ArrayList<>();
    private static ArrayList<SalesMan> salesManList = new ArrayList<>();


    public static Person getPerson(String name){
        for (Person p : personNameList) {
            if (name.equals(p.getName())) {
                return p;
            }
        }
        return null;
    }

    public static Item getItem(String id){
        for (Item I : itemList) {
            if (id.equals(I.getItemId())) {
                return I;
            }
        }
        return null;
    }

    void personList(){
        for (Person p : personNameList){
            System.out.println("person name :"+p.getName());
        }
    }

    void getMangerList(){
        for(Manger m :managerList){
            System.out.println("manger id :"+m.getMangerId()+"  manger name :"+m.getName());
        }
    }

    void getSaleManList(){
        for(SalesMan sm :salesManList){
            System.out.println("salesMan id :"+sm.getSalesManId()+" saleMan name :"+sm.getName());
        }
    }

    void getShopWorkerList(){
        for(ShopWorker sw:shopWorkerList){
            System.out.println("shopWorker id :"+sw.getShopWorkerId()+" shopWorker name :"+sw.getName());
        }
    }
    void getItemList(){
        for(Item i : itemList){
            System.out.println("item id :"+i.getItemId()+" item name :"+i.getItemName()+" item price :"+i.getItemPrice()+" item quantity :"+i.getQuantity());
        }
    }
    void addPerson (Person person){
        personNameList.add(person);
    }
    void assignManger(Person person,String mId){
        Manger manger = new Manger(person.getName(),person.getEmail(), person.getPhone(), person.getAccount(),mId);
        managerList.add(manger);
    }
    void assignShopWorker(Person person,String SWId){
        ShopWorker shopWorker = new ShopWorker(person.getName(),person.getEmail(), person.getPhone(), person.getAccount(),SWId);
        shopWorkerList.add(shopWorker);
    }
    void assignSalesMan(Person person,String salesPersonId){
        SalesMan salesMan = new SalesMan(person.getName(),person.getEmail(), person.getPhone(), person.getAccount(),salesPersonId);
        salesManList.add(salesMan);
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
            System.out.println("Access denied");
            return false;
        }
    }
    void addItem(Item item){
        itemList.add(item);
    }
    void removeItem(String id){
        Item item;
        item=getItem(id);
        if(item != null){
            itemList.remove(item);
        }
        else {
            System.out.println("Item not found ");
        }
    }
    public static boolean deleteItem(String id,Person person){
        if(person instanceof Manger){
            Item item;
            item=getItem(id);
            if(item != null){
                itemList.remove(item);
                return true;
            }
            else {
                return false;
            }
        }
        else{
            System.out.println("access denied");
            return false;
        }
    }

    public static void  updateItem(float quantity,Item item){
        Item item1;
        item1=item;
        item1.setQuantity(quantity);
        itemList.remove(item);
        itemList.add(item1);
    }
     public static void sales(Person person,String id,float quantity){
        if((person instanceof Manger) || (person instanceof SalesMan) ){
            Item item;
            float updateQuantity;
            item=getItem(id);
            if(item!= null){
                if (quantity< item.getQuantity()){
                    float price;
                    price=quantity* item.getItemPrice();
                    System.out.println("the total amount rs:"+price);
                    updateQuantity= item.getQuantity()-quantity;
                    updateItem(updateQuantity,item);
                }
                else {
                    System.out.println("insufficient stock");
                    System.out.println("available stock is "+item.getQuantity());
                }
            }
            else {
                System.out.println("item not found");
            }
        }
        else {
            System.out.println("access denied");
        }
     }
     public static void purchase(Person person,String id,float quantity){
        if(person instanceof Manger){
            Item item;
            float updateQuantity;
            item= getItem(id);
            if(item != null){
                updateQuantity= item.getQuantity()+quantity;
                updateItem(updateQuantity,item);
            }
            else {
                System.out.println("item not found");
            }
        }
        else {
            System.out.println("access denied");
        }
     }

}
