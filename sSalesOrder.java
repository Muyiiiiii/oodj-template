package oodjAssign;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class sSalesOrder {
	private JPanel panel;
	private JFrame frame;
	
	public sSalesOrder(JFrame frame) {
		this.frame = frame;
	}
	
	public void createPanel() {
		panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(1080, 640));
        
        
        JPanel centerPanel = new JPanel(new GridBagLayout());
    	GridBagConstraints gbc = new GridBagConstraints();
    	gbc.gridx = 0;
    	gbc.gridy = 0;
    	gbc.anchor = GridBagConstraints.CENTER;
    	gbc.insets = new Insets(10,10,10,10);
    	
    	JButton homeButton = new JButton("Home");
    	
    	
    	//Arrangement
	    panel.add(centerPanel, BorderLayout.CENTER);
	        
	    gbc.gridy = 0;
	    gbc.gridx = 2;
	    gbc.ipadx = 60;
	    centerPanel.add(homeButton,gbc);
	    
	    
	    homeButton.addActionListener(e ->{
	    	_login.openSalespUI();
	    });
	}
	
	public JPanel getPanel() {
		return panel;
	}
}
