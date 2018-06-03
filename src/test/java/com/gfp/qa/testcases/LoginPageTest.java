package com.gfp.qa.testcases;

import com.gfp.qa.base.TestBase;
import com.gfp.qa.pages.HomePage;
import com.gfp.qa.pages.LoginPage;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void SetUp() {
		TestBase.Initialization();
		loginPage = new LoginPage();
	}
	
	
	@Test
	public void LoginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
		
	}
	
	@Test
	public void crmLogoImageTest() {
		boolean flag = loginPage.validatecrmImage();
		Assert.assertTrue(flag);
		
	}
	
	@Test
	public void LoginTest() {
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void Teardown() {
		
		driver.quit();
	}
	
	
}
