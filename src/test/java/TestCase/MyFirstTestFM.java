package TestCase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

import Base.BaseTest;
import Utilities.DataProvider1;

public class MyFirstTestFM extends BaseTest {
/*
	@SuppressWarnings("deprecation")
	@Test(dataProvider = "dataset_navigation", dataProviderClass = DataProvider1.class, description = "Navigation Testing")
	public void NavigationTest(String locator, String name) throws InterruptedException {
		Actions action = new Actions(driver);
		test = extent.startTest(name);
		// driver.findElement(By.xpath("//*[@id=\"nav-menu-item-2464\"]/a")).click(); //
		// for home screen
		WebElement element = driver.findElement(By.xpath(locator));
		action.moveToElement(element).build().perform();
		element.click();
		// To Show Parent Window
		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> iterator = windowhandles.iterator();
		String parentwindow = iterator.next();
		driver.switchTo().window(parentwindow);
		test.log(LogStatus.PASS, "Navigation test case");
	}

	/*
	 * @Test public void UserNavigationCategory() {
	 * driver.findElement(By.xpath("//*[@id=\"main-toggle-menu\"]/div[1]")).click();
	 * driver.findElement(By.xpath("//*[@id=\"nav-menu-item-116264\"]/a")).click();
	 * driver.findElement(By.xpath(
	 * "//*[@id=\"woocommerce_product_categories-2\"]/ul/li[1]")).click(); }
	 * 
	 * @Test public void LogoPresent() { boolean logopresent =
	 * driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div[1]/h1/a/img")
	 * ).isDisplayed(); as.assertTrue(logopresent); }
	 */
	/*@SuppressWarnings("deprecation")
	@Test
	public void SearchResultCheck() {
		test = extent.startTest("search result");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		WebElement searchele = driver.findElement(By.cssSelector("input[id=yith-s]"));
		searchele.sendKeys("vedic kapoor dani");
		searchele.sendKeys(Keys.ENTER);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		// action.moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div/ul/li/div/div[1]/div/div/div/div[2]"))).build().perform();
		WebElement searchresultpresent = driver
				.findElement(By.linkText("Vedic Kapoor Dani – Spirtual Healthcare Product"));
		String SearchText = searchresultpresent.getText();
		System.out.println(SearchText);
		as.assertEquals("Vedic Kapoor Dani – Spirtual Healthcare Product", SearchText);
		test.log(LogStatus.PASS, "Search Result");
	}*/

	@Test(dataProvider = "dataset_login", dataProviderClass = DataProvider1.class, description = "Login")
	public void LoginTest(String username, String password) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//test = extent.startTest("LOGIN");
		driver.findElement(By.linkText("Login/Register")).click();
		WebElement uName = driver.findElement(By.cssSelector("input[id=username]"));
		uName.sendKeys(username);
		WebElement uPass = driver.findElement(By.cssSelector("input[id=password]"));
		uPass.sendKeys(password);
		driver.findElement(By.cssSelector("button[name=login]")).click();
		//test.log(LogStatus.PASS, "LOGIN");
		//extent.endTest(test);
	}
/*
	@Test(dataProvider = "dataset_login", dataProviderClass = DataProvider1.class, description = "ADD_CART")
	public void addcard(String username, String password) throws InterruptedException {
		
		LoginTest(username, password);
		test = extent.startTest("ADD_CART");
		String Title = driver.getTitle();
		System.out.println(Title);
		if (Title.equalsIgnoreCase("REETREE - Your Online Shopping Hub | My Account")) {
			System.out.println("user Loged In");
			Actions action = new Actions(driver);
			driver.findElement(By.linkText("View Store")).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");
			driver.findElement(By.xpath(
					"//a[@href=\"https://reetree.in/shop/health-personal-care/oxi9-multani-mitti-daisy-extracts-soap-75g-4-pcs-pack/\"]/div[@class=\"labels\"]"))
					.click();
			driver.findElement(By.xpath("//button[@type=\"submit\"][@name=\"add-to-cart\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"mini-cart\"]/div[1]/span[1]/i")).click();
			driver.findElement(By.xpath("//*[@id=\"mini-cart\"]/div[2]/div/div/a")).click();
			Thread.sleep(20000);
		} else {
			System.out.println("Login creditentials are not OK");
		}
		test.log(LogStatus.PASS, "ADD_CART");
		extent.endTest(test);
	}

	@Test(dataProvider = "dataset_login", dataProviderClass = DataProvider1.class, description = "REMOVE_CART")
	public void cartremove(String username, String password) {
		test = extent.startTest("REMOVE_CART");
		LoginTest(username, password);
		String Title = driver.getTitle();
		System.out.println(Title);
		if (Title.equalsIgnoreCase("REETREE - Your Online Shopping Hub | My Account")) {
			driver.findElement(By.xpath("//*[@id=\"mini-cart\"]/div[1]/span[1]/i")).click();
			driver.findElement(By.xpath("//*[@id=\"mini-cart\"]/div[2]/div/div/a")).click();
			List<WebElement> cartiteam = driver.findElements(By.xpath("//tr[@class=\"cart_item\"]"));
			int count = 1;
			for (WebElement iteam : cartiteam) {
				String iteamName = driver.findElement(By.xpath("//tr[@class=\"cart_item\"][" + count + "]/td[2]/a"))
						.getText();
				if (iteamName.equalsIgnoreCase("Vedic Kapoor Dani - Spirtual Healthcare Product - Mango")) {
					driver.findElement(By.xpath("//tr[@class=\"cart_item\"][1]/td[1]/div/a[2]")).click();
	
				} else {
					System.out.println("Iteam is not present");
				}
				count++;
			}
		} else {
			System.out.println("Login creditentials are not OK");
		}
		test.log(LogStatus.PASS, "REMOVE_CART");
	}
	/*
	//@Test
	/*public void PriceSortAsending() throws InterruptedException {
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  Actions action = new Actions(driver);
		  //WebElement price = driver.findElement(By.xpath("//*[@id=\"content\"]//ins/span"));
		  //WebElement searchele = driver.findElement(By.cssSelector("input[id=yith-s]"));
		  //searchele.sendKeys("vedic kapoor dani");
		  //searchele.sendKeys(Keys.ENTER);
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,350)", "");
		  //Thread.sleep(30000);
		  //WebDriverWait wait = new WebDriverWait(driver,20);
		  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/main/div[4]/div/ul/li[1]/div/div[2]/span[2]/ins/span/bdi")));
		  //Before sort
		  action.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div/article/div/div/div/div/section[6]/div/div/div/div/div/div[2]/div/div/div/ul/li[4]/div/div[2]/span/ins/span/bdi")));
		  //WebElement BeforePrice = driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div/ul/li/div/div[2]/span[2]/ins/span/bdi"));
		 // System.out.println(Double.valueOf(BeforePrice.getText())); 
		  //remove $ and convert to double from string
		  //ArrayList<Double> BeforeFilterPriceList = new ArrayList<Double>();
		  
		  for(WebElement p:BeforePrice) {
			  BeforeFilterPriceList.add(Double.valueOf(p.getText()));
		  }
		  System.out.println(BeforeFilterPriceList);
		  //action.moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div/ul/li/div/div[2]"))).build().perform();
		  WebElement searchresultpresent = driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div/ul/li/div/div[1]/a/div[2]/img[2]"));
		  String SearchText = searchresultpresent.getText();
		  System.out.println(SearchText);
		  as.assertEquals("Vedic Kapoor Dani – Spirtual Healthcare Product", SearchText); 
	  } */
}
