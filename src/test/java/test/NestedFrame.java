package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NestedFrame {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "src\\test\\java\\lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com");
		Actions ac = new Actions(driver);
		driver.findElement(By.linkText("Frames")).click();
		driver.findElement(By.linkText("Nested Frames")).click();
		Thread.sleep(5000);
		// swtiching to bottom frame using frame name
		driver.switchTo().frame("frame-bottom");
		String a = driver.findElement(By.xpath("//*[contains(text(),'BOTTOM')]")).getText();
		System.out.println(a);
		driver.switchTo().defaultContent();
		// SWTICHINFG TO PARENT FRAME
		driver.switchTo().frame(0);
		// SWTICH TO CHILD FRAME
		driver.switchTo().frame("frame-left");
		String a1 = driver.findElement(By.xpath("//*[contains(text(),'LEFT')]")).getText();
		System.out.println(a1);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.switchTo().frame("frame-right");
		String a2 = driver.findElement(By.xpath("//*[contains(text(),'RIGHT')]")).getText();
		System.out.println(a2);

	}

}
