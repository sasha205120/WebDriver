package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Lib.Util;

public class JunitTestAmazon extends Util {

	/*
	 * Junit TestNG
	 */

	@Test
	public void testing() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", readproperties("chropath"));
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(readproperties("url"));
		Actions ac = new Actions(driver);

		ac.moveToElement(Findele(readproperties("signin"), driver)).build().perform();
		sleep(2);
		driver.findElement(By.linkText(readproperties("singuplink"))).click();
		sleep(3);
		Findele(readproperties("username"), driver).sendKeys("that guy");
		Findele(readproperties("email"), driver).sendKeys("email@gmail.com");
		Findele(readproperties("password"), driver).sendKeys("1234567890");
		Findele(readproperties("repass"), driver).sendKeys("1234567890");
		Findele(readproperties("signbut"), driver).click();

	}

//	//@Test
//	public void testing1() {
//		System.setProperty("webdriver.chrome.driver", "src\\test\\java\\lib\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("https://www.facebook.com/");
//		
//	}

}
