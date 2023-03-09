package pom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
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
		@FindBy (xpath = "//div[@class='footer_copy']") private WebElement footer;

		
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
		
		
		public void clickOnTwitterButton(WebDriver driver ) {
			
			twitterButton.click();
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> a = handles.iterator();
			
			while (a.hasNext()){
		    	
		    	String handle = a.next();
		    	driver.switchTo().window(handle);
		    	
		    	String expectedUrl = "https://twitter.com/saucelabs";
		    	String actualUrl = driver.getCurrentUrl();

		    	if(expectedUrl.equals(actualUrl)){
		    		
		    		break;
		    	}
			}
		}
		
		public void clickOnFacebookButton(WebDriver driver) {
			
			facebookButton.click();
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> a = handles.iterator();
			
			while (a.hasNext()){
		    	
		    	String handle = a.next();
		    	driver.switchTo().window(handle);
		    	
		    	String expectedUrl = "https://www.facebook.com/saucelabs";
		    	String actualUrl = driver.getCurrentUrl();

		    	if(expectedUrl.equals(actualUrl)){
		    		
		    		break;
		    	}
			}
		}
		
		public void clickOnLinkedinButton(WebDriver driver) {
			
			linkedinButton.click();
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> a = handles.iterator();
			
			while (a.hasNext()){
		    	
		    	String handle = a.next();
		    	driver.switchTo().window(handle);
		    	
		    	String expectedUrl = "https://www.linkedin.com/company/sauce-labs/?original_referer=";
		    	String actualUrl = driver.getCurrentUrl();

		    	if(expectedUrl.equals(actualUrl)){
		    		
		    		break;
		    	}
			}
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
		
		public int addAllProductsToCart() {
			
			int size = totalAddToCartButton.size();
			for(int i=size-1;i>=0;i--)
			{
				WebElement addToCart = totalAddToCartButton.get(i);
				addToCart.click();
			}
			String Items = cartItemCounterNotification.getText();
			int itemNum = Integer.parseInt(Items);
			return itemNum;
	    }
	
		public int countProduct() {
			
			int count=0;
			int size = totalProducts.size();
			 for(int i =0; i<size ; i++){
				 
				 count++;  
			 }
			return count;
		 }
	
		public String getFooter() {
			
			String ft = footer.getText();
			return ft;
		}
	

}
