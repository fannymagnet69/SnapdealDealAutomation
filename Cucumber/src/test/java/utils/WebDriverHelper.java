package utils;

import java.time.Duration;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverHelper {
	private WebDriver driver;
	private WebDriverWait wait;
	private long EXPLICIT_WAIT_DURATION = 20;
	Logger log;

	public WebDriverHelper(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_DURATION));
	}

	public void waitForElementToBeVisible(By element, int timeoutInSeconds) throws Exception {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
					.until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch (Exception e) {
			throw new Exception("Unable to click the element" + e.getCause());
		}
	}

	public void clickOnElement(By element) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			WebElement webElement = driver.findElement(element);
			webElement.click();
		} catch (Exception e) {
			throw new Exception("Exception: " + e.getClass().getName());
		}
	}

	public void clear(By element) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			WebElement webElement = driver.findElement(element);
			webElement.clear();
		} catch (Exception e) {
			throw new Exception("Exception: " + e.getClass().getName());
		}

	}

	public void sendKeys(By element, String data) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			WebElement webElement = driver.findElement(element);
			webElement.sendKeys(data);
		} catch (Exception e) {
			throw new Exception("Exception: " + e.getClass().getName());
		}
	}

	public void sendKeys(By element, Keys keyboardKeys) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			WebElement webElement = driver.findElement(element);
			webElement.sendKeys(keyboardKeys);
		} catch (Exception e) {
			throw new Exception("Exception: " + e.getClass().getName());
		}
	}

	public void switchToNewTab() throws Exception {
		try {
			String parentTab = driver.getWindowHandle();
			Set<String> tabsList = driver.getWindowHandles();
			for (String tab : tabsList) {
				if (!tab.equalsIgnoreCase(parentTab)) {
					driver.switchTo().window(tab);
				} else {
					driver.switchTo().window(parentTab);
				}
			}
		} catch (Exception e) {
			throw new Exception("Exception: " + e.getClass().getName());
		}

	}

	public void hoverOnElement(By element) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			WebElement webElement = driver.findElement(element);
			Actions action = new Actions(driver);
			action.moveToElement(webElement).perform();
		} catch (Exception e) {
			throw new Exception("Exception: " + e.getClass().getName());
		}

	}

	public void selectByVisibleText(By element, String value) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			WebElement webElement = driver.findElement(element);
			Select select = new Select(webElement);
			select.selectByVisibleText(value);
		} catch (Exception e) {
			throw new Exception("Exception: " + e.getClass().getName());
		}

	}

	public void selectByIndex(By element, int index) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			WebElement webElement = driver.findElement(element);
			Select select = new Select(webElement);
			select.selectByIndex(index);
		} catch (Exception e) {
			throw new Exception("Exception: " + e.getClass().getName());
		}

	}

	public String getText(By element) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			return driver.findElement(element).getText();
		} catch (Exception e) {
			throw new Exception("Exception: " + e.getClass().getName());
		}
	}

	public void scrollToElement(By element) throws Exception {
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			WebElement webElement = driver.findElement(element);
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
		} catch (Exception e) {
			throw new Exception("Exception: " + e.getClass().getName());
		}

	}

	public void jsClick(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'background: lightskyblue; border: 2px solid red;');",
					element);
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
			js.executeScript("arguments[0].click();", element);
			// String elementName = element.getText();
		} catch (Exception e) {
			// Handle or rethrow the exception here
			e.printStackTrace();
		}
	}

	public void clearTextBoxWithKeys(By element) {
		try {
			WebElement webElement = driver.findElement(element);
			webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void jsScroll(By element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement e = driver.findElement(element);
		js.executeScript("arguments[0].scrollIntoView(false)", e);
	}

	public void jsScroll2(WebDriver driver, int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixels + ");");
	}
}
