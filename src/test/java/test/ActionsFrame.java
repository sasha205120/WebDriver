package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsFrame {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "src//test//java//Lib//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/");

		driver.findElement(By.linkText("Context Menu")).click();

		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//div[@oncontextmenu='displayMessage()']"))).contextClick()
				.build().perform();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		Thread.sleep(2000);
		ac.moveToElement(driver.findElement(By.xpath("//h3[contains(.,'Context Menu')]"))).click().build().perform();
		Thread.sleep(3000);
		driver.navigate().back();

		driver.findElement(By.linkText("Drag and Drop")).click();

		WebElement a = driver.findElement(By.xpath("//div[@class='column'][@id='column-a']"));
		WebElement b = driver.findElement(By.xpath("//div[@class='column'][@id='column-b']"));

		ac.moveToElement(a).clickAndHold().dragAndDrop(a, b).release(b).build().perform();

	}

}
