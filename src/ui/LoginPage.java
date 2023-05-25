package ui;

//import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPage extends JFrame implements ActionListener {
  
      JFrame frame = new JFrame();
      
      Color light = new Color(148, 180, 108);
      Color dark = new Color(98, 129, 58);
      
//      New label (text inside frame)
      JLabel loginLabel = new JLabel();

//      New panel (function)
      JPanel loginPanel = new JPanel();
      
      
      JTextField userName = new JTextField(10);
      JPasswordField password = new JPasswordField(10);
      
      JLabel labelUserName = new JLabel("Username");
      JLabel labelPassword = new JLabel("Password");
      
      JButton loginButton = new JButton("Login");

      
//      EndingListener button1 = new EndingListener();
      ImageIcon logo = new ImageIcon("logo.jpg");
      
      private MainUIPage main;
      
      public LoginPage () {
//    	  initialize
          this.init();
      }
  
      public void init () {
          
//          button.setBounds(100, 160, 200, 40);
//          button.setFocusable(false);
//          button.setBackground(Color.MAGENTA);
//          button.addActionListener();
          
          
          frame.setTitle("PetClinic");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setSize(300,300);
          frame.setLayout(null);
          frame.setResizable(false);
          frame.setFocusable(true);
          frame.setVisible(true);
          frame.setIconImage(logo.getImage());
          frame.getContentPane().setBackground(light);
          frame.add(loginPanel);
          frame.add(loginLabel);
          
          loginLabel.setText("Login");
          loginLabel.setBounds(1, 1, 100, 30);
          loginLabel.setFont(new Font("MV Boli", Font.BOLD, 16));
          
//          labelLogin.setHorizontalTextPosition(JLabel.CENTER);
//          labelLogin.setVerticalTextPosition(JLabel.BOTTOM);

          
          userName.setBounds(140, 40, 120, 30);
          userName.setBackground(light);
          labelUserName.setBounds(50,40,120,30);
          
          password.setBounds(140, 80, 120, 30);
          password.setBackground(light);
          labelPassword.setBounds(50,80,120,30);
          
          loginButton.setBounds(150, 120, 100, 30);
          loginButton.setBackground(light);
          loginButton.setFocusable(false);
//          this->implements
          loginButton.addActionListener(this);
        		  	
          
          loginPanel.setBounds(0,30, 300, 270);
          loginPanel.setBackground(dark);
          loginPanel.setLayout(null);
          loginPanel.add(userName);
          loginPanel.add(labelUserName);
          loginPanel.add(password);
          loginPanel.add(labelPassword);
          loginPanel.add(loginButton);
          
          
          
  }

//      Add unimplemented methods from class LoginPage (Because we have error)
		@Override
		public void actionPerformed(ActionEvent e) {
		
//		  	String usrn = userName.getText();
//		  	String psw = password.getText();
//		  	
//		  	if (usrn.contains("admin") && psw.contains("admin123")) {
//		  		userName.setText(null);
//		  		password.setText(null);
//		  		
//		  		MainUIPage mainUiPage = new MainUIPage();
//		  		
//		  	} else {
//		  		JOptionPane.showMessageDialog(null, "Invalid Login", "Login Error", JOptionPane.ERROR_MESSAGE);
//		  		password.setText(null);
//		  		userName.setText(null);
//		  	}
			
			main = new MainUIPage();
			
		} 
      
  
         
}



