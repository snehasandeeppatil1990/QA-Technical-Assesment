package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	 private WebDriver driver;
	    private By logo = By.className("app_logo");

	    public ProductPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public boolean isPageOpened() {
	        return driver.findElement(logo).isDisplayed();
	    }
	
}
