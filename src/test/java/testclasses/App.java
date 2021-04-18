package testclasses;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;



/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { NewTest.class });
		testng.addListener(tla);
		testng.run();
		}
}
