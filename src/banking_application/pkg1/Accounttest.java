package banking_application.pkg1;

import java.util.Scanner;

public class Accounttest {
    //only creating 100 accounts
    static Account acc [] = new Account [100];
    public static int count;
    
    //prints out the menu options
    public static void mainMenu(){
        System.out.println("\n++++++++++++++++++");
        System.out.println("Bank Application");
        System.out.println("++++++++++++++++++++");
        System.out.println("1. Add new Account");
        System.out.println("2. Deposite or withdraw amount");
        System.out.println("3. Get balance for the given account");
        System.out.println("4. Print all account information");
        System.out.println("5. Exit");
    }
    //takes the user input for the switch and it is used for the do while loop
    public static int getMenuOption(){
        int option;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter your option");
        option = userInput.nextInt();
        
        return option;
    }
    //create a new account fuction is being created
    public static void addNewAccount(){
        int userOption = 0;
        
        System.out.println("Enter Account Type");
        System.out.println("1-Checking Account or 2-Savings Account");
        userOption = getMenuOption();
        
        //swtich operation us being used to see what kind of account the user wants
        switch(userOption){
            case 1:
                //using the CheckingAccount class
                acc[count] = new CheckingAccount();
                acc[count].input();
                count++;
                
                break;
                
            case 2:
                //using the SavingsAccount class
                acc[count] = new SavingsAccount();
                acc[count].input();
                count++;
                break;          
        }
    }
    //deposite or withdraw money from Savings or Checking accounts
    public static void depOrWith(){
        int userOption = 0;
        String accountNumber;
        
        Scanner userInput = new Scanner(System.in);
        //accountNumber will already know if its savings or the checking account
        System.out.println("Account Number");
        accountNumber = userInput.nextLine();
        
        System.out.println("Deposite or Withdraw");
        System.out.println("1-Deposie or 2- Withdraw");
        userOption = getMenuOption();
        
        for(int i=0; i < count; i++){
           
            if(acc[i].getNumber().equals(accountNumber)){
                
                //if the user wants to deposite they will enter 1 matching the deposite function
                if(userOption == 1){
                    acc[i].deposit();
                    
                    }else
                    //else it's to withdraw
                    acc[i].withdraw();
                }
            } 
        }
    //get balance function
    public static void getBalance(){
        String accountNumber;
        
        Scanner userInput = new Scanner(System.in);
        //checks the balance for the specific account number
        System.out.println("Account Number");
        accountNumber = userInput.nextLine();
        
        for(int i=0; i < count; i++){
           //checks if the accounts number matches the users input
            if(acc[i].getNumber().equals(accountNumber)){
                //prints out the balance of the account the user wants
                System.out.println("Balance"+ acc[i].getBalance());
                
            }
        }
    }
    //print all the account information 
    public static void printAll(){
        for(int i=0; i < count; i++){
            acc[i].print();
        }
    }
    
    public static void main(String[] args){
        count = 0;
        
        int option = 0;
        //using a do while to keep the program running
        do{
            mainMenu();
            option = getMenuOption();
            //switch for the getMenuOption function to go throught the options in the main menu
            switch(option){
                case 1:
                    System.out.println("Add new account");
                    //calls the function
                    addNewAccount();
                    
                    break;
                
                case 2:
                    System.out.println("Deposite or withdraw amount");
                     //calls the function
                    depOrWith();
                    
                    break;
                    
                case 3:
                    System.out.println("Get balance for the given account");
                     //calls the function
                    getBalance();
                    
                    break;
                    
                case 4:
                    System.out.println("Print all account information");
                     //calls the function
                    printAll();
                    
                    break;
                    
                case 5:
                    System.out.println("Exit");
                    
                    break;
                    
                default:
                    System.out.println("Error in the input");
            
            } 
            //exits the program
        } while (option != 5);
    }
}
