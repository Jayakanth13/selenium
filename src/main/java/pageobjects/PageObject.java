package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import customwaitconditions.NoExceptionThrown;
import customwaitconditions.NoExceptionThrownWhileClearingField;
import customwaitconditions.NoExceptionThrownWhileFinding;
import customwaitconditions.NoExceptionThrownWhileSwitching;
import customwaitconditions.NoExceptionThrownWhileTyping;
import customwaitconditions.TextIsNotBlank;

public class PageObject {
	
	protected WebDriver driver;
	
	public PageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}



	protected void type(By locator,String text) {
		WebDriverWait type = new WebDriverWait(driver,20,100);
		type.until(new NoExceptionThrownWhileTyping(locator,text));
				
	}
	
	protected WebElement find(By locator) {
		WebDriverWait type = new WebDriverWait(driver,20,100);
		type.until(new NoExceptionThrownWhileFinding(locator));
		return driver.findElement(locator);
				
	}
	
	protected void reset(By locator) {
		WebDriverWait reset = new WebDriverWait(driver,20,100);
		reset.until(new NoExceptionThrownWhileClearingField(locator));
				
	}
	
	protected void click(By locator) {
		WebDriverWait click = new WebDriverWait(driver,20,100);
		click.until(new NoExceptionThrown(locator));
				
	}
	
	protected void clickByCoordiante(int[] coordinates) {
		
		Actions actions = new Actions(driver);
		actions.moveByOffset(coordinates[0], coordinates[1]).click().build().perform();
				
	}
	
	
	
	protected String findTextInLocator(By locator) {
		/*
		 * WebDriverWait wait = new WebDriverWait(driver,5,100); wait.until(new
		 * TextIsNotBlank(locator));
		 */
		return 	driver.findElement(locator).getText().toString();
	}
	
   protected String getURL() {	
		return driver.getCurrentUrl();
	}
   
   
   protected void switcToIframe(By locator) {
	    //WebDriverWait switchToIframe  = new WebDriverWait(driver,5,100);
	    //switchToIframe.until(new NoExceptionThrownWhileSwitching(locator));
	    
	    new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
   }

	
	
	

}
