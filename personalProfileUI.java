package oodjAssign;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class personalProfileUI {
	private JPanel panel;
    private JTextField userField;
    private JPasswordField pwdField;
    private JFrame frame;
	private String selectedWorkerType; 
    
    public personalProfileUI(JFrame frame, String selectedWorkerType) {
        this.frame = frame;
        this.selectedWorkerType = selectedWorkerType;
        frame.setTitle("Personal Profile");
        createPanel();
    }
    
    public void createPanel() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(1080, 640));
        String curUsername = new String();
    	String curPassword = new String();
    	if(selectedWorkerType == "Officer") {
    		curUsername = "officer";
    		curPassword = "reciffo";
        	pwdField = new JPasswordField(curPassword);
    		System.out.println(curPassword);
    	}else if (selectedWorkerType == "SalesPerson") {
    		curUsername = "sales";
    		curPassword = "sales";
        	pwdField = new JPasswordField(curPassword);
    	}else
    		curUsername = _login.usercreds().toString();
    		curPassword = _login.pwdcreds().toString();
    		
    
        		
//============================================================================================================//
	        	JPanel centerPanel = new JPanel(new GridBagLayout());
	        	GridBagConstraints gbc = new GridBagConstraints();
	        	gbc.gridx = 0;
	        	gbc.gridy = 0;
	        	gbc.anchor = GridBagConstraints.CENTER;
	        	
//	        	String curUsername = _login.usercreds().toString();
//	        	String curPassword = _login.pwdcreds().toString();
	        	
	        	
	        	
	        	//Username
	        	JLabel username = new JLabel("Username:     ");
	        	userField = new JTextField(curUsername);
	        	userField.setEditable(false);
	        	userField.setPreferredSize(new Dimension (100, 25));
	        	
	        	
	        	//Password
	        	JLabel password = new JLabel("Password:     ");
	        	pwdField.setEditable(false);
	        	pwdField.setPreferredSize(new Dimension (100, 25));
	        	
	        	
	        	//Home
	        	JButton home = new JButton("Home");
	        	
	        	//Show
	        	JButton show = new JButton("Show");
	        	show.setPreferredSize(new Dimension(67, 23));
	        	
//============================================================================================================//	        	
	        	gbc.gridy = 0;
	        	gbc.gridx = 2;
	        	gbc.insets = new Insets(20,20,20,20);
	        	centerPanel.add(home, gbc);
	        	
	        	gbc.gridy = 2;
	        	gbc.gridx = 1;
	        	gbc.insets = new Insets(0,0,0,0);
	        	centerPanel.add(username, gbc);
	        	gbc.gridx = 2;
	        	centerPanel.add(userField, gbc);
	        	
	        	gbc.gridy = 3;
	        	gbc.gridx = 1;
	        	centerPanel.add(password, gbc);
	        	gbc.gridx = 2;
	        	centerPanel.add(pwdField, gbc);
	        	gbc.gridx = 3;
	        	centerPanel.add(show, gbc);
	        	
	        	panel.add(centerPanel, BorderLayout.CENTER);
	        	
//============================================================================================================//	        	
	        	//Adding functions to home button
	        	home.addActionListener(new ActionListener() {
	        		public void actionPerformed(ActionEvent e) {
		        		String username = _login.usercreds().toString();
		                String password = _login.pwdcreds().toString();
	                    
	                    if (username.equals("admin") && password.equals("nimda")) {
	                    	_login.openAdminUI();
	                    } else if (username.equals("officer") && password.equals("reciffo")) {
	                    	_login.openOffiUI();
	                    } else if (username.equals("sales") && password.equals("sales")) {
	                    	_login.openSalespUI();
	                    } else {
	                        JOptionPane.showMessageDialog(panel, "Invalid username or password!");
	                    }
	                }        		
	            });
	        	
	        	show.addActionListener(new ActionListener() {
	        		public void actionPerformed(ActionEvent e) {
	        			toggleShowpwd();
	        		}
	        		private void toggleShowpwd() {
	        			if (pwdField.getEchoChar() == 0) {
	        	            // If echo char is 0, set it to default (bullet)
	        	            pwdField.setEchoChar('\u2022');
	        	            show.setText("Show");
	        	        } else {
	        	            // If echo char is not 0, set it to 0 (show characters)
	        	            pwdField.setEchoChar((char) 0);
	        	            show.setText("Hide ");
	        	        }
	        		}
	        	});
    }
    
//============================================================================================================//
    public JPanel getPanel() {
    	return panel;
    }
    
    public void openUIPanel(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
        frame.pack();
    }
    
}
