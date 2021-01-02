package AutomationAssign.AutamationProject;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import AutomationAssign.AutamationProject.BaseTest;

public class Assignment3Test extends BaseTest{

	@BeforeClass
	public void beforeClass() throws Exception {
		 assignMent = "Assignment3";
		 super.setUp();
	}
		
	@Test
	public void testMethod() 
	{
		driver.findElement(By.xpath("//a[text()='Gmail']")).sendKeys(Keys.chord(Keys.CONTROL,Keys.RETURN));
		ArrayList<String>  win=new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(win.get(1));
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("mahantesh.np155");
		
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		driver.switchTo().window(win.get(0));
		
		BaseTest baseTest = new BaseTest();
		baseTest.WaitForElementToDisplay(By.xpath("//input[@type='text']"));
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Selenium WebDriver");		
	}
	
	@AfterClass (alwaysRun = true)
	public void afterClass() throws Exception {
		super.tearDown();
	}
}
