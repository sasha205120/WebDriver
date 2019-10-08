package WebDriverSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopUpHandle {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String username = "admin";
		String password = "admin";
		// http://username:password@test.com
		driver.get("http://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth");

		String text = driver.findElement(By.cssSelector("p")).getText();
		System.out.println(text);
	}

}
