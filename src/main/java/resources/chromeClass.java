package resources;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class chromeClass {
	public WebDriver driver;
	public Properties property;
	public WebDriver initializeDriver() throws IOException {
		property=new Properties();
		FileInputStream fis=new FileInputStream("F:\\Automation\\src\\main\\java\\Assessment_Automation\\Automation\\input.properties");
		property.load(fis);
		String browserName=property.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
}
