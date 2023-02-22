package practice;

import java.util.*;

public class ATM{
    public static void main(String[] args) {
        ATMop obj = new ATMop();
    }
}
class Data{
    int balance;
}

 class ATMop {
    HashMap<Integer , Data >  map  = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    ATMop(){
            System.out.println("Welcome to our ATM");
            op();
    }

     public void op(){
         System.out.println("enter valid pin");

         int pin = sc.nextInt();

         if(map.containsKey(pin)){
             Data obj = map.get(pin);
             menu(obj);
         }else{
             System.out.println("please create account first ");
             System.out.println("set pin code");
             System.out.println("set pin greater than 2  and less than 5");

             int setpin = sc.nextInt();

             Data obj = new Data();
             if(Integer.toString(setpin).length() < 5 && 2<Integer.toString(setpin).length() ){
                 obj.balance = 0;
                 map.put(setpin , obj);
                 menu(obj);
             }
             else{
                 System.out.println("Invalid pin system terminate");
             }
         }
     }


    public void menu(Data obj){
        System.out.println("******************************************************************************");
        System.out.println("Enter your choice");

        System.out.println("1 . check balance");
        System.out.println("2 . withdraw money");
        System.out.println("3 . deposit money");
        System.out.println("4 . exit");
        System.out.println("5 . check another account");
        System.out.println("Enter option choose");
        int x = sc.nextInt();

        if(x == 1){
            check_balance(obj);
        }
        else if(x==2){
            withdraw(obj);
        }
        else if(x==3){
            deposite(obj);
        }
        else if(x == 4){
            System.out.println("thank you for using our ATM");
        }else if(x == 5){
//            ATMop obj = new ATMop();
            op();
        }
        else{
            System.out.println("enter valid option");
            menu(obj);
        }
    }

    public void check_balance(Data obj){
        System.out.println("your current balance " + obj.balance);
        System.out.println("******************************************************************************");
        menu(obj);
    }

    public void deposite(Data obj){
        System.out.println("enter the amount ");
        float d = sc.nextFloat();
        obj.balance += d;
        System.out.println("amount deposited successfully ");
        System.out.println("******************************************************************************");
        menu(obj);
    }

    public void withdraw(Data obj){
        System.out.println("enter the amount ");
        float d = sc.nextFloat();
       if(d > obj.balance) {System.out.println("ïnsufficient balance"); menu(obj);}
        obj.balance -= d;
        System.out.println("amount withdraw successfully ");
        System.out.println("******************************************************************************");
        menu(obj);
    }


}
