package bankaccount;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stace Omwando
 */
public class Main {
    static Account customer = new Account("","","", 0, 0);
    public static void main (String []args){
       
       
      int option;
      
        do {     
            menu();
            Scanner input = new Scanner(System.in);
            option = input.nextInt();
           switch(option){
               case 0:
                   System.exit(0);
                   break;
               case 1:
                   accountCreation();
                   break;
               case 2:
                   deposit();
                   break;
               case 3:
                   withdrawal();
                   break;
               case 4:
                   showDetails();
                   break;
                default:
                    System.out.println("Invalid option");
                    break;
           }
        } while (option!=0);
                 
}
     public static void menu(){
            System.out.println("<------------------Welcome to Kulukulu Bank------------------------->");
            System.out.println("Please select an option");
            
            System.out.println("0. Exit");
            System.out.println("1. Create an account");
            System.out.println("2. Deposit amount.");
            System.out.println("3. Withdraw amount");
            System.out.println("4. Check status");
     }
     
    public static void accountCreation(){
        String name;
        String lname;
        String id;
        int accNo;
        System.out.println("Please Enter your Name");
        Scanner input =  new Scanner(System.in);
        name = input.next();
        lname = input.next();
        id = input.next();
        
        System.out.println("Please Enter your account Number");
        accNo = input.nextInt();
        
        
        customer.setName(name);
        customer.setlName(lname);
        customer.setId(id);
        customer.setAccountNumber(accNo);
        customer.statusCheck();
    }
    
    public static void deposit(){
        double availableBalance;
        double deposit;
        availableBalance = customer.getBalance();
        Scanner input =  new Scanner(System.in);
        System.out.println("Enter amount you want to deposit");
        deposit = input.nextDouble();
        
        availableBalance = deposit + availableBalance;
        customer.setBalance(availableBalance);
        
    }
    
    public static void withdrawal(){
        double availableBalance = customer.getBalance();
        Scanner input =  new Scanner(System.in);
        System.out.println("Enter your withdraw amount");
        double withdrawal = input.nextDouble();
        
        if (availableBalance <= withdrawal) {
            System.out.println("Insufficient Balance");
        } else {
            System.out.println("Withdrawal succesful");
            availableBalance = availableBalance - withdrawal;
            customer.setBalance(availableBalance);
            System.out.println("Your new Balance is: "+customer.getBalance());
        }
        
    }
    
    public static void showDetails(){
        customer.statusCheck();
    }
    
}
