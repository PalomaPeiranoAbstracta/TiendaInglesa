package pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage {

	public LoginPage(AppiumDriver appiumDriver) {
		super(appiumDriver);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Usuario / e-mail']")
	WebElement usernameInput;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Contraseña']")
	WebElement passwordInput;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Ingresar']")
	WebElement enterBtn;

	
	private void typeUsername(String username) {
		this.tapElement(usernameInput);
		this.typeText(usernameInput, username);
	}
	
	private void typePassword(String password) {
		this.tapElement(passwordInput);
		this.typeText(passwordInput, password);
	}
	
	public void login(String username, String password) {
		this.typeUsername(username);
		this.typePassword(password);
		this.tapElement(enterBtn);
	}
}
