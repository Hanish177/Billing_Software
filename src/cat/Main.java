
package cat;

import java.util.Scanner;

class BookStore{
    void Search(int []arr) {
        int Id, i;
        System.out.println("Enter the ID : ");
        Scanner in = new Scanner(System.in);
        Id = in.nextInt();
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == Id)
                System.out.println("Id found");
            else
                System.out.println("Id not found");
        }
    }
    int AddItem(int[] arrayItem, int a){
        System.out.println("Enter the item to be added :");
        Scanner sc = new Scanner(System.in);
        arrayItem[a] = sc.nextInt();
        a++;
        return a;
    }
    void display(int[]ar){
        int i;
        for(i=0;i< ar.length;i++){
            System.out.println(ar[i]);
        }
    }
    void display(char[]str){
        int i;
        for (i=0;i< str.length;i++){
            System.out.println(str[i]);
        }
    }
}
class Customer extends BookStore {
    String Name;
    int CustomerId;
    String Phone;
    String Mail;
    String Address;

    Customer(String name, int customerId, String phone, String mail, String address) {
        Name = name;
        CustomerId = customerId;
        Phone = phone;
        Mail = mail;
        Address = address;
    }

}

class Item extends BookStore{
    String[] title = new String[200];
    String[] author = new String[200];
    public int[] ISBN = new int[200] ;
    public int[] price = new int[200];
    public int[] stock = new int[200];
    int i=0;
    void AddItem(){

        Scanner it = new Scanner(System.in);
        System.out.print("\n Enter the title  :");
        title[i] = it.nextLine();
        it.nextLine();
        System.out.print("Enter the author  :");
        author[i] = it.nextLine();
        it.nextLine();
        System.out.print("Enter the ISBN  :");
        ISBN[i] = it.nextInt();
        it.nextLine();
        System.out.print("\nEnter the quantity of Stock  :");
        stock[i] = it.nextInt();
        System.out.print("\nEnter the price  :");
        price[i] = it.nextInt();
        it.nextLine();
        i++;
        System.out.println(i);


    }
    int[] ReturnISBN(){
        return  ISBN;
    }
    int[] ReturnPrice(){
        return price;
    }
    int[] ReturnStock(){
        return stock;
    }

}
class ItemOrder extends Item{
    int numberOfItems;
    double discount,tax = 0.02;
    double netTax,billTotal;
    int total,i,j,k,l,shop,Tt=0;
    int[] netTotal = new int[200];
    int[] Itemno = new int[200];
    int[] quantity = new int[200];
    int[] IndPrice = new int[200];

    void Bill(int[]ISBN,int[]price,int[]stock) {

        System.out.print("\nEnter the number of items  :");
        Scanner or = new Scanner(System.in);
        numberOfItems = or.nextInt();
        for (i = 0; i < numberOfItems; i++) {
            System.out.print("\nEnter the item no  :");
            Itemno[i] = or.nextInt();
            System.out.print("\nEnter the quantity  :");
            quantity[i] = or.nextInt();
            int op = netTotal[i];
            for(k=0;k<ISBN.length;i++){

                if(ISBN[k]==Itemno[i]){
                    if(quantity[i]<stock[k]) {
                        System.out.println("\n\nThe Stock is available\n\t Proceed to Pay");
                        stock[k] = stock[k]-quantity[i];
                        System.out.println("\nThe available stock  :"+stock[k]);
                        break;
                    }
                    else {
                        System.out.println("\n The available Stock is  :" + stock[k]);
                        System.out.println("\n Would you like to Shop\n 1.Yes\n2.No");
                        System.out.print("\n Enter the choice  :");
                        shop = or.nextInt();
                        if (shop == 1) {
                            quantity[i] = stock[k];
                            stock[k] = 0;
                            break;
                        }
                        if (shop == 2) {
                            System.out.println("\n The order is cancelled");
                            break;
                        }
                    }

                }
                else
                    System.out.println("\nThe Stock is not available");
                break;
            }
            for (j = 0; j < ISBN.length; j++) {
                if (ISBN[j] == Itemno[i])
                    netTotal[i] = (price[j]*quantity[i])+op;
                IndPrice[i] = price[j];

            }


            if (netTotal[i] > 500) {
                discount = 0.10;
            }
            if (netTotal[i] > 1000) {
                discount = 0.20;
            }
            if (netTotal[i] > 2000) {
                discount = 0.50;
            }
            netTax = tax * quantity[i];
            billTotal = (netTotal[i] - discount) + netTax;
        }
    }

    double ReturnDiscount(){
        return discount;
    }
    double ReturnTax(){
        return tax;
    }
    double ReturnBTotal(){
        return billTotal;
    }
    int ReturnNo(){
        return numberOfItems;
    }
    int[] ReturnIndPr(){
        return IndPrice;
    }
    int[] ReturnQuantity(){
        return quantity;
    }
    int[] ReturnItem(){
        return Itemno;
    }
    int[] ReturnNetT(){
        return netTotal;
    }

}

class Payment{
    int PaymentStatus;
    String AccountNo;
    double PaidAmount,BalanceAmount;
}
class DC extends Payment {
    private String cvv;
    private String exp;

    int payCard(double nettotal) {
        int op, a, b, wh = 0, c, d = 0;
        Scanner py = new Scanner(System.in);
        do {
            System.out.print("\n Enter the account number :");
            AccountNo=py.nextLine();
            py.nextLine();
            a = AccountNo.length();
            try {
                if (a != 16)
                    throw new Exception();
                else
                    d = 0;
                wh=0;

            } catch (Exception pb) {
                System.out.println("Please enter a valid account number");
                wh = 2;
                d = 1;
            }
            if (d == 0) {
                System.out.print("Enter the cvv  :");
                cvv = py.nextLine();
                py.nextLine();
                b = cvv.length();
                try {
                    if (b > 3 || b < 3)
                        throw new Exception();
                    else
                        d = 0;
                    wh=0;
                } catch (Exception pb) {
                    System.out.println("Please enter a valid cvv");
                    wh = 2;
                    d = 1;
                }
            }
            if (d == 0) {
                System.out.print("Enter the date and month of expiry  :");
                exp = py.nextLine();
                py.nextLine();
                c = exp.length();
                try {
                    if (c > 4 || c < 4)
                        throw new Exception();
                    else
                        d = 0;
                    wh = 0;
                } catch (Exception pb) {
                    System.out.println("Please enter a valid date");
                    wh = 3;
                }


            }
        }while (wh!=0);
        System.out.println("The amount to be paid  :"+nettotal);
        System.out.println("Enter the amount  :");
        PaidAmount = py.nextDouble();
        BalanceAmount = nettotal - PaidAmount;
        if(BalanceAmount ==0)
        {
            System.out.print("\nPayment Done Successfull");
            PaymentStatus = 0;
        }
        if(BalanceAmount!=PaidAmount){
            System.out.println("\n Amount to be paid  :"+BalanceAmount);
            PaymentStatus = 1;
        }
        return PaymentStatus;
    }

}
class NetBanking extends Payment{
    String CRN,Mpin;
    int s,j,v,g;
    int NB(double netTotal) {

        Scanner cc;
        do {
            System.out.print("Enter the CRN number  :");
            cc = new Scanner(System.in);
            CRN = cc.nextLine();
            s = CRN.length();
            try {
                if (s != 10)
                    throw new Exception();
                else {
                    g = 0;
                    j = 0;
                }

            } catch (Exception pb) {
                System.out.println("Please enter a valid CRN");
                g = 2;
                j = 1;
            }
            System.out.print("\nEnter the Mpin  :");
            Mpin = cc.nextLine();
            v = Mpin.length();
            try {
                if (v != 6)
                    throw new Exception();
                else
                    g = 0;
                j = 0;

            } catch (Exception pb) {
                System.out.println("Please enter a valid Mpin");
                g = 2;
                j = 1;
            }
        } while (g != 0);
        System.out.println("The amount to be paid  :" + netTotal);
        System.out.print("\nEnter the amount  :");
        PaidAmount = cc.nextDouble();
        BalanceAmount = netTotal - PaidAmount;
        if (BalanceAmount == 0) {
            System.out.println("Payment Done Successfull");
            PaymentStatus = 0;
        }
        if (BalanceAmount != PaidAmount) {
            System.out.println("\n Amount to be paid  :" + BalanceAmount);
            PaymentStatus = 1;
        }
        return PaymentStatus;
    }
}
public class Main {

    public static void main(String[] args) {
        int i = 0,k=0,pm,qu,c=0;
        int choice = 0,nn=0;
        String name=new String();
        int customerId=0;
        String phone = new String();
        String mail = new String();
        String address = new String();
        String nname = new String();
        String gender = new String();
        int[] isbn = new int[200];
        int[] pp = new int[200];
        int[] Stock = new int[200];
        int[] IP = new int[200];
        int[] Quan = new int[200];
        int[] itn = new int[200];
        int[]nt = new int[200];
        double tax=0,dis=0,bt = 0;
        int ps=0,ci,v;
        Scanner in = new Scanner(System.in);
        Customer[] cus = new Customer[200];
        Item ite = new Item();
        ItemOrder Order = new ItemOrder();
        do {
            System.out.println("\n\t\t      WELCOME !!! TO GSHADE BOOK STORES ");
            System.out.println("=============================================================================");
            System.out.println("\n1.Add Item\n" +
                    "2. Customer Details\n" +
                    "3.Order Item\n" +
                    "4.Payment\n" + "5.Bill\n" + "6.Cancel\n" + "7.Exit");
            System.out.println("=============================================================================");
            System.out.print("\n Enter the choice  :");
            choice = in.nextInt();
            try {
                if (choice > 7 || choice < 1)
                    throw new Exception();
            }
            catch (Exception op) {
                System.out.println("Please enter a valid menu choice option ;");
            }

            switch (choice) {
                case 2: {




                    System.out.print("\nEnter the Customer Id  :");
                    customerId=in.nextInt();
                    System.out.print("\n Enter the gender  :");
                    gender = in.nextLine();
                    in.nextLine();
                    System.out.print("\nEnter the phone number  :");
                    phone = in.nextLine();
                    in.nextLine();
                    System.out.print("Enter the customer name  :");
                    name = in.nextLine();
                    in.nextLine();
                    System.out.print("Enter the Mail address  :");
                    mail = in.nextLine();
                    in.nextLine();
                    System.out.print("Enter the address  :");
                    address = in.nextLine();
                    in.nextLine();
                    cus[i] = new Customer(name,customerId,phone,mail,address);
                    i++;
                    break;
                }
                case 1:{

                    ite.AddItem();
                    isbn = ite.ReturnISBN();
                    pp = ite.ReturnPrice();
                    Stock = ite.ReturnStock();
                    break;
                }
                case 3:{

                    Order.Bill(isbn,pp,Stock);

                    dis = Order.ReturnDiscount();
                    bt = Order.ReturnBTotal();
                    tax = Order.ReturnTax();
                    nn = Order.ReturnNo();
                    Quan = Order.ReturnQuantity();
                    IP = Order.ReturnIndPr();
                    itn = Order.ReturnItem();
                    nt = Order.ReturnNetT();
                    break;
                }
                case 4: {
                    System.out.println("\nEnter the Mode of payment \n 1. Cash \n 2. Debit(or)Credit \n 3.Netbanking \n");
                    System.out.print("\nEnter the choice  :");
                    pm = in.nextInt();
                    if(pm==1){
                        System.out.print("\nThe amount to be paid  :"+bt);
                    }
                    if(pm ==2){
                        DC py = new DC();
                        ps = py.payCard(bt);
                    }
                    if(pm==3){
                        NetBanking nb = new NetBanking();
                        ps=nb.NB(bt);

                    }
                    break;
                }
                case 6:{
                    System.out.print("\nEnter the item no  :");
                    ci = in.nextInt();
                    System.out.print("\nEnter the no.of items to be cancelled");
                    qu = in.nextInt();
                    for(k=0;k<isbn.length;k++){
                        if(isbn[k]==ci)
                        {
                            System.out.println("Your Order has been Successfully cancelled");
                            Stock[k] = Stock[k]+ qu;
                            c=0;
                            break;
                        }
                        else
                            c=1;

                    }
                    if(c==1){
                        System.out.println("The item number is invalid");
                    }
                    break;

                }
                case 5:{
                    System.out.println("\t\t\t\t----------------GSHADE BOOK STORES-------------------");
                    System.out.println("\t\t\t\t----------------CUSTOMER INVOICE---------------------");
                    System.out.println("\n\t\tCustomer Name -->  "+name);
                    System.out.println("\n\t\tCustomer ID   --> "+customerId);
                    System.out.println("\n\t\tPhone         -->  " +phone);
                    System.out.println("\n\t\tMail          --> "+ mail);
                    System.out.println("\n\t\t Address      -->"+address);
                    System.out.println("\t\t\t\t------------------Item Description---------------------");
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println("\tItem No \t Quantity \t TotalPrice");
                    for(v=0;v<nn;v++){
                        System.out.println("\n\t"+itn[v]+"\t\t\t"+Quan[v]+"\t\t\t"+nt[v]);
                    }
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("\t\t\t\t------------------Amount Description--------------------");
                    System.out.println("\t\tNet Total: " +bt);
                    System.out.println("\t\tDiscount: "+dis);
                    System.out.println("\t\tTax per item: "+tax);
                    if(ps == 1){
                        System.out.println("\t\tPayment Status: Done");
                    }
                    else{
                        System.out.println("\t\tPayment Status: Not Done");
                    }
                    break;

                }
                case 7:
                    break;
            }

        } while (choice != 7);

    }
}
