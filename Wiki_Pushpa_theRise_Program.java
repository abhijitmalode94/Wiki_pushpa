package TestNg;

import java.util.List;
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

public class Wiki_Pushpa_theRise_Program {
	
	WebDriver driver;
	
	@BeforeMethod
	public void launchbrowser()
	{
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	@Test
	public void validMovieData()
	{
		driver.findElement(By.xpath("//input[@class=\"vector-search-box-input\"]")).sendKeys("Pushpa:The Rise");
		driver.findElement(By.id("searchButton")).click();
		
		driver.findElement(By.xpath("(//span[text()=\"Pushpa\"])[1]")).click();
		
		

		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("scrollBy(0,800)");
		
		WebElement rdate=driver.findElement(By.xpath("//table[@class='infobox vevent']//tbody[1]/tr[12]/td[1]"));
		
		String release_date=rdate.getText();
		System.out.println("Release date is= "+release_date);
		
		WebElement cnty=driver.findElement(By.xpath("//table[@class='infobox vevent']//tbody[1]/tr[14]/td[1]"));
		String cty=cnty.getText();
		System.out.println("Country ="+cty);
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}


}
