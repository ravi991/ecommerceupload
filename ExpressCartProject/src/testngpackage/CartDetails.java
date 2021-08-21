package testngpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class CartDetails {
	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver, 20);
	@Test
	public void cart_click()
	{
		WebElement addCart= driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div/p/a"));
		addCart.click();
		
		
		WebElement cart_button_top=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/nav/div/ul/li[3]/a")));
		cart_button_top.click();
	}
	
	@Test(dependsOnMethods = "cart_click")
	public void check_button_click()
	{
		WebElement checkout_button= wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Checkout")));
		checkout_button.click();
		
		driver.findElement(By.id("checkoutInformation")).click();
		
		WebElement proceedPayment= wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Proceed to payment")));
		proceedPayment.click();
	}
	
	@Test(dependsOnMethods = "check_button_click")
	public void card_data()
	{
		WebElement driv=driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/div/div/div[2]/ul/li/div/div/div/form/div/div/iframe"));
		driver.switchTo().frame(driv);
//		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/div/div/div[2]/ul/li/div/div/div/"));
		driver.findElement(By.name("cardnumber")).sendKeys("4242 4242 4242 4242");
		driver.findElement(By.name("exp-date")).sendKeys("11/22");
		driver.findElement(By.name("cvc")).sendKeys("111");
		driver.findElement(By.name("postal")).sendKeys("20176");
		driver.switchTo().defaultContent();
		
		WebElement paymentProcess= driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/div/div/div[2]/ul/li/div/div/div/form/button"));
		paymentProcess.click();
	}

	@Test(dependsOnMethods = "card_data")
	public void success_screen()
	{
		WebElement success= wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text-success")));
		success.click();
	}
	
	@Test(dependsOnMethods = "success_screen")
	public void logout()
	{
		WebElement customer_icon_logout= driver.findElement(By.xpath("/html/body/nav/div/ul/li[2]/div/button"));
		WebElement customer_icon= driver.findElement(By.xpath("/html/body/nav/div/ul/li[2]/a"));
		customer_icon.click();
		
		WebElement log_out= driver.findElement(By.xpath("/html/body/nav/div/ul/li[2]/div/div/a[2]"));
		log_out.click();
	}
}
