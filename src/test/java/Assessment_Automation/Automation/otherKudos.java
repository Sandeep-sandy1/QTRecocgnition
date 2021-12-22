package Assessment_Automation.Automation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.kudosCredentials;
import pageObjects.loginCredentials;
import pageObjects.othersKudosCredentials;

public class otherKudos extends chromeClass{
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
	public void kudosFromMeClick() throws IOException, InterruptedException {
		login();
		log4.info("Successfully logged in");
		othersKudosCredentials other=new othersKudosCredentials(driver);
		other.kudosFromMe().click();
		log4.info("Clicked on Kudos From Me");
		Thread.sleep(2000);
		boolean test=other.fromDisplayed().isDisplayed();
		Assert.assertTrue(test);
		stopAndClose();
	}
	@Test
	public void kudosToMeClick() throws IOException, InterruptedException {
		login();
		log4.info("Successfully logged in");
		othersKudosCredentials other=new othersKudosCredentials(driver);
		other.kudosToMe().click();
		log4.info("Clicked on Kudos To Me");
		boolean test1=other.toDisplayed().isDisplayed();
		Assert.assertTrue(test1);
		stopAndClose();
	}
	@Test
	public void kudosActivityClick() throws IOException, InterruptedException {
		login();
		log4.info("Successfully logged in");
		othersKudosCredentials other=new othersKudosCredentials(driver);
		other.kudosActivity().click();
		log4.info("Clicked on Kudos Activity");
		Thread.sleep(3000);
		boolean test2=other.activityDisplayed().isDisplayed();
		Assert.assertTrue(test2);
		stopAndClose();
	}
	@Test
	public void recentKudosCount() throws IOException, InterruptedException {
		login();
		log4.info("Successfully logged in");
		othersKudosCredentials other=new othersKudosCredentials(driver);
		other.kudosActivity().click();
		Thread.sleep(3000);
		String[] Text=other.getKudosCount().getText().split(" ");
		int count1=Integer.parseInt(Text[0]);
		kudosCredentials kud=new kudosCredentials(driver);
		kud.sendKudos().click();
		kud.searchBar().click();
		kud.searchBar().sendKeys("Sandeep N  (sandeep.n@qualitestgroup.com,)");
		kud.giveCard().click();
		log4.info("clicked on comment box");
		kud.addcomment().sendKeys("Automation Engg!");
		kud.send().click();
		Thread.sleep(2000);
		other.closeKudosSend().click();
		other.kudosActivity().click();
		driver.navigate().refresh();
		Thread.sleep(3000);
		String[] Text1=other.getKudosCount().getText().split(" ");
		int count2=Integer.parseInt(Text1[0]);
		if(count1>=count2) {
			Assert.assertTrue(false);
			log4.error("Kudos count is not increased");
		}
		stopAndClose();
	}
	@Test
	public void sendSelfKudos() throws IOException, InterruptedException {
		login();
		log4.info("Successfully logged in");
		kudosCredentials kud=new kudosCredentials(driver);
		kud.sendKudos().click();
		kud.searchBar().click();
		kud.searchBar().sendKeys("Madhu Sudhan M  (madhu.sudhan@qualitestgroup.com)");
		kud.giveCard().click();
		kud.addcomment().sendKeys("Automation Engg!");
		kud.send().click();
		Thread.sleep(3000);
		String error=kud.errorInSent().getText();
		if(error.contains("Mailer Error: SMTP connect() failed.")) {
			Assert.assertTrue(false);
			log4.error("Self kudos cannot be sent");
		}
		stopAndClose();
	}
}
