package AutomationAssign.AutamationProject;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest
{
	private static Properties properties = new Properties();
	public static String  browser;
	public static String assignment1Url;
	public static String  environment;
	public static String  assignment2Url;
	public static String  assignment3Url;
	public static String  userName;
	public static String  passWord;	
	public String assignMent = null;
	
	public static WebDriver driver;
	
	
	public  void setUp() throws Exception {
		initializeStaticFields();
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		 driver= new ChromeDriver();
		}
		if(assignMent == "Assignment1")
		{
			driver.get(assignment1Url);
		}
		
		if(assignMent == "Assignment2")
		{
			driver.get(assignment2Url);
		}
		
		if(assignMent == "Assignment3")
		{
			driver.get(assignment3Url);
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	private static void initializeStaticFields() {
	
		loadProperties("environment.properties"); 
	
		browser = System.getProperty("browser");
		if (browser == null)
			browser = properties.getProperty("browser");
		System.out.println(  "browser : " + browser);
		
		assignment1Url = properties.getProperty("assignment1Url");
		assignment2Url  = properties.getProperty("Assignment2Url");
		assignment3Url  = properties.getProperty("Assignment3Url");
		userName =  properties.getProperty("userName");
		passWord = properties.getProperty("passWord");	
	}
	
	public String getTitlte()
	{
		return driver.getTitle();
	}

	private static void loadProperties(String propFileName) {
		try
		{
			InputStream is = BaseTest.class.getClassLoader().getResourceAsStream(propFileName);
			properties.load(is);
			is.close();
		} catch (Exception e)
		{
			System.out.println("#### Error: Unable to load the \"" + propFileName + "\" file.");
			System.exit(1);
		}
	}
	
	public void WaitForElementToDisplay(By element)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void WaitForTextToDisplay(By element,String message)
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(element, message));
	}
	
	public void WaitFor(int delay) throws InterruptedException
	{
		Thread.sleep(1000*delay);
	}
	
	public void tearDown()
	{
		driver.quit();
	}
}
