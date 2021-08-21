package automate_website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\\\\\\\\\Program Files\\\\\\\\\\\\\\\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://44.192.66.40:1111");
		driver.manage().window().maximize();
		
		WebElement customer_icon= driver.findElement(By.xpath("/html/body/nav/div/ul/li[2]/a"));
		customer_icon.click();
	
		driver.findElement(By.name("email")).sendKeys("raviranjancs4@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Ravi@1234");
		driver.findElement(By.id("customerloginForm")).click();
	
	}

}
