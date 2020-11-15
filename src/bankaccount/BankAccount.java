/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static bankaccount.Create.us;
import java.awt.Color;
public class BankAccount extends JFrame{

         JLabel info;
         JButton Two;
         JButton Three;
         JButton Four;
         JLabel Message;
         
         
   
    public BankAccount(){
        
       
    
        
        JFrame BankUI = new JFrame ("Dashboard");
        Panel UI = new Panel();
        Panel side = new Panel();
        
         JLabel inf = new JLabel("The bank of choice");
        inf.setFont(new Font("Century Gothic", 1, 13));
        JLabel topic = new JLabel("Kulukulu Bank");
        topic.setFont(new Font("Century Gothic", 1, 20));
        JButton exit = new JButton("Log Out");
         exit.setFont(new Font("Century Gothic", 0, 12));
         ImageIcon icon4 = new ImageIcon("C:\\Users\\Stace Omwando\\Documents\\java icons\\person icon.png");
         JLabel img4 = new JLabel(icon4);
        info = new JLabel ("WELCOME, "+us );
        info.setFont(new Font("Century Gothic", 1, 20));
        BankUI.setResizable(false);
        ImageIcon icon = new ImageIcon("C:\\Users\\Stace Omwando\\Documents\\java icons\\bicon.png");
       JLabel meh = new JLabel(icon);
       
       ImageIcon icon1 = new ImageIcon("C:\\Users\\Stace Omwando\\Documents\\java icons\\dep.png");
       ImageIcon icon2 = new ImageIcon("C:\\Users\\Stace Omwando\\Documents\\java icons\\with.png");
       ImageIcon icon3 = new ImageIcon("C:\\Users\\Stace Omwando\\Documents\\java icons\\book.png");
       
        
        Message = new JLabel("Select the action you would like to take");
         Message.setFont(new Font("Century Gothic", 1, 14));
        Two = new JButton("Make deposit");
        //Two.setIcon(icon1);
         Two.setFont(new Font("Century Gothic", 0, 12));
        Three = new JButton("Make withdrawal");
       // Three.setIcon(icon2);
         Three.setFont(new Font("Century Gothic", 0, 12));
        Four = new JButton("Check Status");
       // Four.setIcon(icon3);
         Four.setFont(new Font("Century Gothic", 0, 12));
       side.setBackground(Color.decode("#74776C"));
       UI.setBackground(Color.decode("#A4AB93"));
        
        
        UI.setLayout(null);
        side.setLayout(null);
        side.setBounds(0,0,300,700);
        UI.setBounds(300,0,500,700);
        
        info.setBounds(10,200,300,30);
        Message.setBounds(100,230, 300, 30);
       
        Two.setBounds(150, 280, 150, 100);
        Three.setBounds(150,400, 150, 100);
        Four.setBounds(150, 520, 150, 100);
        exit.setBounds(370, 630, 100, 30);
        meh.setBounds(20,150,260,300);
        topic.setBounds(80,90,150,30);
        inf.setBounds(80,430,300,30);
        img4.setBounds(150,20,150,150);
        
        BankUI.add(UI);
        BankUI.add(side);
       
        UI.add(Two);
        UI.add(Three);
        UI.add(Four);
        UI.add(exit);
        UI.add(info);
        UI.add(Message);
        side.add(meh);
        side.add(inf);
        side.add(topic);
        UI.add(img4);
       
        
        BankUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BankUI.setSize(800,700);
        BankUI.setVisible(true);
      
         Two.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                BankUI.dispose();
               new Deposit(); 
               
            }
        });   
        
         Three.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                BankUI.dispose();
               new Withdrawal(); 
               
            }
        });   
 
        
          Four.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                BankUI.dispose();
               new StatusCheck(); 
               
            }
        });   
        
           exit.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                BankUI.dispose();
                new Login();
                JOptionPane.showMessageDialog(null, "You have successfully logged out\n","Insertion",JOptionPane.INFORMATION_MESSAGE);
                
            }
        });   
        
        
       
         
        
    }
    
    public static void main(String[]args){
        BankAccount stace  = new BankAccount();
         
    }
}
   
    

