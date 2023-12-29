package oodjAssign;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class aReportGen {
	private JPanel panel;
    private JTextField userField;
    private JPasswordField pwdField;
    private JFrame frame;
	private String selectedReportType; 
    
    public aReportGen(JFrame frame, String selectedReportType) {
        this.frame = frame;
        this.selectedReportType = selectedReportType;
        frame.setTitle("Personal Profile");
        createPanel();
    }
	
    public void createPanel() {
    	panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(1080, 640));
        		
//============================================================================================================//        		
	        	JPanel centerPanel = new JPanel(new GridBagLayout());
	        	GridBagConstraints gbc = new GridBagConstraints();
	        	gbc.gridx = 0;
	        	gbc.gridy = 0;
	        	gbc.anchor = GridBagConstraints.CENTER;
	        	
//============================================================================================================//	        	
	        	JButton home = new JButton("Home");
	        	
//============================================================================================================//
		        home.addActionListener(e ->{
		        	_login.openAdminUI();
		        });
    }
    
//============================================================================================================//    
    public JPanel getPanel() {
    	return panel;
    }
}
