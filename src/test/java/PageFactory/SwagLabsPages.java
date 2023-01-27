package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsPages {
	WebDriver driver;
	@FindBy(id="user-name")
	WebElement usernameField;
	public WebElement getUsernameField()
	{

		return usernameField;
	}
	@FindBy(id="password")
	WebElement passwordField;
	public WebElement getpasswordField() {

		return passwordField;
	}
	@FindBy(id="login-button")
	WebElement loginButton;
	public WebElement getLoginButton() {

		return loginButton;
	}
	@FindBy(id="item_4_title_link")
	WebElement product;
	public WebElement getProduct() {

		return product;
	}
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement addToCart;
	public WebElement getAddToCart() {

		return addToCart;
	}
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	WebElement secAddtoCart;
	public WebElement getSecAddtoCart()
	{

		return secAddtoCart;
	}
	@FindBy(className="shopping_cart_link")
	WebElement shoppingCart;
	public WebElement getShoppingCart()
	{

		return shoppingCart;
	}
	@FindBy(className="inventory_item_name")
	WebElement itemName;
	public WebElement getItemName()
	{

		return itemName;
	}
	@FindBy(className="shopping_cart_badge")
	WebElement cartBadge;
	public WebElement getBadge() {

		return cartBadge;
	}
	@FindBy(xpath="//div[@class='inventory_details_name large_size']")
	WebElement productName;
	public WebElement getProductName()
	{

		return productName;
	}
	@FindBy(id="checkout")
	WebElement checkout;
	public WebElement getCheckout()
	{

		return checkout;
	}
	@FindBy(className="title")
	WebElement title;
	public WebElement getTitle() {

		return title;
	}
    @FindBy(name="firstName")
    WebElement fname;
    public WebElement getFirstName() {

		return fname;
    }
    @FindBy(name="lastName")
    WebElement lname;
    public WebElement getLastName() {

		return lname;
    }
    @FindBy(name="postalCode")
    WebElement postalcode;
    public WebElement getPostalCode() {

		return postalcode;
    }
    @FindBy(id="continue")
    WebElement cntn;
    public WebElement getContinueButton() {

		return cntn;
    }
    @FindBy(id="finish")
    WebElement finish;
    public WebElement getFinish()
    {

		return finish;
    }
    @FindBy(id="react-burger-menu-btn")
	WebElement menu;
	public WebElement getMenu() {

		return menu;
	}
	@FindBy(id="logout_sidebar_link")
	WebElement logout;
	public WebElement getLogout() {
		return logout;

	}
	public SwagLabsPages(WebDriver driver) {    //Constructor for the SwagLabsPages class
		this.driver=driver;
		PageFactory.initElements(driver, this);   //Initializing the pagefactory for the elements
		
	}
}
