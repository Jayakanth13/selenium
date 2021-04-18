package customwaitconditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class NoExceptionThrown implements ExpectedCondition<Boolean> {

	private By locator;
	
	public NoExceptionThrown(By locator) {
		super();
		this.locator = locator;
	}
	
	public Boolean apply(WebDriver driver) {
		try {
		driver.findElement(locator).click();
		return true;
		}catch(Exception e) {
			return false;
		}
		
	}

}
