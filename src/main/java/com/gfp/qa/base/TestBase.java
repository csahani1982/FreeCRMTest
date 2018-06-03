package com.gfp.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gfp.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	//initialize properties

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip  = new FileInputStream("/Users/Chetanpreet/eclipse-workspace/FreeCRMTest/src/main/java/com/gfp/qa/config/config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void Initialization() {
		
		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/Chetanpreet/Downloads/chromedriver");
			driver = new ChromeDriver();
		}
		else if ( browserName.equals("firefox")) {
			System.setProperty("webdriver.geico.driver", "/Users/Chetanpreet/Downloads/geckodriver");
			driver = new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}
	
}
