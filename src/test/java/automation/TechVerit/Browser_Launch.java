package automation.TechVerit;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser_Launch {

		  
	   public static WebDriver driver ;
	  	
  @BeforeSuite
  public void Setup () {
		
	        WebDriverManager.chromedriver().setup(); 
	        
	        driver = new ChromeDriver();
			
		driver.get("https://rajeev-girikar.herokuapp.com/admin/");
		driver.manage().window().maximize();
		driver.findElement(By.id("admin_user_email")).sendKeys("admin@example.com");	    
	    driver.findElement(By.id("admin_user_password")).sendKeys("password");
		driver.findElement(By.name("commit")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
}

   @Test(enabled=false) 
   public void CreateProductTest ()  
   {
	   Products Products = new Products ("ad1ds", "fsds1d", "gard1er") ;    
	   Products_Methods Products_methods = new Products_Methods();
	   Products_methods.CreateProduct(); 
	   Products_methods.fillproductdetails (Products) ;
	   String successmsg = driver.findElement(By.className("flashes")).getText() ;
	   Assert.assertEquals(successmsg, "Product was successfully created.");
       	
	}
   
   @Test(enabled=false)
   public void UpdateProductTest() 
   {
	
  	  Products Products = new Products ("AA11AA", "BBB11BB", "C11CC") ;
  	  Products_Methods Products_methods = new Products_Methods();
  	  Products_methods.UpdateProduct("1014");
  	  Products_methods.fillproductdetails(Products); 	  
  	  String updatesmsg = driver.findElement(By.className("flashes")).getText() ;
  	  Assert.assertEquals(updatesmsg,"Product was successfully updated.");
   }
   
   @Test
   public void DeleteProductTest() 
   {
	   Products_Methods Products_methods = new Products_Methods();
	   Products_methods.DeleteProduct("1044");	   
	   String deletesmsg = driver.findElement(By.className("flashes")).getText() ;
	   Assert.assertEquals(deletesmsg,"Product was successfully destroyed.");
   }

	    
}