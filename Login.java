
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login,fpassword, signup;
    JLabel username;
    JTextField tfpassword,tfusername;
    
    
    Login(){
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/icons/login.png"));
        Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(100,120,200,200);
        p1.add(image);
        
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);
        
        username=new JLabel("Username");
        username.setBounds(60,20,100,25);
        username.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        p2.add(username);
        
        tfusername=new JTextField();
        tfusername.setBounds(60,60,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);
        
        JLabel password=new JLabel("Password");
        password.setBounds(60,110,100,25);
        password.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        p2.add(password);
        
         tfpassword=new JTextField();
        tfpassword.setBounds(60,150,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);
            
        login =new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        login.addActionListener(this);
        p2.add(login);
        
        signup =new JButton("Signup");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(133, 193, 233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);
        
        fpassword=new JButton("Forget Password");
        fpassword.setBounds(130,250,130,30);
        fpassword.setBackground(new Color(133, 193, 233));
        fpassword.setForeground(Color.WHITE);
        fpassword.setBorder(new LineBorder(new Color(133, 193, 233)));
        fpassword.addActionListener(this);
        p2.add(fpassword);
        
         JLabel text = new JLabel("Trouble in login...");
         text.setBounds(300,250,150,20);
         text.setForeground(Color.RED);
         p2.add(text);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            try{
                String user=tfusername.getText();
                String pass=tfpassword.getText();
                
                String query ="SELECT * from account1 where usrname='"+user+"' AND password='"+pass+"'";
                Conn c= new Conn();
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(true);
                    new Loading(user);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect usernme or password");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()== signup){
            setVisible(false);
            new Signup();
        }
        else{
            setVisible(false);
            new ForgetPassword();
        }
    }
    public static void main(String[] args){
        new Login();
    }
    
}
