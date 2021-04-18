package testclasses;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;
import okhttp3.internal.cache.DiskLruCache.Snapshot;
import pageobjects.OnlineCalculatorPage;
import utility.Constants;
import utility.Driver;
import utility.Utility;

public class NewTest {
	private static WebDriver driver;
	private static int testCaseNumber=0;
	private static int screenshotNumber=0;
	@BeforeClass
	public void setup() {
		driver= Driver.getChromeDriver();
		 driver.manage().window().maximize();
		driver.get(Constants.applicationURL); 				
	}
	
	@AfterClass
	public void afterClasee() {
		
	}
	
@BeforeMethod
public void resetCalculator() {
	 driver.get(Constants.applicationURL); 	
	 driver.manage().window().maximize();
	 testCaseNumber++;
	 screenshotNumber=0;
}
		
  @Test
  public void testAddition() {
	    
		
		  OnlineCalculatorPage onlineCalculatorPage = new OnlineCalculatorPage(driver);
		  onlineCalculatorPage .clickButton(Constants.one) 
		  .clickButton(Constants.plus)
		  .clickButton(Constants.four) 
		  .clickButton(Constants.equals);
		
		
	    BufferedImage img1 = Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		  onlineCalculatorPage
		 .clickButton(Constants.ce) 
		 .clickButton(Constants.five);
		 
		  BufferedImage img2= Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++ screenshotNumber);
		  
		  Assert.assertTrue(Utility.compareImages(img1,img2));
			
		
  }
  @Test
  public void testSubtraction() {

	  OnlineCalculatorPage onlineCalculatorPage = new OnlineCalculatorPage(driver);
	  onlineCalculatorPage .clickButton(Constants.four) 
	  .clickButton(Constants.minus)
	  .clickButton(Constants.one) 
	  .clickButton(Constants.equals);
	  driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

    BufferedImage img1 = Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	
	  onlineCalculatorPage
	 .clickButton(Constants.ce) 
	 .clickButton(Constants.three);
	 
	  BufferedImage img2= Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
	  
	  Assert.assertTrue(Utility.compareImages(img1,img2));
		
	
}
  
  
  @Test
  public void testSubtractionForNumbersHavingOneDecimalPlace() {
	  

	 
	  OnlineCalculatorPage onlineCalculatorPage = new OnlineCalculatorPage(driver);
	  onlineCalculatorPage .clickButton(Constants.four) 
	  .clickButton(Constants.point)
	  .clickButton(Constants.one)
	  .clickButton(Constants.minus)
	  .clickButton(Constants.one) 
	  .clickButton(Constants.equals);
	 

    BufferedImage img1 = Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  onlineCalculatorPage
	 .clickButton(Constants.ce) 
	 .clickButton(Constants.three)
	 .clickButton(Constants.point)
	 .clickButton(Constants.one);
	 
	  BufferedImage img2= Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++ screenshotNumber);
	  
	  Assert.assertTrue(Utility.compareImages(img1,img2));
		
}
  
  @Test
  public void testSubtractionForNumbersHavingTwoDecimalPlaces() {

	
		
	  OnlineCalculatorPage onlineCalculatorPage = new OnlineCalculatorPage(driver);
	  onlineCalculatorPage .clickButton(Constants.four) 
	  .clickButton(Constants.point)
	  .clickButton(Constants.one)
	  .clickButton(Constants.two)
	  .clickButton(Constants.minus)
	  .clickButton(Constants.one) 
	  .clickButton(Constants.equals);
	 

    BufferedImage img1 = Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	
	
	  onlineCalculatorPage
	 .clickButton(Constants.ce) 
	 .clickButton(Constants.three)
	 .clickButton(Constants.point)
	 .clickButton(Constants.one)
	 .clickButton(Constants.two);
	 
	  BufferedImage img2= Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
	  
	  Assert.assertTrue(Utility.compareImages(img1,img2));
		
}
  
  @Test
  public void testBoundaryValueAdditionForZero() {
	  
	  int screenshotNumber=0;
	
	  
	  OnlineCalculatorPage onlineCalculatorPage = new OnlineCalculatorPage(driver);
	  onlineCalculatorPage 
	   .clickButton(Constants.zero) 
	  .clickButton(Constants.point)
	  .clickButton(Constants.zero)
	  .clickButton(Constants.plus)
	  .clickButton(Constants.zero)
	  .clickButton(Constants.equals);
	  BufferedImage img1 = Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    
	    onlineCalculatorPage
		 .clickButton(Constants.ce) 
		 .clickButton(Constants.zero);
	    BufferedImage img2= Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
		  
		  Assert.assertTrue(Utility.compareImages(img1,img2));
	 
  }
  
  @Test
  public void testBoundaryValueSubtractionForZero() {
	  

	  
	  OnlineCalculatorPage onlineCalculatorPage = new OnlineCalculatorPage(driver);
	  onlineCalculatorPage 
	   .clickButton(Constants.zero) 
	  .clickButton(Constants.point)
	  .clickButton(Constants.zero)
	  .clickButton(Constants.plus)
	  .clickButton(Constants.zero)
	  .clickButton(Constants.equals);
	  BufferedImage img1 = Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    
	    onlineCalculatorPage
		 .clickButton(Constants.ce) 
		 .clickButton(Constants.zero);
	    BufferedImage img2= Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
		  
		  Assert.assertTrue(Utility.compareImages(img1,img2));
	 
  }
  
  
  
  @Test
  public void testAdditionFunctionalityWithMaximumDecimalPlaces() {
	  
	
	  
	  OnlineCalculatorPage onlineCalculatorPage = new OnlineCalculatorPage(driver);
	  onlineCalculatorPage 
	   .clickButton(Constants.nine) 
	  .clickButton(Constants.point)
	  .clickButton(Constants.nine,8)
	  .clickButton(Constants.plus)
	  .clickButton(Constants.zero)
	  .clickButton(Constants.point)
	  .clickButton(Constants.nine,8)
	  .clickButton(Constants.equals);
	  
	  BufferedImage img1 = Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    
	    onlineCalculatorPage
		.clickButton(Constants.ce) 
		.clickButton(Constants.one)
	    .clickButton(Constants.zero)
	    .clickButton(Constants.point)
	    .clickButton(Constants.nine,7)
	    .clickButton(Constants.eight);
	    
	    BufferedImage img2= Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
		  
		  Assert.assertTrue(Utility.compareImages(img1,img2));
	 
  }
  
  @Test
  public void testDeletionFunctionalityWithMaximumDecimalPlaces() {
	  

	  
	  OnlineCalculatorPage onlineCalculatorPage = new OnlineCalculatorPage(driver);
	  onlineCalculatorPage 
	   .clickButton(Constants.nine) 
	  .clickButton(Constants.point)
	  .clickButton(Constants.nine,8)
	  .clickButton(Constants.minus)
	  .clickButton(Constants.zero)
	  .clickButton(Constants.point)
	  .clickButton(Constants.nine,8)
	  .clickButton(Constants.equals);
	  
	  BufferedImage img1 = Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    
	    onlineCalculatorPage
		.clickButton(Constants.ce) 
	    .clickButton(Constants.nine);
	   
	    
	    BufferedImage img2= Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
		  
		  Assert.assertTrue(Utility.compareImages(img1,img2));
	 
  }
  
  @Test
  public void testInvalidInputsSquareRootDivisionAndNine() {
	  
	  String testCase="TC5";
	  
	  OnlineCalculatorPage onlineCalculatorPage = new OnlineCalculatorPage(driver);
	  onlineCalculatorPage 
	   .clickButton(Constants.squareRoot) 
	  .clickButton(Constants.divide)
	  .clickButton(Constants.nine)
	  .clickButton(Constants.equals);
	  
	  BufferedImage img1 = Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    
	    onlineCalculatorPage
		.clickButton(Constants.ce) 
	    .clickButton(Constants.zero);
	   
	    
	    BufferedImage img2= Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
		  
		  Assert.assertTrue(Utility.compareImages(img1,img2));
	 
  }
  
  @Test
  public void testSubtractOpertionWithSubtractAsTheFirstOperation() {
	  
	 
	  
	  OnlineCalculatorPage onlineCalculatorPage = new OnlineCalculatorPage(driver);
	  onlineCalculatorPage 
	   .clickButton(Constants.minus) 
	  .clickButton(Constants.three)
	  .clickButton(Constants.minus)
	  .clickButton(Constants.three)
	  .clickButton(Constants.equals);
	  
	  BufferedImage img1 = Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    
	    onlineCalculatorPage
		.clickButton(Constants.ce) 
	    .clickButton(Constants.minus)
	    .clickButton(Constants.six)
	    .clickButton(Constants.equals);
	   
	    
	    BufferedImage img2= Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
		  
		  Assert.assertTrue(Utility.compareImages(img1,img2));
	 
  }
  
  @Test
  public void testInvalidIputsTwoPointsAndOneNumber() {
	  
	
	  
	  OnlineCalculatorPage onlineCalculatorPage = new OnlineCalculatorPage(driver);
	  onlineCalculatorPage 
	   .clickButton(Constants.point) 
	  .clickButton(Constants.point)
	  .clickButton(Constants.three)
	  .clickButton(Constants.equals);
	  
	  BufferedImage img1 = Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    
	    onlineCalculatorPage
		.clickButton(Constants.ce) 
	    .clickButton(Constants.zero)
	    .clickButton(Constants.point)
	    .clickButton(Constants.three)
	    .clickButton(Constants.equals);
	   
	    
	    BufferedImage img2= Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
		  
		  Assert.assertTrue(Utility.compareImages(img1,img2));
	 
  }
  
  @Test
  public void testInvalidIputsTwoPointsAndEquals() {
	  

	  
	  OnlineCalculatorPage onlineCalculatorPage = new OnlineCalculatorPage(driver);
	  onlineCalculatorPage 
	   .clickButton(Constants.point) 
	  .clickButton(Constants.point)
	  .clickButton(Constants.equals);
	  
	  BufferedImage img1 = Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    
	    onlineCalculatorPage
		.clickButton(Constants.ce);
	   
	 
	    BufferedImage img2= Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
		  Assert.assertTrue(Utility.compareImages(img1,img2));
	 
  }
  
  @Test
  public void testDivisionFunctionality() {
	  
	
	  
	  OnlineCalculatorPage onlineCalculatorPage = new OnlineCalculatorPage(driver);
	  onlineCalculatorPage 
	   .clickButton(Constants.nine) 
	  .clickButton(Constants.divide)
	  .clickButton(Constants.three)
	  .clickButton(Constants.equals);
	  
	  BufferedImage img1 = Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    
	    onlineCalculatorPage
		.clickButton(Constants.ce)
		.clickButton(Constants.three);
	   
	 
	    BufferedImage img2= Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
		  Assert.assertTrue(Utility.compareImages(img1,img2));
	 
  }
  
  @Test
  public void testMultiplicationFunctionality() {
	  

	  
	  OnlineCalculatorPage onlineCalculatorPage = new OnlineCalculatorPage(driver);
	  onlineCalculatorPage 
	   .clickButton(Constants.nine) 
	  .clickButton(Constants.multiply)
	  .clickButton(Constants.three)
	  .clickButton(Constants.equals);
	  
	  BufferedImage img1 = Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    
	    onlineCalculatorPage
		.clickButton(Constants.ce)
		.clickButton(Constants.two)
		.clickButton(Constants.seven);
	   
	 
	      BufferedImage img2= Utility.convertToPartialImage(((TakesScreenshot) driver),testCaseNumber+"-"+ ++screenshotNumber);
		  Assert.assertTrue(Utility.compareImages(img1,img2));
	 
  }
  
  
  
  
  
  
  
  
  
  
  
}
