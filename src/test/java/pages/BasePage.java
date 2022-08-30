package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {
	AppiumDriver driver;

	
	@AndroidFindBy(xpath = "(//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup)[2]")
	WebElement advertisementCloseBtn;
	
	public BasePage(AppiumDriver appiumDriver) {
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
		driver = appiumDriver;
	}

	public void clear(WebElement element) {
		element.clear();
	}

	public void backPage() {
		driver.navigate().back();
	}

	public void tapElement(WebElement element) {
		element.click();
	}

	public void typeText(WebElement element, String text) {
		this.clear(element);
		element.sendKeys(text);
	}

	public String getAttribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public void longPress(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));
	}

	public void swipe(WebElement element, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
				ImmutableMap.of("elementId", element, "direction", "left", "percent", 0.75));
	}

	public void dragAndDrop(WebElement element, int x, int y) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "endX", x, "endY", y));
	}
	
	public void closeAdvertisementIfExists() {
		if(advertisementCloseBtn.isDisplayed()) { //consultar
			this.tapElement(advertisementCloseBtn);
		}
	}

}
