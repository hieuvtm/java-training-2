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

import PageObjects.BELoginPage;
import PageObjects.RegisterPage;

public class BELoginSteps {

	WebDriver driver = Hook.driver;
	BELoginPage beloginPage;

//	@Before
//	public void StartTest() {
//		//beloginPage = new BELoginPage(Hook.driver);	
//	}
//
//	@After
//	public void EndTest(Scenario scenario) {
//		if (scenario.isFailed()) {
//			byte[] screenshot = ((RemoteWebDriver) this.driver).getScreenshotAs(OutputType.BYTES);
//			scenario.embed(screenshot, "image/png");
//		}
//	}

	@Given("^I am staying at testmaster\\.vn/Admin$")
	public void i_am_staying_at_testmaster_vn_Admin() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		beloginPage = new BELoginPage(Hook.driver);	
		driver.get("http://testmaster.vn/Admin");
	}

	@When("^I give the invalid email$")
	public void i_give_the_invalid_email() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    beloginPage.txtUsername.sendKeys("abcdef");
	}

	@When("^I do login backend$")
	public void i_do_login_backend() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    beloginPage.btnLogin.click();
	}

	@Then("^The correspond messages is showed for invalid case\\.$")
	public void the_correspond_messages_is_showed_for_invalid_case() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		String toolTipText = beloginPage.txtUsername.getAttribute("data-original-title");

	    Assert.assertEquals(toolTipText, "Hãy nhập E-mail ở định dạng: user@email.com");
	    
	}

	@When("^I give the valid email/password$")
	public void i_give_the_valid_email_password() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    beloginPage.txtUsername.sendKeys("khanh.tx@live.com");
	    beloginPage.txtPassword.sendKeys("abc123");
	}

	@Then("^I should see the Backend page$")
	public void i_should_see_the_Backend_page() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		Thread.sleep(1000);
		String text= beloginPage.logo.getText();

	    Assert.assertEquals(text, "Testmaster.vn - Admin");
	}


	
}
