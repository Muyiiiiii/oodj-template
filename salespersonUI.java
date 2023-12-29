package oodjAssign;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class salespersonUI {
	private JPanel panel;
    private salesperson sape;

    public salespersonUI(salesperson sape) {
        this.sape = sape;
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
		    JButton logoutButton = new JButton("Logout");
		    JButton printButton = new JButton("Print Orders");
		    JButton salesButton = new JButton("Sales Order");
		    JButton personal = new JButton("Personal Profile");
		        
		    String printType[] = {"Unapproved","Approved"};
		    JComboBox printSel = new JComboBox(printType);
		    printSel.setBounds(50,50,90,20);    
		        
		    
		    //Arrangement
		    panel.add(centerPanel, BorderLayout.CENTER);
		        
		    gbc.gridy = 0;
		    gbc.gridx = 2;
		    gbc.ipadx = 60;
		    centerPanel.add(homeButton,gbc);
		    
		    gbc.gridy = 1;
		    gbc.gridx = 2;
		    gbc.ipadx = 0;
		    centerPanel.add(personal,gbc);
		    
		    gbc.gridy = 2;
		    gbc.gridx = 1;
		    centerPanel.add(printButton,gbc);
		    gbc.gridx = 3;
		    centerPanel.add(salesButton,gbc);
		    
		    gbc.gridy = 3;
		    gbc.gridx = 1;
		    gbc.ipadx = 9;
		    gbc.insets = new Insets(0,0,0,0);
		    centerPanel.add(printSel,gbc);
		    
		    gbc.gridy = 4;
		    gbc.gridx = 3;
		    gbc.insets = new Insets(80,10,10,10);
		    centerPanel.add(logoutButton,gbc);
	        

        

        homeButton.addActionListener(e -> {
            System.out.println("Clicked Home button");
        });

        printButton.addActionListener(e -> {
            System.out.println("printing order");
            printOrderUI();
        });
        
        salesButton.addActionListener(e ->{
        	System.out.println("sales order generating");
        	salesOrderUI();
        });
        
        logoutButton.addActionListener(e -> {
        	openLoginUI();
        });
        
        personal.addActionListener(e -> {
        	String selectedWorkerType = _login.usercreds();
        	openPerproUI(selectedWorkerType);
        });
    }
    
    private void openLoginUI() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel);
        frame.getContentPane().removeAll();
        _login login = new _login(frame);
        frame.setPreferredSize(new Dimension(1200, 675));
        frame.add(login.getPanel());
        frame.revalidate();
        frame.repaint();
        frame.pack();
    }

    private void openPerproUI(String selectedWorkerType) {
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel);
        frame.getContentPane().removeAll();
        personalProfileUI proUI = new personalProfileUI(frame, selectedWorkerType);
        frame.setPreferredSize(new Dimension(300, 400));
        frame.add(proUI.getPanel());
        frame.revalidate();
        frame.repaint();
        frame.pack();
    }
    
    private void printOrderUI() {
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel);
        frame.getContentPane().removeAll();
        sPrintOrders printUI = new sPrintOrders(frame);
        frame.setPreferredSize(new Dimension(1080, 640));
        printUI.createPanel();
        frame.add(printUI.getPanel());
        frame.revalidate();
        frame.repaint();
        frame.pack();
    }
    
    private void salesOrderUI() {
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel);
        frame.getContentPane().removeAll();
        sSalesOrder orderUI = new sSalesOrder(frame);
        frame.setPreferredSize(new Dimension(1200, 675));
        orderUI.createPanel();
        frame.add(orderUI.getPanel());
        frame.revalidate();
        frame.repaint();
        frame.pack();
    }

    public JPanel getPanel() {
        return panel;
    }
}
