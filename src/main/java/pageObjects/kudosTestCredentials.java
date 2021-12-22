package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class kudosTestCredentials {
	public WebDriver driver;
	By kudosSearch=By.xpath("//a[@onclick='searchKudosByUser()']");
	By search=By.id("s_e_add");
	By icon=By.xpath("//button[@onclick='kudosSearch()']");
	By History=By.cssSelector("div[id='shoutout_to_me']");
	public kudosTestCredentials(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement KudosSearch() {
		return driver.findElement(kudosSearch);
	}
	public WebElement SearchBar() {
		return driver.findElement(search);
	}
	public WebElement SearchIcon() {
		return driver.findElement(icon);
	}
	public WebElement SeeHistory() {
		return driver.findElement(History);
	}
}
