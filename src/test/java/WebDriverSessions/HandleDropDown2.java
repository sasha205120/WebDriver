package WebDriverSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropDown2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.facebook.com");
		
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
//		WebElement year = driver.findElement(By.id("year"));
		
		Select select = new Select(day);
		
		select.selectByIndex(2);
		Thread.sleep(2000);
		
		System.out.println(select.isMultiple());
		
		List<WebElement> listDays = select.getOptions();
		System.out.println(listDays.size());
		int TotalDays = listDays.size()-1;
		System.out.println("total days are: "+ TotalDays);
		
		for(int i=0; i<listDays.size(); i++){
			String dayVal = listDays.get(i).getText();
			System.out.println(dayVal);
				if(dayVal.equals("15")){
					listDays.get(i).click();
					break;
				}
		}
	
        Select selectmn = new Select(month);
		
		selectmn.selectByIndex(3);
		Thread.sleep(2000);

		System.out.println(selectmn.isMultiple());
		
		List<WebElement> listMonth = selectmn.getOptions();
		System.out.println(listMonth.size());
		int TotalMonths = listMonth.size()-1;
		System.out.println("total month are: "+ TotalMonths);
		
		for(int i=0; i<listMonth.size(); i++){
			String MonVal = listMonth.get(i).getText();
			System.out.println(MonVal);
				if(MonVal.equals("Nov")){
					listMonth.get(i).click();
					break;
				}
		}
	
		
		
		
	}

}
