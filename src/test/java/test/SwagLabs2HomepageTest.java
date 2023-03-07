package test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwagLabsHomepage;
import pom.SwagLabsLoginPage;
import utility.BaseClass;
import utility.ExtentReport;

@Listeners(utility.Listeners.class)
	public class SwagLabs2HomepageTest extends BaseClass {
		
		
		
		ExtentReports reports;
		ExtentTest test;
		
		@BeforeTest
		public void configureReport() {
			reports = ExtentReport.createExtentReports();
			reports.setSystemInfo("Test Suite", "Regression Test");
			reports.setSystemInfo("Test Performed By", "Krushna Patare");
		}
		
		@BeforeMethod()
		
		public void openInventorypage() throws InterruptedException {
			
			driver = Browser.openBrowser("chrome");
			SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
			swagLabsLoginPage.enterUsername("standard_user");
		    swagLabsLoginPage.enterPassword("secret_sauce");
			swagLabsLoginPage.clickOnLogin();
		    Thread.sleep(1000);
		}
	/*	

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
			
			test = reports.createTest("verifyHomepage_LogoPresendAndSpelling_Checked");
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
			
			test = reports.createTest("clickSort_Clickable_OpenedDropdown");
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
		
		      test = reports.createTest("clickSort_Clickable_OpenedDropdown");
				Thread.sleep(100);
		}
		

	
		
		@Test()
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
			
			test = reports.createTest("clickSort_PriceHighToLow_GotInOrder");
			Thread.sleep(100);
		}
	
		
		@Test(priority=8)
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
			
			test = reports.createTest("clickSort_PriceLowToHigh_GotInOrder");
			Thread.sleep(100);	
		}
		
		@Test()
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
			test = reports.createTest("clickSort_ProductDescending_GotInOrder");
			Thread.sleep(100);
		}
			
		@Test(priority=6)
		public void clickSort_ProductAscending_GotInOrder() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			SwagLabsHomepage.sortByAscendingOrder();
			
			List <WebElement> item = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
			int size = item.size();
			for(int i=0;i<size;i++) {
				
				String expectedProductBanner = aop.get(i);
				String actualProductBanner = item.get(i).getText();
				System.out.println("expectedProductBanner = "+expectedProductBanner);
				System.out.println("actualProductBanner = "+actualProductBanner);
				Assert.assertEquals(expectedProductBanner, actualProductBanner);
			}
			test = reports.createTest("clickSort_ProductAscending_GotInOrder");
			Thread.sleep(100);
		}
	
		
		@Test()
		public void clickSort_ProductCountAfter_RemainedSame() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			int productNumberBeforeSort = SwagLabsHomepage.countProduct();
			SwagLabsHomepage.sortByHighToLowPrice();
			
			int productNumberAfterSort = SwagLabsHomepage.countProduct();
			System.out.println("productNumberBeforeSort = "+productNumberBeforeSort);
			System.out.println("productNumberAfterSort = "+productNumberAfterSort);
			
			Assert.assertEquals(productNumberBeforeSort, productNumberAfterSort);
			test = reports.createTest("clickSort_Clickable_OpenedDropdown");
			Thread.sleep(100);
		}
		
		@Test()
		public void clickSort_ProductsBefore_PredefinedNumber() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			int expectedProductNumberBeforeSort = SwagLabsHomepage.countProduct();
			
			int actualProductNumberBeforeSort = 6;
			System.out.println("expectedProductNumberBeforeSort = "+expectedProductNumberBeforeSort);
			System.out.println("actualProductNumberBeforeSort = "+actualProductNumberBeforeSort);
			
			Assert.assertEquals(expectedProductNumberBeforeSort, actualProductNumberBeforeSort);
			test = reports.createTest("clickSort_ProductsBefore_PredefinedNumber");
			Thread.sleep(100);
		}
		

		
		
		@Test()
		public void clickSort_ProductOrder_UnarrangedLikeBefore() throws InterruptedException {

			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			SwagLabsHomepage.sortByHighToLowPrice();
			SwagLabsHomepage.clickOnresetAppStateButton();
			String expectedProduct = "Sauce Labs Backpack";
			String actualProduct = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
			
			Assert.assertEquals(expectedProduct, actualProduct);
			test = reports.createTest("clickSort_ProductOrder_UnarrangedLikeBefore");
			Thread.sleep(100);
		}
		
		@Test()
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
			test = reports.createTest("clickSortBefore_DoOtherActions_SavedSortingType");
			Thread.sleep(100);
		}
		
		
		@Test()
		public void clickSortAfter_PreviousSortedResults_GotSortedAgain() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			ArrayList<String> aop = SwagLabsHomepage.sortByDescendingOrder();
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
			test = reports.createTest("clickSortAfter_PreviousSortedResults_GotSortedAgain");
				Thread.sleep(100);
		}
		
		
		
		
		
		
		
		@Test()
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
			test = reports.createTest("clickOpenMenu_Clickable_OpenedAllOptions");
			Thread.sleep(100);
		}
		
		
		@Test()
		public void clickOpenMenu_$About$Option_OpenedLinkedPage() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			SwagLabsHomepage.clickOnOpenMenuButton();
			SwagLabsHomepage.clickOnaboutButton();
			String actualTitle = SwagLabsHomepage.getTitle(driver);
			String expectedTitle = "Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing";
			System.out.println("expectedTitle = "+expectedTitle);
			System.out.println("actualTitle = "+actualTitle);
			Assert.assertEquals(expectedTitle,actualTitle);

		test = reports.createTest("clickOpenMenu_$About$Option_OpenedLinkedPage");
		Thread.sleep(100);
		}
		
		
		@Test()
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
				test = reports.createTest("clickOpenMenu_$AllItems$Option_ShowedAllHomepageProducts");
			}
			Thread.sleep(100);
		}
		
		
		@Test()
		public void clickOpenMenu_$Logout$Option_LoggedoutUser() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			SwagLabsHomepage.clickOnOpenMenuButton();
			SwagLabsHomepage.clickOnlogoutButton();
			String actualTitle = SwagLabsHomepage.getTitle(driver);
			String expectedTitle = "Swag Labs";
			System.out.println("expectedTitle = "+expectedTitle);
			System.out.println("actualTitle = "+actualTitle);
			Assert.assertEquals(expectedTitle,actualTitle);
			test = reports.createTest("clickOpenMenu_$Logout$Option_LoggedoutUser");
			Thread.sleep(100);
		}
		
		
		@Test()
		public void clickOpenMenu_$ResetAppState$Option_DefaultAppState() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			SwagLabsHomepage.clickOnSingleAddToCart();
			
			SwagLabsHomepage.clickOnOpenMenuButton();
			SwagLabsHomepage.clickOnresetAppStateButton();
			SwagLabsHomepage.clickOncloseMenuButton();		
			
			boolean expectedReset = true;
			boolean actualReset = false;
			
			 try {
				 int items = SwagLabsHomepage.countCartItem();				 
				 }
			catch(Exception e)
			     {
				 	actualReset = true;
					e.printStackTrace();
			     }
			System.out.println("expectedReset = "+expectedReset);
			System.out.println("actualReset = "+actualReset);
			
			Assert.assertEquals(expectedReset,actualReset);
			test = reports.createTest("clickOpenMenu_$ResetAppState$Option_DefaultAppState");
			Thread.sleep(100);
		}
		
		
		@Test()
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
			 test = reports.createTest("clickOpenMenu_CloseMenuButton_ClosedAllOptions");
			 Thread.sleep(100);
		}
		
		
		
		
		
		@Test()
		public void clickTwitterTab_SocialSite_OpenedTwitterPage() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			SwagLabsHomepage.clickOnTwitterButton(driver);
			String expectedUrl = "https://twitter.com/saucelabs";
			String actualUrl = driver.getCurrentUrl();
			
			System.out.println("actualUrl = "+actualUrl);
			System.out.println("expectedUrl = "+expectedUrl);
			
			Assert.assertEquals(actualUrl, expectedUrl);
			test = reports.createTest("clickTwitterTab_SocialSite_OpenedTwitterPage");
			Thread.sleep(100);
		}
		
		
		
		
		@Test()
		public void clickFacebookTab_SocialSite_OpenedFacebookPage() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			SwagLabsHomepage.clickOnFacebookButton(driver);
			String expectedUrl = "https://www.facebook.com/saucelabs";
			String actualUrl = driver.getCurrentUrl();
			
			System.out.println("actualUrl = "+actualUrl);
			System.out.println("expectedUrl = "+expectedUrl);
			
			Assert.assertEquals(actualUrl, expectedUrl);
			test = reports.createTest("clickFacebookTab_SocialSite_OpenedFacebookPage");
			Thread.sleep(100);
		}
		
		
		
		@Test()
		public void clickLinkedTab_SocialSite_OpenedLinkedPage() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
			SwagLabsHomepage.clickOnLinkedinButton(driver);
			String expectedUrl = "https://www.linkedin.com/company/sauce-labs/?original_referer=";
			String actualUrl = driver.getCurrentUrl();
			
			System.out.println("actualUrl = "+actualUrl);
			System.out.println("expectedUrl = "+expectedUrl);
			
			Assert.assertEquals(actualUrl, expectedUrl);
			test = reports.createTest("clickFacebookTab_SocialSite_OpenedFacebookPage");
			Thread.sleep(100);
		}
		*/
		
		
		
		
		@Test()
		public void verifyCartTab_TotalProductNumber_ShowedInNotification(){
			
			
			
			
			
			
			
		}
		
		/*
		@Test()
		public void verifyProduct_TitleAndDescriptionAndPrice_Checked() {}
		
		
		@Test()
		public void verifyProducts_Same$ActualAndGiven_ShownOnScreen() {}
		
		
		@Test()
		public void verifyProducts_AddAction_AddedToCart() {}
		
		
		@Test()
		public void verifyProducts_RemoveAction_RemovedFromCart() {}
		
		@Test()
		public void verifyHomepageFooter_Text_Checked() {}
		
		@Test()
		public void verifyHomepageNavigation_BackForewardRefresh_ReloadedWebpageSuccessfully() {}
		*/
		
		
		
		
//		@Test
//		public void addToCart() {
//			
//			SwagLabsHomepage SwagLabsInventoryPage = new SwagLabsHomepage(driver);
//			SwagLabsInventoryPage.clickOnAddToCart();
//			String actualItems = SwagLabsInventoryPage.countItem();
//			String expectedItem = "6";
//			Assert.assertEquals(actualItems, expectedItem);
//			System.out.println(actualItems);
//			System.out.println(expectedItem);
//			test = reports.createTest("addToCart");
//		}
/*		
		@Test
		public void selectDropdown() throws InterruptedException {
			
			SwagLabsHomepage SwagLabsInventoryPage = new SwagLabsHomepage(driver);
			SwagLabsInventoryPage.sort();
			Thread.sleep(10000);
			String actualHighCost = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[1]")).getText();
			String expectedHighCost = "$49.99";
			System.out.println(actualHighCost);
			System.out.println(expectedHighCost);
			Assert.assertEquals(actualHighCost, expectedHighCost);
			test = reports.createTest("selectDropdown");

			
		}
		
		@Test
		public void removeFromCart() {
			
			SwagLabsHomepage SwagLabsInventoryPage = new SwagLabsHomepage(driver);
			String actualText = SwagLabsInventoryPage.clickOnRemove();
			String expectedText = "ADD TO CART";
			System.out.println(actualText);
			System.out.println(expectedText);
			Assert.assertEquals(actualText, expectedText);
			test = reports.createTest("removeFromCart");

		}
		
		@Test
		public void openCart() {
			
			SwagLabsHomepage SwagLabsInventoryPage = new SwagLabsHomepage(driver);
			SwagLabsInventoryPage.clickOncartLink();
			String expectedTitle = "https://www.saucedemo.com/cart.html";
			String actualTitle = driver.getCurrentUrl();
			System.out.println(actualTitle);
			System.out.println(expectedTitle);
			Assert.assertEquals(actualTitle, expectedTitle);
			test = reports.createTest("openCart");

		}
		
		@Test
		public void openBurgerButtonMenu() {
			
			SwagLabsHomepage SwagLabsInventoryPage = new SwagLabsHomepage(driver);
			SwagLabsInventoryPage.clickOnOpenMenuButton();
//			String actualOption1 = driver.findElement(By.xpath("(//a[@class='bm-item menu-item'])[1]")).getText();
//			String expectedOption1 = "";
//			System.out.println(actualOption1);
//			System.out.println(expectedOption1);
			
			String actualClose = driver.findElement(By.xpath("//button[text()='Close Menu']")).getText();
			String expectedClose = "Close Menu";
			System.out.println(actualClose);
			System.out.println(expectedClose);
			Assert.assertEquals(actualClose, expectedClose);
			test = reports.createTest("openBurgerButtonMenu");
		}
		
		@Test
         public void openTwitterPage() {
			
			SwagLabsHomepage SwagLabsInventoryPage = new SwagLabsHomepage(driver);
			SwagLabsInventoryPage.clickOnTwitterButton(driver);
			String expectedUrl = "https://twitter.com/saucelabs";
			String actualUrl = driver.getCurrentUrl();
			System.out.println(actualUrl);
			System.out.println(expectedUrl);
			Assert.assertEquals(actualUrl, expectedUrl);
			test = reports.createTest("openTwitterPage");
		}
		
		@Test()
         public void openFacebookPage() {
			
			SwagLabsHomepage SwagLabsInventoryPage = new SwagLabsHomepage(driver);
			SwagLabsInventoryPage.clickOnFacebookButton(driver);
			String expectedUrl = "https://www.facebook.com/saucelabs";
			String actualUrl = driver.getCurrentUrl();
			System.out.println(actualUrl);
			System.out.println(expectedUrl);
			Assert.assertEquals(actualUrl, expectedUrl);
			test = reports.createTest("openFacebookPage");
			driver.close();
		}
		
		@Test(dependsOnMethods= {"openFacebookPage"})
        public void openLinkedinPage() {
			
			SwagLabsHomepage SwagLabsInventoryPage = new SwagLabsHomepage(driver);
			SwagLabsInventoryPage.clickOnLinkedinButton(driver);
			String expectedUrl = "https://www.linkedin.com/authwall?trk=bf&trkInfo=AQFwiqSv2-rs9QAAAYSfJTaYYB0GXzaNySQxgnOtz-Lway-tsnac5KABBOfwtpgTF_0qHjp67PtfUkOtA3uT0w6hSM_rQaQ6_aV5K5vqjUuR7RRsr_i0_EuEZzuJRZ-QvspsHFQ=&original_referer=&sessionRedirect=https%3A%2F%2Fwww.linkedin.com%2Fcompany%2Fsauce-labs%2F";
			String actualUrl = driver.getCurrentUrl();
			System.out.println(actualUrl);
			System.out.println(expectedUrl);
			Assert.assertEquals(actualUrl, expectedUrl);
			test = reports.createTest("openLinkedinPage");
		}
	*/
		
		@AfterMethod
		public void publishResult (ITestResult result) {
			
			if(result.getStatus()==ITestResult.SUCCESS) {
				
	        	test.log(Status.PASS,result.getName());
			   }
	        
			else if(result.getStatus()==ITestResult.FAILURE) {
				
				test.log(Status.FAIL, result.getName());
				}
			
			else if(result.getStatus()==ITestResult.SKIP) {
				
				test.log(Status.SKIP, result.getName());
				}
			
			driver.close();		
		}

		
		@AfterTest
		public void createReport() {
			reports.flush();
		}
		
	
	}
