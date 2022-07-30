package TestNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IMDVBB_pushaTherise_Program {
	
WebDriver driver;
	
	@BeforeMethod
	public void launchbrowser()
	{
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.imdb.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	@Test
	public void validMovieData()
	{
		driver.findElement(By.xpath("//input[@id='suggestion-search']")).sendKeys("Pushpa:The Rise");
		driver.findElement(By.xpath("(//*[@class=\"ipc-icon ipc-icon--magnify\"])[1]")).click();
		
		driver.findElement(By.xpath("//a[text()=\"Pushpa: The Rise - Part 1\"]")).click();
		

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,800)");
		
		WebElement rdate=driver.findElement(By.xpath("//a[normalize-space()='January 7, 2022 (United States)']"));
		
		String rd1=rdate.getText();
		System.out.println("Release date ="+rd1);
	
		
		WebElement cty =driver.findElement(By.xpath("//a[normalize-space()='India']"));
		
		String ct1=cty.getText();
		System.out.println("Country of origin ="+ct1);
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}


}
