package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Lib.Util;

public class SignupGmail extends Util {
	/*
	 * 1. setup browser 2 open
	 * "https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp"
	 * 
	 * 
	 */
	@Test
	public void artful() throws IOException {
		System.setProperty("webdriver.chrome.driver", "src\\test\\java\\Lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(readproperties("gmailurl"));
		Findele(readproperties("fname"), driver).sendKeys(readexcel(6, 0));
		Findele(readproperties("lname"), driver).sendKeys(readexcel(6, 1));
		Findele(readproperties("usrname"), driver).sendKeys(readexcel(6, 6));
		Findele(readproperties("psw"), driver).sendKeys(readexcel(6, 4));
		Findele(readproperties("conpsw"), driver).sendKeys(readexcel(6, 5));
		Findele(readproperties("click"), driver).click();
	}

}
