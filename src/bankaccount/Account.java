package bankaccount;


import java.io.InputStream;
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
public class Account {
    
    public String Name;
    public String lName;
    public String id;
    public int AccountNumber;
    private double balance;
    
  

    public Account(String Name,String lName, String id, int AccountNumber, double balance) {
        this.Name = Name;
        this.lName = lName;
        this.id = id;
        this.AccountNumber = AccountNumber;
        this.balance = balance;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
     public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

     public String  getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public int getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(int AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
  
    public void statusCheck(){
        System.out.println("<---------------------Details of your account:------------------------->");
        System.out.println("Account Holder: "+getName());
        System.out.println("Account Number: "+getAccountNumber());
        System.out.println("Balance: "+getBalance());
    }
    
   
    
}
