package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FacebookKeydown {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "src//test//java//Lib//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");

		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.name("email")))
		.sendKeys("email@gmail.com"+Keys.TAB+"1234567"+Keys.ENTER).build().perform();
	}

}
