package com.ui.tests;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.LoginPage;


public class VerifyDashBoardPageTable {
	private WebDriver wd;
	private LoginPage page;
	private String sKeyword ;

	@BeforeMethod(description = "Setup the Browser and load the page", alwaysRun = true)
	public void setup() {
		wd = new ChromeDriver();
		page = new LoginPage(wd);
	sKeyword = "barbie";	
	}
	
	
	@Test(groups = { "sanity" })
	  public void testProductSearchResultFoundForWebSite() {
	  Assert.assertEquals(page.doLogin("testuser02052024@gmail.com","TestUser").amazonSearch(sKeyword), sKeyword); }
	 
	
}
