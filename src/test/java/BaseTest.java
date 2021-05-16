package test.java;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import main.java.utils.TestConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private final int TIMOUT = 10;
    private static final String reportsPath = System.getProperty("user.dir") + File.separator + "reports" + File.separator;
    private static final String driversPath = System.getProperty("user.dir") + File.separator + "drivers" + File.separator;
    public static WebDriver driver;
    public ExtentSparkReporter spark;
    public static ExtentReports reports;
    public static ExtentTest logger;

    @BeforeTest
    public void beforeTest(){
        spark = new ExtentSparkReporter(reportsPath + "AutomatedReport.html");
        spark.config().setEncoding("utf-8");
        spark.config().setDocumentTitle("Automated Test Report");
        spark.config().setReportName("Automated Test Results");
        spark.config().setTheme(Theme.DARK);
        
        reports = new ExtentReports();
        reports.attachReporter(spark);
        reports.setSystemInfo("Automation Tester", "Musa Ugurlu");
    }

    @BeforeMethod
    @Parameters(value = {"browserName"})
    public void beforeMethod(String browserName, Method method){
        logger = reports.createTest(method.getName());
        setupDriver(browserName);
        driver.manage().window().maximize();
        driver.get(TestConstants.webUrl);
        driver.manage().timeouts().implicitlyWait(TIMOUT, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod(ITestResult result){
        if (result.getStatus() == ITestResult.SUCCESS) {
            String methodName = result.getMethod().getMethodName();
            String log = "Test Case: " + methodName + " Passed!";
            Markup markup = MarkupHelper.createLabel(log, ExtentColor.GREEN);
            logger.log(Status.PASS, markup);
        } else if (result.getStatus() == ITestResult.FAILURE) {
            String methodName = result.getMethod().getMethodName();
            String log = "Test Case: " + methodName + " Failed!";
            Markup markup = MarkupHelper.createLabel(log, ExtentColor.RED);
            logger.log(Status.FAIL, markup);
        }
        driver.quit();
    }

    @AfterTest
    public void afterTest() {
        reports.flush();
    }

    public void setupDriver(String browserName) {
        switch (browserName) {
            // This is default. So no need to specify it here.
//            case "chrome":
//                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");
//                driver = new ChromeDriver();
//                break;
            case "msedge":
                System.setProperty("webdriver.chrome.driver", driversPath + "msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", driversPath + "chromedriver.exe");
                driver = new ChromeDriver();
        }
    }
}
