package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Newpract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "src\\test\\java\\lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com");
		
		driver.findElement(By.linkText("Dynamic Controls")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//button[contains(.,'Remove')]")).click();
		WebDriverWait n = new WebDriverWait(driver, 15);
	
		WebElement r=n.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		System.out.println(r.getText());
		n.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Add')]"))).click();
	
		
		
	
	}

}
