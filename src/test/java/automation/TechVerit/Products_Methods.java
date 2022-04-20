package automation.TechVerit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Products_Methods extends Browser_Launch 
	{
	  	  
	  private By sku = By.id("product_sku") ;
	  private By description = By.id("product_description") ;
	  private By title = By.id("product_title") ;
	  
			
	  public String fillproductdetails (Products Products )
	  	{
				
		  	driver.findElement(title).sendKeys(Products.getTitle());
		  	driver.findElement(sku).sendKeys(Products.getSku());
		  	driver.findElement(description).sendKeys(Products.getDescription());
		  	driver.findElement(By.id("product_submit_action") ).click();		
		  	return driver.findElement(By.className("flashes") ).getText() ;
	      				
	  	}
	    
        public void CreateProduct( )  
        {        
        	  driver.findElement(By.linkText("Products")).click();
        	  driver.findElement(By.linkText("New Product")).click();
			
        }
        
        public void UpdateProduct(String id)
        {	
        	  
              driver.findElement(By.linkText("Products")).click();
          	  driver.findElement(By.partialLinkText(id)).click();
          	  driver.findElement(By.linkText("Edit Product")).click();
        	
        }
        
        public void DeleteProduct(String id)
        {
        	
        	driver.findElement(By.linkText("Products")).click();
        	driver.findElement(By.partialLinkText(id)).click();
        	driver.findElement(By.linkText("Delete Product")).click();
        	driver.switchTo().alert().accept();
        }
     
      	   	 	
     }

