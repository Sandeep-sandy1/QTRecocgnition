package Assessment_Automation.Automation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.kudosTestCredentials;
import pageObjects.loginCredentials;

public class kudosSearchPage extends chromeClass{
	public static Logger log4=LogManager.getLogger(chromeClass.class.getName());
	public void login() throws IOException {
		driver=initializeDriver();
		driver.get(property.getProperty("url"));
		log4.info("Reached website successfully!");
		loginCredentials log=new loginCredentials(driver);
		log.Email().sendKeys("madhu.sudhan@qualitestgroup.com");
		log.Password().sendKeys("P@ssw0rd");
		log.Submit().click();
		log4.info("Clicked the login button");
	}
	public void stopAndClose() throws InterruptedException{
		log4.info("Closing the current window");
		Thread.sleep(1000);
		driver.close();
	}
	@Test
	public void kudosSearchClick() throws IOException {
		login();
		kudosTestCredentials kudcred=new kudosTestCredentials(driver);
		kudcred.KudosSearch().click();
		kudcred.SearchBar().click();
		log4.info("Clicked on Kudos Search Bar");
		kudcred.SearchBar().sendKeys("madhu.sudhan@qualitestgroup.com");
		kudcred.SearchIcon().click();
		log4.info("Clicked on Search Icon");
		boolean text=kudcred.SeeHistory().isDisplayed();
		Assert.assertTrue(text);
	}
}
