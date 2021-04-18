package customwaitconditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class TextIsNotBlank implements ExpectedCondition<Boolean> {

	private By locator;
	
	
	public TextIsNotBlank(By locator) {
		super();
		this.locator = locator;
		
	}
	
	
	public Boolean apply(WebDriver driver) {
		// TODO Auto-generated method stub
		try {
			System.out.println("1"+driver.findElement(locator).getText().toString());	
			
		    driver.findElement(locator).getText().toString().charAt(0);
		return true;
		}catch(Exception e) {
			return false;
		}
	}

}
