package ProjectOne;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class UI extends JFrame implements ActionListener{
	//static JFrame frame; 
	JButton netflix = new JButton("Netflix");
	JButton Facebook = new JButton("Facebook"); 
	JButton myUW = new JButton("MyUW");
	JButton Twitter = new JButton("Twitter");
	JButton Google = new JButton("Google");
	JButton Spotify = new JButton("Spotify");
	JButton Instagram = new JButton("Instagram");
	JButton Hulu = new JButton("Hulu");
	JButton Disney = new JButton("Disney Plus");
	JButton Amazon = new JButton("Amazon");
	JButton Microsoft = new JButton("Microsoft");
	JButton Apple = new JButton("Apple");
	JButton Ebay = new JButton("Ebay");
	JButton LinkedIn = new JButton("LinkedIn");
	JButton Youtube = new JButton("YouTube");
	
	UI() {
		System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		this.setLayout(new GridLayout(3,4));
		addComponents();
		addActionListener();
		
	}
	
	public void addComponents() {
		this.add(Facebook);
		this.add(myUW);
		this.add(netflix);
		this.add(Twitter);
		this.add(Google);
		this.add(Spotify);
		this.add(Instagram);
		this.add(Hulu);
		this.add(Disney);
		this.add(Amazon);
		this.add(Microsoft);
		this.add(Apple);
		this.add(Ebay);
		this.add(LinkedIn);
		this.add(Youtube);
		
	}
	
	public void addActionListener() {
		Facebook.addActionListener(this);
		myUW.addActionListener(this);
		netflix.addActionListener(this);
		Twitter.addActionListener(this);
		Google.addActionListener(this);
		Spotify.addActionListener(this);
		Instagram.addActionListener(this);
		Hulu.addActionListener(this);
		Disney.addActionListener(this);
		Amazon.addActionListener(this);
		Microsoft.addActionListener(this);
		Apple.addActionListener(this);
		Ebay.addActionListener(this);
		LinkedIn.addActionListener(this);
		Youtube.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == Facebook) {
			
		} else if (e.getSource() == myUW) {
		
		} else if (e.getSource() == netflix) {
			WebPortalClass netflix = new WebPortalClass("thomberg@gklaw.com", "homburglar", "https://www.netflix.com/login", "button[data-uia=login-submit-button]", "id_userLoginId", "id_password");
			netflix.run();
			System.exit(0);
		} else if (e.getSource() == Twitter) {
			
		} else if (e.getSource() == Google) {
				
		} else if (e.getSource() == Spotify) {
			
		} else if (e.getSource() == Instagram) {
				
		} else if (e.getSource() == Hulu) {
				
		} else if (e.getSource() == Disney) {
					
		} else if (e.getSource() == Amazon) {
			
		} else if (e.getSource() == Microsoft) {
				
		} else if (e.getSource() == Apple) {
			
		} else if (e.getSource() == Ebay) {
				
		} else if (e.getSource() == LinkedIn) {
				
		} else if (e.getSource() == Youtube) {
			
		}
	}
	
	public static void main(String[] args) {
		

    	UI frame = new UI();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
	}
}
