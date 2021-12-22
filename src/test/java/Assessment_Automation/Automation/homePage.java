package Assessment_Automation.Automation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homeCredentials;
import pageObjects.loginCredentials;

public class homePage extends chromeClass {
	public static Logger log4=LogManager.getLogger(chromeClass.class.getName());
	public void login() throws IOException {
		driver=initializeDriver();
		driver.get(property.getProperty("url"));
		log4.info("Reached website successfully!");
		loginCredentials log=new loginCredentials(driver);
		log.Email().sendKeys("sandeep.n@qualitestgroup.com");
		log.Password().sendKeys("P@ssw0rd");
		log.Submit().click();
		log4.info("Clicked the login button");
	}
	public void stopAndClose() throws InterruptedException, IOException{
		log4.info("Closing the current window");
		Thread.sleep(1000);
		driver.close();
	}
	@Test
	public void nameVerification() throws IOException, InterruptedException {
		login();
		homeCredentials home=new homeCredentials(driver);
		String name=home.getTheName().getText();
		Assert.assertEquals(name,"Sandeep N");
		log4.error("Name is not displayed");
		stopAndClose();
	}
	@Test
	public void imageVerifcation() throws IOException, InterruptedException {
		login();
		homeCredentials home=new homeCredentials(driver);
		String imgName=home.getTheImage().getAttribute("alt");
		if(imgName.contains("Sample Image")) {
			Assert.assertTrue(false);
			log4.error("Image is not uploaded");
		}
		else
		{
			Assert.assertTrue(true);
			log4.info("Image uploaded");
		}
		stopAndClose();
	}
	@Test
	public void titleVerification() throws IOException, InterruptedException {
		login();
		String title=driver.getTitle();
		Assert.assertEquals(title, "QTRecognition");
		log4.info("Title of the page is verified");
		stopAndClose();
	}
}
