package customwaitconditions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class NoExceptionThrownWhileClearingField implements ExpectedCondition<Boolean> {
	
	private By locator;
	
	
	public NoExceptionThrownWhileClearingField(By locator) {
		super();
		this.locator = locator;
		
	}

	public Boolean apply(WebDriver driver) {
		try {
			driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			return true;
		}catch(Exception e) {
			return false;
		}
	}

}
