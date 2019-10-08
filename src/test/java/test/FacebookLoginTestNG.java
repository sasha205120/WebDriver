package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Lib.Util;

public class FacebookLoginTestNG extends Util {

	WebDriver driver = null;

	@BeforeMethod
	public void initialize() throws IOException {

		System.out.println("before test");
		System.setProperty("webdriver.chrome.driver", readproperties("chropath"));

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		System.out.println("After test");
		sleep(3);
		driver.manage().deleteAllCookies();
		driver.close();

	}

	
	@Test(dataProvider = "login")
	public void facebooklogin(String email, String pass) throws IOException {
		driver.get(readproperties("urlfb"));
		Findele(readproperties("fblogem"), driver).sendKeys(email);
		Findele(readproperties("fblogpass"), driver).sendKeys(pass);
		Findele(readproperties("fblogin"), driver).click();

	}
	@Test(dataProvider = "signup",enabled = false)
	public void facebooksignup(int num) throws IOException, InterruptedException {
		driver.get(readproperties("urlfb"));

		Findele(readproperties("firstname"), driver).sendKeys(readexcelfb(num, 0));
		Findele(readproperties("lastname"), driver).sendKeys(readexcelfb(num, 1));
		Findele(readproperties("mobandemail"), driver).sendKeys(readexcelfb(num, 2));
		sleep(3);
		Findele(readproperties("rephoneemail"), driver).sendKeys(readexcelfb(num, 3));
		Findele(readproperties("pwd"), driver).sendKeys(readexcelfb(num, 4));

		Select sltmonth = new Select(Findele(readproperties("month"), driver));
		Select sltday = new Select(Findele(readproperties("day"), driver));
		Select sltyear = new Select(Findele(readproperties("year"), driver));

		sltmonth.selectByVisibleText(readexcelfb(num, 5));
		sltday.selectByVisibleText(readexcelfb(num, 6));
		sltyear.selectByVisibleText(readexcelfb(num, 7));

		Findele(readproperties("gender"), driver).click();
		Findele(readproperties("submitbut"), driver).click();
		
		String experror="Too many users have this email listed as pending.";
		String acterror=Findele(readproperties("errormsg"), driver).getText();
		System.out.println(acterror);
	}
	
	@DataProvider(name="signup")
	public Object[] signup() {
		return new Object[] {1,2,3,4};
	}

	@DataProvider(name = "login")
	public Object[][] login() {
		return new Object[][] { { "natejack1@gmail.com", "Reasdf12" }, { "natejack2@gmail.com", "Reasdf11" },
				{ "natejack3@gmail.com", "Reasdf13" }, { "natejack4@gmail.com", "Reasdf10" } };
	}

}
