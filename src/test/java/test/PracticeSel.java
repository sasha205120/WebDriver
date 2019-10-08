package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PracticeSel {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "src\\test\\java\\lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com");
		
		driver.findElement(By.linkText("Checkboxes")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		
		driver.navigate().back();
		driver.findElement(By.linkText("Dropdown")).click();
		Thread.sleep(1000);
		WebElement dropdown= driver.findElement(By.xpath("//select[@id='dropdown']"));
		Select drop= new Select(dropdown);
		
		
		
		/*Thread.sleep(3000);
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

		/* 		// explicit wait
		driver.findElement(By.xpath("//button[contains(.,'Start')]")).click();
		WebDriverWait n=new WebDriverWait(driver, 15);
		WebElement hello=n.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[contains(.,'Hello World!')]"))));
		
		System.out.println(hello.getText());
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Elemental Selenium")).click();
		
		
/*
 * implicit wait--- beginning of your script, it will apply to whole, only wait till page full loaded
 * thread.sleep--- you can give it anywhere, it apply to whole page, it wait specific whatever condition.
 * explicit wait--- specific for element, 
 */

		 

	}

}
