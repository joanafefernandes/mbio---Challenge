package seleniumCode;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class selenium {
	public static WebDriver driver;
	@Given ("^I am on page collections$")
	public void I_am_on_page_collections () {
		System.setProperty("chromeodriver","/Users/joanafernandesefernandes/eclipse-workspace/mbio⁩");
		driver = new ChromeDriver();
		driver.get("https://shop.mercedes-benz.com/en-gb/collection/");
		driver.manage().window().maximize();
	}
	
	@When("^I close cookies panel$")
	public void i_close_cookies_panel() {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("button-text")));
	    driver.findElement(By.id("button-text")).click();
	} 

	@When("^I select Collection and accessories link$")
	public void I_select_collection_and_accessories_link() {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div/shopnav-main/div/div[1]/div/div/div/div/ul/li/a")));
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/shopnav-main/div/div[1]/div/div/div/div/ul/li/a")).click();
	}
	@And("^I select all product$")
	public void I_select_all_product() {
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/shopnav-main/div/div[2]/div/shopnav-flyout/div/div[1]/div/div[1]/ul/li[1]/a")).click();
	}

	@And("^I select see all products$")
	public void i_select_see_all_products() {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[1]/utils-stage/div/ui-helper-slick/div/div/div/div/div/div[2]/div/div/a[1]")));
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[1]/utils-stage/div/ui-helper-slick/div/div/div/div/div/div[2]/div/div/a[1]")).click();
}
	@Then("^I am on collectioin and accessories page$")
	public void i_am_on_collectioin_and_accessories_page(){
		String expectedPage = "Collection & accessories";
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[1]/div/pg-grid/div/div/div[1]/div")));
    	String result = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[1]/div/pg-grid/div/div/div[1]/div")).getText();
        Assert.assertEquals(expectedPage, result);
	}

	@When("^I select one product$")
	public void i_select_one_product() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[1]/div/pg-grid/div/div/div[3]/div[1]/utils-product-tile-large/div/a/h3")));
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[1]/div/pg-grid/div/div/div[3]/div[1]/utils-product-tile-large/div/a/h3")).click();
	}
	@And("^I add product to the basket$")
	public void i_add_product_to_the_basket() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[1]/div/pdp-grid/div[1]/div[2]/utils-sticky-bar/ng-transclude/div/div/pdp-buy-box-add-to-basket/div/div/div/div[2]/button")));
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[1]/div/pdp-grid/div[1]/div[2]/utils-sticky-bar/ng-transclude/div/div/pdp-buy-box-add-to-basket/div/div/div/div[2]/button")).click();
	}

	@Then("^a pop-up display$")
	public void a_pop_up_display() {
		String expectedMessage = "You have saved the following item in your shopping basket.";
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[12]/div/div/div/div[2]/div[1]")));
    	String result = driver.findElement(By.xpath("/html/body/div[12]/div/div/div/div[2]/div[1]")).getText();
        Assert.assertEquals(expectedMessage, result);
	}

	@When("^I go to shooping basket$")
	public void i_go_to_shooping_basket() {
		driver.findElement(By.xpath("/html/body/div[12]/div/div/div/div[2]/div[2]/div/div[2]/button[1]")).click();
	}

	@Then("^cart page display$")
	public void cart_page_display() {
		String expectedTitle = "Your shopping basket";
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[4]/div/co-grid/div/div/div/form/div/div[1]/h5")));
    	String result = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[4]/div/co-grid/div/div/div/form/div/div[1]/h5")).getText();
        Assert.assertEquals(expectedTitle, result);
	}

	@When("^I continue to address and delivery$")
	public void i_continue_to_address_and_delivery() {
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[3]/div/co-func-header/div/div[2]/button")).click();
	}

	@Then("^Address and delivery step display$")
	public void address_and_delivery_step_display() {
		String expectedPannel = "Place order as guest";
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div/co-grid-tunnel/div/div/co-order-process-login/div/div/div[3]/ng-include/div/h3")));
    	String result = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/co-grid-tunnel/div/div/co-order-process-login/div/div/div[3]/ng-include/div/h3")).getText();
        Assert.assertEquals(expectedPannel, result);
	}

	
	@When("^I insert an email to place order as a guest$")
	public void i_insert_an_email_to_place_order_as_a_guest() {
		driver.findElement(By.id("dcp-login-guest-user-email")).click();
		driver.findElement(By.id("dcp-login-guest-user-email")).sendKeys("test@test.com");
	}

	@And("^choose place order as a guest$")
	public void choose_place_order_as_a_guest() {
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/co-grid-tunnel/div/div/co-order-process-login/div/div/div[3]/ng-include/div/form/button")).click();
	}

	@Then("^shipping page display$")
	public void shipping_page_display() {
		String expectedTitle = "Your invoice address";
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"co-address-payment\"]/h3")));
    	String result = driver.findElement(By.xpath("//*[@id=\"co-address-payment\"]/h3")).getText();
        Assert.assertEquals(expectedTitle, result);
	}

	@When("^I fill user details$")
	public void i_fill_user_details() {
		// select mr radio-button
		WebElement mrRadioBtn = driver.findElement(By.xpath("//*[@id=\"co-address-payment\"]/div[1]/utils-dynamic-form/div/form/div[1]/div[1]/label"));
		boolean radioBtnIsDisplayed = mrRadioBtn.isDisplayed();
        System.out.println("Is Male radio button displayed: "+radioBtnIsDisplayed);
        mrRadioBtn.click();
		// fill first name field
		driver.findElement(By.id("co_payment_address-firstName")).sendKeys("Harry");
		// fill last name field
		driver.findElement(By.id("co_payment_address-lastName")).sendKeys("Potter");
		// fill Number field
		driver.findElement(By.id("co_payment_address-line2")).sendKeys("900000000");
		// fill Street field
		driver.findElement(By.id("co_payment_address-line1")).sendKeys("Avenida Carlos da Maia");
		// fill Town field
		driver.findElement(By.id("co_payment_address-town")).sendKeys("London");
		// fill Postcode field
		driver.findElement(By.id("co_payment_address-postalCode")).sendKeys("SP2 0FL");
		// fill birth day field
		driver.findElement(By.id("dateOfBirth")).sendKeys("09");
		// fill birth month field
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[4]/co-grid-shipping/div/div/div/div/div[1]/co-payment-address/div/div[1]/utils-dynamic-form/div/form/div[6]/div[1]/input[2]")).sendKeys("04");
		// fill birth year field
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[4]/co-grid-shipping/div/div/div/div/div[1]/co-payment-address/div/div[1]/utils-dynamic-form/div/form/div[6]/div[1]/input[3]")).sendKeys("1988");
	}

	@And("^continue to payment step$")
	public void continue_to_payment_step() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[6]/div/co-func-footer/div/div/div/div[1]/button")));
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[6]/div/co-func-footer/div/div/div/div[1]/button")).click();
	}

	@Then("^payment step display$")
	public void payment_step_display() {
		String expectedTitle = "Your payment type";
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[4]/co-grid-payment/div/div/div/div[1]/co-payment-modes/div/h3")));
    	String result = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[4]/co-grid-payment/div/div/div/div[1]/co-payment-modes/div/h3")).getText();
        Assert.assertEquals(expectedTitle, result);
	}

	@When("^I choose paypal method$")
	public void i_choose_paypal_method() {
		WebElement paypalRadioBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[4]/co-grid-payment/div/div/div/div[1]/co-payment-modes/div/div/div[2]/div/div[1]/div/label/strong"));
		boolean radioBtnIsDisplayed = paypalRadioBtn.isDisplayed();
        System.out.println("Is Paypal radio button displayed: "+radioBtnIsDisplayed);
        paypalRadioBtn.click();
	}

	@And("^continue to verification and order placement$")
	public void continue_to_verification_and_order_placement() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[6]/div/co-func-footer/div/div/div/div[1]/button")));
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[6]/div/co-func-footer/div/div/div/div[1]/button")).click();
	}

	@Then("^Verification and order placement page display$")
	public void verification_and_order_placement_page_display() {
		String expectedTitle = "Your order data";
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[5]/co-grid-summary/div/div/div/co-order-data/div/div/div[1]/h2")));
    	String result = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[5]/co-grid-summary/div/div/div/co-order-data/div/div/div[1]/h2")).getText();
        Assert.assertEquals(expectedTitle, result);
	}

	
}
