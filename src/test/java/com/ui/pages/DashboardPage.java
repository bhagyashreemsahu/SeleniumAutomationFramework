package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.utility.BrowserUtil;

public final class DashboardPage extends BrowserUtil {
	
	private static final By USERNAME_TEXT_LOCATOR = By.xpath("//span[contains(text(),'Hello,')]");
	private static final By SEARCH_TEXTBOX_LOCATOR = By.xpath("//input[@name='field-keywords']");
	private static final By SEARCH_ICON_LOCATOR = By.xpath("//input[@value='Go']");
	private static final By SEARCHRESULT_TEXT_LOCATOR = By.xpath("//span[contains(text(),'results for')]/../span[3]");


	private WebDriver wd;

	public DashboardPage(WebDriver wd) {
		super(wd);
		this.wd = wd;

	}

	public String getUserName() {
		String userName = getVisibleText(USERNAME_TEXT_LOCATOR);
		return userName;
	}
	
	public String amazonSearch(String sKeyword) {
		enterText(SEARCH_TEXTBOX_LOCATOR,sKeyword );
		clickOn(SEARCH_ICON_LOCATOR);
		String searchResultFound = getVisibleText(SEARCHRESULT_TEXT_LOCATOR).replace("\"", "");
		return searchResultFound;
	}

}