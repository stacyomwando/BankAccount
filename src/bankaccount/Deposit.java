/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;
import static bankaccount.Create.acc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import javax.swing.*;

/**
 *
 * @author Stace Omwando
 */
public class Deposit extends JFrame{
    static int availableBalance;
    public Deposit(){
        JFrame bank = new JFrame ("Deposit");
        Panel ui = new Panel();
        bank.add(ui);
        JLabel message;
        message = new JLabel("Enter the amount you would like to deposit");
        ui.add(message);
        
        JLabel one;
        JTextField two;
        JButton three;
        JButton four;
        
        one = new JLabel("Amount: ");
        two = new JTextField (20);
        three = new JButton("Submit");
        four = new JButton ("Cancel");
        
        ui.setLayout(null);
        
        message.setBounds(250,10,300,30);
        one.setBounds(50, 100, 100, 30);
        two.setBounds(120, 100, 200, 30);
        three.setBounds(170, 150, 100, 30);
        four.setBounds(300,150,100,30);
        
        ui.add(one);
        ui.add(two);
        ui.add(three); 
        ui.add(four);
        bank.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        bank.setSize(800,700);
        bank.setVisible(true);
        
        three.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent ae)
            {
                
                String dep = two.getText();
                int deposit = Integer.parseInt(dep);
               
          
                try{
                Class.forName("com.mysql.jdbc.Driver");
                String path = "jdbc:mysql://localhost/bank";
                String user = "root";
                String pass = "";
                Connection con =DriverManager.getConnection(path,user,pass);
                Statement stmt = con.createStatement();
                String sql = "Select Balance from customer where AccountNo = '"+acc+"';";
                
                ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()){

                String bal = rs.getString("Balance");
                availableBalance = Integer.parseInt(bal);
                 
                    }
                    availableBalance = deposit + availableBalance;
                    String query1 = "update customer set Balance = '"+availableBalance+"' where AccountNo = '"+acc+"';";
                    
                stmt.executeUpdate(query1);
                 

               bank.dispose();
               JOptionPane.showMessageDialog(null, "You have made your deposit successfully\n","Insertion",JOptionPane.INFORMATION_MESSAGE);
               new BankAccount(); 
               
    two.setText(null);
    
    
}
                
                  catch(NullPointerException e){
                     
                   JOptionPane.showMessageDialog(null, "Error!\n" +e,"ERROR",JOptionPane.ERROR_MESSAGE);   
                 }
                 catch(SQLException e){
                 JOptionPane.showMessageDialog(null, "Error!\n" +e,"ERROR",JOptionPane.ERROR_MESSAGE);    
                 }
catch (Exception e){
    
     JOptionPane.showMessageDialog(null, "Error!\n" +e,"ERROR",JOptionPane.ERROR_MESSAGE);
    two.setText(null);
    
            }
            }
        });   
        
         four.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent ae)
            {
                
                bank.dispose();
                JOptionPane.showMessageDialog(null, "You have canceled deposit\n","Insertion",JOptionPane.INFORMATION_MESSAGE);
               new BankAccount(); 
            }
        });  
    }
    
    public static void main(String []args){
        Deposit me = new Deposit();
    }
}
