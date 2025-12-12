package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;

	By usernameInput = By.id("user-name");
	By passwordInput = By.xpath("//*[@placeholder='Password']");
	By LoginButton = By.id("login-button");
	By ErrorMessage = By.xpath("//h3[starts-with(text(),'Epic')]");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void enterUsername(String username) {
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
    }
	
	public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(LoginButton).click();
    }
	
    public ProductPage loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return new ProductPage(driver);
    }
    
    public String getErrorMessage() {
    	return driver.findElement(ErrorMessage).getText();
    }
    
   
	
}
