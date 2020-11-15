/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;
import static bankaccount.Create.acc;
import static bankaccount.Main.customer;
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
public class Withdrawal extends JFrame{
    int availableBalance;
    public Withdrawal(){
        JFrame stace = new JFrame("Withdrawal");
        Panel ui = new Panel();
        stace.add(ui);
        
        JLabel message;
        message = new JLabel("Enter the amount you wish to withdraw");
        
        
        JLabel one;
        JTextField two;
        JButton three;
        
        one = new JLabel("Amount: ");
        two=new JTextField(20);
        three=new JButton("Submit");
        JButton four = new JButton("Cancel");
        
        ui.setLayout(null);
        
        message.setBounds(250, 10, 300, 30);
        one.setBounds(50, 100, 100, 30);
        two.setBounds(120, 100, 200, 30);
        three.setBounds(150, 150, 100, 30);
        four.setBounds(300, 150, 100, 30);
        
        
        
        ui.add(one);
        ui.add(two);
        ui.add(three);
        ui.add(message);
        ui.add(four);
        
        
        stace.setVisible(true);
        stace.setSize(800, 700);
        stace.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
         
        three.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent ae)
            {
                String with = two.getText();
                int withdrawal = Integer.parseInt(with);
               
           
          
                
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
                        
                if (availableBalance <= withdrawal){
                   JOptionPane.showMessageDialog(null,"Insufficient Balance","Error",JOptionPane.ERROR_MESSAGE);
                }
                
                
                else{
                     availableBalance = availableBalance-withdrawal;
                String query = "update customer set Balance = '"+availableBalance+"' where AccountNo = '"+acc+"';";
                stmt.executeUpdate(query);
               
                stace.dispose();
                JOptionPane.showMessageDialog(null, "You have made your withdrawal successfully\n","Insertion",JOptionPane.INFORMATION_MESSAGE);
               new BankAccount(); 

               
    
                }
                two.setText(null);
    
}
                
                  catch(NullPointerException e){
                     
                   JOptionPane.showMessageDialog(null, "Error!\n" +e,"ERROR",JOptionPane.ERROR_MESSAGE);   
                 }
                 catch(SQLException e){
                 JOptionPane.showMessageDialog(null, "Error!\n" +e,"ERROR",JOptionPane.ERROR_MESSAGE);    
                 }
catch (Exception e){
    
     JOptionPane.showMessageDialog(null, "Error!\n"+e,"ERROR",JOptionPane.ERROR_MESSAGE);
    two.setText(null);
    
               
                
            }
            }
            
        });   
        
        
    four.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                stace.dispose();
                JOptionPane.showMessageDialog(null, "You have canceled withdrawal\n","Insertion",JOptionPane.INFORMATION_MESSAGE);
               new BankAccount(); 
            }
        });  
    }
    
    public static void main (String[]args ){
        Withdrawal me = new Withdrawal();
    }
}
