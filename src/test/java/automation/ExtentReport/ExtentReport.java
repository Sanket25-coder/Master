package automation.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport 
{
	ExtentReports extent;
	
	@BeforeTest
	public void reports()
	{
		String path = System.getProperty("user.dir")+"\\reports\\Webreports.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("WebAutomationTesting");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Tester Name", "Sanket Mate");
	}
	
	@Test
	public void initialDemo()
	{
	
		ExtentTest test = extent.createTest("Data Manipulation");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.youtube.com");
		System.out.println(driver.getTitle());
		test.addScreenCaptureFromPath("user.dir\\result.png");
		//test.fail("RESULTS DO NOT MATCH");
		
		extent.flush();//clear output directory
	}
}
