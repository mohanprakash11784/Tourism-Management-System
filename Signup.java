
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
    JButton create, back;
    JTextField tfusername,tfName,tfpassword,tfanswer;
    Choice security;
    Signup(){
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
          JPanel p1=new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        
        JLabel username=new JLabel("username");
        username.setFont(new Font(" Tahoma",Font.BOLD,14));
        username.setBounds(50,20,125,25);
        p1.add(username);
        
        tfusername=new JTextField();
        tfusername.setBounds(190,20,180,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        JLabel Name=new JLabel("Name");
        Name.setFont(new Font(" Tahoma",Font.BOLD,14));
        Name.setBounds(50,60,125,25);
        p1.add(Name);
        
        tfName=new JTextField();
        tfName.setBounds(190,60,180,25);
        tfName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfName);
        
        JLabel lpassword=new JLabel("Password");
        lpassword.setFont(new Font(" Tahoma",Font.BOLD,14));
        lpassword.setBounds(50,100,125,25);
        p1.add(lpassword);
        
         tfpassword=new JTextField();
        tfpassword.setBounds(190,100,180,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        JLabel lsecurity=new JLabel("Security Question");
        lsecurity.setFont(new Font(" Tahoma",Font.BOLD,14));
        lsecurity.setBounds(50,140,125,25);
        p1.add(lsecurity);
        
       security = new Choice();
        security.add("Fav Character from The Boys");
        security.add("Fav Marvel superhero");
        security.add("Your Lucky number");
        security.add("Your childhood superhero");
        security.setBounds(190,140,180,25);
        p1.add(security);
        
         JLabel lAnswer=new JLabel("Answer");
        lAnswer.setFont(new Font(" Tahoma",Font.BOLD,14));
        lAnswer.setBounds(50,180,125,25);
        p1.add(lAnswer);
        
        tfanswer=new JTextField();
        tfanswer.setBounds(190,180,180,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
         create = new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133,193,233));
        create.setFont(new Font("Tahoma",Font.BOLD,14));
        create.setBounds(80,250,100,30);
        create.addActionListener(this);
        p1.add(create);
        
         
       back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133,193,233));
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setBounds(250,250,100,30);
        p1.add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/icons/signup.png"));
        Image i2=i1.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(580,50,250,250);
        back.addActionListener(this);
        add(image);
        
      
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==create){
           
            String username=tfusername.getText();
            String name=tfName.getText();
            String password=tfpassword.getText();
            String question=security.getSelectedItem();
            String answer=tfanswer.getText();
            String query= "INSERT INTO account VALUES ('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"');";
          
           try{
               Conn c=new Conn();
               c.s.executeUpdate(query);
               
               JOptionPane.showMessageDialog(null,"Account Created Sucessfully");
               
               setVisible(false);
               new Login();
           }catch (Exception e){
               e.printStackTrace();
           }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args){
        new Signup();
    }
    
}
