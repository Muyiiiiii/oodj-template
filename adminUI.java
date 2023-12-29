package oodjAssign;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class adminUI {
	private JPanel panel;
    private admin nimda;

    public adminUI(admin nimda) {
        this.nimda = nimda;
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
        		gbc.insets = new Insets(10,10,10,10);

    	
        		//Declare buttons and others
        		JButton homeButton = new JButton("Home");
        		JButton logoutButton = new JButton("Logout");
		        
        		JButton reportGen = new JButton("Generate Report");        
        		JButton personal = new JButton("Personal Profile");        
        		JButton worker = new JButton("Worker Profile");        
        	
        		//Declaring Combobox
        		String repType[] = {"Approved Sales Report", "Closed Sales Report", "Work Done Report"};        
        		JComboBox<String> repSel = new JComboBox(repType);
        		repSel.setBounds(50,50,90,20);
		        
        		String worType[] = {"Officer", "SalesPerson"};
        		JComboBox<String> worSel = new JComboBox(worType);
        		worSel.setBounds(50,50,90,20);
        		
        		JLabel officerLabel = new JLabel("wubba lubba dub dub");   
        		
//============================================================================================================//		    
        		//Arrangement    
        		panel.add(centerPanel, BorderLayout.CENTER);
		    
        		gbc.gridy = 0;
        		gbc.gridx = 2;
        		gbc.ipadx = 55;
        		centerPanel.add(homeButton, gbc);
		    
        		gbc.gridy = 1;
        		gbc.gridx = 2;
        		centerPanel.add(personal, gbc);
		    
        		gbc.gridy = 2;
        		gbc.gridx = 1;
        		gbc.ipadx = 35;
        		centerPanel.add(reportGen, gbc);
        		gbc.gridx = 3;
        		centerPanel.add(worker, gbc);
		    
        		gbc.gridy = 3;
			    gbc.gridx = 1;
			    gbc.insets = new Insets(0,0,0,0);
			    gbc.ipadx = 0;
			    centerPanel.add(repSel,gbc);
			    gbc.gridx = 3;
			    centerPanel.add(worSel, gbc);
		    
			    gbc.gridy = 4;
			    gbc.gridx = 3;
			    gbc.insets = new Insets(80,10,10,10);
			    centerPanel.add(logoutButton,gbc);		
			    
//============================================================================================================//			    
			    //Functions of Buttons
				//Home
		        homeButton.addActionListener(e -> {
		        	//to be modified or deleted
		            System.out.println("Clicked Home button");
		        });
		        
		        //Logout
				logoutButton.addActionListener(e -> {
				        	openLoginUI();
				        });
				
				//Generating Report
		        reportGen.addActionListener(e -> {
		        	String selectedReportType = (String)repSel.getSelectedItem();
		        	openRepGenUI(selectedReportType);
		        	
		        });
		        
		        //Worker Profile
		        worker.addActionListener(e ->{
		        	String selectedWorkerType = (String)worSel.getSelectedItem();
		        	openPerproUI(selectedWorkerType);
		        });
		        
		        //Personal Profile
		        personal.addActionListener(e ->{
		        	String selectedWorkerType = _login.usercreds();
		        	openPerproUI(selectedWorkerType);
		        	});
		    }
    
//============================================================================================================//
    //Directing to intended UI
    private void openLoginUI() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel);
        frame.getContentPane().removeAll();
        _login login = new _login(frame);
        frame.setPreferredSize(new Dimension(1080, 640));
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
    
    private void openRepGenUI(String selectedReportType) {
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel);
        frame.getContentPane().removeAll();
        aReportGen repgenUI = new aReportGen(frame, selectedReportType);
        frame.setPreferredSize(new Dimension(600, 500));
        frame.add(repgenUI.getPanel());
        frame.revalidate();
        frame.repaint();
        frame.pack();
    }
    

    //try to come up with a way to link the data of the users to the personal Profile UI, 
    //if impossible just create a new UI

    public JPanel getPanel() {
        return panel;
    }
}
