package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "src//test//java//Lib//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/");

		driver.findElement(By.linkText("Hovers")).click();

		Actions ac = new Actions(driver);

		WebElement profile=driver.findElement(By.xpath("(//img[contains(@alt,'User Avatar')])[2]"));
		
		ac.moveToElement(profile).build().perform();
		driver.findElement(By.linkText("View profile")).click();
		System.out.println(driver.findElement(By.xpath("//h1[contains(.,'Not Found')]")).getText());

	}

}
