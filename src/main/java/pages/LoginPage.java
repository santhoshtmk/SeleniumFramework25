package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By emailTextBox=By.id("Email");
	private By passwordTextBox=By.id("Password");
	private By loginButton=By.xpath("//button[@type='submit']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void enterEmail(String email)
	{
		driver.findElement(emailTextBox).clear();
		driver.findElement(emailTextBox).sendKeys(email);
	}
	public void enterPassword(String pwd)
	{
		driver.findElement(emailTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		driver.findElement(loginButton).click();
	}
}
