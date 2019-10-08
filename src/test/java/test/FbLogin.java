package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Lib.Util;
import junit.framework.Assert;

public class FbLogin extends Util {
	WebDriver driver = null;

	@BeforeTest
	public void initalize() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\java\\Lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@AfterTest
	public void teardown() throws InterruptedException {
		sleep(3);
		driver.manage().deleteAllCookies();
		driver.close();

	}

	@Test(dataProvider = "login")
	public void facebooklogin(String username, String password) throws IOException, InterruptedException {
		driver.get(readproperties("urlfb"));
		Findele(readproperties("emailfb"), driver).sendKeys(username);
		Findele(readproperties("passwordfb"), driver).sendKeys(password);
		Findele(readproperties("loginbtn"), driver).click();
		sleep(3);
		String experror="The password you’ve entered is incorrect. Forgot Password?";
		String acterror=Findele(readproperties("errormsglogin"), driver).getText();
		System.out.println(acterror);
		
		Assert.assertEquals("Expected and Acutual doesn't match ", experror, acterror);
	}

	@DataProvider(name = "login")
	public Object[][] getdata() {
		return new Object[][] {  {"littleMark","asdasdsadsa"},{ "littleMar", "a124656" }, { "littleMa", "b124656" },
				{ "littleark", "c12345679" }, { "litteMark", "d124656" } };
	}

}
