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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
/**
 *
 * @author Stace Omwando
 */
public class StatusCheck extends JFrame{
        JLabel message;
       JLabel one;
       JLabel two;
       JLabel three;
       JLabel four;
       JLabel five;
       JTextField fname;
       JTextField lname;
       JTextField id;
       JTextField number;
       JTextField balance;
       JButton exit;
        String bal ;
        String namef;
        String namel;
        String idf;
        String acno;
    public StatusCheck(){
        JFrame stace = new JFrame("Check Status");
        Panel panel = new Panel();
        stace.add(panel);
        
      
       message = new JLabel("Here are your account details");
       one = new JLabel("First Name: ");
       fname = new JTextField (20);
       two = new JLabel("Last Name: ");
       lname = new JTextField (20);
       three = new JLabel("ID Number: ");
       id = new JTextField (20);
       four = new JLabel("Account Number: ");
       number = new JTextField (20);
       five = new JLabel("Balance: ");
       balance = new JTextField (20);
       exit = new JButton("Exit");
       JButton menu = new JButton ("Menu");
       JButton show = new JButton ("Show details");
       
       
       panel.setLayout(null);
       
       message.setBounds(300, 10, 300, 30);
       one.setBounds(50, 100, 100, 30);
       fname.setBounds(170, 100, 200, 30);
       two.setBounds(50, 150, 100, 30);
       lname.setBounds(170, 150, 200, 30);
       three.setBounds(50, 200, 100, 30);
       id.setBounds(170, 200, 200, 30);
       four.setBounds(50, 250, 200, 30);
       number.setBounds(170, 250, 200, 30);
       five.setBounds(50, 300, 100, 30);
       balance.setBounds(170, 300, 200, 30);
       exit.setBounds(250,350,100,30);
       menu.setBounds(370, 350, 100, 30);
       show.setBounds(50, 50, 150, 30);

       
       
        panel.add(message);
        panel.add(one);
        panel.add(fname);
        panel.add(two);
        panel.add(lname);
        panel.add(three);
        panel.add(id);
        panel.add(four);
        panel.add(number);
        panel.add(five);
        panel.add(balance);
        panel.add(exit);
        panel.add(menu);
        panel.add(show);
        
        stace.setVisible(true);
        stace.setSize(800, 700);
        stace.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
         exit.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent ae)
            {
                System.exit(0);
            }
        });   
        
         menu.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent ae)
            {
                stace.dispose();
                new BankAccount();
            }
        }); 
         
         show.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent ae)
            {
                try {
            Class.forName("com.mysql.jdbc.Driver");
            String path = "jdbc:mysql://localhost:3306/bank";
            String user = "root";
            String pass = "";
            Connection con = DriverManager.getConnection(path, user, pass);
            Statement stmt = con.createStatement();
            String sql = "select * from customer where AccountNo = '"+acc+"';";
            ResultSet rs = stmt.executeQuery(sql);
             while (rs.next()){

               bal = rs.getString("Balance");
               namef = rs.getString("FName");
               namel = rs.getString("LName");
               idf = rs.getString("ID");
               acno = rs.getString("AccountNo");
                    }
            
            
                fname.setText(""+namef);
               lname.setText(""+namel);
                id.setText(""+idf);
                number.setText(""+acno);
                balance.setText(""+bal);
                

        }
                
                  catch(NullPointerException e){
                     
                   JOptionPane.showMessageDialog(null, "Error!\n" +e,"ERROR",JOptionPane.ERROR_MESSAGE);   
                 }
                 catch(SQLException e){
                 JOptionPane.showMessageDialog(null, "Error!\n" +e,"ERROR",JOptionPane.ERROR_MESSAGE);    
                 }
                catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error!\n" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }        // TODO add 
                
                
            }
        }); 
         
    }
   public static void main(String []args){
       StatusCheck me = new StatusCheck();
   } 
}
