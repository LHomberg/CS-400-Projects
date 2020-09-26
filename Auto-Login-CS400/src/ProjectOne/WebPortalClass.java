package ProjectOne;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebPortalClass {
	
	private String username;
	private String password; 
	private String weblink;
	private String buttonName;
	private String usernameId;
	private String passwordId;
	//private boolean continueCheck;
	WebDriver driver = new ChromeDriver();

	public WebPortalClass(String username, String password, String weblink, String buttonName, String usernameId, String passwordId) {
		setUsername(username);
		setPassword(password);
		setButtonName(buttonName);
		setUsernameId(usernameId);
		setPasswordId(passwordId);
		setWeblink(weblink);
		//setContinueCheck(continueCheck);
		
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setWeblink(String weblink) { 
		this.weblink = weblink;
	}
	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}
	
	public void setPasswordId(String passwordId) {
		this.passwordId = passwordId;
	}
	
	public void setUsernameId(String usernameId) { 
		this.usernameId = usernameId;
	}
	/**
	 * Initializes Chrome and proceeds to login to website of choice.
	 */
	public void run() {
		driver.manage().window().maximize();
		driver.get(weblink);
		driver.findElement((By.id(usernameId))).sendKeys(username);
		driver.findElement((By.id(passwordId))).sendKeys(password);
		driver.findElement((By.cssSelector(buttonName))).click();	
	}
	public void continueChain(String continueLink) throws InterruptedException {

	}
	
}
