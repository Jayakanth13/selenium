package pageobjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.Constants;

public class OnlineCalculatorPage extends PageObject {
	
	
    By canvasLocator = By.xpath("//*[@id='canvas']");
	By iframeLocator= By.xpath("//body//iframe[@id='fullframe']");
	Map <String, int []> buttonPostionMap;
	private static int [] defaultCoordinates = {0,0};

	public OnlineCalculatorPage(WebDriver driver) {
		super(driver);
		 buttonPostionMap = populateMap();
	}

	private Map<String, int[]> populateMap() {
		 Map<String, int[]> buttonPostionMap = new HashMap<String,int[]>();
		 buttonPostionMap.put(Constants.zero, Constants.positionZero);
		 buttonPostionMap.put(Constants.one, Constants.positionOne);
		 buttonPostionMap.put(Constants.two, Constants.positionTwo);
		 buttonPostionMap.put(Constants.three, Constants.positionThree);
		 buttonPostionMap.put(Constants.four, Constants.positionFour);
		 buttonPostionMap.put(Constants.five, Constants.positionFive);
		 buttonPostionMap.put(Constants.six, Constants.positionSix);
		 buttonPostionMap.put(Constants.seven, Constants.positionSeven);
		 buttonPostionMap.put(Constants.eight, Constants.positionEigth);
		 buttonPostionMap.put(Constants.nine, Constants.positionNine);
		 buttonPostionMap.put(Constants.plus, Constants.positionPlus);
		 buttonPostionMap.put(Constants.minus, Constants.positionMinus);
		 buttonPostionMap.put(Constants.equals, Constants.positionEquals);
		 buttonPostionMap.put(Constants.multiply, Constants.positionX);
		 buttonPostionMap.put(Constants.point, Constants.positionPoint);
		 buttonPostionMap.put(Constants.squareRoot, Constants.positionSquareRoot);
		 buttonPostionMap.put(Constants.divide, Constants.positionDivide);
		 buttonPostionMap.put(Constants.ce, Constants.positionCE);
		return buttonPostionMap;
	}

	public OnlineCalculatorPage clickButton(String button) {
		int[] coordinates = buttonPostionMap.get(button);
		clickByCoordinate(getCurrentCoordinates(),coordinates);
		
		//find(canvasLocator);
		//switchToIframe(iframeLocator);
	
		return this;
	}

	private void clickByCoordinate(int[] currentCoordinates, int[] coordinates) {
		Actions actions = new Actions(driver);
		actions.moveByOffset(coordinates[0]-currentCoordinates[0], coordinates[1]-currentCoordinates[1]).click().build().perform();
		setNewCoordinats(coordinates);
		
	}

	private void setNewCoordinats(int[] coordinates) {
		this.defaultCoordinates=coordinates;
		
	}

	private int [] getCurrentCoordinates() {
		
		return defaultCoordinates;
	}

	private OnlineCalculatorPage switchToIframe(By locator) {
		switcToIframe(locator);
		return this;
		
		
	}
	
	

	public OnlineCalculatorPage clickPlusButton() {
		// TODO Auto-generated method stub
		return this;
	}

	public  OnlineCalculatorPage clickEqualsButton() {
		return this;
		
	}

	public OnlineCalculatorPage clickButton(String button, int amount) {
		int[] coordinates = buttonPostionMap.get(button);
		for (int i = 0; i < amount; i++) {
			clickByCoordinate(getCurrentCoordinates(),coordinates);
		}
		
		return this;
	}

	

}
