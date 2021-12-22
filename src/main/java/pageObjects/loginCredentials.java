package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginCredentials {
	public WebDriver driver;
	By Username=By.xpath("//input[@type='text']");
	By password=By.xpath("//input[@type='password']");
	By Login=By.xpath("//button[@type='submit']");
	By navyColor=By.xpath("//button[@type='submit']");
	By goldColor=By.cssSelector(".myHeading");
	By whiteColor=By.tagName("body");
	public loginCredentials(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement Email() {
		return driver.findElement(Username);
	}
	public WebElement Password() {
		return driver.findElement(password);
	}
	public WebElement Submit() {
		return driver.findElement(Login);
	}
	public WebElement NavyColor() {
		return driver.findElement(navyColor);
	}
	public WebElement GoldColor() {
		return driver.findElement(goldColor);
	}
	public WebElement WhiteColor() {
		return driver.findElement(whiteColor);
	}
	public String error() {
		String errorMessage=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return errorMessage;	
	}

}
