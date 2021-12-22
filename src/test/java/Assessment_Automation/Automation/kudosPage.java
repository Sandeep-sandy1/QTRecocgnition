package Assessment_Automation.Automation;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.kudosCredentials;
import pageObjects.loginCredentials;

public class kudosPage extends chromeClass {
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
	public void kudosSend() throws IOException, InterruptedException {
		login();
		kudosCredentials kud=new kudosCredentials(driver);
		Thread.sleep(2000);
		log4.info("Successfully logged in");
		kud.sendKudos().click();
		kud.searchBar().click();
		kud.searchBar().sendKeys("Sandeep N  (sandeep.n@qualitestgroup.com,)");
		kud.giveCard().click();
		log4.info("clicked on comment box");
		kud.addcomment().sendKeys("Automation Engg!");
		kud.send().click();
		Thread.sleep(3000);
		log4.info("Successfuly clicked on send button");
		String error=kud.errorInSent().getText();
		if(error.contains("Mailer Error: SMTP connect() failed.")) {
			Assert.assertTrue(false);
			log4.error("No, Successfully sent message");
		}
		stopAndClose();
	}
	@Test
	public void kudosSendFailure() throws IOException, InterruptedException {
		login();
		kudosCredentials kud=new kudosCredentials(driver);
		Thread.sleep(2000);
		log4.info("Successfully logged in");
		kud.sendKudos().click();
		kud.searchBar().click();
		kud.searchBar().sendKeys("P Akshay Raghottham  (akshay.rago@qualitestgroup.com,)");
		kud.giveCard().click();
		kud.send().click();
		log4.info("Successfuly clicked on send button");
		Thread.sleep(3000);
		String message=kud.errorMessage().getText();
		if(message.contains("Please enter any comment.")) {
			Assert.assertTrue(true);
			log4.error("Details are mandatory");
		}
		stopAndClose();
	}
}
