package Lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Util {

	public static void sleep(int a) throws InterruptedException {
		Thread.sleep(1000 * a);
	}

	public static WebElement Findele(String xpath, WebDriver driver) {
		return driver.findElement(By.xpath(xpath));
	}

	public static String readproperties(String key) throws IOException {
		File fl = new File("src\\test\\java\\Lib\\Xpath.properties");
		FileInputStream fis = new FileInputStream(fl);
		Properties prop = new Properties();

		prop.load(fis);

		String value = prop.getProperty(key);
		return value;
	}

	// read excel by row and column
	public static String readexcel(int rownum, int colnum) throws IOException {
		File fl = new File("src\\test\\java\\Lib\\Homework1.xlsx");
		FileInputStream fis = new FileInputStream(fl);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sht = workbook.getSheetAt(0);
		XSSFRow rw = sht.getRow(rownum);
		XSSFCell cell = rw.getCell(colnum);
		String value = cell.getStringCellValue();
		return value;

	}

	public static String readexcelfb(int rownum, int colnum) throws IOException {
		File fl = new File("src\\test\\java\\Lib\\fbsignup.xlsx");
		FileInputStream fis = new FileInputStream(fl);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sht = workbook.getSheetAt(0);
		XSSFRow rw = sht.getRow(rownum);
		XSSFCell cell = rw.getCell(colnum);
		String value = cell.getStringCellValue();
		return value;
	}

}
