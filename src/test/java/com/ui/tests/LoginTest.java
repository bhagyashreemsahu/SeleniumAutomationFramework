package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.*;


@Listeners(com.listeners.MyUITestListener.class)
public class LoginTest {
	private WebDriver wd;
	private LoginPage page;

	@BeforeMethod(description = "Setup the Browser and load the page", alwaysRun = true)
	public void setup() {
		wd = new ChromeDriver();
		page = new LoginPage(wd);
	}


	
	@Test(groups = { "sanity" },dataProviderClass = com.dataproviders.LoginDataProvider.class,dataProvider = "LoginEXCELDATA") 	
	public void testLoginForWebSite(String userName, String password) {
		Assert.assertEquals(page.doLogin(userName,password).getUserName(), "Hello, TestUser");
	}
	
	
}
