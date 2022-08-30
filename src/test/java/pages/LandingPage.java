package pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LandingPage extends BasePage{

	public LandingPage(AppiumDriver appiumDriver) {
		super(appiumDriver);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(xpath = "\"//android.widget.Button[@text='Iniciar sesión']\"")
	WebElement iniciarSesionBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='WHILE USING THE APP']")
	static WebElement allowDeviceLocationWhileUsingTheAppBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	WebElement noGooglePlayServicesBtn;
	
}
