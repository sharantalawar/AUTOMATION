package AutomationAssign.AutamationProject;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import AutomationAssign.AutamationProject.BaseTest;
import AutomationAssign.AutamationProject.DepartmentPage;

public class Assignment1Test extends BaseTest
{
	
	 @BeforeClass
	public void beforeClass() throws Exception {
		 assignMent = "Assignment1";
		 super.setUp();
	}
	
	@Test
	public void testMethod() throws Exception
	{
		DepartmentPage dept = new DepartmentPage(driver);
		dept.ClickOnDepartment();
		dept.GetlistOfLink("Faculty of Civil Engineering");
		
		BaseTest bs = new BaseTest();
		Assert.assertTrue(bs.getTitlte().contains("Institute For Ocean Management"), "'Institute For Ocean Management' page is not displayed");
		
		dept.GetTopLink();
		dept.GetTopSubLink("Coastal Pollution Monitoring and Hazards");
		Assert.assertTrue(dept.GetPageHeader().contains("RESEARCH THEMES > COASTAL POLLUTION MONITORING AND HAZARDS"),"'COASTAL POLLUTION MONITORING AND HAZARDS' page is not displayed");
	}
	
	@AfterClass (alwaysRun = true)
	public void afterClass() throws Exception {
		super.tearDown();
	}	
}
