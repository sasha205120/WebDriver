package WebDriverSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClickMethod {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&ru=https%3A%2F%2Fwww.ebay.com%2F");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@name='userid']")).sendKeys("matthew scudder");
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("Happy2019");
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Actions action = new Actions(driver);
		action.click(driver.findElement(By.xpath("//button[@type='submit']"))).build().perform();
		Thread.sleep(2000);
		driver.close();

	}

}
