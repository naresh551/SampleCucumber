package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Alert_TestNG 
{
    static WebDriver driver;
    static Alert al;
    
  @Test
  public void AlertCheck() throws Exception
  {
		//Click on the  Alert (Prompt Dialog) 'show' button
		//driver.findElement(By.xpath("//html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[2]/div[1]/button[1]")).click();
		Thread.sleep(3000);					
		
		//Getting the reference of Alert
			al = driver.switchTo().alert();
			System.out.println(" Alert reference is :: "+al);
  }
  
  @Test(dependsOnMethods= {"AlertCheck"})
  public void AlertOperations() throws Exception
  {
	//Alert Operations
		//Reading the text in the alert
			String altxt = al.getText();
			System.out.println(" The alert text message is :: "+altxt);
			
		//Enter the Name in the name text box of alert
				al.sendKeys("Naresh");
				Thread.sleep(3000);
				
		//Click on Ok button in alert
				al.accept(); //al.dismiss();
				Thread.sleep(3000);
				
		//Switch back to main page reference
				driver.switchTo().defaultContent();
  }
  
  
  @BeforeClass
  public void beforeClass() throws Exception
  {
	  System.setProperty("webdriver.gecko.driver", "F:\\Automation\\Softwares\\geckodriver.exe");
	  //System.setProperty("Webdriver.chrome.driver", "F:\\Automation\\Softwares\\chromedriver.exe");
	  //System.setProperty("Webdriver.ie.driver", "F:\\Automation\\Softwares\\IEDriverServer.exe");
	  //System.setProperty("Webdriver.edge.driver", "F:\\Automation\\Softwares\\msedgedriver.exe");
	  
	//initialize WebDriver interface with 'ChromeDriver' class to open a chrome browser
		 //interface name obj = new implemented class name();
			driver=  new FirefoxDriver(); //It is an constructor that will automatically invoke and execute the process steps inside it, where it will check for the firefox browser in the System and open its
			Thread.sleep(5000);
			System.out.println(" The opened firefox browser reference is :: "+driver);
			
			//Maximize the browser								
			 driver.manage().window().maximize();
			 Thread.sleep(3000);
			 
			//navigate to bing setting page in the opened firefox browser
			driver.get("https://leafground.com/alert.xhtml");
			Thread.sleep(5000);
			String title = driver.getTitle();
			System.out.println(" The title of the FB home page is ::"+title);
  }

  @AfterClass
  public void afterClass()
  {
	  //Close the browser
	  	driver.close();
  }

}
