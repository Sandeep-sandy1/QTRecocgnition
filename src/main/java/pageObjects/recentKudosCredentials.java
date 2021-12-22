package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class recentKudosCredentials{
	public WebDriver driver;
	By paperBoat=By.xpath("(//a[@data-toggle='modal']//i[@aria-hidden='true'])[2]");
	By Card=By.xpath("//p/i[contains(text(),'\"Innovative Thinker\"')]");
	By Comment=By.id("comment");
	By SendBtn=By.cssSelector(".btn-primary");
	By ErrorMessage=By.xpath("//center[contains(text(),'Mailer Error: SMTP connect() failed.')]");
	public recentKudosCredentials (WebDriver driver) {
		this.driver=driver;
	}
	public WebElement recentContact() {
		return driver.findElement(paperBoat);
	}
	public WebElement selectCard() {
		return driver.findElement(Card);
	}
	public WebElement addComment() {
		return driver.findElement(Comment);
	}
	public WebElement clickSend() {
		return driver.findElement(SendBtn);
	}
	public WebElement errorMessage() {
		return driver.findElement(ErrorMessage);
	}
}
