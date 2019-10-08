package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dummy {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src//test//java//Lib//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");

		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Little");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Mark");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@aria-label='Mobile number or email']"))
				.sendKeys("littlemark03@outlook.com");
		driver.findElement(By.xpath("//input[@aria-label='Re-enter email']")).sendKeys("littlemark03@outlook.com");
		driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys("Happy@2019");
		Thread.sleep(3000);

		WebElement month = driver.findElement(By.id("month"));
		Select mth = new Select(month);
		mth.selectByVisibleText("Apr");
		WebElement day = driver.findElement((By.id("day")));
		Select dy = new Select(day);
		dy.selectByVisibleText("1");
		WebElement year = driver.findElement((By.id("year")));
		Select yer = new Select(year);
		yer.selectByVisibleText("1999");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='sex'][@value='-1']")).click();
		Thread.sleep(2000);
		Select slc=new Select(driver.findElement(By.name("preferred_pronoun")));
		slc.selectByIndex(1);
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();

		String actualerrormsg = driver.findElement(By.xpath("//*[@id='reg_error']")).getText();

		System.out.println(actualerrormsg);

		String c = driver.findElement(By.xpath("//*[contains(text(),'Sign U')]")).getText();
		System.out.println(c);
	}

}
