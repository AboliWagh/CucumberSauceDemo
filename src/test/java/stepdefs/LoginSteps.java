package stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	WebDriver driver = BaseClass.driver;

	@Given("User is on SauceDemo Login Page")
	public void user_is_on_SauceDemo_Login_Page() throws InterruptedException {
		
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(1000);
	}

	@When("User enters Username {string} and Password {string}")
	public void user_enters_Username_and_Password(String usernameval, String passwordval) {
		
		WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
		username.sendKeys(usernameval);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(passwordval);
		
		

	}

	@When("User clicks on Login button")
	public void user_clicks_on_Login_button() {

		WebElement LoginButton = driver.findElement(By.id("login-button"));
		LoginButton.click();
	}

	@Then("User lands on the Product Page")
	public void user_lands_on_the_Product_Page() {

		WebElement product = driver.findElement(By.xpath("//span[@class='title']"));

		System.out.println("User is on Products Page");
	}



	@Then("User gets the error message as {string}")
	public void user_gets_the_error_message_as(String string) {
		WebElement ErrorMsg = driver.findElement(By.xpath("//h3[@data-test='error']"));
		String ActualMsg = ErrorMsg.getText();
		String ExpeMsg = "Epic sadface: Username and password do not match any user in this service";

		if (ActualMsg.equals(ExpeMsg)) {
			System.out.println("TC Passed");

		} else {
			System.out.println("TC Failed");
		}
		
	}

}
