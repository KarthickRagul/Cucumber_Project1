package stepDefinitions;

//import static org.testng.Assert.assertTrue;

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

public class AddToCartStepDefinition {
	
	WebDriver driver;
	SwagLabsPages slp;
	ResourceBundle rb;
	@Before
	public void setup()
	{
		rb= ResourceBundle.getBundle("config");
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

	String productName;	
    @Given("The user is in the home page")
    public void the_user_is_in_the_home_page() throws InterruptedException  {
    	   driver.get("https://www.saucedemo.com/");
		   driver.manage().window().maximize();
    	   slp.getUsernameField().sendKeys("standard_user");
           slp.getpasswordField().sendKeys("secret_sauce");
           Thread.sleep(5000);
           slp.getLoginButton().click();
        
    }

    @When("The user clicks on the product")
    public void the_user_clicks_on_the_product() throws Throwable {
        //clicking product
    	slp.getProduct().click();
    }

    @When("The user clicks on the first product")
    public void the_user_clicks_on_add_to_cart_on_first_product()  {
		//clicking add to cart
    	slp.getAddToCart().click();

    }

    @Then("The product should be added to cart")
    public void the_product_should_be_added_to_cart() throws Throwable {
    	
    	slp.getShoppingCart().click(); 
    	
    	String cartProductName=slp.getItemName().getText();
    	Assert.assertEquals(productName, cartProductName,"Expected cart is not added to the cart");
        
    }

    @Then("The cart count should be increased to {string}")
    public void the_cart_count_should_be_increased_to_something(String actualCount) {
    	
    	String count=slp.getBadge().getText();
    	Assert.assertEquals(actualCount,count,"Cart Count is not increased");
        
    }

    @And("The user clicks on the add to cart button")
    public void the_user_clicks_on_the_add_to_cart_button() {
    	
    	productName=slp.getProductName().getText();
    	
    	slp.getAddToCart().click();
        
    }

    @And("The user clicks on Add to cart on the Second product")
    public void the_user_clicks_on_add_to_cart_on_the_second_product()  {
    	
    	slp.getSecAddtoCart().click();
        
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