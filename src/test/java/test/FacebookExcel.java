package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Lib.Util;

public class FacebookExcel extends Util {
	
	
	
	@Test
	public void testfacebook() throws IOException, InterruptedException{
		System.setProperty("webdriver.chrome.driver", readproperties("chropath"));
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(readproperties("urlfb"));
		
		Findele(readproperties("firstname"), driver).sendKeys(readexcel(1, 0));
		Findele(readproperties("lastname"), driver).sendKeys(readexcel(1, 1));
		Findele(readproperties("mobandemail"), driver).sendKeys(readexcel(1, 2));
		sleep(3);
		Findele(readproperties("rephoneemail"), driver).sendKeys(readexcel(1, 3));
		Findele(readproperties("pwd"), driver).sendKeys(readexcel(1, 4));
		
		Select sltmonth=new Select(Findele(readproperties("month"), driver));
		Select sltday=new Select(Findele(readproperties("day"), driver));
		Select sltyear=new Select(Findele(readproperties("year"), driver));

		sltmonth.selectByVisibleText(readexcel(1, 5));
		sltday.selectByVisibleText(readexcel(1, 6));
		sltyear.selectByVisibleText(readexcel(1, 7));
		
		Findele(readproperties("gender"), driver).click();
		Findele(readproperties("submitbut"), driver).click();



		
		
	}

}
