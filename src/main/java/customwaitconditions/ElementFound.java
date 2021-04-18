package customwaitconditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ElementFound  implements ExpectedCondition<Boolean> {

	
	private By locator;
	
	public Boolean apply(WebDriver driver) {
		try {
			driver.findElement(locator);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

}
