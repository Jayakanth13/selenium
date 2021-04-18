package customwaitconditions;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class NoExceptionThrownWhileFinding implements ExpectedCondition<Boolean>{

    private By locator;
		
	public NoExceptionThrownWhileFinding(By locator) {
		super();
		this.locator = locator;
		
	}
	
	
	public Boolean apply(WebDriver driver) {
		try {
			String value = driver.findElement(locator).getText();
			System.out.println(value);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

}
