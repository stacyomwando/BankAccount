/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

import static bankaccount.Main.customer;
import java.awt.Color;
import java.awt.Font;
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
public class Create extends JFrame{
    public static int acc;
    public static String us;
    public Create(){
               
        
        
        
        JFrame stace = new JFrame("Account Creation");
        Panel ba = new Panel();
        Panel side = new Panel();
        
        stace.setResizable(false);
        JLabel message;
        JLabel info = new JLabel ("Create an account");
         info.setFont(new Font("Century Gothic", 1, 13));
        message = new JLabel("Fill the fields to create account");
        message.setFont(new Font("Century Gothic", 1, 12));
        ImageIcon icon = new ImageIcon("C:\\Users\\Stace Omwando\\Documents\\java icons\\per.png");
        JLabel meh = new JLabel (icon);
        ba.add(message);
        JLabel one;
        JLabel two;
        JLabel three;
        
        JLabel five;
        
        one = new JLabel("First Name: ");
        one.setFont(new Font("Century Gothic", 0, 12));
        two = new JLabel("Second Name: ");
        two.setFont(new Font("Century Gothic", 0, 12));
        three = new JLabel("ID Number: ");
        three.setFont(new Font("Century Gothic", 0, 12));
        
        JButton submit;
        submit = new JButton("Submit");
        submit.setFont(new Font("Century Gothic", 0, 12));
        JButton cancel;
        cancel = new JButton ("Cancel");
        cancel.setFont(new Font("Century Gothic", 0, 12));
        
        JLabel pass = new JLabel("Password:");
        pass.setFont(new Font("Century Gothic", 0, 12));
        JPasswordField pword = new JPasswordField(20);
        JPasswordField cpass = new JPasswordField(20);
        JLabel cpword = new JLabel("Confirm Password:");
        cpword.setFont(new Font("Century Gothic", 0, 12));
        side.setBackground(Color.decode("#5634A5"));
        ba.setBackground(Color.decode("#515DAB"));
        
        
        JTextField sally;
        JTextField maureen;
        JTextField macky;
        
        
        
        
        
        sally = new JTextField(20);
        maureen = new JTextField(20);
        macky = new JTextField(20);
        
        
        ba.setLayout(null);
        side.setLayout(null);
        side.setBounds(0,0,300,700);
        ba.setBounds(300,0,500,700);
        meh.setBounds(20,20,260,400);
        info.setBounds(80,450,300,30);
        message.setBounds(100, 10, 300, 30);
        one.setBounds(50, 120, 120, 30);
        sally.setBounds(180, 120, 200, 30);
        two.setBounds(50, 170, 120, 30);
        maureen.setBounds(180, 170, 200, 30);
        three.setBounds(50, 220, 120, 30);
        macky.setBounds(180, 220, 200, 30);
        submit.setBounds(200, 420, 100,30);
        cancel.setBounds(350,420,100,30);
        pass.setBounds(50, 270, 100,30);
        pword.setBounds(180, 270, 200,30);
        cpword.setBounds(50, 320, 150,30);
        cpass.setBounds(180, 320, 200,30);
        
        stace.add(ba);
        stace.add(side);
        ba.add(one);
        ba.add(sally);
        ba.add(two);
        ba.add(maureen);
        ba.add(three);
        ba.add(macky);
        ba.add(cancel);
        ba.add(pword);
        ba.add(pass);
        ba.add(cpword);
        ba.add(cpass);
        side.add(meh);
        side.add(info);
        
        
        ba.add(submit);
         
        stace.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        stace.setSize(800,700);
        stace.setVisible(true);
        
         submit.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent ae)
            {
                
               String fname = sally.getText();
               String lname = maureen.getText();
               String id = macky.getText();
               String word = pword.getText();
               String conf = cpass.getText();
               
               
               
               if ((fname=="")||(lname=="")||(id==""))
{
       JOptionPane.showMessageDialog(null, "Error!All fields should be filled.\n","ERROR",JOptionPane.ERROR_MESSAGE);
}
else{
         if(cpass.getText().trim().equals(pword.getText())){
                   
                 try{
                Class.forName("com.mysql.jdbc.Driver");
                String path = "jdbc:mysql://localhost/bank";
                String user = "root";
                String pass = "";
                Connection con =DriverManager.getConnection(path,user,pass);
                Statement stmt = con.createStatement();
                String query1 = "insert into customer (FName,LName,ID,Password)values('"+fname+"','"+lname+"','"+id+"','"+word+"');";
                stmt.executeUpdate(query1);
                 String sql = "Select AccountNo,FName from customer;";
                ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()){

                String no = rs.getString("AccountNo");
                us = rs.getString("FName");
                 acc  = Integer.parseInt(no);
                 
                    }
                 
                stace.dispose();
                new BankAccount();
                JOptionPane.showMessageDialog(null, "You have signed up successfully\n","Insertion",JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Your account number is \n" +acc,"Insertion",JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Welcome to Kulukulu bank\n","Insertion",JOptionPane.INFORMATION_MESSAGE);
                
                    
                
    
}
                  catch(NullPointerException e){
                     
                   JOptionPane.showMessageDialog(null, "Error!\n" +e,"ERROR",JOptionPane.ERROR_MESSAGE);   
                 }
                 catch(SQLException e){
                 JOptionPane.showMessageDialog(null, "Error!\n" +e,"ERROR",JOptionPane.ERROR_MESSAGE);    
                 }
                 
    catch (Exception e){
     
     JOptionPane.showMessageDialog(null, "Error!\n" +e,"ERROR",JOptionPane.ERROR_MESSAGE);
     
//        sally.setText(null);
//        maureen.setText(null);
//        macky.setText(null);
//        pword.setText(null);
//        cpass.setText(null);
            } 
          
         } 
              else
       {
           JOptionPane.showMessageDialog(null,"The passwords do not match","Error",JOptionPane.ERROR_MESSAGE);
       }
            
               }
            }
        });   
         
         cancel.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent ae)
            {
                stace.dispose();
                new Login();
                JOptionPane.showMessageDialog(null, "You have canceled account creation\n","Insertion",JOptionPane.INFORMATION_MESSAGE);
                
            }
        });   
        
    
   
       
       
        
        
    }
    public static void main(String[]args){
        Create me = new Create();
        
    }

    
}
