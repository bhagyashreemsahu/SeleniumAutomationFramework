package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtil;

public class ForgotPasswordPage extends BrowserUtil {
	
	private static final By USER_NAME_TEXTBOX_LOCATOR = By.xpath("//input[@name='email']");
	private static final By CONTINUE_BUTTON_LOCATOR = By.id("continue");
	private static final By ENTER_OTP_LABEL_LOCATOR = By.xpath("//div[contains(text(),'OTP')]");
	
   private WebDriver wd;

	public ForgotPasswordPage(WebDriver wd) {
		super(wd);
		this.wd=wd;
	}
	
	public String doEnterEmailOrMobileNo(String userName) {
		enterText(USER_NAME_TEXTBOX_LOCATOR, userName);
		clickOn(CONTINUE_BUTTON_LOCATOR);
		String enterOTPLabel = getVisibleText(ENTER_OTP_LABEL_LOCATOR);
		return enterOTPLabel;
		
	}

}
