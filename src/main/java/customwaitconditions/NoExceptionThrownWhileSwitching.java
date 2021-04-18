package customwaitconditions;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.sun.tools.sjavac.Log;

public class NoExceptionThrownWhileSwitching implements ExpectedCondition<Boolean> {
	
	private By locator;
	
	public NoExceptionThrownWhileSwitching(By locator) {
		super();
		this.locator = locator;
		
	}

	public Boolean apply(WebDriver driver) {
		try {
			
	        //driver.findElement(locator);
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.id("//*[@id='fullframe']")));
			return true;
		}catch(Exception e) {
			//System.out.println(e.getLocalizedMessage());
			return false;
		}
	}

	
}
