package oodjAssign;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import uiCX.StudentUI;

public class _login {
	private JPanel panel;
    private static JTextField usernameField;
    private static JPasswordField passwordField;
    private static JFrame frame; ;
    
    public _login(JFrame frame) {
        this.frame = frame;
        createPanel();
    }

    public void createPanel() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel(new GridBagLayout());
        	GridBagConstraints gbc = new GridBagConstraints();
        	gbc.gridx = 0;
        	gbc.gridy = 0;
        	gbc.anchor = GridBagConstraints.CENTER;
        	
        //Declaring label for Username & Password
        JLabel username = new JLabel("Username:       ");
        usernameField = new JTextField();
        JLabel password = new JLabel("Password:       ");
        passwordField = new JPasswordField();
        
        //Declaring button for Login
        JButton loginButton = new JButton("Login");
        JButton showPwdButton = new JButton("Show");
        showPwdButton.setPreferredSize(new Dimension (67,23));
        
        	//Declaring size for the box
        	passwordField.setPreferredSize(new Dimension(200, 25));
        	usernameField.setPreferredSize(new Dimension(200, 25));
        	
        	//Declaring labels' font
        	username.setForeground(Color.BLACK);
        	password.setForeground(Color.BLACK);

        	//Declare the vertical position of each label and textBox
        	//then declare the horizontal position
        	
        	//1st row
        	gbc.gridy = 1;
        	gbc.gridx = 1;
        	centerPanel.add(username, gbc);
        	gbc.gridx = 2;
        	centerPanel.add(usernameField, gbc);
        	
        	//2nd row
        	gbc.gridy = 2;
        	gbc.gridx = 1;
        	centerPanel.add(password, gbc);
        	gbc.gridx = 2;
        	centerPanel.add(passwordField, gbc);
        	gbc.gridx = 3;
        	centerPanel.add(showPwdButton,gbc);
        	
        	//3rd row
        	gbc.gridy = 3;
        	gbc.gridx = 2;
        	centerPanel.add(loginButton, gbc);
        	

        	
        	panel.add(centerPanel, BorderLayout.CENTER);
        	
        	
        	
        	//Adding functionality to Login Button
        	loginButton.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
                    String username = usercreds().toString();
                    String password = pwdcreds().toString();
                    

                    if (username.equals("admin") && password.equals("nimda")) {
                    	openAdminUI();
                    } else if (username.equals("officer") && password.equals("reciffo")) {
                    	openOffiUI();
                    } else if (username.equals("sales") && password.equals("sales")) {
                    	openSalespUI();
                    } else {
                        JOptionPane.showMessageDialog(panel, "Invalid username or password!");
                    }
                }        		
            });
        	

        	//Adding functionality to Show & Hide pwd button [toggle]
        	showPwdButton.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        				toggleShowpwd();
        		}
        		private void toggleShowpwd() {
        			if (passwordField.getEchoChar() == 0) {
        	            // If echo char is 0, set it to default (bullet)
        	            passwordField.setEchoChar('\u2022');
        	            showPwdButton.setText("Show");
        	        } else {
        	            // If echo char is not 0, set it to 0 (show characters)
        	            passwordField.setEchoChar((char) 0);
        	            showPwdButton.setText("Hide ");
        	        }
        		}
        	});
    }
    
    public static String usercreds() {
        String username = usernameField.getText();
        return username;
	}
    
    public static String pwdcreds() {
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);
        return password;
    }
    
    public JPanel getPanel() {
    	return panel;
    }
    
    public static void openUIPanel(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
        frame.pack();
    }
    
    //Method for opening adminUI
    public static void openAdminUI() {
    	frame.setTitle("Admin");
    	frame.setPreferredSize(new Dimension (1080, 640));
    	admin newAd = new admin();
    	adminUI adUI = new adminUI(newAd);
        adUI.createPanel();
        openUIPanel(adUI.getPanel());
    }
    
    //Method for opening officerUI
    public static void openOffiUI() {
    	frame.setTitle("Officer");
    	frame.setPreferredSize(new Dimension (1080, 640));
    	officer newOf = new officer();
    	officerUI ofUI = new officerUI(newOf);
    	ofUI.createPanel();
    	openUIPanel(ofUI.getPanel());
    }
    
    //Method for opening salespersonUI
    public static void openSalespUI() {
    	frame.setTitle("Salesperson");
    	frame.setPreferredSize(new Dimension (1080, 640));
    	salesperson newSales = new salesperson();
    	salespersonUI saUI = new salespersonUI(newSales);
    	saUI.createPanel();
    	openUIPanel(saUI.getPanel());
    }

}
