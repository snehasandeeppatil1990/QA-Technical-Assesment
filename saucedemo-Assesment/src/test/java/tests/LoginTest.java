package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test(priority=1)
    public void ValidLoginTest() {
		 LoginPage login = new LoginPage(driver);
	        login.enterUsername("standard_user");
	        login.enterPassword("secret_sauce");
	        login.clickLogin();
	        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }
	
	@Test(priority=2)
	public void LockedUserLoginTest() {
		LoginPage login = new LoginPage(driver);
        login.enterUsername("locked_out_user");
        login.enterPassword("wrong_password");
        login.clickLogin();
        
        String expected = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(login.getErrorMessage(), expected);
      

		
	}
	

}
