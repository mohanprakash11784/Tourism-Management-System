package travel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Loading extends JFrame implements Runnable {

	
	 JProgressBar progressBar;
	Thread th;
        String username;

	public void run() {
            try {
                for (int i = 1; i <= 101; i++) {
                   
                    int m = progressBar.getMaximum();
                    int v = progressBar.getValue();
                    if (v < m) {
                        progressBar.setValue(progressBar.getValue() + 1);
                    } else {
                        setVisible(false);
                        new Dashboard(username);
                    }
                    Thread.sleep(50);
                }
            } catch (Exception e) {
		e.printStackTrace();
            }
	}

	public Loading(String username) {
            this.username=username;
            
            th = new Thread(this);

            setBounds(500, 200, 650, 400);
            getContentPane().setBackground(Color.WHITE);
            
            JLabel text= new JLabel("Travel and Toursim Application");
            text.setBounds(50, 20, 600, 40);
            text.setForeground(Color.BLUE);
            text.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
            add(text);
	
            progressBar = new JProgressBar();
            progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
            progressBar.setStringPainted(true);
            progressBar.setBounds(150, 100, 300, 35);
            add(progressBar);

             JLabel loading= new JLabel("Loading Please Wait....");
            loading.setBounds(200, 140, 150, 30);
            loading.setForeground(Color.BLUE);
            loading.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
            add(loading);
            
            JLabel lblusername= new JLabel("Welcome"+username);
            lblusername.setBounds(20, 310, 400, 40);
            lblusername.setForeground(Color.RED);
            lblusername.setFont(new Font("Raleway", Font.BOLD, 16));
            add(lblusername);
	

            th.start();
           setVisible(true);
	}
        public static void main(String[] args){
            new Loading("");
}
}