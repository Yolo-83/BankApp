import com.sun.jdi.InconsistentDebugInfoException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount bank1 = new BankAccount("Yolo", "161012");
        BankAccount bank2 = new BankAccount("Milo", "010487");

        bank1.Menu();

    }
}




class BankAccount{
    int balance;
    int previousTransaction;
    String userName;
    String userId;


    ////  COSTRUCTOR"
    BankAccount (String uName, String uId) {
        userName = uName;
        userId = uId;
    }




    ////  Method "DEPOSIT"
    void deposit (int amount) {
        if(amount != 0 ){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    ////  Method "WITHDRAW"
    void withdraw (int amount) {
        if(amount != 0 ){
            balance = balance + amount;
            previousTransaction = -amount;
        }
    }

    ////  Method "PREVIOUS TRANSACTION"
    void getPreviousTransaction (){
        if(previousTransaction > 0 ){
            System.out.println("Deposited: " + previousTransaction);
        }
        else if (previousTransaction < 0){   // -50=50 eller -400=400
            System.out.println("Withdraw: " + Math.abs(previousTransaction));
        }
        else {
            System.out.println("No transaction made");

        }
    }



    ////  MENU
    void Menu () {

        char operations = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + userName);
        System.out.println("Your ID is: " + userId);
        System.out.println();


        do {
            System.out.println("A. Deposit");
            System.out.println("B. Withdraw");
            System.out.println("C. Check balance");
            System.out.println("D. Last transaction");
            System.out.println("E. Exit");
            System.out.println();
            System.out.println("----------------------------------------");
            System.out.println("Please, choose an option and press ENTER");
            System.out.println("----------------------------------------");
            operations = scanner.next().charAt(0);

            // Change letters from lower case to upper case. (a b c d e)
            ///// Character.toUpperCase(operations);


            switch (operations) {
                case 'A':
                    System.out.println("-------------------------------------");
                    System.out.println("Please, enter a deposit amount");
                    System.out.println("-------------------------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;

                case 'B':
                    System.out.println("-------------------------------------");
                    System.out.println("Please, enter a withdraw amount");
                    System.out.println("-------------------------------------");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;

                case  'C':
                    System.out.println("-------------------------------------");
                    System.out.println("Your balance is: " + balance);
                    System.out.println("-------------------------------------");
                    break;

                case  'D':
                    System.out.println("-------------------------------------");
                    getPreviousTransaction();
                    System.out.println("-------------------------------------");
                    System.out.println();
                    break;

                case 'E':
                    System.out.println("-------------------------------------");
                    System.out.println("Hey " + userName + " thanks for using out service. See you soon.");
                    System.out.println("-------------------------------------");
                    break;

                default:
                    System.out.println("invalid operation. Please try again.");


            }

        }while (operations != 'E');

    }

}