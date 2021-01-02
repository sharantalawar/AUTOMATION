package AutomationAssign.AutamationProject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import AutomationAssign.AutamationProject.BaseTest;

public class TriphoboPage  extends BaseTest{

	public TriphoboPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void EnterDetails() throws InterruptedException
	{
		driver.findElement(By.id("plan-my-trip")).click();
		WaitForElementToDisplay(By.xpath("//input[@value='']"));
		driver.findElement(By.xpath("//input[@value='']")).click();
		driver.findElement(By.xpath("//input[@value='']")).clear();
		driver.findElement(By.xpath("//input[@value='']")).sendKeys("Houston");
		driver.findElement(By.xpath("//div[@id='js-suggestions']/div[3]/div/ul/li/span")).click();
	}
	
	public void SelectDate()
	{
		WaitForElementToDisplay(By.className("start-date-control"));
		driver.findElement(By.className("start-date-control")).click();
		driver.findElement(By.linkText("18")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'22')])[2]")).click();
	}
	
	public void ClickButtons(String buttonName)
	{
		List<WebElement> buttonsList = driver.findElements(By.className("button"));
		for(int i=0;i<buttonsList.size();i++)
		{
			if(buttonsList.get(i).getText().equals(buttonName))
			{
				if(buttonsList.get(i).isDisplayed())
				{
					buttonsList.get(i).click();
					break;
				}
			}
		}	
	}
	
	public void ClickonNext() throws InterruptedException
	{
		WaitForElementToDisplay(By.id("js_city_next_step_title"));
		driver.findElement(By.id("js_city_next_step_title")).click();
	}
	
	public void ClickOnThingsToDo()
	{
		driver.findElement(By.xpath("(//span[text()='Things to do'])[3]")).click();;
	}
	
	public void ClickToNext() throws InterruptedException
	{		
		driver.findElement(By.className("js-next-alreadybooked")).click();		
	}
	
	public void WaitForbackButton()
	{
		WaitForElementToDisplay(By.className("js-back-alreadybooked"));
	}
	
	public void WaitForAccommodationDetails()
	{
		WaitForTextToDisplay(By.className("accommodation--l"), "ADD ACCOMMODATION DETAILS");
	}
	
	public void ChangeDate() throws InterruptedException
	{
		driver.findElement(By.cssSelector("i.c-icon.js_calendar_icon")).click();
		driver.findElement(By.linkText("21")).click();
	}
		
	public void clickToSkipNext()
	{
		driver.findElement(By.xpath("//span[text()='Skip to']")).click();
	}
	
	public void wondaringSolo()
	{
		WaitForElementToDisplay(By.xpath("//div[@class='entry-point solo-ep']"));
		driver.findElement(By.xpath("//div[@class='entry-point solo-ep']")).click();
	}
	
	public void clickOnTripOverView()
	{
		WaitForElementToDisplay(By.id("js_city_next_step_title"));
		driver.findElement(By.id("js_city_next_step_title")).click();
	}

	public void clickEditableView() throws InterruptedException
	{
		WaitFor(12);
		driver.findElement(By.xpath("//span[text()='Editable view']")).click();
	}

	public void ClickOnSaveplan() throws InterruptedException
	{
		WaitFor(2);
		driver.findElement(By.className("save-to-plan")).click();;
		driver.findElement(By.className("js-finish-planning")).click();
	}
	
	
	public void ClickModalButton()
	{
		driver.findElement(By.className("for-transportation-accomodation")).findElement(By.className("as-next")).click();
	}
	
}
