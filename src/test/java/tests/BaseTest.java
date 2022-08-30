package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	AppiumDriverLocalService service;
	protected AndroidDriver driver;
	static private final String APP_PATH = "C://Users//Abstracta//eclipse-workspace//wa//TiendaInglesaAutomation//src//test//resources//Tienda Inglesa_33.01_apkcombo.com.apk";
	static private final String DEVICE_NAME = "Cliente";
	static private final String IP_ADDRESS = "127.0.0.1";
	static private final int PORT = 4723;
	static private final String SERVER_URL = "http://" + IP_ADDRESS +":" + PORT; // CONSULTAR
	static private final String MAIN = "C://Users//Abstracta//AppData//Roaming//npm//node_modules//appium//build//lib//main.js";
	private int logedIn = 0;
	
	@BeforeClass
	public void setUpAppium() throws MalformedURLException {
		while(logedIn != 5) {
			try {
				service = new AppiumServiceBuilder().withAppiumJS(new File(MAIN)).withIPAddress(IP_ADDRESS).usingPort(PORT)
						.build();
				service.start();

				UiAutomator2Options options = new UiAutomator2Options();
				options.setDeviceName(DEVICE_NAME);
				options.setApp(APP_PATH);

				driver = new AndroidDriver(new URL(SERVER_URL), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				logedIn = allowDeviceLocationBtn;
			} catch (Exception e) {
				e.printStackTrace();
			    continue;
			}
		}
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
