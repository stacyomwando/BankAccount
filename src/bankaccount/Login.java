/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

import static bankaccount.Create.acc;
import static bankaccount.Create.us;
import java.awt.BorderLayout;
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
public class Login extends JFrame{
    String no;
    String word;

    public Login(){
        JFrame stace = new JFrame("Login");
        Panel ui = new Panel();
        Panel side = new Panel();
        
//         stace.setLocationRelativeTo(null);
         stace.setResizable(false);
        ImageIcon icon = new ImageIcon("C:\\Users\\Stace Omwando\\Documents\\java icons\\bicon.png");
        JLabel meh = new JLabel (icon);
        JLabel info = new JLabel("The bank of choice");
        info.setFont(new Font("Century Gothic", 1, 13));
        JLabel topic = new JLabel("Kulukulu Bank");
        topic.setFont(new Font("Century Gothic", 1, 20));
        JLabel last = new JLabel ("Don't have an account?");
        JLabel message = new JLabel("Login");
        JLabel one = new JLabel ("Account number:");
        JLabel two = new JLabel ("Password:");
        JTextField acno = new JTextField(20);
        JPasswordField pass = new JPasswordField(20);
        JButton login = new JButton("Login");
        JButton exit = new JButton ("Sign Up");
        side.setBackground(Color.decode("#CE2945"));
        ui.setBackground(Color.decode("#DF6B7E"));
        last.setFont(new Font("Century Gothic", 1, 12));
        one.setFont(new Font("Century Gothic", 0, 12));
        two.setFont(new Font("Century Gothic", 0, 12));
        message.setFont(new Font("Century Gothic", 1, 15));
        login.setFont(new Font("Century Gothic", 0, 12));
        exit.setFont(new Font("Century Gothic", 0, 12));
        
        ui.setLayout(null);
        side.setLayout(null);
        side.setBounds(0,0,300,700);
        ui.setBounds(300,0,500,700);
        message.setBounds(450,80,150,30);
        one.setBounds(350,150,150,30);
        two.setBounds(350,220,100,30);
        acno.setBounds(470,150,100,30);
        pass.setBounds(470,220,100,30);
        login.setBounds(400,330,120,30);
        exit.setBounds(400,450,120,30);
        topic.setBounds(80,90,150,30);
        meh.setBounds(20,150,260,300);
        last.setBounds(350,400,300,30);
        info.setBounds(80,430,300,30);
        
        
        stace.add(side);
        stace.add(ui);
        ui.add(message);
        ui.add(one);
        ui.add(two);
        ui.add(acno);
        ui.add(pass);
        ui.add(login);
        ui.add(exit);
        ui.add(last);
        side.add(meh);
        side.add(topic);
        side.add(info);
         stace.setVisible(true);
        stace.setSize(800, 700);
        stace.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        login.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                String accno = acno.getText();
                String pword = pass.getText();
                
                try{
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
                    Statement stmt =con.createStatement();
                    String sql = "Select AccountNo,Password,FName from customer;";
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()){
                        
                        no = rs.getString("AccountNo");
                        acc = Integer.parseInt(no);
                        word =  rs.getString("Password");
                        us = rs.getString("FName");
                        
                        
                    
                    }
                    if(accno.equals(no) && (pword.equals(word)))
                    {
                stace.dispose();
               new BankAccount();
               
               JOptionPane.showMessageDialog(null, "Welcome to Kulukulu Bank\n","Insertion",JOptionPane.INFORMATION_MESSAGE);
                 
                    }
                    else{
                       
                       
                        acno.setText(null);
                       pass.setText(null);
                       JOptionPane.showMessageDialog(null,"Incorrect username or password","Error",JOptionPane.ERROR_MESSAGE);
                    }
                
                }
                
                  catch(NullPointerException e){
                     
                   JOptionPane.showMessageDialog(null, "Error!\n" +e,"ERROR",JOptionPane.ERROR_MESSAGE);   
                 }
                 catch(SQLException e){
                 JOptionPane.showMessageDialog(null, "Error!\n" +e,"ERROR",JOptionPane.ERROR_MESSAGE);    
                 }
                catch(Exception e)
                        {
                            JOptionPane.showMessageDialog(null, "Error!\n"+e,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
               
            }
            
        });  
        exit.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                stace.dispose();
                new Create();
            }
        });  
//        
//        stace.setSize(800,700);
//        stace.setVisible(true);
//        stace.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
    
    public static void main(String []args){
        Login me = new Login();
    }
    
}
