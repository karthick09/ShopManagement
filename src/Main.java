import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static String validateName()
    {
        int stringLength;
        boolean value=true;
        String string;
        boolean isAlphabet=true;
        do {
            if(!value||!isAlphabet) {
                System.out.println("(Input size should be greater than 4 and should not contain any numbers or special characters)" +
                        "Enter again:");
            }
            Scanner scanner=new Scanner(System.in);
            string=scanner.nextLine();
            for (int i=0; i<string.length(); i++) {
                char c = string.charAt(i);
                isAlphabet=(c>=0x41&&c<=0x5a)||(c>=0x61&&c<=0x7a)||(c==0x20);
                if(!isAlphabet)
                    break;
            }

            stringLength=string.length();
            value=(stringLength>=5);
        }while (!value||!isAlphabet);
        return string;
    }
    static String validateUserName()
    {
        int stringLength;
        String string;
        boolean value=true;
        boolean isUserName;
        do{
            if(!value)
            {
                System.out.println("(Input size should be greater than 4)"+"Enter again:");
            }
            Scanner scanner=new Scanner(System.in);
            string=scanner.nextLine();
            stringLength=string.length();
            isUserName=Owner.checkUserName(string);
            value=stringLength>=5;
        }while (!isUserName||!value);
        return string;
    }
    public static int validateInteger()
    {
        boolean flag;
        int integer1 = 0;
        do {
            flag = true;
            try {
                Scanner scanner = new Scanner(System.in);
                integer1 = scanner.nextInt();

            } catch (InputMismatchException ignored) {
            }
            if(integer1==0)
            {
                System.out.println("enter a valid input:");
                flag=false;
            }
        }while (!flag);
        return integer1;
    }
    static String validatePhoneNumber()
    {
        int stringLength;
        boolean value=true;
        String string;
        boolean isNumber=true;
        do{
            if(!value||!isNumber)
            {
                System.out.println("(Input size should be equal to 10 and contain only numbers)"+
                        "Enter again:");
            }
            Scanner scanner=new Scanner(System.in);
            string=scanner.nextLine();
            for (int i=0; i<string.length(); i++) {
                char c = string.charAt(i);
                isNumber=(c>=0x30&&c<=0x39);
                if(!isNumber)
                    break;
            }

            stringLength=string.length();
            value=stringLength==10;
        }while (!value||!isNumber);
        return string;
    }
    public static float validateFloat()
    {
        boolean flag;
        float float1 = 0;
        do {
            flag = true;
            try {
                Scanner scanner = new Scanner(System.in);
                float1 = scanner.nextFloat();

            } catch (InputMismatchException ignored) {
            }
            if(float1==0)
            {
                System.out.println("enter a valid input:");
                flag=false;
            }
        }while (!flag);
        return float1;
    }
    static String validatePassword()
    {
        int stringLength;
        String string;
        boolean isPassword=true;
        do{
            if(!isPassword)
            {
                System.out.println("(Input size should be greater than 7)"+
                        "Enter again:");
            }
            Scanner scanner=new Scanner(System.in);
            string=scanner.nextLine();
            stringLength=string.length();
            isPassword=stringLength>=8;
        }while (!isPassword);
        return string;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do{
            String username,password,idNo ;
            int choice1,choice2;
            System.out.println("1.owner login \n2.manger login \n3.salesman \n4.exit");
            choice1= validateInteger();
            if(choice1==4){
                System.exit(0);
            }
            Login login =new Login();
            System.out.println("enter the id ");
            idNo= sc.next();
            System.out.println("enter the username");
            username=sc.next();
            System.out.println("enter the password");
            password= sc.next();
            switch (choice1){
                case 1:
                    if(username.equals("abc") && password.equals("123")) {
                        do {
                            Owner owner = new Owner();
                            System.out.println("1.Add manager \n2.Add salesperson \n3.Add shopWorker \n4.showList \n5.Add item \n6.Delete item");
                            choice2 = validateInteger();
                            String userId = "", pass = "", name = "", email = "", phone = "";
                            if (choice2 < 4) {
                                System.out.println("enter the person details");
                                System.out.println("enter the username");
                                userId = validateUserName();
                                System.out.println("enter the password");
                                pass = validatePassword();
                                System.out.println("enter the name ");
                                name = validateName();
                                System.out.println("enter the email");
                                email = sc.next();
                                System.out.println("enter the phone");
                                phone = validatePhoneNumber();
                            }
                            Account account = new Account(userId, pass, AccountStatus.ACTIVE);
                            Person person = new Person(name, email, phone, account);
                            switch (choice2) {
                                case 1 -> {
                                    System.out.println("enter the manager id");
                                    String mId = sc.next();
                                    owner.addPerson(person);
                                    owner.assignManger(person, mId);
                                }
                                case 2 -> {
                                    System.out.println("enter the salesperson id ");
                                    String salePersonId = sc.next();
                                    owner.addPerson(person);
                                    owner.assignSalesMan(person, salePersonId);
                                }
                                case 3 -> {
                                    System.out.println("enter the salesperson id ");
                                    String SWId = sc.next();
                                    owner.addPerson(person);
                                    owner.assignShopWorker(person, SWId);
                                }
                                case 4 -> {
                                    System.out.println("1.person list \n2.manger list \n3.salesman list \n4.shopWorker list\n5.item list");
                                    int ch = validateInteger();
                                    switch (ch) {
                                        case 1 -> owner.personList();
                                        case 2 -> owner.getMangerList();
                                        case 3 -> owner.getSaleManList();
                                        case 4 -> owner.getShopWorkerList();
                                        case 5 -> Owner.getItemList();
                                        default -> System.out.println("invalid choice");
                                    }
                                }
                                case 5 -> {
                                    String iName, iId;
                                    float price, quantity;
                                    System.out.println("enter the item id");
                                    iId = sc.next();
                                    System.out.println("enter the item name");
                                    iName = sc.next();
                                    System.out.println("enter the price");
                                    price = validateFloat();
                                    System.out.println("enter the quantity");
                                    quantity = validateFloat();
                                    Item item = new Item(iId, iName, price, quantity);
                                    Owner.addItem(item, idNo);
                                }
                                case 6 -> {
                                    String iId;
                                    System.out.println("enter the item id");
                                    iId = sc.next();
                                    Owner.deleteItem(iId, idNo);
                                }
                                default -> System.out.println("invalid choice");
                            }
                            System.out.println("want to continue press 1");
                        } while (sc.nextInt()==1);
                    }
                    else {
                            System.out.println("invalid username and password");
                    }
                    break;
                case 2:
                    if(login.login(username,password)){
                        Manger manger;
                        manger = Owner.getManger(idNo);
                        String itemId;
                        float quantity;
                        do{
                            System.out.println("1.showItemList \n2.Add item \n3.Delete item \n4.sales \n5.purchase");
                            choice2= validateInteger();
                            switch (choice2) {
                                case 1 -> Owner.getItemList();
                                case 2 -> {
                                    String iName;
                                    float price;
                                    System.out.println("enter the item id");
                                    itemId = sc.next();
                                    System.out.println("enter the item name");
                                    iName = sc.next();
                                    System.out.println("enter the price");
                                    price = validateFloat();
                                    System.out.println("enter the quantity");
                                    quantity = validateFloat();
                                    Item item = new Item(itemId, iName, price, quantity);
                                    if (manger != null) {
                                        Owner.addItem(item, manger.getMangerId());
                                    }
                                }
                                case 3 -> {
                                    System.out.println("enter the item id");
                                    itemId = sc.next();
                                    if (manger != null) {
                                        Owner.deleteItem(itemId, manger.getMangerId());
                                    }
                                }
                                case 4 -> {
                                    System.out.println("enter the item no ");
                                    itemId = sc.next();
                                    System.out.println("enter the no of quantity");
                                    quantity=validateFloat();
                                    if (manger != null) {
                                        Owner.sales(manger.getMangerId(),itemId,quantity);
                                    }
                                }
                                case 5 -> {
                                    System.out.println("1.To update item \n2.new item");
                                    int ch= sc.nextInt();
                                    if(ch==1){
                                        System.out.println("enter the item id");
                                        itemId= sc.next();
                                        System.out.println("enter the count to add");
                                        quantity= validateFloat();
                                        if (manger != null) {
                                            Owner.purchase(manger.getMangerId(),itemId,quantity);
                                        }
                                    }
                                    else if(ch==2){
                                        String iName;
                                        float price;
                                        System.out.println("enter the item id");
                                        itemId = sc.next();
                                        System.out.println("enter the item name");
                                        iName = sc.next();
                                        System.out.println("enter the price");
                                        price = validateFloat();
                                        System.out.println("enter the quantity");
                                        quantity = validateFloat();
                                        Item item = new Item(itemId, iName, price, quantity);
                                        if (manger != null) {
                                            Owner.addItem(item, manger.getMangerId());
                                        }
                                    }
                                    else {
                                        System.out.println("invalid choice");
                                    }
                                }
                                default -> System.out.println("invalid choice");
                            }
                            System.out.println("want to continue press 1");
                        }while (sc.nextInt()==1);
                    }
                    else {
                        System.out.println("invalid username or password");
                    }
                    break;
                case 3:
                    if(login.login(username,password)){
                        SalesMan salesMan;
                        String itemId;
                        float quantity;
                        salesMan=Owner.getSalesMan(idNo);
                        do{
                            System.out.println("1.view list \n2.sales");
                            choice2= validateInteger();
                            switch (choice2) {
                                case 1 -> Owner.getItemList();
                                case 2 -> {
                                    System.out.println("enter the item no ");
                                    itemId = sc.next();
                                    System.out.println("enter the no of quantity");
                                    quantity = validateFloat();
                                    if (salesMan != null) {
                                        Owner.sales(salesMan.getSalesManId(), itemId, quantity);
                                    }
                                }
                                default -> System.out.println("invalid choice");
                            }
                            System.out.println("want to continue press 1");
                        }while (sc.nextInt()==1);
                    }
                    else {
                        System.out.println("invalid username or password");
                    }
                    break;
                default:
                    System.out.println("invalid choice");
            }

        }while(true);


    }
}