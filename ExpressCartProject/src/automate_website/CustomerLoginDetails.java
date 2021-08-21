package automate_website;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerLoginDetails {
	
	public WebDriver driver;
	public void openUrl()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\\\\\\\\\Program Files\\\\\\\\\\\\\\\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://44.192.66.40:1111");
		driver.manage().window().maximize();
		
	}
	
	public void click_on_customer_icon()
	{
		WebElement customer_icon= driver.findElement(By.xpath("/html/body/nav/div/ul/li[2]/a"));
		customer_icon.click();
	}

	public void login_url()
	{
		driver.findElement(By.name("email")).sendKeys("raviranjancs4@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Ravi@1234");
		driver.findElement(By.id("customerloginForm")).click();
	}
	
	public void home_link()
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement home= wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText( "Home")));
		home.click();
		
	}
	
	public void add_to_cart()
	{
		WebElement addCart= driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div/p/a"));
		addCart.click();
	}
	
	public void cart_button_top()
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement cart_button_top=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/nav/div/ul/li[3]/a")));
		cart_button_top.click();
	}
	
	public void click_on_checkout()
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement checkout_button= wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Checkout")));
		checkout_button.click();
	}
	public void shipping()
	{
		driver.findElement(By.id("checkoutInformation")).click();
	}
	
	public void proceed_to_payment()
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement proceedPayment= wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Proceed to payment")));
		proceedPayment.click();
	}
	
	public void card_deatils_window()
	{
		WebElement driv=driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/div/div/div[2]/ul/li/div/div/div/form/div/div/iframe"));
		driver.switchTo().frame(driv);
		driver.findElement(By.name("cardnumber")).sendKeys("4242 4242 4242 4242");
		driver.findElement(By.name("exp-date")).sendKeys("11/22");
		driver.findElement(By.name("cvc")).sendKeys("111");
		driver.findElement(By.name("postal")).sendKeys("20176");
		driver.switchTo().defaultContent();

	}

	
	public void payment_process()
	{
		WebElement paymentProcess= driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/div/div/div[2]/ul/li/div/div/div/form/button"));
		paymentProcess.click();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement success= wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text-success")));
		success.click();
	}

	public void customer_icon()
	{
		WebElement customer_icon= driver.findElement(By.xpath("/html/body/nav/div/ul/li[2]/div/button"));
		customer_icon.click();
	}
	public void logout()
	{
		WebElement log_out= driver.findElement(By.xpath("/html/body/nav/div/ul/li[2]/div/div/a[2]"));
		log_out.click();
	}
	
	public static void main(String[] args) {
		
		CustomerLoginDetails obj=new CustomerLoginDetails();
		obj.openUrl();
		obj.click_on_customer_icon();
		obj.login_url();
		obj.home_link();
		obj.add_to_cart();
		obj.cart_button_top();
		obj.click_on_checkout();
		obj.shipping();
		obj.proceed_to_payment();
		obj.card_deatils_window();
        obj.payment_process();
		obj.customer_icon();
		obj.logout();
	}
	
	
}
