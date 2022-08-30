package pages;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import tests.BaseTest;

public class Only extends BaseTest {

	@Test
	public void wifiSettingsName() throws MalformedURLException {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Iniciar sesión']")).click();
			driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Usuario / e-mail']")).click();
			driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Usuario / e-mail']")).sendKeys("clienteautomation@gmail.com");
			driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Contraseña']")).click();
			driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Contraseña']")).sendKeys("clienteTI1.");
			driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Ingresar']")).click();
			
			WebElement close = driver.findElement(AppiumBy.xpath("(//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup)[2]"));
			if(close.isDisplayed()) {
				close.click();
			}
			//driver.findElement(AppiumBy.className("android.widget.EditText")).click();
			driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("coca-cola");
			//driver.findElement(AppiumBy.className("android.widget.EditText")).click();
			driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[2]/android.widget.FrameLayout")).click();
			// no funciona 
			// driver.pressKey(new KeyEvent(AndroidKey.SEARCH));
			driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Refresco COCA-COLA Sabor Original 600 ml\"));")); 
			
			
			List<WebElement> products = driver.findElements(AppiumBy.xpath("//android.view.ViewGroup[@resource-id='com.imasdev.tiendainglesa:id/grid_item_content']/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.TextView"));
			int productCount = products.size();
			int i = 0;
			boolean productFound = false;
			while (i < productCount && !productFound) {
				productFound = (products.get(i).getText()).equalsIgnoreCase("Refresco COCA-COLA Sabor Original 600 ml");
				i++;
			}
			if (productFound) {
				driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id='com.imasdev.tiendainglesa:id/grid_item_content']/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView)["+ i +"]")).click();
				driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='OK']")).click();
				driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Usuario / e-mail']")).click();
				driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Usuario / e-mail']")).sendKeys("clienteautomation@gmail.com");
				driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Contraseña']")).click();
				driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Contraseña']")).sendKeys("clienteTI1.");
				driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Ingresar']")).click();
			}
			
			//Ver carrito
			driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.ImageView")).click();
			driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Pagar']")).click();
			driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[4]//android.widget.ImageView")).click();
			driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout/android.view.ViewGroup")).click();
			driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id='com.imasdev.tiendainglesa:id/grid_item_content']/android.view.ViewGroup")).click();
			driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Continuar']")).click();
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Débito']")).click();
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Visa Debito']")).click();
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("ERROR: ");
			System.out.println(e);
		}
		
		
		/* driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String popUpTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		Assert.assertEquals(popUpTitle, "WiFi settings");
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("password");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click(); */
		}
}
