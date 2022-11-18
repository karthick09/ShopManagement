import java.time.LocalDate;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class Owner {
    private static final ArrayList<Person> personNameList =new ArrayList<>();
    private static final ArrayList<Item> itemList = new ArrayList<>();
    private static final ArrayList<Manger> managerList = new ArrayList<>();
    private static final ArrayList<ShopWorker> shopWorkerList =new ArrayList<>();
    private static final ArrayList<SalesMan> salesManList = new ArrayList<>();
    private static final HashMap<String, Float> salesList = new HashMap<>();
    private static final HashMap<String, Float> purchaseList = new HashMap<>();



    public static Manger getManger(String id){
        for (Manger m : managerList) {
            if (id.equals(m.getMangerId())) {
                return m;
            }
        }
        return null;
    }

    public static boolean checkUserName(String username){
        boolean flag=true;
        Account account;
        for(Person p :personNameList){
            account=p.getAccount();
            if(account.getId().equals(username)){
                System.out.println("User name already exist!");
                flag=false;
                break;
            }
        }
        return flag;
    }
    public static boolean checkItemName(String itemName){
        boolean flag=true;
        for(Item item :itemList){
            if(item.getItemName().equals(itemName)){
                System.out.println("item name already exits");
                flag=false;
                break;
            }
        }
        return flag;
    }
    public static boolean checkItemId(String itemId){
        boolean flag=true;
        for(Item item :itemList){
            if(item.getItemId().equals(itemId)){
                System.out.println("item id already exits");
                flag=false;
                break;
            }
        }
        return flag;
    }

    public static boolean checkMId(String MID){
        boolean flag=true;
        for(Manger manger :managerList){
            if(manger.getMangerId().equals(MID)){
                System.out.println("manager id already exits");
                flag=false;
                break;
            }
        }
        return flag;
    }

    public static boolean checkSId(String SID){
        boolean flag=true;
        for(SalesMan salesMan :salesManList){
            if(salesMan.getSalesManId().equals(SID)){
                System.out.println("salesman id already exits");
                flag=false;
                break;
            }
        }
        return flag;
    }

    public static SalesMan getSalesMan(String id){
        for (SalesMan SM : salesManList) {
            if (id.equals(SM.getSalesManId())) {
                return SM;
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
            System.out.println("manger id :"+m.getMangerId()+" --manger name :"+m.getName());
        }
    }

    void getSaleManList(){
        for(SalesMan sm :salesManList){
            System.out.println("salesMan id :"+sm.getSalesManId()+" --saleMan name :"+sm.getName());
        }
    }

    void getShopWorkerList(){
        for(ShopWorker sw:shopWorkerList){
            System.out.println("shopWorker id :"+sw.getShopWorkerId()+" --shopWorker name :"+sw.getName());
        }
    }
    static void getItemList(){
        for(Item i : itemList){
            System.out.println("item id :"+i.getItemId()+" --item name :"+i.getItemName()+" --item price :"+i.getItemPrice()+" --item quantity :"+i.getQuantity());
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
        for(Person p :personNameList){
            Account account =p.getAccount();
            if(id.equals(account.getId()) && password.equals(account.getPassword())){
                return true;
            }
        }
        return false;

    }

    public static void addItem(Item item,String idNo){
        if((managerList.contains(getManger(idNo))) || idNo.equals("owner")) {
            itemList.add(item);
            salesList.put(item.getItemId(), (float) 0);
            purchaseList.put(item.getItemId(),item.getQuantity());
        }
        else{
            System.out.println("Access denied");
        }
    }

    public static void deleteItem(String id,String idNo){
        if((managerList.contains(getManger(idNo))) || idNo.equals("owner")){
            Item item;
            item=getItem(id);
            if(item != null){
                itemList.remove(item);
            }
            else {
                System.out.println("item not found");
            }
        }
        else{
            System.out.println("access denied");
        }
    }

    public static void  updateItem(float quantity,Item item){
        Item item1;
        item1=item;
        item1.setQuantity(quantity);
        itemList.set(itemList.indexOf(item),item1);
    }
     public static void sales(String personIdNo,String itemId,float quantity){
        if((salesManList.contains(getSalesMan(personIdNo))) || (managerList.contains(getManger(personIdNo)))){
            Item item;
            float updateQuantity;
            item=getItem(itemId);
            if(item!= null){
                if (quantity< item.getQuantity()){
                    float price;
                    price=quantity* item.getItemPrice();
                    System.out.println("the total amount rs:"+price);
                    updateQuantity= item.getQuantity()-quantity;
                    updateItem(updateQuantity,item);
                    float value=salesList.get(itemId);
                    value=value+quantity;
                    salesList.put(itemId,value);
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
     public static void purchase(String personId,String id,float quantity){
        if(managerList.contains(getManger(personId))){
            Item item;
            float updateQuantity;
            item= getItem(id);
            if(item != null){
                updateQuantity= item.getQuantity()+quantity;
                updateItem(updateQuantity,item);
                float value = purchaseList.get(id);
                value=value+quantity;
                purchaseList.put(id,value);
            }
            else {
                System.out.println("item not found");
            }
        }
        else {
            System.out.println("access denied");
        }
     }

     float salary(String empId,String designation){
        float salary;
         if(designation.equals("manager")){
             Manger manger=getManger(empId);
             if (manger != null) {
                 LocalDate doj=manger.getDateOfJoin();
                 LocalDate presentDate=LocalDate.now();
                 long noOfDays=ChronoUnit.DAYS.between(doj,presentDate);
                 salary=(float)noOfDays/30;
                 salary=salary*20000;
                 salary=Math.round(salary);
                 return salary;
             }
             else {
                 System.out.println("manager not found");
                 return -1;
             }
         }
         else if(designation.equals("salesman")){
             SalesMan salesMan=getSalesMan(empId);
             if(salesMan != null){
                 LocalDate doj=salesMan.getDateOfJoin();
                 LocalDate presentDate=LocalDate.now();
                 long noOfDays=ChronoUnit.DAYS.between(doj,presentDate);
                 salary=(float)noOfDays/30;
                 salary=salary*15000;
                 salary=Math.round(salary);
                 return salary;
             }
             else {
                 System.out.println("salesman not found");
                 return -1;
             }
         }
         else {
             System.out.println("designation not found ");
         }
         return -1;
     }
     void turnover(int choice){
        if(choice==1){
            for (Map.Entry<String, Float> entry : salesList.entrySet()) {
                Item item=getItem(entry.getKey());
                if (item != null) {
                    System.out.println("item id :"+entry.getKey()+"item name :"+item.getItemName()+" total sales count "+entry.getValue());
                }
                else{
                    System.out.println("item id :"+entry.getKey()+" total sales count "+entry.getValue());
                }
            }
        }
        else if (choice==2){
            for (Map.Entry<String, Float> entry : purchaseList.entrySet()) {
                Item item=getItem(entry.getKey());
                if (item != null) {
                    System.out.println("item id :"+entry.getKey()+"item name:"+item.getItemName()+" total purchase count "+entry.getValue());
                }
                else {
                    System.out.println("item id :"+entry.getKey()+" total purchase count "+entry.getValue());

                }
            }
        }
        else {
            System.out.println("invalid choice");
        }
     }
}