package pom;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SwagLabsInventoryPage {
	
		@FindBy (xpath = "//button[text()='Open Menu']") private WebElement openMenuButton;
		@FindBy (xpath = "//a[@class='shopping_cart_link']") private WebElement cartButton;
		@FindBy (xpath = "//select[@class='product_sort_container']") private WebElement sortDropdown;
		@FindBy (xpath = "(//button[text()='Add to cart'])") private List<WebElement> totalAddToCartButton;
		@FindBy (xpath = "(//button[text()='Remove'])[1]") private WebElement removeButton;
		@FindBy (xpath = "//a[text()='Twitter']") private WebElement twitterButton;
		@FindBy (xpath = "//a[text()='Facebook']") private WebElement facebookButton;
		@FindBy (xpath = "//a[text()='LinkedIn']") private WebElement linkedinButton;
		@FindBy (xpath = "//span[@class='shopping_cart_badge']") private WebElement cartItemCounter;
		@FindBy (xpath = "//select[@class='product_sort_container']") private WebElement dropdown;
		@FindBy (xpath = "(//button[text()='Add to cart'])[1]") private WebElement addToCartSingle;

	
		
		public SwagLabsInventoryPage (WebDriver driver) {
			
			PageFactory.initElements(driver, this);
		}
		
		public void clickOnOpenMenuButton() {
			
			openMenuButton.click();
		}
		
		
		
		public void clickOncartLink() {
			
			cartButton.click();
			}
		
		public void clickOnTwitterButton(WebDriver driver) {
					
			twitterButton.click();
			Set<String> handles = driver.getWindowHandles();//to store all page address(handle)
		    Iterator<String> a = handles.iterator();//to fetch data

		    
		    while (a.hasNext()){
		    	
		    	String handle = a.next();
		    	driver.switchTo().window(handle);
		    	String actualUrl = driver.getCurrentUrl();
		        String pageUrl = "https://twitter.com/saucelabs";
		    	
		    	if(pageUrl.equals(actualUrl))
		    	{
		    	  break;	
		    	}
		      }
		  }
		
		public void clickOnFacebookButton(WebDriver driver) {
			
			facebookButton.click();
			Set<String> handles = driver.getWindowHandles();//to store all page address(handle)
		    Iterator<String> a = handles.iterator();//to fetch data

		    
		    while (a.hasNext()){
		    	
		    	String handle = a.next();
		    	driver.switchTo().window(handle);
		    	String actualUrl = driver.getCurrentUrl();
		        String pageUrl = "https://www.facebook.com/saucelabs";
		    	
		    	if(pageUrl.equals(actualUrl))
		    	{
		    	  break;	
		    	}
		      }
			}
		
		public void clickOnLinkedinButton(WebDriver driver) {
			
			linkedinButton.click();
			Set<String> handles = driver.getWindowHandles();//to store all page address(handle)
		    Iterator<String> a = handles.iterator();//to fetch data

		    
		    while (a.hasNext()){
		    	
		    	String handle = a.next();
		    	driver.switchTo().window(handle);
		    	String actualUrl = driver.getCurrentUrl();
		        String pageUrl = "https://www.linkedin.com/authwall?trk=bf&trkInfo=AQF1Z-MKqlK6ZwAAAYSfKSpQCPo1_do4M8CYJzVJIl9D9RteSrN1R9Yfvy4TMXqFKuAN_Ci8xwlLSIidofEfKjiheRH45p6MjyxfR67JgJBvIAY7Wmm8WwDqGbxaR8URbNUkZZc=&original_referer=&sessionRedirect=https%3A%2F%2Fwww.linkedin.com%2Fcompany%2Fsauce-labs%2F";
		    	
		    	if(pageUrl.equals(actualUrl))
		    	{
		    	  break;	
		    	}
		      }
			}
		
		
		
		public String countItem() {
			
			String Items = cartItemCounter.getText();
			return Items;
		}
		
		public void clickOnAddToCart() {
			
			for(int i=5;i>=0;i--)
			{
				WebElement addToCart = totalAddToCartButton.get(i);
				addToCart.click();
			}
			
	}
	
		public void sort() throws InterruptedException {
			
			Select select = new Select(dropdown);
			
			select.selectByValue("az");
		    
			select.selectByIndex(1);
			
			select.selectByVisibleText("Price (low to high)");
			
			select.selectByIndex(3);
			
			
		}
		
	
		public String clickOnRemove() {
			
			addToCartSingle.click();
			removeButton.click();
			String value = addToCartSingle.getText();
			return value;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
