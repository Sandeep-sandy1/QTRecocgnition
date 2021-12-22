package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class othersKudosCredentials {
	By FromMe=By.xpath("//span[contains(text(),'Kudos from me')]");
	By ToMe=By.xpath("//span[contains(text(),'Kudos to me')]");
	By Activity=By.xpath("//span[contains(text(),'Activity')]");
	By FromMeDisplayed=By.cssSelector("#shoutout_to_me");
	By ToMeDisplayed=By.xpath("(//div[@class='media-body'] //h5[@class='header-font-size'])[7]");
	By RecentACtivity=By.id("shoutout_to_me");
	By KudosCount=By.id("todayCount");
	By Close=By.cssSelector(".close");
	public WebDriver driver;
	public othersKudosCredentials(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement kudosFromMe() {
		return driver.findElement(FromMe);
	}
	public WebElement kudosToMe() {
		return driver.findElement(ToMe);
	}
	public WebElement fromDisplayed() {
		return driver.findElement(FromMeDisplayed);
	}
	public WebElement toDisplayed() {
		return driver.findElement(ToMeDisplayed);
	}
	public WebElement kudosActivity() {
		return driver.findElement(Activity);
	}
	public WebElement activityDisplayed() {
		return driver.findElement(RecentACtivity);
	}
	public WebElement getKudosCount() {
		return driver.findElement(KudosCount);
	}
	public WebElement closeKudosSend() {
		return driver.findElement(Close);
	}
}
