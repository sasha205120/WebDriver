package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loadpage {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src//test//java//Lib//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		Thread.sleep(3000);
		WebDriverWait n = new WebDriverWait(driver, 15);
		// explicit wait
		
		n.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Start')]"))).click();

		WebElement hello = n
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(.,'Hello World!')]")));
		

		System.out.println(hello.getText());
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.linkText("Elemental Selenium")).click();

		/*
		 * implicit wait--- beginning of your script, it will apply to whole, only wait
		 * till page full loaded thread.sleep--- you can give it anywhere, it apply to
		 * whole page, it wait specific whatever condition. explicit wait--- specific
		 * for element,
		 */

	}
}