package oodjAssign;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class _main {
	public static void main (String[] args) {
		JFrame mainMenu = new JFrame("Main Menu");
		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainMenu.setSize(1080, 640);
		mainMenu.setLayout(new BorderLayout());
		mainMenu.setLocationRelativeTo(null);
		
		_login login = new _login (mainMenu);
		mainMenu.add(login.getPanel());
		
		mainMenu.setVisible(true);
	}
}
