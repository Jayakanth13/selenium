package customwaitconditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class NoExceptionThrownWhileTyping implements ExpectedCondition<Boolean> {

	private By locator;
	private String text;
	
	
	public NoExceptionThrownWhileTyping(By locator, String text) {
		super();
		this.locator = locator;
		this.text = text;
	}

	public Boolean apply(WebDriver driver) {
		try {
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(text);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

}
