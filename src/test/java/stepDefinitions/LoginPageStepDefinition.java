package stepDefinitions;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import PageFactory.SwagLabsPages;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ResourceBundle;


public class LoginPageStepDefinition {
	WebDriver driver;
	SwagLabsPages slp;

	ResourceBundle rb;
	@Before
	public void setup()
	{
		rb=ResourceBundle.getBundle("config");
        if(rb.getString("browser").equalsIgnoreCase("Chrome")){
			driver=new ChromeDriver();
		}
        else if(rb.getString("browser").equalsIgnoreCase("Edge")){
			driver=new EdgeDriver();
		}
		else{
			driver=new FirefoxDriver();
		}
	    slp=new SwagLabsPages(driver);
	}
	    @Given("The user is on the login page")
	    public void the_user_is_on_the_login_page() throws InterruptedException {
			driver.get("https://www.saucedemo.com/");
			driver.manage().window().maximize();
			Thread.sleep(2000);
	    }
	    @When("The user enters the valid username {string} and password {string} and clicks login")
	    public void the_user_enters_the_valid_username_and_password(String username, String password) throws InterruptedException  {
	    	slp.getUsernameField().sendKeys(username);
			slp.getpasswordField().sendKeys(password);
			Thread.sleep(2000);
			slp.getLoginButton().click();
	    }

	    @Then("The Home should be displayed")
	    public void the_home_should_be_displayed() {
	    	String currentURL=driver.getCurrentUrl();
	    	Assert.assertEquals(currentURL,"https://www.saucedemo.com/inventory.html","URL is not matching");
	        
	    }
        
	    //@When("The user enters the valid username \"(.*)\" and password \"(.*)\"")
		@When("The user enters the valid username \"(.*)\" and password \"(.*)\" and clicks login")
	    public void the_user_enters_the_locked_username_and_password_something(String username, String password) throws InterruptedException  {
	    	   slp.getUsernameField().sendKeys(username);
	           slp.getpasswordField().sendKeys(password);
	           Thread.sleep(2000);
	           slp.getLoginButton().click(); 
          
	    }

	    @Then("The error message should be displayed")
	    public void the_error_message_should_be_displayed() {
	    	String expectedError="Epic sadface: Sorry, this user has been locked out.";
	    	String actualError=driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
	    	Assert.assertEquals(expectedError,actualError,"Error message is not displayed");
	    }
	    //@Given("The user is logged in with username \"([^\"]*)\"  and password \"([^\"]*)\" and in the home page")
		@Given("The user is logged in with username {string} and password {string} and in the home page")
		public void the_user_is_logged_in_with_username_and_password_and_in_the_home_page(String username, String password) throws InterruptedException {
	    	 driver.get("https://www.saucedemo.com/");
	    	 slp.getUsernameField().sendKeys(username);
			 slp.getpasswordField().sendKeys(password);
			 Thread.sleep(2000);
			 slp.getLoginButton().click();
	    	
	    }

	    @When("The user clicks on the hamburger button")
	    public void the_user_clicks_on_the_hamburger_button() throws InterruptedException {
		Thread.sleep(2000);
		slp.getMenu().click();
	    }
     
	    @And("The user Clicks logout")
	    public void the_user_clicks_logout() throws InterruptedException  {
	    	Thread.sleep(2000);
	    	slp.getLogout().click();   	
	       
	    }
	    
	    @Then("The login page should be displayed")
	    public void the_login_page_should_be_displayed() {
	    	String currentURL=driver.getCurrentUrl();
	    	String actualURL="https://www.saucedemo.com/";
	    	Assert.assertEquals(currentURL, actualURL,"The URL is wrong");

	    }
	@After
	public void afterTest(Scenario scenario)
	{
		System.out.println("Test Status----->"+scenario.getStatus());
		if(scenario.isFailed()){
			TakesScreenshot ts= (TakesScreenshot) driver;
			byte [] screenshot=ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot,"image/png",scenario.getName());
		}
		driver.quit();
	}


}
