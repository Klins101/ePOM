import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.time.Duration;


public class tryeww {
    ExtentSparkReporter htmlReporter;
    ExtentReports extent;

    public static WebDriver driver;
    @BeforeSuite
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/KlinsmannAgyei/Desktop/Projects/Selenium/ePOM/src/main/java/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        htmlReporter = new ExtentSparkReporter("report/extented.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }


    @Test(priority = 0)
    public void openSite() throws Exception {
        ExtentTest test = extent.createTest("Free flow on Automation Practice", "Opening the Site");
        test.log(Status.INFO, "Opening the website");
        driver.get("http://automationpractice.com/index.php");
        String expectedURL = "http://automationpractice.com/index.php";
        String actualURL = driver.getCurrentUrl();

        if(actualURL.equalsIgnoreCase(expectedURL)) {
            test.info("website opened");
            test.pass("Website opened successfully");
            test.log(Status.PASS, "Website Open successfully");
        }
        else {
            test.info("website refused open");
            test.fail("Website refused to open");
            test.log(Status.FAIL, "Website Did not open");
        }
    }


    @Test(priority = 1)
    public void clickSignIn() throws Exception {
        WebElement signInButton = driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a"));
        ExtentTest test = extent.createTest("Testing the sigin button", "Click sigin button and it should redirect to the signin page");
        test.log(Status.INFO, "clicking signin");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
        String expectedSURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        String actualSURL = driver.getCurrentUrl();
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

    @Test(priority = 2)
    public void logIn() throws Exception {
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("passwd"));
        WebElement signInButton = driver.findElement(By.id("SubmitLogin"));
        ExtentTest test = extent.createTest("Testing the Filling signin form", "Type email and password");
        test.log(Status.INFO, "Filling login form");
        emailField.sendKeys("klinsmannjurgenagyei@gmail.com");
        passwordField.sendKeys("123456");
        signInButton.click();
        String expectedSURL = "http://automationpractice.com/index.php?controller=my-account";
        String actualSURL = driver.getCurrentUrl();

        if(actualSURL.equalsIgnoreCase(expectedSURL)) {
            test.info("Redirecting to signin page");
            test.pass("Signin successful");
            test.log(Status.PASS, "Signin successful");
        }
        else {
            test.info("Wrong email or password");
            test.fail("Website refused to redirect");
            test.log(Status.FAIL, "Wrong password");
        }
    }

    @Test(priority = 3)
    public void Home() throws Exception {
        WebElement homeButton = driver.findElement(By.cssSelector("#header_logo > a"));
        ExtentTest test = extent.createTest("Going to Home page", "Click home page and it should redirect to the home page");
        test.log(Status.INFO, "clicking signin");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(homeButton));
        homeButton.click();
        String expectedSURL = "http://automationpractice.com/index.php";
        String actualSURL = driver.getCurrentUrl();

        if(actualSURL.equalsIgnoreCase(expectedSURL)) {
            test.info("Redirecting to Home page");
            test.pass("Signin page opened successfully");
            test.log(Status.PASS, "Website Open successfully");
        }
        else {
            test.info("Refused to redirect to the Home page");
            test.fail("Website refused to redirect");
            test.log(Status.FAIL, "Website Did not redirect");
        }
    }

    @Test(priority = 4)
    public void addFirstElementToCart() throws Exception{
        WebElement addToCartFirst = driver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default"));
        WebElement firstElement = driver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line"));
        WebElement proceedToCheckoutButton = driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a"));
        WebElement cart = driver.findElement(By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a"));
        ExtentTest test = extent.createTest("Add items to cart", "Add items to cart and proceed to checkout");
        test.log(Status.INFO, "Add first item");
        Actions hover = new Actions(driver);
        hover.moveToElement(firstElement).build().perform();
        addToCartFirst.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
        proceedToCheckoutButton.click();
        if (cart.getText().contains("1 Product")) {
            test.info("Adding item to cart");
            test.pass("Item added to cart");
            test.log(Status.PASS, "Cart updated successfully");
        }
        else {
            test.info("item wasn't to cart");
            test.fail("Failed to add item to cart");
            test.log(Status.FAIL, "Cart update unsuccessful");

        }

    }


    @AfterSuite
    public void tearDown(){
        extent.flush();
        driver.quit();

    }

}
