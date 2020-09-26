package ProjectOne;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class StartUp extends JFrame implements ActionListener {
	JButton store = new JButton("Store");
	JButton login = new JButton("Login");
	
	StartUp() {
		this.setLayout(new GridLayout(2,1));
		
		setLocation();
		addComponents();
		addActionListener();
	}
	
	public void setLocation() {
		login.setBounds(30, 100, 300, 100);
		store.setBounds(30, 200, 300, 100);
	}
	
	public void addComponents() {
		this.add(login);
		this.add(store);
	}
	
	public void addActionListener() {
		login.addActionListener(this);
		store.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login) {
		   	UI frame = new UI();
	        frame.setTitle("Login Form");
	        frame.setVisible(true);
	        frame.setBounds(10, 10, 370, 400);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLocationRelativeTo(null);
	        frame.setResizable(false);
		} else if (e.getSource() == store) {
			StoreUI frame = new StoreUI();
	        frame.setTitle("Login Form");
	        frame.setVisible(true);
	        frame.setBounds(10, 10, 370, 400);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLocationRelativeTo(null);
	        frame.setResizable(false);
		}
	}
	
	public static void main(String[] args) {
		StartUp frame = new StartUp();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

	}
}
