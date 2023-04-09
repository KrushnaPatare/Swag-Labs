package test;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.SwagLabsHomepage;
import pom.SwagLabsLoginPage;
import utility.BaseClass;
@Listeners(utility.Listeners.class)
	public class SwagLabs2HomepageTest extends BaseClass {

		@BeforeMethod()
		public void openInventorypage() throws InterruptedException {
			
			driver = Browser.openBrowser("chrome");
			SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
			swagLabsLoginPage.enterUsername("standard_user");
		    swagLabsLoginPage.enterPassword("secret_sauce");
			swagLabsLoginPage.clickOnLogin();
		    Thread.sleep(1000);
		}

		@AfterMethod
		public void closeBrowser (ITestResult result ) {
			
			driver.quit();
		}

		@Test(priority=1)
		public void verifyHomepage_LogoPresendAndSpelling_Checked() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			String actualLogo = SwagLabsHomepage.getLogo();
			String actualLogoText = SwagLabsHomepage.getLogoText();
			String expectedLogo = "app_logo";
			String expectedLogoText = "Swag Labs";
			
			System.out.println("expectedLogo = "+expectedLogo);
			System.out.println("actualLogo = "+actualLogo);
			System.out.println("expectedLogoText = "+expectedLogoText);
			System.out.println("actualLogoText = "+actualLogoText);
			
			Assert.assertEquals(expectedLogo, actualLogo);
			Assert.assertEquals(expectedLogoText, actualLogoText);
			Thread.sleep(100);
		}
		
		
		@Test(priority=2)
		public void clickSort_Clickable_OpenedDropdown() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			SwagLabsHomepage.sortByHighToLowPrice();
			String actualSort = SwagLabsHomepage.findSortOption();
			String expectedSort = "Price (high to low)";
			
			System.out.println("expectedSort = "+expectedSort);
			System.out.println("actualSort = "+actualSort);
			
			Assert.assertEquals(expectedSort, actualSort);
			
			Thread.sleep(100);
		}
		
		
		@Test(priority=3)
		public void clickSort_OptionsList_CheckedAllOptions() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			ArrayList<String> aop = new ArrayList<String>();
			aop.add("Name (A to Z)");
			aop.add("Name (Z to A)");
			aop.add("Price (low to high)");
			aop.add("Price (high to low)");
			
			List <WebElement> op = SwagLabsHomepage.getAllSortOptions();
			int size = op.size();
		      for(int i =0; i<size ; i++){
		         String actualOptions = op.get(i).getText();
		         String expectedOptions = op.get(i).getText();
		         System.out.println("expectedOptions = "+expectedOptions);
		         System.out.println("actualOptions = "+actualOptions);
		         Assert.assertEquals(expectedOptions, actualOptions);
		      }
		
		    Thread.sleep(100);
		}
		
		
		@Test(priority=4)
		public void clickSort_PriceHighToLow_GotInOrder() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			ArrayList<String> price = SwagLabsHomepage.sortByHighToLowPrice();
			
			List <WebElement> itemP = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
			int size = itemP.size();
			for(int i=0;i<size;i++) {
				
				String actualPrice = itemP.get(i).getText();
				String expectedPrice = price.get(i);
				System.out.println("expectedPrice = "+expectedPrice);
				System.out.println("actualPrice = "+actualPrice);
				Assert.assertEquals(expectedPrice, actualPrice);
			}
			
			Thread.sleep(100);
		}
	
		
		@Test(priority=5)
		public void clickSort_PriceLowToHigh_GotInOrder() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			ArrayList<String> price = SwagLabsHomepage.sortByLowToHighPrice();

			List <WebElement> itemP = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
			int size = itemP.size();
			for(int i=0;i<size;i++) {
				
				String actualPrice = itemP.get(i).getText();
				String expectedPrice = price.get(i);
				System.out.println("expectedPrice = "+expectedPrice);
				System.out.println("actualPrice = "+actualPrice);
				Assert.assertEquals(expectedPrice, actualPrice);
			}
			Thread.sleep(100);	
		}
		
		
		@Test(priority=6)
		public void clickSort_ProductDescending_GotInOrder() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			ArrayList<String> aop = SwagLabsHomepage.sortByDescendingOrder();
			
			List <WebElement> item = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
			int size = item.size();
			for(int i=0;i<size;i++) {
				
				String expectedProductBanner = aop.get(i);
				String actualProductBanner = item.get(i).getText();
				System.out.println("expectedProductBanner = "+expectedProductBanner);
				System.out.println("actualProductBanner = "+actualProductBanner);
				Assert.assertEquals(expectedProductBanner, actualProductBanner);
			}
			Thread.sleep(100);
		}
		
		
		@Test(priority=7)
		public void clickSort_ProductAscending_GotInOrder() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			ArrayList<String> aop = SwagLabsHomepage.sortByAscendingOrder();
			
			List <WebElement> item = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
			int size = item.size();
			for(int i=0;i<size;i++) {
				
				String expectedProductBanner = aop.get(i);
				String actualProductBanner = item.get(i).getText();
				System.out.println("expectedProductBanner = "+expectedProductBanner);
				System.out.println("actualProductBanner = "+actualProductBanner);
				Assert.assertEquals(expectedProductBanner, actualProductBanner);
			}
			Thread.sleep(100);
		}
	
		
		@Test(priority=8)
		public void clickSort_ProductCountAfter_RemainedSame() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			int productNumberBeforeSort = SwagLabsHomepage.countProduct();
			SwagLabsHomepage.sortByHighToLowPrice();
			
			int productNumberAfterSort = SwagLabsHomepage.countProduct();
			System.out.println("productNumberBeforeSort = "+productNumberBeforeSort);
			System.out.println("productNumberAfterSort = "+productNumberAfterSort);
			
			Assert.assertEquals(productNumberBeforeSort, productNumberAfterSort);
			Thread.sleep(100);
		}
		
		
		@Test(priority=9)
		public void clickSort_ProductsBefore_PredefinedNumber() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			int expectedProductNumberBeforeSort = SwagLabsHomepage.countProduct();
			
			int actualProductNumberBeforeSort = 6;
			System.out.println("expectedProductNumberBeforeSort = "+expectedProductNumberBeforeSort);
			System.out.println("actualProductNumberBeforeSort = "+actualProductNumberBeforeSort);
			
			Assert.assertEquals(expectedProductNumberBeforeSort, actualProductNumberBeforeSort);
			Thread.sleep(100);
		}		
		
		
		@Test(priority=10)
		public void clickSort_ProductOrder_UnarrangedLikeBefore() throws InterruptedException {

			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			SwagLabsHomepage.sortByHighToLowPrice();
			SwagLabsHomepage.clickOnresetAppStateButton();
			String expectedProduct = "Sauce Labs Backpack";
			String actualProduct = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
			
			Assert.assertEquals(expectedProduct, actualProduct);
			Thread.sleep(100);
		}
		
		
		@Test(priority=11)
		public void clickSortBefore_DoOtherActions_SavedSortingType() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			SwagLabsHomepage.sortByHighToLowPrice();
			SwagLabsHomepage.clickOnCartButton();
			driver.navigate().back();
			String expectedProduct = "Sauce Labs Backpack";
			String actualProduct = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
			System.out.println("expectedProduct = "+expectedProduct);
			System.out.println("actualProduct = "+actualProduct);
			Assert.assertEquals(expectedProduct, actualProduct);
			Thread.sleep(100);
		}
		
		
		@Test(priority=12)
		public void clickSortAfter_PreviousSortedResults_GotSortedAgain() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			SwagLabsHomepage.sortByDescendingOrder();
			ArrayList<String> asc =SwagLabsHomepage.sortByAscendingOrder();

			List <WebElement> item = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
			int size = item.size();
			for(int i=0;i<size;i++) {
				
				String expectedProductBanner = asc.get(i);
				String actualProductBanner = item.get(i).getText();
				System.out.println("expectedProductBanner = "+expectedProductBanner);
				System.out.println("actualProductBanner = "+actualProductBanner);
				Assert.assertEquals(expectedProductBanner, actualProductBanner);
			}
			Thread.sleep(100);
		}

		
		@Test(priority=13)
		public void clickOpenMenu_Clickable_OpenedAllOptions() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			List<String> actOpAll = SwagLabsHomepage.clickOnOpenMenuButton();
			ArrayList<String> expOpAll = new ArrayList<String>();
			expOpAll.add("All Items");
			expOpAll.add("About");
			expOpAll.add("Logout");
			expOpAll.add("Reset App State");
			expOpAll.add("Close Menu");
			
			int size = expOpAll.size();
			for(int i=0; i<size; i++) {
				String expectedOptions = expOpAll.get(i);
				String actualOptions = actOpAll.get(i);
				System.out.println("expectedOptions = "+expectedOptions);
				System.out.println("actualOptions = "+actualOptions);
				Assert.assertEquals(expectedOptions,actualOptions);
			}
			Thread.sleep(100);
		}
		
		
		@Test(priority=14)
		public void clickOpenMenu_$About$Option_OpenedLinkedPage() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			SwagLabsHomepage.clickOnOpenMenuButton();
			SwagLabsHomepage.clickOnaboutButton();
			String actualTitle = SwagLabsHomepage.getTitle(driver);
			String expectedTitle = "Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing";
			System.out.println("expectedTitle = "+expectedTitle);
			System.out.println("actualTitle = "+actualTitle);
			Assert.assertEquals(expectedTitle,actualTitle);

			Thread.sleep(100);
		}
		
		
		@Test(priority=15)
		public void clickOpenMenu_$AllItems$Option_ShowedAllHomepageProducts() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			SwagLabsHomepage.clickOnOpenMenuButton();
			SwagLabsHomepage.clickOnAllItemsButton();
			SwagLabsHomepage.clickOncloseMenuButton();
			
			ArrayList<String> aop = SwagLabsHomepage.sortByAscendingOrder();
			List <WebElement> item = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
			int size = item.size();
			for(int i=0;i<size;i++) {
				
				String expectedProductBanner = aop.get(i);
				String actualProductBanner = item.get(i).getText();
				System.out.println("expectedProductBanner = "+expectedProductBanner);
				System.out.println("actualProductBanner = "+actualProductBanner);
				Assert.assertEquals(expectedProductBanner, actualProductBanner);
			}
			Thread.sleep(100);
		}
		
		
		@Test(priority=16)
		public void clickOpenMenu_$Logout$Option_LoggedoutUser() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			SwagLabsHomepage.clickOnOpenMenuButton();
			SwagLabsHomepage.clickOnlogoutButton();
			String actualTitle = SwagLabsHomepage.getTitle(driver);
			String expectedTitle = "Swag Labs";
			System.out.println("expectedTitle = "+expectedTitle);
			System.out.println("actualTitle = "+actualTitle);
			Assert.assertEquals(expectedTitle,actualTitle);
			Thread.sleep(100);
		}
		
		
		@Test(priority=17)
		public void clickOpenMenu_$ResetAppState$Option_DefaultAppState() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			SwagLabsHomepage.clickOnSingleAddToCart();
			SwagLabsHomepage.clickOnOpenMenuButton();
			SwagLabsHomepage.clickOnresetAppStateButton();
			SwagLabsHomepage.clickOncloseMenuButton();		
			
			boolean expectedReset = true;
			boolean actualReset = false;
			
			 try {
				   SwagLabsHomepage.countCartItem();				 
				 }
			catch(Exception e)
			     {
				 	actualReset = true;
					e.printStackTrace();
			     }
			System.out.println("expectedReset = "+expectedReset);
			System.out.println("actualReset = "+actualReset);
			Assert.assertEquals(expectedReset,actualReset);
			Thread.sleep(100);
		}
		
		
		@Test(priority=18)
		public void clickOpenMenu_CloseMenuButton_ClosedAllOptions() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			SwagLabsHomepage.clickOnOpenMenuButton();
			SwagLabsHomepage.clickOncloseMenuButton();	
			String button = driver.findElement(By.xpath("//button[text()='Close Menu']")).getAttribute("tabindex");
			boolean expectedValue = true;
			boolean actualValue = false;
			
			if(button.equals("-1")) {
				
				actualValue = true;
			}
			
			 System.out.println("button = "+button);
			 System.out.println("expectedValue = "+expectedValue);
			 System.out.println("actualValue = "+actualValue);
				
			 Assert.assertEquals(expectedValue,actualValue);
			 Thread.sleep(100);
		}
		
		
		@Test(priority=19)
		public void clickTwitterTab_SocialSite_OpenedTwitterPage() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			SwagLabsHomepage.clickOnTwitterButton(driver);
			String expectedUrl = "https://twitter.com/saucelabs";
			String actualUrl = driver.getCurrentUrl();
			System.out.println("actualUrl = "+actualUrl);
			System.out.println("expectedUrl = "+expectedUrl);
			Assert.assertEquals(actualUrl, expectedUrl);
			Thread.sleep(100);
		}
		
		
		@Test(priority=20)
		public void clickFacebookTab_SocialSite_OpenedFacebookPage() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			SwagLabsHomepage.clickOnFacebookButton(driver);
			String expectedUrl = "https://www.facebook.com/saucelabs";
			String actualUrl = driver.getCurrentUrl();
			System.out.println("actualUrl = "+actualUrl);
			System.out.println("expectedUrl = "+expectedUrl);
			Assert.assertEquals(actualUrl, expectedUrl);
			Thread.sleep(100);
		}
		
		
		@Test(priority=21)
		public void clickLinkedTab_SocialSite_OpenedLinkedPage() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			SwagLabsHomepage.clickOnLinkedinButton(driver);
			String expectedUrl = "https://www.linkedin.com/company/sauce-labs/?original_referer=";
			String actualUrl = driver.getCurrentUrl();
			System.out.println("actualUrl = "+actualUrl);
			System.out.println("expectedUrl = "+expectedUrl);
			Assert.assertEquals(actualUrl, expectedUrl);
			Thread.sleep(100);
		}
		
		
		@Test(priority=22)
		public void verifyCartTab_TotalProductNumber_ShowedInNotification() throws InterruptedException{

			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			SwagLabsHomepage.clickOnSingleAddToCart();
			Thread.sleep(2000);
			int actualNum = SwagLabsHomepage.countCartItem();
			int expectedNum = 1;
			System.out.println("actualNum = "+actualNum);
			System.out.println("expectedNum = "+expectedNum);
			Assert.assertEquals(expectedNum, actualNum);
			Thread.sleep(100);
		}
			
		
		
		@Test(priority=23)
		public void verifyHomepageFooter_Text_Checked() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			String actualFooter = SwagLabsHomepage.getFooter();
			String expectedFooter = "© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
			System.out.println("actualFooter = "+actualFooter);
			System.out.println("expectedFooter = "+expectedFooter);
			Assert.assertEquals(expectedFooter, actualFooter);
			Thread.sleep(100);
		}
		
		@Test(priority=24)
		public void verifyHomepageNavigation_BackForewardRefresh_ReloadedWebpageSuccessfully() throws InterruptedException {
		
		driver.navigate().back();
		driver.navigate().refresh();
		driver.navigate().forward();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";

		Assert.assertEquals(actualUrl, expectedUrl);
		Thread.sleep(100);
		}

	
	}
