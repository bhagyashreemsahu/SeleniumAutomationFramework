package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtil;

public final class LoginPage extends BrowserUtil {

	private static final By ELE_SIGN_LOCATOR = By.xpath("//span[contains(text(),'Hello, sign in')]");
	private static final By USER_NAME_TEXTBOX_LOCATOR = By.xpath("//input[@name='email']");
	private static final By CONTINUE_BUTTON_LOCATOR = By.id("continue");
	private static final By PASSWORD_TEXTBOX_LOCATOR = By.id("ap_password");
	private static final By SIGN_BUTTON_LOCATOR = By.id("signInSubmit");

	private WebDriver wd;

	public LoginPage(WebDriver wd) {
		super(wd);
		// TODO Auto-generated constructor stub
		this.wd = wd;
		goToWebSite("https://www.Amazon.in/");
		viewInFullScreen();

	}

	public DashboardPage doLogin(String userName, String password) {
		
		clickOn(ELE_SIGN_LOCATOR);
		enterText(USER_NAME_TEXTBOX_LOCATOR, userName);
		clickOn(CONTINUE_BUTTON_LOCATOR);
		enterText(PASSWORD_TEXTBOX_LOCATOR, password);
		clickOn(SIGN_BUTTON_LOCATOR);
		
		DashboardPage dashboardPage = new DashboardPage(wd);
		return dashboardPage;
	}
	
}
