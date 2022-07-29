package utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.Base64;
import java.util.concurrent.TimeUnit;



public class utils {
    public static WebDriver driver;
    public static ExtentReports report;
    public static ExtentTest test;
    static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;

    @BeforeSuite
    public static void instantiate() {
        System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        sparkReporter = new ExtentSparkReporter(Constants.REPORT_PATH);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }
    @Test(priority=0)
    public static void openPage() {
        ExtentTest test = extent.createTest("Open Automation Practice Website", "Opening the Site");
        test.log(Status.INFO, "Opening the website");
        driver.get(Constants.HOME_URL);
        String expectedURL = Constants.HOME_URL;
        String actualURL = driver.getCurrentUrl();
        if(actualURL.equalsIgnoreCase(expectedURL)) {
            test.log(Status.PASS, "Website Open successfully");
        }
        else {
            test.log(Status.FAIL, "Website Did not open, Kindly check url");
        }
    }
    @AfterSuite
    public static void closeDriver() {
        extent.flush();
        driver.quit();
    }
    public static String decode64(String encodedStr) {
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(encodedStr.getBytes()));
    }

}

