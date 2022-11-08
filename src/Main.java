import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do{
            String username,password;
            int choice1,choice2;
            System.out.println("1.owner login \n2.manger login \n3.salesman \n4.exit");
            choice1= sc.nextInt();
            if(choice1==4){
                System.exit(0);
            }
            System.out.println("enter the username");
            username=sc.next();
            System.out.println("enter the password");
            password= sc.next();
            switch (choice1){
                case 1:
                    if(username.equals("abc") && password.equals("123")){
                        Owner owner =new Owner();
                        System.out.println("1.Add manager \n2.Add salesperson \n3.Add shopWorker \n4.showList");
                        choice2= sc.nextInt();
                        if(choice2==4){
                            System.out.println("1.person list \n2.manger list \n3.salesman list \n4.shopWorker list");
                            int ch=sc.nextInt();
                            switch (ch) {
                                case 1 -> owner.personList();
                                case 2 -> owner.getMangerList();
                                case 3 -> owner.getSaleManList();
                                case 4 -> owner.getShopWorkerList();
                                default -> System.out.println("invalid choice");
                            }
                        }
                        else{
                            System.out.println("enter the person details");
                            String userId,pass,name,email,phone;
                            System.out.println("enter the username");
                            userId=sc.next();
                            System.out.println("enter the password");
                            pass=sc.next();
                            System.out.println("enter the name ");
                            name=sc.next();
                            System.out.println("enter the email");
                            email=sc.next();
                            System.out.println("enter the phone");
                            phone= sc.next();
                            Account account =new Account(userId,pass,AccountStatus.ACTIVE);
                            Person person = new Person(name,email,phone,account);
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
                                default -> System.out.println("invalid choice");
                            }
                        }

                    }
                    break;
                case 2:

            }

        }while(true);


    }
}