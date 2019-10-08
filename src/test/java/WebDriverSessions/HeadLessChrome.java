package WebDriverSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessChrome {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(co);
		
		driver.get("https://app.hubspot.com/login");
		
		System.out.println("login page title is: "+ driver.getTitle());
		
		driver.findElement(By.xpath("//input[contains(@type,'email')]")).sendKeys("naveenanimation20@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@1234");
		
		driver.findElement(By.xpath("//button[@data-button-use='primary']")).click();
		
		Thread.sleep(10000);
		
		System.out.println("login page title is: "+ driver.getTitle());

		
		
	}

}
