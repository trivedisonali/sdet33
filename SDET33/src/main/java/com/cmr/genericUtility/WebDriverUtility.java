package com.cmr.genericUtility;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.crm.ObjectRepository.OrganizationInfo;

/**
 * This class is collection of webdriver ations
 * @author SONALI TIWARI
 *
 *
 */
public class WebDriverUtility {
/*/**
	 * This method is used to wait implicity for specfied time
	 * @param driver
	 * @param timeout
	 */
	public static void waitforPageload(WebDriver driver, long timeout) {

		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

	}
	/**
	 * This method is used to wait until element visible
	 * @param driver
	 * @param oinfop
	 */
	public void waitUntilElementVisible(WebDriver driver, long timeout ,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeout) ;
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	/**
	 * This method is used to wait until element visible with specific polling time
	 * @param driver
	 * @param timeout
	 * @param element
	 * @param pollingTime
	 */
	public static void waitUntilElementVisibleWithCustompoll(WebDriver driver, long timeout ,WebElement element, long pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, timeout) ;
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.pollingEvery(Duration.ofSeconds(pollingTime));
		wait.ignoring(Throwable.class);


	}
	/**
	 * This method is used to wait until element is clickable with customize time and polling period
	 * @param element
	 * @param timeout
	 * @param pollingTime
	 * @throws InterruptedException
	 */
	public static void customWaitTillElementClickable(WebElement element,int timeout, int  pollingTime) throws InterruptedException {

		int count=0;
		while (count<=timeout) {
			try {
				element.click();
				break;

			} catch (NoSuchElementException e) {
				Thread.sleep(pollingTime);
				count++;
			}			
		}
	}
	/**
	 * This method will maximize the browser window
	 * @param driver
	 */

	public static void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method will used to open the application with maximize
	 * @param driver
	 * @param url
	 * @param timeout
	 */
	public static void launchApplicationWithMaximize(WebDriver driver, String url, long timeout) {

		driver.get(url);
		maximizeBrowser(driver);
		waitforPageload(driver, timeout);
	}
	/**
	 * This method will used to switch to the particular window
	 * @param driver
	 * @param partialTitleText
	 */
	public static void switchToWindow(WebDriver driver, String partialTitleText) {


		Set<String> winIDs2 = driver.getWindowHandles();
		for (String id : winIDs2) {
			driver.switchTo().window(id);
			if (driver.getTitle().contains(partialTitleText)) {
				break;

			}

		}
	}
	/**
	 * This method will used to move to the cursor on element
	 * @param driver
	 * @param element
	 */
	public static void moveToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * This method will used to right click on element
	 * @param driver
	 * @param element
	 */
	public static void rightClickonElement(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();

	}
	/**
	 * This method will used to double click on element
	 * @param driver
	 * @param element
	 */
	public static void doubleClickonElement(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();


	}
	/**
	 * This method will used to select the dropdown option by index
	 * @param element
	 * @param index
	 */
	public static void select(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}
	/**
	 * This method will used to select the dropdown option by visibleText
	 * @param element
	 * @param visibleText
	 */
	public static void select(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	/**
	 * This method will used to select the dropdown option by Value
	 * @param Value
	 * @param element
	 */
	public static void select(String Value, WebElement element) {
		Select select = new Select(element);
		select.selectByValue(Value);
	}
	/**
	 * This method will used to quit the browser instance
	 * @param driver
	 */
	public static void closeBrowser(WebDriver driver) {
		driver.quit();
	}
	/**
	 * This method will used to switch the frame by index
	 * @param driver
	 * @param index
	 */
	public static void frame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method will used to switch the frame by nameOrID
	 * @param driver
	 * @param nameOrID
	 */
	public static void frame(WebDriver driver,String nameOrID) {
		driver.switchTo().frame(nameOrID);

	}
	/**
	 * This method will used to switch the frame by element
	 * @param driver
	 * @param element
	 */
	public static void frame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method will used to take the screenshot of the failed test script
	 * @param driver
	 * @param FileName
	 * @throws IOException
	 */
	public static void takeScreenshotOfFailedScript(WebDriver driver,String FileName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./errorshots/"+FileName+"_"+JavaUtility.getcurrentTimeAndDate()+".png");
		FileUtils.copyFile(src,dst );
	}
	/**
	 *This method will used to take the screenshot of the failed test script and also it will return the AbsolutePath of the screenshot where it store
	 * @param driver
	 * @param FileName
	 * @return
	 * @throws IOException
	 */
	public static String takeScreenShotandgetpath(WebDriver driver, String FileName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/"+FileName+"_"+JavaUtility.getcurrentTimeAndDate()+".png");
		//Files.copy(src, dst);
		FileUtils.copyDirectory(src, dst);
		String absolutepath = dst.getAbsolutePath();
		return absolutepath;

	}

/**this method is created to open the application through javascript
 * 
 * @param driver
 * @param url
 */
public static void openApplicationThroughJs(WebDriver driver,String url) {
       
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("window.location='"+url+"'");


}
/**
 * 
 * @param driver
 * @param element
 * @param input
 */

public static void sendkeysThroughJs(WebDriver driver ,WebElement element,String input) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("argument[0].value='"+input+"'",element);
}
	
		/**
		 * 
		 * @param driver
		 * @param url
		 */
		public static void openApplicationThroughJS(WebDriver driver, String url) {
		      JavascriptExecutor js=(JavascriptExecutor) driver;
		      js.executeScript("window.location='"+url+"'");

		}
		/**
		 * This method is used to send the data into particular textfield
		 * @param driver
		 * @param element
		 * @param input
		 */
		public static void sendKeysThroughJS(WebDriver driver,WebElement element,String input)
		{
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='"+input+"'", element);
		}


		/**
		 * This method is used to click on the button/element
		 * @param driver
		 * @param element
		 */
		public static void clickActionThroughJS(WebDriver driver,WebElement element){
			
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);	
		}

		/**
		 * This method is used to scroll the webpage until the element is present 
		 * @param driver
		 * @param element
		 */
		public static void scrollTillElementThroughJS(WebDriver driver,WebElement element) {
			
			
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
			
			
		}
		/**This method is used to scroll the webpage till the end or up according to the user input
		 * 
		 * @param driver
		 * @param upOrDown
		 */
		public static void scrollDownToPageThroughJS(WebDriver driver,String upOrDown) {
			
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,"+upOrDown+"document.body.scrollHeight)");
			
		}
		public static void waitUntilElementVisiblity(WebDriver driver, int i, Object object, int j) {
			// TODO Auto-generated method stub
			
		}
		public static void closeAllBroserWindow(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}
		
		}




