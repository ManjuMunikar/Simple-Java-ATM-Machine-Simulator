package atmmachine;

import java.util.Scanner;

public class AtmMachine { //main class vayo
    public static void main(String[] args) {
        ATM atm= new ATM();
    }
}
class ATM{
    float currentBalance;
    int PIN=111; //direct hardcode
    float depositAmount;

    Scanner scanner= new Scanner(System.in);

    ATM(){
        System.out.print("Enter your PIN::");
        int enteredPin= scanner.nextInt();
        if(enteredPin==PIN){
            menu();
        }else{
            System.out.println("Enter valid pin.");
        }
    }

    public void menu() {
        System.out.println(".............MenuOption..............");
        System.out.println("1. Check account balance");
        System.out.println("2. Withdraw balance");
        System.out.println("3. Deposit money");
        System.out.println("4. Check another account");
        System.out.println("5. Exit ");

        System.out.print("..........Enter number you want to:::::");
        int menuOption= scanner.nextInt();
        if(menuOption==1){
            checkBalance();
        }else if(menuOption==2){
            withdrawBalance();
        }else if(menuOption==3){
            depositMoney();
        }else if(menuOption==4){
            anotherAccount();
        } else if (menuOption==5) {
            System.out.println("Thank You for visiting our ATM");
            System.exit(0);

        }else{
            System.out.println("Invalid menu option");
        }
    }

    public void anotherAccount() {

    }

    public void checkBalance() {
        currentBalance = currentBalance+depositAmount;
        System.out.println("Your current balance is:"+"Rs."+ currentBalance);
        if(currentBalance<=0){
            System.out.println("Unable to withdraw, insufficient balance.");
            menu();
        }else {
            menu();
        }
    }

    public void withdrawBalance(){
        System.out.print("Enter the amount you want to withdraw::");
        float withdrawAmount=scanner.nextFloat();
        if(withdrawAmount<=currentBalance){
            currentBalance-=withdrawAmount;
            System.out.println("The remaining balance is:"+"Rs."+currentBalance);
            menu();
        }else{
            System.out.println("Insufficient amount to withdraw.");
            menu();
        }




    }
    public void depositMoney() {
        System.out.print("Enter the amount you want to deposit::");
        float depositAmount=scanner.nextFloat();
        currentBalance=+depositAmount;
        System.out.println("Your current balance is::"+"Rs."+currentBalance);
        menu();

    }


}
