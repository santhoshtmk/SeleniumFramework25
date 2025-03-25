package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Log;

public class LoginPage {

	private WebDriver driver;

	// Using PageFactory

	@FindBy(id = "Email")
	WebElement emailTextBox;

	@FindBy(id = "Password")
	WebElement passwordTextBox;

	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterEmail(String email) {
		emailTextBox.clear();
		emailTextBox.sendKeys(email);
	}

	public void enterPassword(String pwd) {
		passwordTextBox.clear();
		passwordTextBox.sendKeys(pwd);
	}

	public void clickLogin() {
		Log.info("User clicked on login button..");
		loginButton.click();
	}

	// Without using pageFactory
	/*
	 * private By emailTextBox=By.id("Email"); private By
	 * passwordTextBox=By.id("Password"); private By
	 * loginButton=By.xpath("//button[@type='submit']");
	 * 
	 * public LoginPage(WebDriver driver) { this.driver=driver; }
	 * 
	 * public void enterEmail(String email) {
	 * driver.findElement(emailTextBox).clear();
	 * driver.findElement(emailTextBox).sendKeys(email); } public void
	 * enterPassword(String pwd) { driver.findElement(emailTextBox).clear();
	 * driver.findElement(passwordTextBox).sendKeys(pwd); }
	 * 
	 * public void clickLogin() { Log.info("User clicked on login button..");
	 * driver.findElement(loginButton).click(); }
	 */
	}
