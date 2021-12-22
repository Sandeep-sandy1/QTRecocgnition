package Assessment_Automation.Automation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.loginCredentials;

public class loginPage extends chromeClass {
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
	public void stopAndClose() throws InterruptedException{
		log4.info("Closing the current window");
		Thread.sleep(1000);
		driver.close();
	}
		@Test
		public void aUserLogin() throws IOException, InterruptedException {
			login();
			stopAndClose();
		}
		@Test
		public void bInvalidlogin() throws IOException, InterruptedException {
			driver=initializeDriver();
			driver.get(property.getProperty("url"));
			log4.info("Reached website successfully!");
			loginCredentials log=new loginCredentials(driver);
			log.Email().sendKeys("@qualitestgroup.com");
			log.Password().sendKeys("India");
			log.Submit().click();
			log4.info("Clicked the login button");
			log.error();
			log4.error("Alert message dislayed");
			stopAndClose();
		}
		@Test
		public void titleVerification() throws IOException, InterruptedException {
			login();
			log4.info("Logged in");
			String title=driver.getTitle();
			Assert.assertEquals(title, "QTRecognition");
			log4.info("Title is verified ");
			stopAndClose();
		}
		@Test
		public void getNavyColor() throws IOException, InterruptedException {
			driver=initializeDriver();
			driver.get(property.getProperty("url"));
			log4.info("Reached website successfully!");
			loginCredentials log=new loginCredentials(driver);
			String color=log.NavyColor().getCssValue("background-color");
			String nColor=Color.fromString(color).asHex().toUpperCase();
			log4.info("Navy color is verifying");
			Assert.assertEquals(nColor,"#2A2559");
			stopAndClose();
		}
		@Test
		public void getGoldColor() throws IOException, InterruptedException {
			driver=initializeDriver();
			driver.get(property.getProperty("url"));
			log4.info("Reached website successfully!");
			loginCredentials log=new loginCredentials(driver);
			String gcolor=log.GoldColor().getCssValue("background-color");
			String goColor=Color.fromString(gcolor).asHex().toUpperCase();
			log4.info("Gold color is verifying");
			Assert.assertEquals(goColor,"#FECC160");
			stopAndClose();
		}
		@Test
		public void getWhiteColor() throws IOException, InterruptedException {
			driver=initializeDriver();
			driver.get(property.getProperty("url"));
			log4.info("Reached website successfully!");
			loginCredentials log=new loginCredentials(driver);
			String wcolor=log.WhiteColor().getCssValue("background-color");
			String whColor=Color.fromString(wcolor).asHex().toUpperCase();
			log4.info("White color is verifying");
			Assert.assertEquals(whColor, "#939598");
			stopAndClose();
		}
}
