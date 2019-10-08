package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dynamicwait {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src//test//java//Lib//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		Thread.sleep(3000);
		driver.findElement(By.linkText("Dynamic Controls")).click();
		driver.findElement(By.xpath("//button[contains(.,'Remove')]")).click();
		
		WebDriverWait w= new WebDriverWait(driver, 15);
		WebElement r=w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'s gone!')]")));
		
		System.out.println(r.getText());
		
		
		
		
		
		
	}

}
