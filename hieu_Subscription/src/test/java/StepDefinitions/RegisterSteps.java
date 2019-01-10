package StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.BatchAllocator.Slicing;
import cucumber.api.java.en.Then;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import javax.xml.ws.LogicalMessage;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.RegisterPage;

public class RegisterSteps {

	WebDriver driver = Hook.driver;
	RegisterPage loginPage;

	@Before
	public void StartTest() {
		loginPage = new RegisterPage(Hook.driver);
	}

	@After
	public void EndTest(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((RemoteWebDriver) this.driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
	}

	@Given("^I am staying at testmaster\\.vn$")
	public void i_am_staying_at_testmaster_vn() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		driver.get("http://testmaster.vn");

		//throw new PendingException();
	}

	@When("^I give the valid email$")
	public void i_give_the_valid_email() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		//this.driver.
		Actions actions = new Actions(driver);
		actions.moveToElement(loginPage.txtUsername);
		loginPage.txtUsername.sendKeys("hieumai886x11qxx11@gmail.com");	
		//TimeUnit thread = null;
	//	Thread.sleep(3000);
		
		//this.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//throw new PendingException();
	}

	@When("^I do login$")
	public void i_do_login() throws Exception {
		// Write code here that turns the phrase above into concrete actions
	//	if(driver.findElements( By.xpath("//div[@class=\"closeButtonContainer\"]") ).size() != 0) {
		//	loginPage.closeChat.click();
	//	}
		//
		loginPage.btnLogin.click();
		//throw new PendingException();
	}

	
	@Then("^I should see the form other$")
	public void i_should_see_the_form_other() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		//String s = loginPage.form1.getText();
		Thread.sleep(3000);
		WebElement element =  driver.findElement( By.xpath("//button[@id=\"ddlGender\"]" ));
		assertEquals("Không xác định", element.getText());
		//aser
		//throw new PendingException();
	}
	
	@When("^I give the invalid name$")
	public void i_give_the_invalid_name() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		loginPage.name.sendKeys("");
		Thread.sleep(1000);
		WebElement element =  driver.findElement( By.xpath("//button[@id=\"allow-button\"]" ));
		System.out.println("element:" + element.getText());
		element.click();
		//loginPage.btnLogin1.click();
		//throw new PendingException();
	}

	@Then("^I should see invalid message$")
	public void i_should_see_invalid_message() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		String s1 = loginPage.mess1.getText();
		assertEquals("This is required field", s1);
		//throw new PendingException();
	}

	@When("^I give the valid name$")
	public void i_give_the_valid_name() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		loginPage.name.sendKeys("abc");
		loginPage.btnLogin1.click();
		//throw new PendingException();
	}

	@Then("^I should see success$")
	public void i_should_see_success() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);
		//Alert alert = this.driver.switchTo().alert();
		//
		WebElement element =  driver.findElement( By.xpath("//div[@class=\"body-message\"]" ));
		System.out.println("abcalert:" + element.getText());
		assertEquals("Bạn đã đăng ký nhận bản tin thành công. Hãy kiểm tra Email để xác nhận việc đăng ký", element.getText());

		//throw new PendingException();
	} 
}
