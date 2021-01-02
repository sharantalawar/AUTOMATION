package AutomationAssign.AutamationProject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import AutomationAssign.AutamationProject.BaseTest;
import AutomationAssign.AutamationProject.TriphoboPage;

public class Assignment2Test extends BaseTest{
	 
	@BeforeClass
	public void beforeClass() throws Exception {
		 assignMent = "Assignment2";
		 super.setUp();
	}
		
	@Test
	public void testMethod() throws Exception
	{
		TriphoboPage tripPage = new  TriphoboPage(driver);
		tripPage.EnterDetails();
		tripPage.SelectDate();
		tripPage.ClickButtons("Start Planning");
		tripPage.ClickonNext();
		tripPage.ClickOnThingsToDo();
		
		tripPage.ClickToNext();
		tripPage.WaitForbackButton();
		tripPage.ChangeDate();
		tripPage.ClickToNext();
		tripPage.WaitForbackButton();
		tripPage.WaitForAccommodationDetails();
		tripPage.ClickToNext();
		
		tripPage.wondaringSolo();
		tripPage.clickOnTripOverView();
		tripPage.clickEditableView();
		
		//Step - Drag "Children's museum to day 3" --- 'Children's museum' is already present in Day 3
		tripPage.ClickOnSaveplan();		
	}
		
	@AfterClass (alwaysRun = true)
	public void afterClass() throws Exception {
		super.tearDown();
	}
	
}

