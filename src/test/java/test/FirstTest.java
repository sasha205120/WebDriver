package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "src//test//java//Lib//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.get("https://www.gamestop.com/");

		String mytitle = driver.getTitle();
		System.out.println(driver.getCurrentUrl());

		System.out.println(mytitle);

		Thread.sleep(5000);

		driver.close();
		driver.quit();

	}

}
