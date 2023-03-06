package pom;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SwagLabsHomepage {
	
		@FindBy (tagName = "title") private WebElement title;
		@FindBy (xpath = "//div[@class='app_logo']") private WebElement SwagLabsLogo;
		@FindBy (xpath = "//select[@class='product_sort_container']") private WebElement sortDropdown;

		@FindBy (xpath = "/html/body/div/div/div/div[2]/div/div/div/div") private List<WebElement> totalProducts;
		@FindBy (xpath = "//button[text()='Open Menu']") private WebElement openMenuButton;
		@FindBy (xpath = "//a[text()='All Items']") private WebElement allItemsButton;
		@FindBy (xpath = "//a[text()='About']") private WebElement aboutButton;
		@FindBy (xpath = "//a[text()='Logout']") private WebElement logoutButton;
		@FindBy (xpath = "//a[text()='Reset App State']") private WebElement resetAppStateButton;
		@FindBy (xpath = "//button[text()='Close Menu']") private WebElement closeMenuButton;
		
		
		@FindBy (xpath = "//div[@class='shopping_cart_container']") private WebElement cartButton;
		@FindBy (xpath = "(//button[text()='Add to cart'])") private List<WebElement> totalAddToCartButton;
		@FindBy (xpath = "(//button[text()='Remove'])[1]") private WebElement removeButton;

		@FindBy (xpath = "//span[@class='shopping_cart_badge']") private WebElement cartItemCounterNotification;
		@FindBy (xpath = "(//button[text()='Add to cart'])[1]") private WebElement addToCartSingle;
		@FindBy (xpath = "//option[text()='Price (high to low)']") private WebElement sortHighToLow;
		@FindBy (xpath = "//a[text()='Twitter']") private WebElement twitterButton;
		@FindBy (xpath = "//a[text()='Facebook']") private WebElement facebookButton;
		@FindBy (xpath = "//a[text()='LinkedIn']") private WebElement linkedinButton;
		
		public SwagLabsHomepage (WebDriver driver) {
			
			PageFactory.initElements(driver, this);
		}
		
		public String getLogo() {
			
			String value = SwagLabsLogo.getAttribute("class");
			return value;
		}
		
		public String getLogoText() {
			
			String value = SwagLabsLogo.getText();
			return value;
		}

		public String getTitle(WebDriver driver) {
			
			String pageTitle = driver.getTitle();
			return pageTitle;
		}
		
		public List <String> clickOnOpenMenuButton() {
			
			openMenuButton.click();
			ArrayList<String> actOpAll = new ArrayList<String>();
			actOpAll.add(allItemsButton.getText());
			actOpAll.add(aboutButton.getText());
			actOpAll.add(logoutButton.getText());
			actOpAll.add(resetAppStateButton.getText());
			actOpAll.add(closeMenuButton.getText());
			return actOpAll;
		}
		
		public void clickOnAllItemsButton() {
			
			allItemsButton.click();
		}

		public void clickOnaboutButton() {
	
			aboutButton.click();
		}
		
		public void clickOnlogoutButton() {
	
			logoutButton.click();
		}
		
		public void clickOnresetAppStateButton() {
	
			resetAppStateButton.click();
		}

		public void clickOncloseMenuButton() {
	
			closeMenuButton.click();
		}
		
		public void clickOnCartButton() {
			
			cartButton.click();
		}
		
		public void clickOnSortDropdown() {
			
			sortDropdown.click();
		}
		
		
		public void clickOnTwitterButton() {
			
			twitterButton.click();
		}
		
		public void clickOnFacebookButton() {
			
			facebookButton.click();
		}
		
		public void clickOnLinkedinButton() {
			
			linkedinButton.click();
		}
		
		public String clickOnSingleAddToCart() {
			
			addToCartSingle.click();
			String value = addToCartSingle.getText();
			return value;
		}
		
		public String clickOnAllAddToCartButton() {
			
			addToCartSingle.click();
			String value = addToCartSingle.getText();
			return value;
		}
		
		public String clickOnRemove() {
			
			addToCartSingle.click();
			removeButton.click();
			String value = addToCartSingle.getText();
			return value;
		}
		
		public String findSortOption() {
			
			String value = sortHighToLow.getText();
			return value;
		}
		
		public List <WebElement> getAllSortOptions() throws InterruptedException {
			
			Select select = new Select(sortDropdown);
			List <WebElement> op =select.getOptions();
			return op;
		}
		
	
		
		public void clickProductImage() {
			
		}
		
		public void clickProductBanner() {
			
		}
		
		public ArrayList<String> sortByHighToLowPrice() {
			
			Select select = new Select(sortDropdown);
			select.selectByVisibleText("Price (high to low)");
			ArrayList<String> price = new ArrayList<String>();
			price.add("$49.99");
			price.add("$29.99");
			price.add("$15.99");
			price.add("$15.99");
			price.add("$9.99");
			price.add("$7.99");
			return price;
		}
		
		public ArrayList<String> sortByLowToHighPrice() {
			
			Select select = new Select(sortDropdown);
			select.selectByVisibleText("Price (low to high)");
			ArrayList <String> price = new ArrayList<String>();
			price.add("$7.99");
			price.add("$9.99");
			price.add("$15.99");
			price.add("$15.99");
			price.add("$29.99");
			price.add("$49.99");
			return price;
		}
		
		public ArrayList<String> sortByDescendingOrder() {
			
			Select select = new Select(sortDropdown);
			select.selectByVisibleText("Name (Z to A)");
			ArrayList<String> aop = new ArrayList<String>();
			aop.add("Test.allTheThings() T-Shirt (Red)");
			aop.add("Sauce Labs Onesie");
			aop.add("Sauce Labs Fleece Jacket");
			aop.add("Sauce Labs Bolt T-Shirt");
			aop.add("Sauce Labs Bike Light");
			aop.add("Sauce Labs Backpack");
			return aop;
		}
		
		public ArrayList<String> sortByAscendingOrder() {
			
			Select select = new Select(sortDropdown);
			select.selectByVisibleText("Name (A to Z)");
			ArrayList<String> aop = new ArrayList<String>();
			aop.add("Sauce Labs Backpack");
			aop.add("Sauce Labs Bike Light");
			aop.add("Sauce Labs Bolt T-Shirt");
			aop.add("Sauce Labs Fleece Jacket");
			aop.add("Sauce Labs Onesie");
			aop.add("Test.allTheThings() T-Shirt (Red)");
			return aop;
		}
		
		
		
		
		

		
		public int countCartItem() {
			
			String Items = cartItemCounterNotification.getText();
			int itemNum = Integer.parseInt(Items);
			return itemNum;
		}
		
		public void addAllProductsToCart() {
			
			for(int i=5;i>=0;i--)
			{
				WebElement addToCart = totalAddToCartButton.get(i);
				addToCart.click();
			}
			
	    }
	
		public int countProduct() {
			
			int count=0;
			int size = totalProducts.size();
			 for(int i =0; i<size ; i++){
				 
				 count++;  
			 }
			return count;
		 }
	
		public select selectSortDropdown(){
			
		
		}
	
	

}
