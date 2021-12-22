package Assessment_Automation.Automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	public void screenShot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot pic=(TakesScreenshot) driver;
		File source=pic.getScreenshotAs(OutputType.FILE);
		String destFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destFile));
	}
}
