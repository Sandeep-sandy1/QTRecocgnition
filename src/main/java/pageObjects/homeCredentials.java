package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homeCredentials {
	public WebDriver driver;
	By Name=By.xpath("//div[@class='media-body']//h5[normalize-space()='']");
	By Image=By.cssSelector("img[src*='svg']");
	public homeCredentials(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement getTheName() {
		return driver.findElement(Name);
	}
	public WebElement getTheImage() {
		return driver.findElement(Image);
	}
}
