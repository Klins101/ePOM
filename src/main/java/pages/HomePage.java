package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Constants;
import utilities.utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;

import java.time.Duration;


public class HomePage {
    static WebElement signInButton = utils.driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a"));
    static WebElement homeButton = utils.driver.findElement(By.cssSelector("#header_logo > a"));
    static WebElement addToCartFirst = utils.driver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default"));
    static WebElement firstElement = utils.driver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line"));
    static WebElement proceedToCheckoutButton = utils.driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a"));
    static WebElement cart = utils.driver.findElement(By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a"));
    ExtentTest test = utils.extent.createTest("Add items to cart", "Add items to cart and proceed to checkout");
    @Test
    public static void clickSignIn() throws Exception {
        ExtentTest test = utils.extent.createTest("Testing the sigin button", "Click sigin button and it should redirect to the signin page");
        test.log(Status.INFO, "clicking signin");
        WebDriverWait wait = new WebDriverWait(utils.driver, Constants.TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
        String expectedSURL = Constants.SIGN_URL;
        String actualSURL = utils.driver.getCurrentUrl();

        if(actualSURL.equalsIgnoreCase(expectedSURL)) {
            test.info("Redirecting to signin page");
            test.pass("Signin page opened successfully");
            test.log(Status.PASS, "Website Open successfully");
        }
        else {
            test.info("Refused to redirect to the signin page");
            test.fail("Website refused to redirect");
            test.log(Status.FAIL, "Website Did not redirect");
        }

    }

    @Test
    public static void clickHome()  {
        ExtentTest test = utils.extent.createTest("Testing home pages", "Redirecting Homepage");
        test.log(Status.INFO, "Redirected to homepage");
        WebDriverWait wait = new WebDriverWait(utils.driver, Constants.TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(homeButton));
        homeButton.click();
        String expectedHURL =  "http://automationpractice.com/index.php";
        String actualHURL = utils.driver.getCurrentUrl();

        if (!actualHURL.equalsIgnoreCase(expectedHURL)) {
            test.info("website refused open");
            test.fail("Website refused to open");
            test.log(Status.FAIL, "Website Did not open");
        } else {
            test.info("website opened");
            test.pass("Website opened successfully");
            test.log(Status.PASS, "Website Open successfully");
        }
    }

    @Test
    public static void addFirstElementToCart() throws Exception{
        ExtentTest test = utils.extent.createTest("Testing adding elements to cart", "Adding an item to the cart");
        test.log(Status.INFO, "Adding adding .........");
        test.log(Status.INFO, "Add first item");
        Actions hover = new Actions(utils.driver);
        hover.moveToElement(firstElement).build().perform();
        addToCartFirst.click();
        WebDriverWait wait = new WebDriverWait(utils.driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
        proceedToCheckoutButton.click();
        if (cart.getText().contains("1 Product")) {
            test.pass("Item added to cart");
            test.log(Status.PASS, "Cart updated successfully");
        }
        else {
            test.fail("Failed to add item to cart");
            test.log(Status.FAIL, "Cart update unsuccessful");

        }

    }




}
