package AutomationAssign.AutamationProject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import AutomationAssign.AutamationProject.BaseTest;

public class DepartmentPage extends BaseTest
{	
	public DepartmentPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void ClickOnDepartment()
	{
		WebElement wb = driver.findElement(By.xpath("//a[@href='http://www.annauniv.edu/department/index.php']"));

		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();", wb);
	}

	public void GetlistOfLink(String deptName)
	{
		List<WebElement> wbs = driver.findElements(By.className("sidelink"));
		
		for(int i=0;i<wbs.size();i++)
		{
			System.out.println(wbs.get(i).getText());
			if(wbs.get(i).getText().equals(deptName))
			{
				Actions action = new Actions(driver);
				action.moveToElement(wbs.get(i)).build().perform();
								
				driver.findElement(By.id("menuLite7")).findElement(By.id("menuItem32")).click();
				break;
			}
		}	
	}
	
	public void GetTopLink()
	{
		List<WebElement> wbs = driver.findElements(By.className("toplink"));	
		for(int i=0;i<wbs.size();i++)
		{
			if(wbs.get(i).getText().equals("Research Themes"))
			{
				Actions action = new Actions(driver);
				action.moveToElement(wbs.get(i)).click().build().perform();
				//driver.findElements(By.className("blacktxt"))
			}		
		}
	}
	
	public void GetTopSubLink(String subMenuName) throws InterruptedException
	{
		List<WebElement> wbs = driver.findElements(By.className("blacktxt"));	
		for(int i=0;i<wbs.size();i++)
		{
			if(wbs.get(i).getText().equals(subMenuName))
			{
				Actions action = new Actions(driver);
				action.moveToElement(wbs.get(i)).click().build().perform();
				break;
			}		
		}
		Thread.sleep(4000);
	}
	
	public String GetPageHeader()
	{
		System.out.println("Page Header ------ "+driver.findElement(By.className("homebothead")).getText());
		return driver.findElement(By.className("homebothead")).getText();	
	}
	
}
