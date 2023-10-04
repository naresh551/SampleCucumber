package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Assertion_TestNG 
{
	  static WebDriver driver;
  @Test
  public void Login() throws Exception 
  {
	  //Code statement of FB login
	  	driver.findElement(By.id("email")).sendKeys("nareshrsv@gmail.com");
	  	Thread.sleep(3000);
	  	driver.findElement(By.id("pass")).sendKeys("nar@dsv1211");
	  	Thread.sleep(3000);
	  	driver.findElement(By.name("login")).click();
	  	Thread.sleep(6000);
	  	
	  	String Loginerrtext = driver.findElement(By.xpath("//span[contains(text(),\"The password you've entered is incorrect.\")]")).getText();
	  	
	  	 /*if(Loginerrtext.equalsIgnoreCase("The password you've entered is incorrect."))
	  	 {
	  		 System.out.println(" Login is failed ");
	  		 Assert.fail("Login is failed");
	  	 }
	  	 else if(driver.getTitle().equalsIgnoreCase("(11) Facebook"))
	  		System.out.println(" Login is sucessfull ");*/
	  	
	  		//Assert.assertNotEquals(Loginerrtext, "The password you've entered is incorrect.");	
	  		Assert.assertFalse(Loginerrtext.equalsIgnoreCase("The password you've entered is incorrect."), "Login is failed");
	  		
	  		Assert.assertEquals("(11) Facebook", driver.getTitle());
	  		 
  }
  
  
  @Test (dependsOnMethods= {"Login"})
  public void Logout() throws Exception 
  {
	 //Logout from the facebook account by clicking on Logout button
	  	driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/span[1]/div[1]/div[1]/div[1]/svg[1]/g[1]/image[1]")).click();
	  	Thread.sleep(3000);
	  	driver.findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
  }
  
  @BeforeClass
  public void beforeClass() throws Exception 
  {
	  System.setProperty("webdriver.gecko.driver", "F:\\Automation\\Softwares\\geckodriver.exe");
	//initialize WebDriver interface with 'ChromeDriver' class to open a chrome browser
		 //interface name obj = new implemented class name();
			driver=  new FirefoxDriver(); //It is an constructor that will automatically invoke and execute the process steps inside it, where it will check for the firefox browser in the System and open its
			Thread.sleep(5000);
			System.out.println(" The opened firefox browser reference is :: "+driver);
			
			//Maximize the browser								
			 driver.manage().window().maximize();
			 Thread.sleep(3000);
			 
			//navigate to bing setting page in the opened firefox browser
			driver.get("https://www.facebook.com/");
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
