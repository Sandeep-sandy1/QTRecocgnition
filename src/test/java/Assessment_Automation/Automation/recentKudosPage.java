package Assessment_Automation.Automation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.loginCredentials;
import pageObjects.recentKudosCredentials;

public class recentKudosPage extends chromeClass{
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
	public void recentContKudos() throws IOException, InterruptedException {
		login();
		log4.info("Successfully logged in");
		Thread.sleep(1000);
		recentKudosCredentials recent=new recentKudosCredentials(driver);
		recent.recentContact().click();
		recent.selectCard().click();
		recent.addComment().sendKeys("Great!");
		log4.info("Added comments");
		Thread.sleep(1000);
		recent.clickSend().click();
		Thread.sleep(3000);
		String msg=recent.errorMessage().getText();
		if(msg.contains("Mailer Error: SMTP connect() failed.")) {
			Assert.assertTrue(false);
		}
		log4.info("Successfuly clicked on send button");
		stopAndClose();
	}
}
