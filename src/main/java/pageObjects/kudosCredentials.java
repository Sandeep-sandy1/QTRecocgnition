package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class kudosCredentials {
	public WebDriver driver;
	By SendKudos=By.xpath("//a[@data-toggle='modal']");
	By Search=By.id("email_address");
	By Card=By.xpath("//p/i[contains(text(),'\"Innovative Thinker\"')]");
	By Comment=By.id("comment");
	By SendBtn=By.cssSelector(".btn-primary");
	By Error=By.xpath("//center[contains(text(),'Please enter any comment.')]");
	By ErrorInSending=By.xpath("//center[contains(text(),'Mailer Error: SMTP connect() failed.')]");
	public kudosCredentials(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement sendKudos() {
		return driver.findElement(SendKudos);
	}
	public WebElement searchBar() {
		return driver.findElement(Search);
	}
	public WebElement send() {
		return driver.findElement(SendBtn);
	}
	public WebElement giveCard() {
		return driver.findElement(Card);
	}
	public WebElement addcomment() {
		return driver.findElement(Comment);
	}
	public WebElement errorMessage() {
		return driver.findElement(Error);
	}
	public WebElement errorInSent() {
		return driver.findElement(ErrorInSending);
	}
}
