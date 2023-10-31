package newatmmachinebypin;

import java.util.HashMap;
import java.util.Scanner;

public class AtmMachine {
    public static void main(String[] args) {
        ATMOP atmop= new ATMOP();

    }
}

class Data{
    float balance;


}
class ATMOP{

    Scanner scanner= new Scanner(System.in);
    HashMap<Integer,    Data> hashMap = new HashMap<>();
    ATMOP(){
        System.out.println("Welcome to the ATM");
        System.out.println("*********************");
        anotherAccount();

    }
    public void anotherAccount() {
        System.out.println("Enter your pin code"); //pincode exit garcha ki nai vanera hasmap use garni
        System.out.println("*********************");
        int pincode= scanner.nextInt();
        if(hashMap.containsKey(pincode)==true){

            Data object= hashMap.get(pincode);
            menu(object);
        }else{
            System.out.println("Please create account first??");
            System.out.println("set your pin code::");
            //If it doesn't exist, it prompts the user to create an account, sets a pin code, creates a new Data object,
            // associates it with the pin code in the hashMap, and then calls the menu() method.
            int pin = scanner.nextInt();
            Data object = new Data();
            hashMap.put(pin, object);
            menu(object);
        }

    }

    public void menu(Data object) {
        System.out.println("*********************");
        System.out.println(".............MenuOption..............");
        System.out.println("1. Check account balance");
        System.out.println("2. Withdraw balance");
        System.out.println("3. Deposit money");
        System.out.println("4. Check another account");
        System.out.println("5. Exit ");

        System.out.print("..........Enter number you want to:::::");
        int menuOption= scanner.nextInt();
        if(menuOption==1){
            checkBalance(object);
        }else if(menuOption==2){
            withdrawBalance(object);
        }else if(menuOption==3){
            depositMoney(object);
        }else if(menuOption==4){
            anotherAccount();
        } else if (menuOption==5) {
            System.out.println("Thank You for visiting our ATM");
            System.exit(0);

        }else{
            System.out.println("Invalid menu option");
        }
    }

    public void checkBalance(Data object) {
        //object.currentBalance = object.currentBalance+object.depositAmount;
        System.out.println("Your current balance is:"+"Rs."+ object.balance);
        if(object.balance <=0){
            System.out.println("Unable to withdraw, insufficient balance.");
            menu(object);
        }else {
            menu(object);
        }
    }
    public void withdrawBalance(Data object){
        System.out.print("Enter the amount you want to withdraw::");
        float withdrawAmount=scanner.nextFloat();
        if(withdrawAmount<=object.balance){
            object.balance -=withdrawAmount;
            System.out.println("The remaining balance is:"+"Rs."+object.balance);
            menu(object);
        }else{
            System.out.println("Insufficient amount to withdraw.");
            menu(object);
        }

    }
    public void depositMoney(Data object) {
        System.out.print("Enter the amount you want to deposit::");
        float depositAmount=scanner.nextFloat();
        object.balance +=depositAmount;
        System.out.println("Your current balance is::"+"Rs."+object.balance);
        menu(object);

    }
}

