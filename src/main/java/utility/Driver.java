package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class Driver {

	public static WebDriver getBrowserDriver(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Driver\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver ();
		if(args.length==0) {
			return getChromeDriver();
		}
		
		if(args[0].equals(Constants.Chrome)) {
		  WebDriver driver = getChromeDriver();
		 
		return driver;
		}
		if(args[0].equals(Constants.Firefox)) {
			WebDriver driver = getFirefoxDriver();
			return driver;
		}
		return getChromeDriver();
	}

	public static WebDriver getChromeDriver() {
		DriverManagerType chrome = DriverManagerType.CHROME;
		   WebDriverManager.getInstance(chrome).setup(); 
		   WebDriver driver=new ChromeDriver();
		return driver;
	}
	
	
	
	public static WebDriver getFirefoxDriver() {
		   DriverManagerType firefox = DriverManagerType.FIREFOX;
		   WebDriverManager.getInstance(firefox).setup(); 
		   WebDriver driver=new FirefoxDriver();
		 
		return driver;
	}
	
	
	
	
	

}
